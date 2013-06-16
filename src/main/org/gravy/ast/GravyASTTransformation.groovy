package org.gravy.ast

import org.codehaus.groovy.ast.ASTNode
import org.codehaus.groovy.ast.ClassCodeVisitorSupport
import org.codehaus.groovy.ast.ClassNode
import org.codehaus.groovy.ast.expr.ClosureExpression
import org.codehaus.groovy.ast.expr.MethodCallExpression
import org.codehaus.groovy.ast.stmt.ExpressionStatement
import org.codehaus.groovy.control.CompilePhase
import org.codehaus.groovy.control.SourceUnit
import org.codehaus.groovy.transform.ASTTransformation
import org.codehaus.groovy.transform.GroovyASTTransformation

@GroovyASTTransformation(phase=CompilePhase.CANONICALIZATION)
@groovy.transform.CompileStatic
class GravyASTTransformation implements ASTTransformation {

	@Override
	void visit(ASTNode[] nodes, SourceUnit source) {
		println "** gravyASTTransformation ** "
		
		
		def visitor = new ClassCodeVisitorSupport() {
			void visitMethodCallExpression(MethodCallExpression method) {
				println " * method.objectExpression.type.dump=" + method.objectExpression.type.dump()
				
				method
				
				if (method.text.startsWith("org.gravy.Gravy")) 
				{ 
					println " * visitor.methodCall is equal"
					
					println "method.arguments instanceof Closure=${method.arguments instanceof Closure}"
				} 
			}
			
			protected SourceUnit getSourceUnit() { source }
		}
		
		source.getAST().classes.each { ClassNode node ->
			visitor.visitClass(node)
		}
			
	}

}
