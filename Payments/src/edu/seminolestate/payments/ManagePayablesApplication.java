// Written by Toni Huffman
// March 15, 2017

package edu.seminolestate.payments;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

import edu.seminolestate.bill.*;
import edu.seminolestate.employees.*;
import edu.seminolestate.payable.*;

public class ManagePayablesApplication {
	static Scanner keyboard = new Scanner(System.in);

	public static void main(String[] args) {
		// Create an ArrayList to store Payable objects
		ArrayList<Payable> payable = new ArrayList<Payable>();
		
		int input = 0;
		
		while (input != 6) {
			// Main program loop
			
			try {
				// Display main menu
				displayMainMenu();
				System.out.println("Enter a menu choice 1-6");
				input = Integer.parseInt(keyboard.nextLine());
				
				if (input == 1) {
					// MENU OPTION 1
					// Add Hourly Employee
					
					// Initialize variables
					String newFName = null;
					String newLName = null;
					int newId = 0;
					double newHours = 0;
					double newRate = 0;
					
					// Prompt for an employee first name
					newFName = getFName();
					
					// Prompt for an employee last name
					newLName = getLName();
					
					// Prompt for an employee ID
					newId = getId();
					
					// Prompt for hours worked
					boolean valid = false;
					
					while (!valid) {
						System.out.println("Enter the hours worked:");
						
						try {
							newHours = Double.parseDouble(keyboard.nextLine());
							
							if (newHours > 0) {
								valid = true;	
							} else {
								System.out.println("Hours worked must be greater than zero.");
							}
						} catch (Exception e) {
							System.out.println("Enter only numbers");
						}
						
						
					}
					
					// Prompt for pay rate
					valid = false;
					
					while (!valid) {
						System.out.println("Enter the pay rate:");
						
						// Try to get user input
						try {
							newRate = Double.parseDouble(keyboard.nextLine());
							
							if (newRate > 0) {
								valid = true;	
							} else {
								System.out.println("Pay rate must be greater than zero.");
							}
						} catch (Exception e) {
							System.out.println("Enter only numbers");
						}
		
					}
					
					// Create HourlyEmployee Object
					try {
						HourlyEmployee employee = new HourlyEmployee(newFName, newLName, newId, newHours, newRate);
						payable.add(employee);
						System.out.println("Hourly employee created.");
					} catch (Exception e) {
						System.out.println("Error creating employee.");
						System.out.println(e.getMessage());
					}
					
					
				} else if (input == 2) {
					// MENU OPTION 2
					// Add Manager
					
					// Initialize variables
					String newFName = null;
					String newLName = null;
					int newId = 0;
					double newSalary = 0;
					
					// Prompt for an employee first name
					newFName = getFName();
					
					// Prompt for an employee last name
					newLName = getLName();
					
					// Prompt for an employee ID
					newId = getId();
					
					// Prompt for annual salary
					newSalary = getAnnualSalary();
					
					// Create Manager Object
					try {
						Manager employee = new Manager(newFName, newLName, newId, newSalary);
						payable.add(employee);
						System.out.println("Manager created.");
					} catch (Exception e) {
						System.out.println("Error creating employee.");
						System.out.println(e.getMessage());
					}
					
					
				} else if (input == 3) {
					// MENU OPTION 3
					// Add Sales Manager
					
					// Initialize variables
					String newFName = null;
					String newLName = null;
					int newId = 0;
					double newSalary = 0;
					double newSales = 0;
					double newRate = 0;
					
					// Prompt for an employee first name
					newFName = getFName();
					
					// Prompt for an employee last name
					newLName = getLName();
					
					// Prompt for an employee ID
					newId = getId();
					
					// Prompt for annual salary
					newSalary = getAnnualSalary();
					
					// Prompt for sales amount
					boolean valid = false;
					
					while (!valid) {
						System.out.println("Enter the sales amount:");
						
						try {
							newSales = Double.parseDouble(keyboard.nextLine());
							
							if (newSales > 0) {
								valid = true;	
							} else {
								System.out.println("Hours worked must be greater than zero.");
							}
						} catch (Exception e) {
							System.out.println("Enter only numbers");
						}
		
					}
					
					// Prompt for commission rate
					valid = false;
					
					while (!valid) {
						System.out.println("Enter the commission rate (between 0 and 1):");
						
						try {
							newRate = Double.parseDouble(keyboard.nextLine());
							
							if (newRate >= 0 && newRate <= 1) {
								valid = true;	
							} else {
								System.out.println("Commission rate must be between 0 and 1.");
							}
						} catch (Exception e) {
							System.out.println("Enter only numbers");
						}		
						
					}
					
					// Create new Sales Manager object
					try {
						SalesManager employee = new SalesManager(newFName, newLName, newId, newSalary, newSales, newRate);
						payable.add(employee);
						System.out.println("Sales Manager created.");
					} catch (Exception e) {
						System.out.println("Error creating employee.");
						System.out.println(e.getMessage());
					}
								
					
				} else if (input == 4) {
					// MENU OPTION 4
					// Add Bill
					String newName = null;
					double newAmount = 0;
					LocalDate newDueDate = null;
					
					// Prompt for vendor name
					boolean valid = false;
					newName = null;
					
					while (!valid) {
						System.out.println("Enter the vendor name:");
						newName = keyboard.nextLine();
					
						
						if (newName != null && newName.length() > 0) {
							valid = true;
						} else {
							System.out.println("Vendor name must be entered.");
						}
					}
					
					// Prompt for amount
					valid = false;
					
					while (!valid) {
						System.out.println("Enter the amount due:");
						
						// Try to get user input
						try {
							newAmount = Double.parseDouble(keyboard.nextLine());
							
							// Validate salary amount
							if (newAmount > 0) {
								valid = true;	
							} else {
								System.out.println("Amount due must be greater than zero.");
							}
						} catch (Exception e) {
							System.out.println("Enter only numbers");
						}
						

					}
					
					// Prompt for due date
					DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("M/d/yyyy");
					valid = false;
					
					while (!valid) {
						// Loop until data is valid
						System.out.println("Enter the due date (like 1/1/2017).");
						try {
							// Try to parse user input as LocalDate
							newDueDate = LocalDate.parse(keyboard.nextLine(),dateFormatter);
							// Make sure it's not null
							if (newDueDate != null) {
								valid = true;
							} else {
								System.out.println("You must enter a valid date.");
							} 
						} catch (DateTimeParseException e) {
							// Catch invalid date error
							System.out.println("You entered an invalid date.");
						}
					}
					
					// Create Bill object
					try {
						Bill bill = new Bill(newName, newAmount, newDueDate);
						payable.add(bill);
					} catch (Exception e) {
						System.out.println("Error creating bill.");
						System.out.println(e.getMessage());
					}
					
					
					
				} else if (input == 5) {
					if (payable.isEmpty()) {
						System.out.println("Payables list is empty.");
					} else {
						for (Payable payables : payable) {
							System.out.println(payables.toString());
							NumberFormat nfCurrencyFormat = NumberFormat.getCurrencyInstance();
							System.out.println("Amount to pay: " + nfCurrencyFormat.format(payables.computeAmountToPay()));
						}
					}	
				}
					
			} catch (NumberFormatException e) {
				// Invalid input
				System.out.println("Invalid input. Enter a menu choice 1-6.");
			}
			
		}
		
		// Exit the program
		System.out.println("Thank you for using Manage Payables.");
		keyboard.close();
	}
	
