package com.hotelmanagement;

public class FunctionHall extends Room{
	private String purpose;
	private int capacity;
	
	// Constructor
    public FunctionHall(int roomNumber, String type, boolean isAvailable, String purpose, int capacity) {
        super(roomNumber, type, isAvailable);
        this.purpose = purpose;
        this.capacity = capacity;
    }
}
