
package org.gravy.query.component


/**
 * Represents the field projection
 * The fields are stored backwards. In a expression
 * <code>select parent.children.name</code>
 * The resulting FieldProjection object should be:
 * 
 * <code>
 * FieldProjection( name: 'name', parent: 
 *    FieldProjection( name: 'children', parent:
 *        FieldProjection( name: 'parent', parent: null )
 *    )
 * )
 * </code>
 * 
 * If any <code>java.lang.reflect.Field</code> is available (i.e., 
 * not working with dynamic expressions), we can store it too.
 * 
 * @author will_lp
 */
class FieldReference {
  String name
  java.lang.reflect.Field field
  FieldReference parent
}
