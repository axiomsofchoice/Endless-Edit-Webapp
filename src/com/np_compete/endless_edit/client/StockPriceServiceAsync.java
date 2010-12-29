/**
 * 
 */
package com.np_compete.endless_edit.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>StockPriceService</code>.
 * 
 * @author axiomsofchoice
 */
public interface StockPriceServiceAsync {

	  void getPrices(String[] symbols, AsyncCallback<StockPrices[]> callback);

}
