package com.mta.javacourse.service;

import java.util.Date;
import java.util.Calendar;

import org.apache.tools.ant.types.CommandlineJava.SysProperties;

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
		
		Portfolio myPortfolio = new Portfolio();
		myPortfolio.setTitle("Exercise 7 portfolio");
		myPortfolio.setBalance(10000f);
		Calendar cal = Calendar.getInstance();
		cal.set(2014, 11, 15);
		
		java.util.Date d1 = cal.getTime();
		java.util.Date d2 = cal.getTime();
		java.util.Date d3 = cal.getTime();
		
		Stock stock1 = new Stock("PIA",10.0f ,8.5f, d1);		
		Stock stock2 = new Stock("AAL",30.0f ,25.5f, d2);
		Stock stock3 = new Stock("CAAS",20.0f , 15.5f, d3);
		
		
		System.out.println("what going on?");
		
		
		
		myPortfolio.buyStock(stock1, 20);
		myPortfolio.buyStock(stock2, 30);
		myPortfolio.buyStock(stock3, 40);
		
		myPortfolio.sellStock("AAL",-1);
		myPortfolio.removeStock("CAAS");
		
		return myPortfolio;
		
		

	}

}