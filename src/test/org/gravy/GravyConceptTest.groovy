package org.gravy

import org.gravy.Gravy;


class GravyConceptTest extends GroovyTestCase {
	
	void testTree() {
		
		def list = [1, 2, 3, 4, 5, 6, 7]
		
		
		/*
		 * From the following query...
		 */
		def result = Gravy.buildExpression {
			def item = from list
			select item * 2
			where item.gt 3
		}
		
		
		/*
		 * ...must result the following tree expression:
		 * 
		 * Expression(
		 * 		Projection	( item )
		 * 		Source			( list )
		 * 		Conditions	( [] )
		 * 		GroupBy			( null )
		 * 		Limit				( null )
		 * )
		 * 
		 * with the following list result;
		 * 
		 * assert result == [8, 10, 12, 14]
		 */
		
		println result
	}
	
}
