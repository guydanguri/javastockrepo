package PortfolioManager;


import com.mta.javacourse.Stock;
import com.mta.javacourse.model.portfolio;

public class protfoliomanger {
	
	public portfolio getPortfolio(){
		
		portfolio protfolio = new portfolio();
		
		protfolio.setTitle("Guy_Portfolio");
		
		@SuppressWarnings("deprecation")
		Stock stock1 = new Stock("HAM",16.4f , 11.4f,new java.util.Date(2015,8,15));		
		protfolio.addstock(stock1);
		
		@SuppressWarnings("deprecation")
		Stock stock2 = new Stock("DAR",13.2f , 11.8f,new java.util.Date(2015,8,15));
		protfolio.addstock(stock2);
		
		@SuppressWarnings("deprecation")
		Stock stock3 = new Stock("GAR",12.2f , 10.8f,new java.util.Date(2015,11,15));
		protfolio.addstock(stock3);		
		
		
		return protfolio ;
		
	}

}

	

