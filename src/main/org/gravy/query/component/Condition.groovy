package org.gravy.query.component

import org.gravy.expression.operator.Operator


/**
 * Express the conditionals to filter a datasource.
 * They are stored like...? TODO
 * 
 */
class Condition {
  Operator operator
  FieldReference lhs
  
  /*
   * This field may be null if the operator accepts only a 
   * single value, like the 'Not' operator.
   */
  FieldReference rhs
}
