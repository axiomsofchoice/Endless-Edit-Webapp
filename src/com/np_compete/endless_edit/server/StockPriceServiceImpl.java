/**
 * 
 */
package com.np_compete.endless_edit.server;

import java.util.Random;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.np_compete.endless_edit.client.StockPriceService ;
import com.np_compete.endless_edit.client.StockPrices;
/**
 * @author axiomsofchoice
 *
 */
public class StockPriceServiceImpl extends RemoteServiceServlet implements StockPriceService {

 	  private static final double MAX_PRICE = 100.0; // $100.00
	  private static final double MAX_PRICE_CHANGE = 0.02; // +/- 2%

	  public StockPrices[] getPrices(String[] symbols) {
	    Random rnd = new Random();

	    StockPrices[] prices = new StockPrices[symbols.length];
	    for (int i=0; i<symbols.length; i++) {
	      double price = rnd.nextDouble() * MAX_PRICE;
	      double change = price * MAX_PRICE_CHANGE * (rnd.nextDouble() * 2f - 1f);

	      prices[i] = new StockPrices(symbols[i], price, change);
	    }

	    return prices;
	  }
}
