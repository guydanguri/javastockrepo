package com.mta.javacourse.model;


import java.util.Date;


/**
 * 
 * This call represent a portfolio
 *
 */
public class Portfolio {
	
	private static final int MAX_PORTFOLIO_SIZE = 5;
	
	private String title = "My Portfolio";
	private Stock[] Stocks = new Stock[MAX_PORTFOLIO_SIZE];
	private int portfoliosize = 0;
	
	public Portfolio(){
		this.title = new String("");			
		this.Stocks = new Stock[MAX_PORTFOLIO_SIZE];
		this.portfoliosize = 0;
	}

	public Portfolio(String title, int portfoliosize) {
		this.title = title;			
		this.Stocks = new Stock[portfoliosize];
		this.portfoliosize= portfoliosize;
	}
	//copy c'tor
	public Portfolio(Portfolio portfolio){ 		
		this.setTitle( new String(portfolio.getTitle()) );
		this.portfoliosize = portfolio.getPortfoliosize();		
		this.Stocks = new Stock[MAX_PORTFOLIO_SIZE];

		for (int i = 0; i < portfoliosize; i++) 
			this.Stocks[i]=new Stock(portfolio.getStocks()[i]);
		}
	//getters and setters
	public int getPortfoliosize() {
		return portfoliosize;
	}

	public void setPortfoliosize(int portfoliosize) {
		this.portfoliosize = portfoliosize;
	}
/**
 * 
 * This method add stock to the portfolio
 */
	public void addstock(Stock stock) {	
		if(stock != null && portfoliosize < MAX_PORTFOLIO_SIZE) {
			Stocks[portfoliosize] = stock;
			portfoliosize++;
		}else {
			System.out.println("Sorry, portfolio is full, or is stock is null!");
		}
	}
	
	/**
	 * This method remove stock from the portfolio
	 */
	public void removeStock(String symbol) {
		if (symbol == null){
			return;
		}
		if (portfoliosize == 1 || symbol.equals(Stocks[portfoliosize-1].getsymbol())){
			Stocks[portfoliosize-1] = null;
			portfoliosize--;
			return;
		}
		for (int i = 0; i < portfoliosize; i++){

			if (symbol.equals(Stocks[i].getsymbol()))
			{
				Stocks[i] = Stocks[portfoliosize - 1];
				Stocks[portfoliosize - 1] = null;
				portfoliosize--;
			}
		}
		return;
	}
	
    
    public Stock[]getStocks(){
    	return Stocks;
    }
    
	public   String getTitle() {
		return this.title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public String getHtmlString() {
		
		String ret = new String( "<h1>" + getTitle() + "</h1>" );
		
		for(int i = 0; i < portfoliosize ;i++) {
			
			ret += this.Stocks[i].getHtmlDescription() + "<br>";
		}
		return ret;
	}
}
