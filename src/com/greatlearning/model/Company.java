package com.greatlearning.model;

public class Company {
	private double sharePrice;
	private boolean stockPriceUp;
	
	public double getSharePrice() {
		return sharePrice;
	}
	public void setSharePrice(double sharePrice) {
		this.sharePrice = sharePrice;
	}
	public boolean isStockPriceUp() {
		return stockPriceUp;
	}
	public void setStockPriceUp(boolean stockPriceUp) {
		this.stockPriceUp = stockPriceUp;
	}
}
