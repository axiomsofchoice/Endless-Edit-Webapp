/**
 * 
 */
package com.np_compete.endless_edit.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * @author axiomsofchoice
 *
 */
@RemoteServiceRelativePath("stockPrices")
public interface StockPriceService extends RemoteService {

	StockPrices[] getPrices(String[] symbols);

}
