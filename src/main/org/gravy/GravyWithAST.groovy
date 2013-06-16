package org.gravy


class GravyWithAST {

	def buildQuery( @DelegatesTo(ExpressionResolver) Closure closure ) {
		closure.delegate = new ExpressionResolver()
		closure.resolveStrategy = Closure.DELEGATE_FIRST
		closure()
	}
	
}
