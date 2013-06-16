package org.gravy.query.operator

/**
 * The available operations.
 * 
 * @author will_lp
 * 
 */
enum Comparator {
	AND ( "&&" ),
	OR  ( "||" ),
	NOT ( "!"  ),
	GT  ( ">"  ),
	GE  ( ">=" ),
	LT  ( "<"  ),
	LE  ( "<=" ),
	NE  ( "!=" ),
	EQ  ( "==" )
	
	private String symbol
	
	private Comparator(String operator) {
		this.symbol = operator
	}
}
