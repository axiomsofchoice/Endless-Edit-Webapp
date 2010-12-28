/**
 * 
 */
package com.np_compete.endless_edit.client;

/**
 * @author axiomsofchoice
 *
 */
public class StockPrices {

	  private String symbol;
	  private double price;
	  private double change;

	  public StockPrices() {
	  }

	  public StockPrices(String symbol, double price, double change) {
	    this.symbol = symbol;
	    this.price = price;
	    this.change = change;
	  }

	  public String getSymbol() {
	    return this.symbol;
	  }

	  public double getPrice() {
	    return this.price;
	  }

	  public double getChange() {
	    return this.change;
	  }

	  public double getChangePercent() {
	    return 10.0 * this.change / this.price;
	  }

	  public void setSymbol(String symbol) {
	    this.symbol = symbol;
	  }

	  public void setPrice(double price) {
	    this.price = price;
	  }

	  public void setChange(double change) {
	    this.change = change;
	  }

}
