// Written by Toni Huffman
// 1/11/2017

package edu.seminolestate.volunteers;
import java.time.LocalDate;

public class Volunteer {
	// Private instance variables for:	
	// String for first name of volunteer
	private String firstName;
	
	// String for last name of volunteer
	private String lastName;
	
	// LocalDate for the date the volunteer starts
	private LocalDate startDate;
	
	// Double for the number of hours the volunteer has worked
	private double volunteerHours;
	
	// Public constants for:
	// Default first name
	public final static String DEFAULT_FIRST_NAME = "no first name assigned";
	
	// Default last name
	public final static String DEFAULT_LAST_NAME = "no last name assigned";
	
	// Default start date
	public final static LocalDate DEFAULT_START_DATE = LocalDate.now();
	
	// Default volunteer hours
	public final static double DEFAULT_HOURS = 0;
	
	// Public constructors (3):
	// (1) With parameters for each instance variable
	Volunteer(String firstname, String lastname, LocalDate start, double hours) {
		setFirstName(firstname);
		setLastName(lastname);
		setStartDate(start);
		setVolunteerHours(hours);	
	}
	
	// (2) With no parameters; defaults using this and constructor 1
	Volunteer() {
		this(DEFAULT_FIRST_NAME, DEFAULT_LAST_NAME, DEFAULT_START_DATE, DEFAULT_HOURS);
	}
	
	// (3) Parameters for first name and last name, using this and constructor 1
	Volunteer(String firstname, String lastname) {
		this(firstname, lastname, DEFAULT_START_DATE, DEFAULT_HOURS);
	}
	
	// Create getters and setters for each variable
	
	// (1) firstName
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String newFName) {
		// First name cannot be null or have a length of zero
		if (newFName != null && newFName.length() != 0) {
			this.firstName = newFName;
		} else {
			this.firstName = DEFAULT_FIRST_NAME;
		}
	}
	
	// (2) lastName
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String newLName) {
		// Last name cannot be null or have a length of zero
		if (newLName.length() != 0 && newLName != null) {
			this.lastName = newLName;
		} else {
			this.lastName = DEFAULT_LAST_NAME;	
		}
	}
	
	// (3) startDate
	public LocalDate getStartDate() {
		return startDate;
	}
	// Method to set start date; one parameter of type LocalDate that is used to update the start date.
	public void setStartDate(LocalDate newStartDate) {
		// Start date cannot be null
		if (newStartDate != null) {
			this.startDate = newStartDate;
		} else {
			this.startDate = DEFAULT_START_DATE;
		}
	}
	// Overloaded method having three int parameters for year, month and day. Use these to create LocalDate and update.
	public void setStartDate(int newYr, int newMonth, int newDay) {
		LocalDate newDate = LocalDate.of(newYr, newMonth, newDay);
		setStartDate(newDate);
	}
	
	// (4) volunteerHours
	public double getVolunteerHours() {
		return volunteerHours;
	}

	public void setVolunteerHours(double volunteerHours) {
		this.volunteerHours = volunteerHours;
	}
	
	// Public method to update volunteer hours. Add value to numberOfHours. Value could be negative.
	public void updateVolunteerHours(double hours) {
		setVolunteerHours(getVolunteerHours() + hours);
	}
	
	// toString method returns value of each variable.
	public String toString() {
		String str = "";
		str += "[firstName=" + this.getFirstName();
		str += ", lastName=" + this.getLastName();
		str += ", startDate=" + this.getStartDate();
		str += ", volunteerHours=" + this.getVolunteerHours() + "]";
		return str;
	}

}
