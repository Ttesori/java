// Used by Toni Huffman
// 4/26/2017

package edu.seminolestate.reserveroom;

/*
 * AUTHOR:		R Grant
 * DATE:		10/2016
 * PURPOSE:		This class represents a simple room reservation. It has
 * 				constants for room rates and options associated with
 * 				rooms.
 */
public class Reservation {
	public static final int 	BUDGET_ROOM = 0;
	public static final int 	BUSINESS_ROOM = 1;
	public static final int 	DELUXE_ROOM = 2;
	public static final double 	BUDGET_ROOM_RATE = 100;
	public static final double 	BUSINESS_ROOM_RATE = 150;
	public static final double 	DELUXE_ROOM_RATE = 300;
	public static final double 	BREAKFAST_PKG_RATE = 7;
	public static final double	SMOKING_RATE = 5;

	private int roomType;
	private int numOfNights;
	private String guestName;
	private boolean isSmokingRoom;
	private boolean isBreakfastPackage;

	public Reservation() {
		//Use default values for all data members except name and # of nights:
		this(0, "No name for guest", 1, false, false);
	}

	public Reservation(int roomType,
			String guestName,
			int numOfNights,
			boolean isSmokingRoom,
			boolean isBreakfastPackage) {
		setRoomType(roomType);
		setSmokingRoom(isSmokingRoom);
		setNumOfNights(numOfNights);
		setGuestName(guestName);
		setBreakfastPackage(isBreakfastPackage);
	}
	/*
	 * Calculation for total cost of reservation is:
	 * (room rate + breakfast plan rate +
	 *    smoking surcharge) * number of nights
	 */
	public double getAmountDue(){
		double rate = 0;
		if (this.roomType == BUDGET_ROOM)
			rate = BUDGET_ROOM_RATE;
		else
		if (this.roomType == BUSINESS_ROOM)
			rate = BUSINESS_ROOM_RATE;
		else {
			rate = DELUXE_ROOM_RATE;
		}
		double amount = rate * this.numOfNights;

		if (this.isBreakfastPackage)
			amount += BREAKFAST_PKG_RATE * this.numOfNights;

		if (this.isSmokingRoom)
			amount += SMOKING_RATE * this.numOfNights;

		return amount;
	}
	public int getRoomType() {
		return roomType;
	}

	/*
	 * This method returns all the room types available in the form
	 * of an array of String objects. Each element in the array
	 * contains the name for the type of room and that room's
	 * nightly charge. Because the method is static it can be called
	 * without creating an object of the Reservation class.
	 */
	public static String[] getAllRoomTypes(){
		String [] userFriendlyRoomTypes = new String[3];
		userFriendlyRoomTypes[0] = "Budget ($100/night)";
		userFriendlyRoomTypes[1] = "Business ($150/night)";
		userFriendlyRoomTypes[2] = "Deluxe ($300/night)";
		return userFriendlyRoomTypes;
	}
	public void setRoomType(int newRoomType) {
		if (newRoomType >= BUDGET_ROOM && newRoomType <= DELUXE_ROOM){
			this.roomType = newRoomType;
		} else {
			throw new IllegalArgumentException("Illegal room type. Received: " + newRoomType);
		}
	}
	public boolean isSmokingRoom() {
		return isSmokingRoom;
	}
	public void setSmokingRoom(boolean isSmokingRoom) {
		this.isSmokingRoom = isSmokingRoom;
	}
	public int getNumOfNights() {
		return numOfNights;
	}
	public void setNumOfNights(int newNumOfNights) {
		if (newNumOfNights > 0){
			this.numOfNights = newNumOfNights;
		} else {
			throw new IllegalArgumentException("Illegal number of nights. Must be > 0. Received: " + newNumOfNights);
		}
	}
	public String getGuestName() {
		return guestName;
	}
	public void setGuestName(String newGuestName) {
		if (newGuestName != null && newGuestName.length() > 0) {
					this.guestName = newGuestName;
		} else {
			throw new IllegalArgumentException("Illegal guest name. Can't be null or 0 length.");
		}
	}
	public boolean isBreakfastPackage() {
		return isBreakfastPackage;
	}
	public void setBreakfastPackage(boolean isBreakfastPackage) {
		this.isBreakfastPackage = isBreakfastPackage;
	}

	@Override
	public String toString() {
		return "Reservation [roomType=" + roomType + ", isSmokingRoom=" + isSmokingRoom + ", numOfNights=" + numOfNights
				+ ", guestName=" + guestName + ", isBreakfastPackage=" + isBreakfastPackage + "]";
	}
}
