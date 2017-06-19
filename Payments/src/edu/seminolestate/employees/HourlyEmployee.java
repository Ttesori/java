// Written by Toni Huffman
// March 15, 2017

package edu.seminolestate.employees;

import edu.seminolestate.exceptions.InvalidArgumentException;
import edu.seminolestate.payable.Payable;

public class HourlyEmployee extends Employee implements Payable {
	private double hoursWorked;
	private double payRate;
	
	public HourlyEmployee(String newFName, String newLName, int newId, double newHours, double newRate) throws InvalidArgumentException {
		super(newFName, newLName, newId);
		setHoursWorked(newHours);
		setPayRate(newRate);	
	}

	public double getHoursWorked() {
		return hoursWorked;
	}

	public void setHoursWorked(double newHours) throws InvalidArgumentException {
		 if (newHours > 0) {
			 this.hoursWorked = newHours;
		 } else {
			 throw new InvalidArgumentException();
		 }
		
	}

	public double getPayRate() {
		return payRate;
	}

	public void setPayRate(double newRate) throws InvalidArgumentException {
		if (newRate > 0) {
			this.payRate = newRate;
		} else {
			throw new InvalidArgumentException();
		}		
	}
	
	public double computeAmountToPay() {
		return getHoursWorked() * getPayRate();
	}
	
	@Override
	public String toString() {
		return super.toString() + " " + getClass() + " [hoursWorked: " + this.getHoursWorked() + ", payRate: " + this.getPayRate() + "]";
	}

}
