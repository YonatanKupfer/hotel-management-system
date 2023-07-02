package com.hotelmanagement;

public class FunctionHall extends Room{
	private String purpose;
	private int capacity;
	
	// Constructor
    public FunctionHall(int roomNumber, String type, boolean isAvailable, Worker worker, String purpose, int capacity) throws CloneNotSupportedException {
        super(roomNumber, type, isAvailable, worker);
        this.purpose = purpose;
        this.capacity = capacity;
    }

    // Getter and Setter methods
    public String getPurpose() {
        return purpose;
    }
    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }
    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
