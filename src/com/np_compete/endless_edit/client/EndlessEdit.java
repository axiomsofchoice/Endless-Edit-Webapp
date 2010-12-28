package com.np_compete.endless_edit.client;

import java.util.ArrayList;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class EndlessEdit implements EntryPoint {
	
	private VerticalPanel mainPanel = new VerticalPanel();
	private FlexTable stocksFlexTable = new FlexTable();
	private HorizontalPanel addPanel = new HorizontalPanel();
	private TextBox newSymbolTextBox = new TextBox();
	private Button addStockButton = new Button("Add");
	private Label lastUpdatedLabel = new Label();
	private ArrayList<String> stocks = new ArrayList<String>();

	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";
	private static final int REFRESH_INTERVAL = 5000; // ms

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		
	    // Create table for stock data.
	    stocksFlexTable.setText(0, 0, "Symbol");
	    stocksFlexTable.setText(0, 1, "Price");
	    stocksFlexTable.setText(0, 2, "Change");
	    stocksFlexTable.setText(0, 3, "Remove");

	    // Assemble Add Stock panel.
	    addPanel.add(newSymbolTextBox);
	    addPanel.add(addStockButton);

	    // Assemble Main panel.
	    mainPanel.add(stocksFlexTable);
	    mainPanel.add(addPanel);
	    mainPanel.add(lastUpdatedLabel);

	    // Associate the Main panel with the HTML host page.
	    RootPanel.get("endlessEdit").add(mainPanel);

	    // Move cursor focus to the input box.
	    newSymbolTextBox.setFocus(true);

	    // Setup timer to refresh list automatically.
	    Timer refreshTimer = new Timer() {
	      @Override
	      public void run() {
	        refreshWatchList();
	      }
	    };
	    refreshTimer.scheduleRepeating(REFRESH_INTERVAL);


	    // Listen for mouse events on the Add button.
	    addStockButton.addClickHandler(new ClickHandler() {
	      public void onClick(ClickEvent event) {
	        addStock();
	      }
	    });

	  }

	/**
	 * 
	 */
	private void refreshWatchList() {
		// TODO Auto-generated method stub
		
	}

	/**
	   * Add stock to FlexTable. Executed when the user clicks the addStockButton or
	   * presses enter in the newSymbolTextBox.
	   */
	  private void addStock() {
		  
		    final String symbol = newSymbolTextBox.getText().toUpperCase().trim();
		    newSymbolTextBox.setFocus(true);

		    // Stock code must be between 1 and 10 chars that are numbers, letters, or dots.
		    if (!symbol.matches("^[0-9A-Z\\.]{1,10}$")) {
		      Window.alert("'" + symbol + "' is not a valid symbol.");
		      newSymbolTextBox.selectAll();
		      return;
		    }

		    newSymbolTextBox.setText("");

		    // Don't add the stock if it's already in the table.
		    if (stocks.contains(symbol))
		      return;
		    
		    // Add the stock to the table.
		    int row = stocksFlexTable.getRowCount();
		    stocks.add(symbol);
		    stocksFlexTable.setText(row, 0, symbol);
		    
		    // Add a button to remove this stock from the table.
		    Button removeStockButton = new Button("x");
		    removeStockButton.addClickHandler(new ClickHandler() {
		      public void onClick(ClickEvent event) {
		        int removedIndex = stocks.indexOf(symbol);
		        stocks.remove(removedIndex);
		        stocksFlexTable.removeRow(removedIndex + 1);
		      }
		    });

		    stocksFlexTable.setWidget(row, 3, removeStockButton);
		    
		    // Get the stock price.
		    refreshWatchList();
	  }
	  
}