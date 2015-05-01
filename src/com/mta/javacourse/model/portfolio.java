package com.mta.javacourse.model;

import com.mta.javacourse.Stock;

public class portfolio {
	
	private static final int MAX_PORTFOLIO_SIZE = 5;
	
	private String title ;
	private Stock[] Stocks = new Stock[MAX_PORTFOLIO_SIZE];
	private int portfoliosize=0;
	
	public void addstock(Stock stock) {
		
		if(stock != null && portfoliosize < MAX_PORTFOLIO_SIZE) {
			this.Stocks[portfoliosize] = stock;
			portfoliosize++;
		}else {
			System.out.println("Sorry, protfolio is full, or is stock is null!");
		}
		
	}
    
    public Stock[]getStocks(){
    	return Stocks;
    }
    
	public String getHtmlString() {
		
		String ret = new String( "<h1>" + getTitle() + "</h1>" );
		
		for(int i = 0; i < portfoliosize ;i++) {
			
			ret += this.Stocks[i].getHtmlDesc() + "<br>";
		}
		
		return ret;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
