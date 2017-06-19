// Written by Toni Huffman
// March 15, 2017

package edu.seminolestate.employees;

import edu.seminolestate.exceptions.InvalidArgumentException;
import edu.seminolestate.payable.Payable;

public class Manager extends Employee implements Payable {
	
	public Manager(String newFName, String newLName, int newId, double salary) throws InvalidArgumentException {
		super(newFName, newLName, newId);
		setAnnualSalary(salary);
	}
	private double annualSalary;

	public double getAnnualSalary() {
		return annualSalary;
	}

	public void setAnnualSalary(double newSalary) throws InvalidArgumentException {
		if (newSalary > 0) {
			this.annualSalary = newSalary;
		} else {
			throw new InvalidArgumentException();
		}
		
	}
	
	public double computeAmountToPay() {
		return getAnnualSalary() / 12;
	}
	
	@Override
	public String toString() {
		return super.toString() + " " + getClass() + " [annualSalary: " + this.getAnnualSalary() + "]";
	}
	

}
