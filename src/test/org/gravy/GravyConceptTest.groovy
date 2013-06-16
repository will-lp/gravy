package org.gravy

import org.gravy.Gravy;


class GravyConceptTest /*extends GroovyTestCase*/ {
	
	//void testTree() {
	static void main(args) {
		
		def list = [1, 2, 3, 4, 5, 6, 7]
		
		
		/*
		 * From the following query...
		 */
		def result = Gravy.buildExpression {
			def item = from list
			select item * 2
			where item > 3
		}
		
		
		/*
		 * ...must result the following expression, after AST processing:
		 * 
		 * Gravy.buildExpression {
		 * 	 def item = from( list )
		 *   select( multiply( item, 2 ) )
		 *   where( gt( item, 3 ) )
		 * }
		 * 
		 * And resulting in the following query object:
		 * 
		 * Query(
		 * 		Projection	( item )
		 * 		Source			( list )
		 * 		Conditions	( [] )
		 * 		GroupBy			( null )
		 * 		Limit				( null )
		 * )
		 * 
		 * With the following list result:
		 * 
		 * assert result == [8, 10, 12, 14]
		 */
		
		println result
	}
	
}
