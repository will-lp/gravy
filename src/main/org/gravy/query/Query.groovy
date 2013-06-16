package org.gravy.query

import org.gravy.expression.component.Condition
import org.gravy.expression.component.GroupBy
import org.gravy.expression.component.Limit
import org.gravy.expression.component.Projection
import org.gravy.expression.component.Source


/**
 * The main structure of Gravy. This is the expression tree which 
 * must be parsed using a dictionary.
 * It must provide operations to work on, at least, the most basic 
 * data sources:
 * - SQL
 * - Collections
 * 
 * On a later phase:
 * - XML
 * - JSON
 * - NoSQL (?)
 * 
 */
class Query {
  Projection projection
  Source source
  List<Condition> conditions
  GroupBy groupBy
  Limit limit
}
