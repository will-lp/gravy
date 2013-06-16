package org.gravy

import org.gravy.Gravy
import org.gravy.mock.Invoice

import groovy.transform.CompileStatic as CS

class SmallGravyTest extends GroovyTestCase {
  
  void testSyntax() {
    Iterator<BigDecimal> totals = Gravy.buildExpression {
      def invoice = from Invoice
      select invoice.total
    }
  }
  
  
  @CS void testStatic() {
    
  }
  
}


