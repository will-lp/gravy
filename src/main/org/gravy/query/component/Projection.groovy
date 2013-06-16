


package org.gravy.query.component

/**
 * Stores references in FieldProjection objects for paths called in 
 * the 'select' statement of an Expression
 * 
 * @author will_lp
 */
class Projection {
  
  /*
   * Stores references to paths like "parent.children.name". 
   * In this model, it will be persisted as "name.children.parent".
   */ 
  List<FieldReference> fields
}
