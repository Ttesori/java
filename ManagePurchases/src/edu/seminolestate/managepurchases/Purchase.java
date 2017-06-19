// Written by Toni Huffman
// 2/24/2017

package edu.seminolestate.managepurchases;

import java.time.LocalDate;

public class Purchase {
	// Variables
	String productName;
	String storeName;
	LocalDate purchaseDate;
	double cost;
	
	// Constructor
	Purchase(String newName, String newStore, LocalDate newDate, double newCost) throws InvalidArgumentException {
		setProductName(newName);
		setStoreName(newStore);
		setPurchaseDate(newDate);
		setCost(newCost);
	}
	
	// Getters and Setters
	
	// Product Name
	public String getProductName() {
		return productName;
	}
	
	public void setProductName(String newName) throws InvalidArgumentException {
		if (newName.length() > 0 && newName != null) {
			this.productName = newName;
		} else {
			throw new IllegalArgumentException();
		}
		
	}
	
	// Store Name
	public String getStoreName() {
		return storeName;
	}
	
	public void setStoreName(String newStore) throws InvalidArgumentException {
		if (newStore.length() > 0 && newStore != null) {
			this.storeName = newStore;
		} else {
			throw new IllegalArgumentException();
		}
	}
	
	// Purchase Date
	public LocalDate getPurchaseDate() {
		return purchaseDate;
	}
	
	public void setPurchaseDate(LocalDate newDate) throws InvalidArgumentException {
		if (newDate != null) {
			this.purchaseDate = newDate;
		} else {
			throw new IllegalArgumentException();
		}
		
	}
	
	// Cost
	public void setCost(double newCost) throws InvalidArgumentException {
		if (newCost >= 0) {
			this.cost = newCost;
		} else {
			throw new IllegalArgumentException();
		}
	}
	
	public double getCost() {
		return cost;
	}
	
	@Override
	// Override toString
	public String toString() {
		return this.getClass() + " [productName: " + this.productName + ", storeName: " + this.storeName + ", purchaseDate: " + this.purchaseDate + ", cost: " + this.cost + "]";
	}
	
}
