package org.latitude

/**
 * Facility to create instance of objects. Not all objects have a clean
 * constructor. 
 * 
 * TODO: Couldn't find an easy way to mock integers neither strings. Need 
 * a reference to methods called in it. 
 * 
 * @author will_lp
 *
 */
class InstanceFactory {

	/**
	 * Creates
	 * 
	 * @param clazz
	 * @return
	 */
	static <T> T create(Class<T> clazz) {
		clazz.case {
			when Number then { clazz.newInstance(0) }
			otherwise { clazz.newInstance() }
		}
	}
	
}
