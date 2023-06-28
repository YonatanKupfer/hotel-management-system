package com.hotelmanagement;

public class Room {
	 private int roomNumber;
	    private String type;
	    private boolean isAvailable;
	    
	    // Constructor
	    public Room(int roomNumber, String type, boolean isAvailable) {
	        this.roomNumber = roomNumber;
	        this.type = type;
	        this.isAvailable = isAvailable;
	    }
}
