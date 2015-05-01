package com.mta.javacourse;

public class Stock {
	
	 private String symbol ;
	 private Float ask;
	 private Float bid;
	 private java.util.Date date;
	 private int recommendation;
	 private int stockQuantity;
	 
	 private static final int BUY=0, SELL=1,REMOVE=2, HOLD=3;
	 
	 public Stock ( String newsymbol, Float newask , Float newbid , java.util.Date newdate){
		 
		 this.symbol= newsymbol;
		 this.ask= newask;
		 this.bid= newbid;
		 this.date=newdate;
	 }
	 public String getstmbol() {
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
			return "<b>Stock symbol</b> : "+this.getstmbol()+", <b>ask</b> : "+this.getask()+", <b>Bid</b>: "+this.getbid()+", <b>Date</b>: "+this.getDateMonth()+"/"+this.getDateDay()+"/"+this.getDateYear(); 
		}
		@SuppressWarnings("deprecation")
		public int getDateDay(){
			return this.date.getDate();
		}
		@SuppressWarnings("deprecation")
		public int getDateMonth(){
			return this.date.getMonth();
		}
		@SuppressWarnings("deprecation")
		public int getDateYear(){
			return this.date.getYear();
		}
		public String getHtmlDesc() {
			// TODO Auto-generated method stub
			return null;
		}
		public int getRecommendation() {
			return recommendation;
		}
		public void setRecommendation(int recommendation) {
			this.recommendation = recommendation;
		}
		public int getStockQuantity() {
			return stockQuantity;
		}
		public void setStockQuantity(int stockQuantity) {
			this.stockQuantity = stockQuantity;
		}
		
	     
	 
	 
	 
	

}
