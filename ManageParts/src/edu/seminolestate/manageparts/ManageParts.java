// Written by Toni Huffman
// 2/15/2017

package edu.seminolestate.manageparts;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class ManageParts {
	
	// Function to see if ID exists in list
	public static boolean checkId(int id, ArrayList<Part> list) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getPartID() == id) {
				// Match found
				return true;
			} 
		}
		// No match found
		return false;
	}

	public static void main(String[] args) {
		// Create ArrayList of Part type
		ArrayList<Part> parts = new ArrayList<Part>();
		
		// Load Scanner
		Scanner input = new Scanner(System.in);
		int option = 0;
		
		// Main Program Loop, Exits on 5
		while (option != 5) {
			System.out.println("Enter your choice:");
			System.out.println("1. Create Purchased Part");
			System.out.println("2. Create Manufactured Part");
			System.out.println("3. List a part");
			System.out.println("4. List all parts");
			System.out.println("5. Exit");
			option = input.nextInt();
			
			if (option == 1) {
				// Create Purchased Part
				
				// Enter ID, check if it's unique
				boolean isDupId = true;
				int id = 0;
				while (isDupId == true) {
					// Loop until valid ID is entered
					System.out.print("Enter Part Number: ");
					id = input.nextInt();
					isDupId = checkId(id,parts);
					if (isDupId) {
						System.out.println("That ID is already used.");
					}
				}
				
				input.nextLine();
				System.out.print("Enter Part Description: ");
				String desc = input.nextLine();
				
				System.out.print("Enter Sell Price: ");
				double sellPrice = input.nextDouble();
				
				System.out.print("Enter Purchase Price: ");
				double pPrice = input.nextDouble();
				
				System.out.print("Enter Handling Cost: ");
				double hCost = input.nextDouble();
				
				input.nextLine();
				System.out.print("Enter Vendor: ");
				String vendor = input.nextLine();
				
				// Create object, add to list
				PurchasedPart pPart1 = new PurchasedPart(id, desc, sellPrice, hCost, pPrice, vendor);
				parts.add(pPart1);
				System.out.println("Purchased part added.\n");
							
			} else if (option == 2) {
				// Create Manufactured Part
				
				// Check to be sure ID is unique
				boolean isDupId = true;
				int id = 0;
				while (isDupId == true) {
					// Loop until valid ID is entered
					System.out.print("Enter Part Number: ");
					id = input.nextInt();
					isDupId = checkId(id,parts);
					if (isDupId) {
						System.out.println("That ID is already used.");
					}
				}
				
				input.nextLine();
				System.out.print("Enter Part Description: ");
				String desc = input.nextLine();
				
				System.out.print("Enter Sell Price: ");
				double sellPrice = input.nextDouble();
				
				System.out.print("Enter Labor Cost: ");
				double lCost = input.nextDouble();
				
				System.out.print("Enter Material Cost: ");
				double mCost = input.nextDouble();
				
				// Create object, add to list
				ManufacturedPart mPart1 = new ManufacturedPart(id, desc, sellPrice, lCost, mCost);
				parts.add(mPart1);
				System.out.println("Manufactured part added.\n");
					
			} else if (option == 3) {
				// List a part
				if (parts.isEmpty()) {
					// Parts list is empty 
					System.out.println("There are no parts to list");
				} else {
					// Prompt for part ID
					System.out.print("Enter Part ID: ");
					int id = input.nextInt();
					
					// Check Part ID
					if (checkId(id, parts)) {
						// Part ID is found
						for (Part part : parts) { // Hopefully this "foreach" syntax is okay, was mentioned in video
							if (part.getPartID() == id) {
								System.out.println(part.toString());
								// Format cost
								NumberFormat nfCurrencyFormat = NumberFormat.getCurrencyInstance();
								System.out.println("Part Cost: " + nfCurrencyFormat.format(part.getTotalCost()));
							} 
						}	
					} else {
						// Part ID is not found
						System.out.println(id + " was not found");
					}
				}
			} else if (option == 4) {
				// List all parts
				if (parts.isEmpty()) {
					// If parts list is empty
					System.out.println("There are no parts to list");
				} else {
					// Print all parts
					System.out.println("All Parts:");
					for (Part part : parts) { // Hopefully this "foreach" syntax is okay, was mentioned in video
						System.out.println(part.toString());
						// Format cost
						NumberFormat nfCurrencyFormat = NumberFormat.getCurrencyInstance();
						System.out.println("Part Cost: " + nfCurrencyFormat.format(part.getTotalCost()));
					}
				}
			} else if (option == 5) {
				// Exit option is selected
				System.out.println("Thanks for using the parts manager!");
			} else {
				// Invalid option is entered
				System.out.println("Invalid value. Enter a value 1-5");
			}
			
		}
		
	}

}
