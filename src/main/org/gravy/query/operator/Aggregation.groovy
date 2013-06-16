package org.gravy.query.operator

enum Aggregation {

	AVG("avg"),
	SUM("sum"),
	COUNT("count")
	
	private String symbol
	
	private Aggregation(String symbol) {
		this.symbol = symbol
	}
}
