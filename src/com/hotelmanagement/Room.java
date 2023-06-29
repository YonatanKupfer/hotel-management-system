package com.hotelmanagement;

public class Room implements Cloneable, Comparable<Room>{
		private int roomNumber;
	    private String type;
	    private boolean isAvailable;
	    
	    // Constructor
	    public Room(int roomNumber, String type, boolean isAvailable) {
	        this.roomNumber = roomNumber;
	        this.type = type;
	        this.isAvailable = isAvailable;
	    }
		// Getter and Setter methods
	    public int getRoomNumber() {
	        return roomNumber;
	    }
	    public void setRoomNumber(int roomNumber) {
	        this.roomNumber = roomNumber;
	    }
	    public String getType() {
	        return type;
	    }
	    public void setType(String type) {
	        this.type = type;
	    }
	    public boolean isAvailable() {
	        return isAvailable;
	    }
	    public void setAvailable(boolean isAvailable) {
	        this.isAvailable = isAvailable;
	    }
	    
	    // toString method
		@Override
		public String toString() {
			return "Room [roomNumber=" + roomNumber + ", type=" + type + ", isAvailable=" + isAvailable + "]";
		}
		@Override
		public int compareTo(Room o) {
			return this.roomNumber - o.roomNumber;
		}
		@Override
		public Room clone() throws CloneNotSupportedException {
			return (Room) super.clone();
		}
	
}
