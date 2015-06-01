package com.mta.javacourse.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;






import org.algo.model.StockInterface;

import com.mta.javacourse.model.Portfolio.ALGO_RECOMMENDATION;



/**
 * 
 * This class represent a stock
 *
 */
public class Stock implements StockInterface  {
	
	 private String symbol ;
	 private Float ask;
	 private Float bid;
	 private java.util.Date date;
	 private  ALGO_RECOMMENDATION recommendation;
	 private int stockQuantity;
	 
	 
	
	 
	 public Stock ( String newsymbol, Float newask , Float newbid , java.util.Date newdate){
		 
		 this.symbol= newsymbol;
		 this.ask= newask;
		 this.bid= newbid;
		 this.date=newdate;
		 this.recommendation=ALGO_RECOMMENDATION.HOLD;
	 }
	 
	 public Stock (StockInterface stockInterface){
		 
		 this.symbol=new String(stockInterface.getSymbol()); 
		 this.ask=new Float(stockInterface.getAsk());
		 this.bid=new Float(stockInterface.getBid());
		 this.date=new java.util.Date(stockInterface.getDate().getTime());
		 
		 
	 }	
	 
	 
	 
	 public Stock() {
		  symbol = null;
		  ask = (float) 0;
		  bid = (float) 0;
		  this.date = null;		 
		  stockQuantity = 0;
		 }

	public String getsymbol() {
			return this.symbol;
		}
	 
	 public void setsymbol(String newsymbol){
		 this.symbol=newsymbol;
	 }
	 
	 public Float getask(){
		 return this.ask;		 
	 }
	 
	 public void setask(Float newask){
		 this.ask= newask;
	 }
	 
	 public Float getbid(){
		 return this.bid;
	 }
	 
	 public void setbid(Float newbid){
		 this.bid= newbid;
	 }
	 
	 public java.util.Date getdate(){
		 return this.date;
	 }
	 
	 public void setdate(java.util.Date newdate){
		 this.date=newdate;
	 }
	 
	 public String getHtmlDescription(){
		 DateFormat df=new SimpleDateFormat("MM/dd/yyyy");
		  String dateStr = df.format(date);
		  
		 String resultStr = new String("<b>Stock symbol is: </b>" + getsymbol() + "<b> ask: </b>" + getask() + "<b> Bid: </b>" + getbid() + "<b> Date: </b>" + dateStr + " The quantity is: " + this.getStockQuantity());
	     return resultStr;		
		     }
	 
	 

	
		public ALGO_RECOMMENDATION getRecommendation() {
			return recommendation;
		}
		public void setRecommendation(ALGO_RECOMMENDATION recommendation) {
			this.recommendation = recommendation;
		}
		public int getStockQuantity() {
			return stockQuantity;
		}
		public void setStockQuantity(int stockQuantity) {
			this.stockQuantity = stockQuantity;
		}

		@Override
		public String getSymbol() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public float getAsk() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public float getBid() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public Date getDate() {
			// TODO Auto-generated method stub
			return null;
		}

		public void setdate(long time) {
			// TODO Auto-generated method stub
			
		}	

}
