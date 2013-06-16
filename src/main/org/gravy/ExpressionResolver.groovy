
package org.gravy

import org.gravy.query.Query;
import org.latitude.Latitude


class ExpressionResolver<T> {
  
  List<T> froms = []
  List<?> projection = []
  
	
  T from(Class<T> clazz) {
    froms << clazz
    Latitude.createTraceableObject clazz
  }
	
	
	T from(List<T> list) {
		froms << list
		Latitude.createTraceableObject T
	}
	
	
	def from(Object object) {
		froms << object
		Latitude.createTraceableObject object.getClass()
	}
  
	
  void select(Object[] args) {
    projection << args
  }
	
  
  void and() {
		
	}
	
	
	void or() {
		
	}
  
	
  void where() {
		
	}
  
	
  Query createExpression() {
    new Query(
      //projection: 
    )
  }
  
}
