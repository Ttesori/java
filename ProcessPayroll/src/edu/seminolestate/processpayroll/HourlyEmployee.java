// Modified by Toni Huffman
// 4-19-2017

package edu.seminolestate.processpayroll;

public class HourlyEmployee {

	public static final double OT_HOURS = 40;
	public static final double OT_MULTIPLIER = 1.5;
	private String name;
	private double hoursWorked;
	private double hourlyRate;

	public HourlyEmployee(String newName, double hoursWorked, double hourlyRate) throws IllegalArgumentException{
		this.setName(newName);
		this.setHoursWorked(hoursWorked);
		this.setHourlyRate(hourlyRate);
	}

	public String getName() {
		return name;
	}

	public void setName(String newName) throws IllegalArgumentException{
		if (newName == null || newName.length() < 1)
			throw new IllegalArgumentException("Name cannot be null or empty.");
		else
			this.name = newName;
	}

		public double getHoursWorked() {
		return hoursWorked;
	}

	public void setHoursWorked(double newHoursWorked) throws IllegalArgumentException{
		if (newHoursWorked <= 0)
			throw new IllegalArgumentException("Hours worked must be > 0.");
		else
			this.hoursWorked = newHoursWorked;
	}

	public double getHourlyRate() {
		return hourlyRate;
	}

	public void setHourlyRate(double newHourlyRate) throws IllegalArgumentException{
		if (newHourlyRate <= 0)
			throw new IllegalArgumentException("Hourly rate must be > 0.");
		else
			this.hourlyRate = newHourlyRate;
	}

	public double computeGrossPay() {
		double grossPay = 0;

		if (getHoursWorked() <= OT_HOURS) {
			grossPay = getHourlyRate()*getHoursWorked();
		} else {
			grossPay = (getHourlyRate()*OT_HOURS) + ((getHoursWorked()-OT_HOURS)*(getHourlyRate()*OT_MULTIPLIER));
		}
		return grossPay;
	}

	public double computeTaxAmount() {
		double taxAmount = 0;

		if (computeGrossPay() >= 10000) {
			taxAmount = computeGrossPay() * .2;
		} else if (computeGrossPay() >= 5000) {
			taxAmount = computeGrossPay() * .15;
		} else if (computeGrossPay() >= 1000 ) {
			taxAmount = computeGrossPay()*.1;
		} else {
			taxAmount = computeGrossPay()*.05;
		}

		return taxAmount;
	}

	public double computeNetPay() {
		return computeGrossPay() - computeTaxAmount();
	}

	@Override
	public String toString() {
		return "HourlyEmployee [name=" + name + ", hoursWorked=" + hoursWorked + ", hourlyRate=" + hourlyRate + "]";
	}
}

