// Written by Toni Huffman
// 1/11/2017

package edu.seminolestate.volunteers;

import java.time.LocalDate;

public class ManageVolunteer {

	public static void main(String[] args) {
		// Instantiate a Volunteer object using constructor with parameters.
		Volunteer vol1 = new Volunteer("Toni", "Huffman", LocalDate.of(2017, 1, 11), 20);
		
		// Display the values of the first object using toString
		System.out.println("Volunteer 1\n" + vol1.toString());
		
		// Instantiate a second Volunteer object using no argument constructor
		Volunteer vol2 = new Volunteer();
		
		// Display the values using toString
		System.out.println("\nVolunteer 2\n" + vol2.toString());
		
		// Instantiate third Volunteer object using constructor with first/last name only
		Volunteer vol3 = new Volunteer("Michael", "Huffman");
		
		// Display values using toString
		System.out.println("\nVolunteer 3\n" + vol3.toString());
		
		// Update the hours worked for first object
		vol1.updateVolunteerHours(-2);
		
		// Change start date for the first object
		vol1.setStartDate(2017, 1, 5);
		
		// Display values of first object
		System.out.println("\nVolunteer 1 after updating hours and start date\n" + vol1.toString());

	}

}
