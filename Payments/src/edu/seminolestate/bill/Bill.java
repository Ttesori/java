// Written by Toni Huffman
// March 15, 2017

package edu.seminolestate.bill;

import java.time.DateTimeException;
import java.time.LocalDate;

import edu.seminolestate.exceptions.InvalidArgumentException;
import edu.seminolestate.payable.Payable;

public class Bill implements Payable{
	
	private String vendorName;
	private double amountOwed;
	private LocalDate dueDate;
	
	public Bill(String vendor, double amount, LocalDate dueDate) throws InvalidArgumentException {	
		setVendorName(vendor);
		setAmountOwed(amount);
		setDueDate(dueDate);
	}
	
	public double computeAmountToPay() {
		return amountOwed;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String newName) throws InvalidArgumentException {
		if (newName != null && newName.length() > 0) {
			this.vendorName = newName;
		} else {
			throw new InvalidArgumentException("Vendor name cannot be set.");
		}
		
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate newDueDate) throws InvalidArgumentException {
		if (newDueDate != null) {
			this.dueDate = newDueDate;
		} else {
			throw new InvalidArgumentException("Due date cannot be null.");
		}
		
	}
	
	public void setDueDate(int newMonth, int newDay, int newYear) throws DateTimeException {
		this.dueDate = LocalDate.of(newYear, newMonth, newDay);
	}

	public double getAmountOwed() {
		return amountOwed;
	}

	public void setAmountOwed(double newAmount) throws InvalidArgumentException {
		if (newAmount > 0) {
			this.amountOwed = newAmount;
		} else {
			throw new InvalidArgumentException("Amount owed must be greater than zero.");
		}
	}
	
	@Override
	public String toString() {
		return getClass() + " [vendorName: " + this.getVendorName() + ", amountOwed: " + this.getAmountOwed() + ", dueDate: " + this.getDueDate() + "]";
	}

}
