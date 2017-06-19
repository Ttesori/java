// Written by Toni Huffman
// March 15, 2017

package edu.seminolestate.employees;

import edu.seminolestate.exceptions.InvalidArgumentException;
import edu.seminolestate.payable.Payable;

public class SalesManager extends Manager implements Payable {
	private double salesAmount;
	private double commissionRate;
	
	public SalesManager(String newFName, String newLName, int newId, double salary, double sales, double rate) throws InvalidArgumentException {
		super(newFName, newLName, newId, salary);
		setSalesAmount(sales);
		setCommissionRate(rate);
	}

	public double getSalesAmount() {
		return salesAmount;
	}

	public void setSalesAmount(double newSales) throws InvalidArgumentException {
		if (newSales >= 0) {
			this.salesAmount = newSales;
		} else {
			throw new InvalidArgumentException("Sales must be greater than or equal to zero.");
		}
		
	}

	public double getCommissionRate() {
		return commissionRate;
	}

	public void setCommissionRate(double newRate) throws InvalidArgumentException {
		if (newRate >= 0 && newRate <= 1) {
			this.commissionRate = newRate;
		} else {
			throw new InvalidArgumentException("Commission rate must be between 0 and 1");
		}
		
	}
	
	public double computeAmountToPay() {
		return getAnnualSalary() + (getSalesAmount() * getCommissionRate());
	}
	
	@Override
	public String toString() {
		return super.toString() + " " + getClass() + " [salesAmount: " + this.getSalesAmount() + ", commissionRate: " + this.getCommissionRate() + "]";
	}

}
