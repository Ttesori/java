// Written by Toni Huffman
// 2/15/2017

package edu.seminolestate.manageparts;

public class PurchasedPart extends Part {
	private double purchasePrice; //what does this part cost to buy?
	private String vendor;  //who do we buy this part from?
	private double handlingCost; //shipping and handling costs when we buy it
	public static final String DEFAULT_VENDOR_NAME = "no vendor name";
	public static final double DEFAULT_PURCHASE_PRICE = 0;
	public static final double DEFAULT_HANDLING_COST = 0; 
	
	// Constructors
	public PurchasedPart(int ID) {
		this(ID, DEFAULT_DESCRIPTION, DEFAULT_SELL_PRICE, DEFAULT_HANDLING_COST, DEFAULT_PURCHASE_PRICE, DEFAULT_VENDOR_NAME);
	}
	
	public PurchasedPart(int ID, double hCost, double pPrice, String vendor) {
		this(ID,DEFAULT_DESCRIPTION,DEFAULT_SELL_PRICE,hCost,pPrice,vendor);
	}
	
	public PurchasedPart(int ID, String desc, double sellPrice, double hCost, double pPrice, String vendor) {
		super(ID, desc, sellPrice);
		// Handling Cost can't be negative
		if (hCost >= 0) {
			setHandlingCost(hCost);
		} else {
			setHandlingCost(DEFAULT_HANDLING_COST);
		}
		
		// Purchase price can't be negative
		if (pPrice >= 0) {
			setPurchasePrice(pPrice);
		} else {
			setPurchasePrice(DEFAULT_PURCHASE_PRICE);
		}
		
		// Vendor name can't be null or blank
		if (vendor != null && vendor.length() > 0) {
			setVendor(vendor);
		} else {
			setVendor(DEFAULT_VENDOR_NAME);
		}
	}
	
	// Purchase Price Getter and Setter
	public double getPurchasePrice() {
		return purchasePrice;
	}
	public void setPurchasePrice(double newPrice) {
		// Only set if positive
		if (newPrice >= 0) {
			purchasePrice = newPrice;
		}
	}
	
	// Handling Cost Getter and Setter
	public double getHandlingCost() {
		return handlingCost;
	}
	public void setHandlingCost(double newCost) {
		// Only set if positive
		if (newCost >= 0) {
			handlingCost = newCost;
		}
	}
	
	// Vendor Name Getter and Setter
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String newVendor) {
		// Only set if not null
		if (newVendor.length() > 0 && newVendor != null) {
			vendor = newVendor;
		}
	}
	
	// toString
	@Override
	public String toString() {
		return super.toString() + " " + this.getClass() + " [handlingCost=" + getHandlingCost() + ", purchasePrice=" + getPurchasePrice() + ", vendor=" + getVendor() + "]";
	}
	
	// Total Cost
	@Override
	public double getTotalCost() {
		return super.getTotalCost() + getHandlingCost() + getPurchasePrice();
	}
	
	
}
