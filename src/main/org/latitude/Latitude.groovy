package org.latitude

import java.lang.reflect.Method

import javassist.util.proxy.MethodFilter
import javassist.util.proxy.MethodHandler
import javassist.util.proxy.ProxyFactory

/**
 * Ease mocking references from objects.
 * Must save the path called from the object.
 *
 * @author will_lp
 */
class Latitude {
	
  static <T> T createTraceableObject(Class<T> clazz) {
		def instance = createDynamicTraceableObject clazz
		
		println "done proxying for class $clazz. Proxied: $instance "
		println "after print"
		
		instance
  }
	
	
	static <T> T createDynamicTraceableObject(Class<T> clazz) {
		def instance = InstanceFactory.create clazz
		
		instance.metaClass.mixin ReferenceInterceptor
		
		instance
	}
	
	
	static <T> T createJavassistTraceableObject(Class<T> clazz) {
		def proxy = new ProxyFactory()
		proxy.superclass = clazz
		proxy.filter = { true } as MethodFilter
		
		def handler = { Object self, Method m, Method proceed, Object[] args ->
			proceed.returnType.case {
				when Void then null
				otherwise { Latitude.createTraceableObject proceed.returnType }
			}
		} as MethodHandler
		
		def newClazz = proxy.createClass()
		def instance = newClazz.newInstance()
		instance.handler = handler
	}
}