	public static void displayMainMenu() {
		// Display main menu
		System.out.println("Main Menu");
		System.out.println("1 - Add hourly employee");
		System.out.println("2 - Add manager");
		System.out.println("3 - Add sales manager");
		System.out.println("4 - Add bill");
		System.out.println("5 - List all payables");
		System.out.println("6 - Exit");
	}
	
	public static String getFName() {
		// Prompt the user for First Name
		boolean valid = false;
		String newFName = null;
		
		while (!valid) {
			// Loop until valid input
			System.out.println("Enter the employee first name:");
			newFName = keyboard.nextLine();
			
			if (newFName != null && newFName.length() > 0) {
				valid = true;
			} else {
				System.out.println("Employee first name must be entered.");
			}
		}
		return newFName;
	}
	
	public static String getLName() {
		// Prompt the user for Last Name
		boolean valid = false;
		String newLName = null;
		
		while (!valid) {
			// Loop until valid input
			System.out.println("Enter the employee last name:");
			newLName = keyboard.nextLine();
			
			if (newLName != null && newLName.length() > 0) {
				valid = true;
				
			} else {
				System.out.println("Employee last name must be entered.");
			}
		}
		return newLName;
	}
	
	public static int getId() {
		// Prompt for user ID
		boolean valid = false;
		int newId = 0;
		
		while (!valid) {
			// Loop until valid input
			System.out.println("Enter the employee ID:");
			
			try {
				newId = Integer.parseInt(keyboard.nextLine());
				
				if (newId > 0) {
					valid = true;	
				} else {
					System.out.println("Employee ID must be greater than zero.");
				}
			} catch (NumberFormatException e) {
				System.out.println("Enter only numbers");
			}
				
		}
		return newId;
	}
	
	public static double getAnnualSalary() {
		// Prompt for annual salary
		boolean valid = false;
		double newSalary = 0;
		
		while (!valid) {
			// Loop until valid amount
			System.out.println("Enter the annual salary:");
			
			// Try to get user input
			try {
				newSalary = Double.parseDouble(keyboard.nextLine());
				
				// Validate salary amount
				if (newSalary > 0) {
					valid = true;	
				} else {
					System.out.println("Salary must be greater than zero.");
				}
			} catch (Exception e) {
				System.out.println("Enter only numbers");
			}	
		}
		return newSalary;
	}

}
