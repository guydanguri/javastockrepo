package com.mta.javacourse.model;

import java.util.Date;

/**
 * 
 * This call represent a portfolio
 *
 */
public class Portfolio {

	public enum ALGO_RECOMMENDATION {
		BUY, SELL, REMOVE, HOLD;
	}

	private static final int MAX_PORTFOLIO_SIZE = 5;

	private String title = "My Portfolio";
	private Stock[] Stocks = new Stock[MAX_PORTFOLIO_SIZE];
	private int portfoliosize = 0;
	private float balance = 0;

	public Portfolio() {
		this.title = new String("");
		this.Stocks = new Stock[MAX_PORTFOLIO_SIZE];
		this.portfoliosize = 0;
	}

	public Portfolio(String title, int portfoliosize) {
		this.title = title;
		this.Stocks = new Stock[portfoliosize];
		this.portfoliosize = portfoliosize;
	}

	// copy c'tor
	public Portfolio(Portfolio portfolio) {
		this.setTitle(new String(portfolio.getTitle()));
		this.portfoliosize = portfolio.getPortfoliosize();
		this.Stocks = new Stock[MAX_PORTFOLIO_SIZE];

		for (int i = 0; i < portfoliosize; i++)
			this.Stocks[i] = new Stock(portfolio.getStocks()[i]);
	}

	// getters and setters
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

		for (int i = 0; i < portfoliosize; i++)
			if (stock.getsymbol().equals(Stocks[i].getsymbol())) {
				System.out.println("stock is allready in the portfolio");
				return;
			}

			else {

				if (portfoliosize < MAX_PORTFOLIO_SIZE) {
					Stocks[portfoliosize] = stock;
					portfoliosize++;
					stock.setStockQuantity(0);

				} else {
					System.out
							.println("Can’t add new stock, portfolio can have only"
									+ MAX_PORTFOLIO_SIZE + "stocks”!");
				}
			}
	}

	/**
	 * This method remove stock from the portfolio
	 */

	public boolean removeStock(String symbol) {
		if (symbol == null) {
			return false;
		}
		if (portfoliosize == 1
				|| symbol.equals(Stocks[portfoliosize - 1].getsymbol())) {
			sellStock(symbol, -1);
			Stocks[portfoliosize - 1] = null;
			portfoliosize--;
			return true;
		}
		for (int i = 0; i < portfoliosize; i++) {

			if (symbol.equals(Stocks[i].getsymbol())) {

				sellStock(symbol, -1);
				Stocks[i] = Stocks[portfoliosize - 1];
				Stocks[portfoliosize - 1] = null;
				portfoliosize--;
				return true;
			}
		}
		return false;

	}

	public Stock[] getStocks() {
		return Stocks;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public String getHtmlString() {

		String ret = new String("<h1>" + getTitle() + "</h1>");

		for (int i = 0; i < portfoliosize; i++) {

			ret += this.Stocks[i].getHtmlDescription() + "<br>";			
		}
		  ret += "Total Portfolio Value is: " + this.getTotalValue() + "$.<br>"+
				  "Total Stocks Value: " + this.getStocksValue() + "$. <br>" + "Balance is: " + this.balance + "$.";
				 
		return ret;
	}

	public void updateBalance(float amount) {

		this.balance += amount;
		if (this.balance < 0) {
			System.out.println("Sorry,the balance cannot be negative");
		} else {
			System.out.println("balance updated");

			return;
		}

	}

	public boolean sellStock(String symbol, int quantity) {

		if (symbol == null || quantity < -1) {
			System.out.println("Sorry,error");

			return false;

		}

		for (int i = 0; i < portfoliosize; i++) {

			if (symbol.equals(Stocks[i].getsymbol())) {

				if (quantity > Stocks[i].getStockQuantity()) {
					System.out.println("Not enough stocks to sell");
					return false;
				}

				if (quantity == -1) {

					balance += Stocks[i].getStockQuantity()
							* Stocks[i].getbid();
					Stocks[i].setStockQuantity(0);
					System.out.println("sell succeed");
					return true;

				} else {
					balance += quantity * Stocks[i].getbid();
					Stocks[i].setStockQuantity(Stocks[i].getStockQuantity()
							- quantity);
					System.out.println("sell succeed");
					return true;
				}

			}
			return false;
		}
		return false;
	}

	public boolean buyStock(Stock stock, int quantity) {
		if (stock == null || quantity < -1) {

			System.out.println("error");
			return false;
		}

		for (int i = 0; i < portfoliosize; i++) {

			if (stock.getsymbol().equals(Stocks[i].getsymbol())) {
				System.out.println("the stock exist in portfolio");

				if (quantity == -1) {
					int numofstock = (int) (balance / stock.getask());
					balance -= numofstock * stock.getask();
					stock.setStockQuantity(stock.getStockQuantity()
							+ numofstock);
					System.out.println("buy succeed");

					return true;
				} else {
					if (quantity * stock.getask() > balance) {
						System.out
								.println("Not enough balance to complete purchase");
						return false;
					} else {
						balance -= quantity * stock.getask();
						stock.setStockQuantity(stock.getStockQuantity()
								+ quantity);
						System.out.println("buy succeed");
						return true;
					}
				}
			}

			else {
				addstock(stock);

				if (quantity == -1) {
					int numofstock = (int) (balance / stock.getask());
					balance -= numofstock * stock.getask();
					stock.setStockQuantity(stock.getStockQuantity()
							+ numofstock);
					System.out.println("buy succeed");

					return true;
				} else {
					if (quantity * stock.getask() > balance) {
						System.out
								.println("Not enough balance to complete purchase");
						return false;
					} else {
						balance -= quantity * stock.getask();
						stock.setStockQuantity(stock.getStockQuantity()
								+ quantity);
						System.out.println("buy succeed");
						return true;
					}

				}

			}

		}
		return false;
	}

	public float getStocksValue() {
		float totalstockvalue = 0;
		for (int i = 0; i < portfoliosize; i++) {

			totalstockvalue += this.Stocks[i].getbid()
					* this.Stocks[i].getStockQuantity();

		}
		return totalstockvalue;
	}

	public float getTotalValue() {

		return getStocksValue() + balance;

	}

}
