package com.mta.javacourse.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;




import com.mta.javacourse.model.Portfolio.ALGO_RECOMMENDATION;



/**
 * 
 * This class represent a stock
 *
 */
public class Stock {
	
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
	 
	 public Stock (Stock stock){
		 
		 this.symbol=new String(stock.getsymbol()); 
		 this.ask=new Float(stock.getask());
		 this.bid=new Float(stock.getbid());
		 this.date=new java.util.Date(stock.getdate().getTime());
		 
		 
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

}
