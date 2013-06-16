package org.gravy.query.component

/**
 * Represents the source of a Gravy expression. It may be:
 * - A list of data
 * - An entity
 * - A XML
 * - A JSON
 * - A SQL connection
 * 
 * It can be anything, as long as there is a dictionary which 
 * can do the translation.
 * 
 * @author will_lp
 */
class Source<T> {
  T datasource
}
