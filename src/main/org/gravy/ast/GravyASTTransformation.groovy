package org.gravy.ast

import org.codehaus.groovy.ast.ASTNode;
import org.codehaus.groovy.control.CompilePhase
import org.codehaus.groovy.control.SourceUnit;
import org.codehaus.groovy.transform.ASTTransformation;
import org.codehaus.groovy.transform.GroovyASTTransformation

@GroovyASTTransformation(phase=CompilePhase.SEMANTIC_ANALYSIS)
class GravyASTTransformation implements ASTTransformation {

	@Override
	public void visit(ASTNode[] nodes, SourceUnit source) {
		println "gravyASTTransformation"
		nodes.each { println it }
		throw new Exception("ast!!!!!")
	}

}
