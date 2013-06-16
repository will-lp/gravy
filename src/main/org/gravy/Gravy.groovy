package org.gravy

import groovy.transform.CompileStatic as CS

import org.gravy.query.Query;

/**
 * Gravy
 * 
 * @author will_lp
 */
@CS class Gravy {
  
  static Iterator sql( @DelegatesTo(ExpressionResolver) Closure closure ) {
    
  }
  
	static Iterator collection( @DelegatesTo(ExpressionResolver) Closure closure ) {
		
	}
  
  static Query buildExpression( @DelegatesTo(ExpressionResolver) Closure closure ) {
    def resolver = new ExpressionResolver()
    closure.delegate = resolver
    closure()
    println resolver.dump()
    resolver.createExpression()
  }
  
}
