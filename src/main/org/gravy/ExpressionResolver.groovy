
package org.gravy

import org.gravy.query.Query;
import org.latitude.Latitude


/**
 * The expression resolver must be able to respond to any command 
 * from the query after the parse from the GravyASTTransformation.
 * 
 * @author will_lp
 *
 * @param <T>
 */
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
	
	void group() {}
  
  void and() {}
	void or() {}
	void not() {}
  void where() {}
	
	void avg() {}
	void count() {}
	void sum() {}
	
	void multiply() {}
	void add() {}
	void power() {}
  void divide() {}
	void subtract() {}
	
	void eq() {}
	void ne() {}
	void gt() {}
	void ge() {}
	void lt() {}
	void le() {}
	
  Query createExpression() {
    new Query(
      //projection: 
    )
  }
  
}
