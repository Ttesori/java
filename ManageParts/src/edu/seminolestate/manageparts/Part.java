// Written by Toni Huffman
// 2/15/2017

package edu.seminolestate.manageparts;

public class Part {
	private int partID;
	private String partDescription;
	private double partSellPrice;
	public static final String DEFAULT_DESCRIPTION = "no part description";
	public static final double DEFAULT_SELL_PRICE = 0;
	
	// Constructors
	public Part(int ID) {
		this(ID,DEFAULT_DESCRIPTION,DEFAULT_SELL_PRICE);
	}
	public Part(int ID, String desc, double sellPrice) {
		setPartID(ID);
		// Description cannot be null or negative
		if (desc != null && desc.length() > 0) {
			setPartDescription(desc);
		} else {
			setPartDescription(DEFAULT_DESCRIPTION);
		}
		// Selling price cannot be negative
		if (sellPrice >= 0) {
			setSellPrice(sellPrice);
		} else {
			setSellPrice(DEFAULT_SELL_PRICE);
		}

	}
	
	// Set Part ID
	public void setPartID (int newId) {
		// Only set if positive
		if (newId >= 0) {
			partID = newId;
		}	
	}
	// Get Part ID
	public int getPartID() {
		return partID;
	}
	
	// Set Description
	public void setPartDescription(String newDesc) {
		// Ensure description length
		if (newDesc.length() > 0 && newDesc != null) {
			partDescription = newDesc;
		} 
	}
	// Get Description
	public String getPartDescription() {
		return partDescription;
	}
	
	// Set Sell Price
	public void setSellPrice(double newSellPrice) {
		// Ensure sell price is greater than zero
		if (newSellPrice > 0) {
			partSellPrice = newSellPrice;
		} 
	}
	// Get Sell Price
	public double getPartSellPrice() {
		return partSellPrice;
	}
	
	// Get Total Cost
	public double getTotalCost() {
		return 0;
	}
	
	// toString
	@Override
	public String toString() {
		return this.getClass() + " [partID=" + getPartID() + ", partDescription=" + getPartDescription() + ", partSellPrice=" + getPartSellPrice() + "]";
	}
}
