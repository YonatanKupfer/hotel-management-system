package com.hotelmanagement;

public class Room implements Cloneable, Comparable<Room>{
		private int roomNumber;
	    private String type;
	    private boolean isAvailable;
		private Worker worker;
	    
	    // Constructor
	    public Room(int roomNumber, String type, boolean isAvailable, Worker worker) throws CloneNotSupportedException {
	        this.roomNumber = roomNumber;
	        this.type = type;
	        this.isAvailable = isAvailable;
			this.worker = worker.clone();
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
		public Worker getWorker() {
			return worker;
		}
		public void setWorker(Worker worker) throws CloneNotSupportedException {
			this.worker = worker.clone();
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

		// assign cleaner to room
		public void assignCleaner(Worker worker) {
			this.worker = worker;
		}
		// remove cleaner from room
		public void removeCleaner() {
			this.worker = null;
		}
		// make room available
		public void makeAvailable() {
			this.isAvailable = true;
		}
		// make room unavailable
		public void makeUnavailable() {
			this.isAvailable = false;
		}


	
}
