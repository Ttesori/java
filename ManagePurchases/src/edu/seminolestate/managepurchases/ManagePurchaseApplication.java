// Written by Toni Huffman
// 2/24/2017

package edu.seminolestate.managepurchases;

import java.io.*;
import java.time.LocalDate;
import java.time.format.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ManagePurchaseApplication {
	private final static String FILE_NAME = "purchases.txt";
	

	public static void main(String[] args) {
		// Create list and retrieve existing purchases
		ArrayList<Purchase> purchases = loadPurchases();
		
		// Load keyboard scanner
		Scanner input = new Scanner(System.in);
		int option = 0;
		
		// Loop while exit isn't selected
		while (option != 3) {
			// Display Main Menu
			System.out.println("Enter your choice:");
			System.out.println("1 - Add a Purchase");
			System.out.println("2 - Display All Purchases");
			System.out.println("3 - Exit");
			
			try {
				// Try to enter menu option
				option = Integer.parseInt(input.nextLine());
				
				if (option == 1) {
					// Option 1: Add a purchase
					
					// Necessary variables
					String newName = null;
					String newStore = null;
					LocalDate newDate = null;
					double newCost = 0;
					boolean valid = false;
					
					// Enter product name
					while (!valid) {
						// Loop until data is valid
						System.out.println("Enter the product name.");
						newName = input.nextLine();
						if (newName.length() > 0) {
							// If length is greater than 0
							valid = true;
						} else {
							System.out.println("You must enter a value.");
						}
					}
					
					// User enters store name
					valid = false;
					while (!valid) {
						// Loop until data is valid
						System.out.println("Enter the store name.");
						newStore = input.nextLine();
						if (newStore.length() > 0) {
							// If length is greater than 0
							valid = true;
						} else {
							System.out.println("You must enter a value.");
						}
					}
					
					// User enters date in proper format
					DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("M/d/yyyy");
					valid = false;
					
					while (!valid) {
						// Loop until data is valid
						System.out.println("Enter the purchase date (like 1/1/2017).");
						try {
							// Try to parse user input as LocalDate
							newDate = LocalDate.parse(input.nextLine(),dateFormatter);
							// Make sure it's not null
							if (newDate != null) {
								valid = true;
							} else {
								System.out.println("You must enter a valid date.");
							} 
						} catch (DateTimeParseException e) {
							// Catch invalid date error
							System.out.println("You entered an invalid date.");
						}
					}
					
					// User enters cost
					valid = false;
					
					while (!valid) {
						// Loop until we get valid data
						System.out.println("Enter the cost.");
						try {
							// Try to parse input
							newCost = Double.parseDouble(input.nextLine());
							if (newCost >= 0) {
								// If number is greater than or equal to 0
								valid = true;
							} else {
								System.out.println("Cost must be >= 0.");
							}
						} catch (NumberFormatException e) {
							// If user enters non-numbers
							System.out.println("Enter only decimal numbers.");
						}	
					}
					
					// Create new object
					try {
						// Try to create new Purchase object
						Purchase p1 = new Purchase(newName, newStore, newDate, newCost);
						purchases.add(p1);
						System.out.println("Purchase created.");
					} catch (InvalidArgumentException e) {
						// Catch constructor error
						System.out.println("Error: " + e.getMessage());
					}
					
				} else if (option == 2) {
					// Option 2: Print all purchases to the screen
					
					if (purchases.size() > 0) {
						// Check to be sure purchases exist
						for (Purchase purchase : purchases) {
							// Print each to the screen
							System.out.println(purchase.toString());
						}
					} else {
						// If purchases list is empty
						System.out.println("There are no purchases.");
					}
					
				} else if (option == 3) {
					// Save purchases to a file and exit
					File saveFile = new File(FILE_NAME);
					
					try (
						// Try to create a file
						PrintWriter output = new PrintWriter(saveFile);
					) {
						for (Purchase purchase : purchases) {
							// For each member of array, output to file
							output.println(purchase.getProductName());
							output.println(purchase.getStoreName());
							output.println(purchase.getPurchaseDate().toString());
							output.println(String.valueOf(purchase.getCost()));
						}
						output.close();
					} catch (Exception e) {
						System.out.println("File error.");
					}
					System.out.println("Thank you for using the Purchase Tracker");
					
				} else {
					// ERROR: User enters invalid menu option
					throw new NumberFormatException();
				}
				
			} catch (NumberFormatException e) {
				// Prompt user for valid menu option.
				System.out.println("Invalid value. Enter a value 1-3.");
				option = 0;
			}
		}
		input.close();
	}

	// Load previous purchases into array
	private static ArrayList<Purchase> loadPurchases() {

		ArrayList<Purchase> purchases = new ArrayList<Purchase>();

		File file = new File(FILE_NAME);

		// If file exists
		if (file.exists()) {
			
			try (
				// Open file
				Scanner saveFile = new Scanner(file);
				) {
				// Create variables to store lines
				String newName;
				String newStore;
				LocalDate newDate;
				double newCost;
				
				while(saveFile.hasNext()) {
					// Parse data while there are lines left
					newName = saveFile.nextLine();
					newStore = saveFile.nextLine();
					newDate = LocalDate.parse(saveFile.nextLine());
					newCost = Double.parseDouble(saveFile.nextLine());

					// Create object, save to list
					purchases.add(new Purchase(newName, newStore, newDate, newCost));
				}

			} catch (Exception e) {
				// Catch any errors
				System.out.println("File error." + e.getMessage());
			}
		}
		// Return purchases list, empty if no purchases
		return purchases;	
	}

} 
