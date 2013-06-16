package org.latitude;

/**
 * A reference to an object. Proxies a class and any property
 * retrieved must return itself plus saving the path called.
 * 
 * @author will_lp
 */
class ReferenceInterceptor<T> {
	
	Class<T> clazz
	def invokedMethods = []
	def invokedProperties = []
	
	ReferenceInterceptor() {
		println "new reference interceptor"
	}
	
	def getProperty(String property) {
		System.out.println "getProperty $property from ${metaClass.owner}"
		invokedProperties << property
		this
	}
	
	def invokeMethod(String method, args) {
		System.out.println "invokeMethod $method with $args"
		this
	}
  
}
