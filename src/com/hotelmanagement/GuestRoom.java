package com.hotelmanagement;

public class GuestRoom extends Room {
	private int numberOfBeds;

	public GuestRoom(int roomNumber, String type, boolean isAvailable, int numberOfBeds) {
        super(roomNumber, type, isAvailable);
        this.numberOfBeds = numberOfBeds;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }
    public void setNumberOfBeds(int numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }
    
}
