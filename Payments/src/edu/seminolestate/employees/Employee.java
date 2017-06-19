// Written by Toni Huffman
// March 15, 2017

package edu.seminolestate.employees;

import edu.seminolestate.exceptions.InvalidArgumentException;
import edu.seminolestate.payable.Payable;

public abstract class Employee implements Payable {
	
	private String firstName;
	private String lastName;
	private int iD;
	
	Employee(String newFName, String newLName, int newId) throws InvalidArgumentException {
		setFirstName(newFName);
		setLastName(newLName);
		setiD(newId);
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String newFName) throws InvalidArgumentException {
		if (newFName != null && newFName.length() > 0) {
			this.firstName = newFName;
		} else {
			throw new InvalidArgumentException();
		}	
	}
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String newLName) throws InvalidArgumentException {
		if (newLName != null && newLName.length() > 0) {
			this.lastName = newLName;
		} else {
			throw new InvalidArgumentException();
		}	
	}
	
	public int getiD() {
		return iD;
	}
	public void setiD(int newId) throws InvalidArgumentException {
		if (newId > 0) {
			this.iD = newId;
		} else {
			throw new InvalidArgumentException();
		}	
	}
	
	@Override
	public String toString() {
		return getClass() + " [firstName: " + this.getFirstName() + ", lastName: " + this.getLastName() + ", iD: " + this.getiD() + "]";
	}
	
	
	

}