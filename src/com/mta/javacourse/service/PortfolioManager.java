package com.mta.javacourse.service;

import java.util.Date;
import java.util.Calendar;

import com.mta.javacourse.model.Portfolio;
import com.mta.javacourse.model.Stock;

/**
 * 
 * This class is the portfolio manger.
 * 
 *
 */

@SuppressWarnings("unused")
public class PortfolioManager{
	/**
	 * 
	 * this method set a new portfolio and return a portfolio;
	 */
	public Portfolio getPortfolio(){
		
		Portfolio portfolio = new Portfolio();
		portfolio.setTitle("Guy_Portfolio");
		
		Calendar cal = Calendar.getInstance();
		cal.set(2015, 10, 15);
		
		java.util.Date d1 = cal.getTime();
		java.util.Date d2 = cal.getTime();
		java.util.Date d3 = cal.getTime();
		
		Stock stock1 = new Stock("HAM",16.4f ,11.4f, d1);		
		Stock stock2 = new Stock("DAR",13.2f ,11.8f, d2);
		Stock stock3 = new Stock("GAR",12.2f , 10.8f, d3);
		
		portfolio.addstock(stock1);
		portfolio.addstock(stock2);
		portfolio.addstock(stock3);		
		
		return portfolio;		
	}

}