package edu.seminolestate.managepurchases;

/*
 * AUTHOR:	R Grant
 * DATE:	2/2017
 * This is a checked exception since it extends the Exception class.
 */
public class InvalidArgumentException extends Exception {
	public InvalidArgumentException(){
		super("Invalid values sent to method");
	}
	public InvalidArgumentException(String msg){
		super(msg);
	}
}