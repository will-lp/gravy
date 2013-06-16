package org.gravy.query.operator

enum Operator {
	MULT ("*"),
	ADD  ("+"),
	SUB  ("-"),
	DIV  ("/"),
	POW  ("**")
	
	private String symbol
	
	private Operator(String symbol) {
		this.symbol = symbol
	}
	
}
