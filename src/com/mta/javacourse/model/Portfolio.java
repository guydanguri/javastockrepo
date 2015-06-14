package com.mta.javacourse.model;

import org.algo.model.PortfolioInterface;
import org.algo.model.StockInterface;

import com.mta.javacourse.exception.BalanceException;
import com.mta.javacourse.exception.PortfolioFullException;
import com.mta.javacourse.exception.StockAlreadyExistsException;
import com.mta.javacourse.exception.StockNotExistException;

/**
 * 
 * This class represents a portfolio
 *
 */
public class Portfolio implements PortfolioInterface {

	public enum ALGO_RECOMMENDATION {
		BUY, SELL, REMOVE, HOLD;
	}

	private static final int MAX_PORTFOLIO_SIZE = 5;

	private String title = "My Portfolio";
	private StockInterface[] Stocks = new Stock[MAX_PORTFOLIO_SIZE];
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
	public Portfolio(Portfolio pf) throws PortfolioFullException, StockAlreadyExistsException{
		this.portfoliosize = pf.getPortfoliosize();
		this.title = new String(pf.getTitle());
		
		for(int i = 0 ; i < pf.getPortfoliosize() ; i++)
		this.addStock(new Stock(pf.Stocks[i]));
	}

	public Portfolio(Stock[] stockArray) {
		for(int i=0;i < this.portfoliosize;i++){
			
			this.Stocks[i]=new Stock(stockArray[i]);
		}
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
	public void addStock(Stock stock) throws PortfolioFullException, StockAlreadyExistsException{
		
		if(this.getPortfoliosize() == (MAX_PORTFOLIO_SIZE))
		{
			throw new PortfolioFullException();
		}
		else
		{
			for(int i = 0 ; i < portfoliosize ; i++)
			{
				if(stock.getSymbol().equals(Stocks[i].getSymbol()))
				{
					throw new StockAlreadyExistsException();
				}
			}
				
		}
		
		if(stock != null)
		{
		Stocks[portfoliosize] = stock;
		((Stock) Stocks[portfoliosize]).setStockQuantity(0);
		portfoliosize++;
		}
		}
	/**
	 * This method remove stock from the portfolio
	 */

	public void removeStock(String symbol)throws StockNotExistException{
		boolean flag = false;
		int j = 0;
		for(int i = 0 ; i < portfoliosize ; i++)
		{	
			if(symbol.equals(this.Stocks[i].getSymbol()))
			{
				this.sellStock(symbol, ((Stock) this.Stocks[i]).getStockQuantity());
				Stocks[i] = null;
				j = i;
				flag = true;
				break;
			}
		}
		if(flag == false)
			throw new StockNotExistException();
		
		while (j < portfoliosize && portfoliosize > 0 && j != MAX_PORTFOLIO_SIZE-1)
		{
		Stocks[j] = Stocks[j+1];
		j++;
		}
		portfoliosize--;
	}

	public StockInterface[] getStocks() {
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

			ret += ((Stock) this.Stocks[i]).getHtmlDescription() + "<br>";			
		}
		  ret += "Total Portfolio Value is: " + this.getTotalValue() + "$.<br>"+
				  "Total Stocks Value: " + this.getStocksValue() + "$. <br>" + "Balance is: " + this.balance + "$.";
				 
		return ret;
	}

	public void updateBalance(float amount) throws BalanceException{
		
		if(amount < 0 && this.balance + amount < 0){
			throw new BalanceException();
		}
		if(this.balance + amount >= 0){
			this.balance += amount;
		}
	}

	@SuppressWarnings("unused")
	public void sellStock(String symbol, int quantity) throws StockNotExistException{
		boolean flag = false;
		int j = 0;
		for(int i = 0 ; i < portfoliosize ; i++)
		{
			if(this.Stocks[i].getSymbol().equals(symbol))
			{
				j = i;
				break;
			}
		}
		if(quantity != -1)
		{
			if(quantity <= ((Stock) this.Stocks[j]).getStockQuantity() )
			{
			this.balance += this.Stocks[j].getBid() * quantity;
			((Stock) this.Stocks[j]).setStockQuantity(((Stock) this.Stocks[j]).getStockQuantity()-quantity);
			flag = true;
			}
			else
				System.out.println("not enough stocks to sell");
		}
		else
		{
			this.balance += this.Stocks[j].getBid() * ((Stock) this.Stocks[j]).getStockQuantity();
			((Stock) this.Stocks[j]).setStockQuantity(0);
			flag = true;
		}
		if (!flag){
			throw new StockNotExistException();
		}
	}

	public void buyStock(Stock stock, int quantity) throws PortfolioFullException, BalanceException, StockAlreadyExistsException{
		boolean isOk = false;
		boolean flag = false;
		for(int i = 0 ; i < portfoliosize ; i++)
		{
			if (stock.getSymbol().equals(Stocks[i].getSymbol()))
			{
				flag = true;
			}
		}
		if(flag == false)
			this.addStock(stock);
		for(int i = 0 ; i < portfoliosize ; i++)
		{
			if(quantity == -1)
			{
				
				if(stock.getSymbol().equals(Stocks[i].getSymbol()))
				{
				int j = (int)(balance / Stocks[i].getAsk());
				this.balance -= Stocks[i].getAsk()*j;
				((Stock) Stocks[i]).setStockQuantity(((Stock) Stocks[i]).getStockQuantity()+j);
				isOk = true;
				}
			}
		
			else
			{
				if(stock.getSymbol().equals(Stocks[i].getSymbol()))
				{
					if(quantity * stock.getAsk() > this.balance)
					{
						throw new BalanceException();/*System.out.println("Not enough balance to complete purchase");*/
					}
		
					else
					{
						this.balance -= quantity * stock.getAsk();
						((Stock) Stocks[i]).setStockQuantity(((Stock) Stocks[i]).getStockQuantity()+quantity);
						isOk = true;
					}
				}
			}	
	}
		if(!isOk){
			throw new PortfolioFullException();
		}
	}
	public float getStocksValue() {
		float totalstockvalue = 0;
		for (int i = 0; i < portfoliosize; i++) {

			totalstockvalue += this.Stocks[i].getBid()
					* ((Stock) this.Stocks[i]).getStockQuantity();

		}
		return totalstockvalue;
	}

	public float getTotalValue() {

		return getStocksValue() + balance;

	}

	public static int getMaxSize() {
		
		return MAX_PORTFOLIO_SIZE;
	}

	 public StockInterface findStock(String symbol) {
		  if (symbol == null){
		   return null;
		  }
		  StockInterface temp = null;
		  for (int i = 0; i < this.portfoliosize; i++){
		   if (symbol.equals(this.Stocks[i].getSymbol())){
		    temp = this.Stocks[i];
		   
		   }
		  }
		  return temp;
		 }





}
