package com.hotelmanagement;

public class Room implements Cloneable, Comparable<Room>{
    private int roomNumber;
    private String type;
    private boolean[] isAvailable = new boolean[31];
    private Worker worker;
      
      // Constructor
    public Room(int roomNumber, String type) throws CloneNotSupportedException {
    	this.roomNumber = roomNumber;
    	this.type = type;
    	this.worker = null;
      // Set the isAvailable value for all elements in the array to false
          for (int i = 0; i < this.isAvailable.length; i++) {
              this.isAvailable[i] = true;
          }
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


    public boolean checkIsAvailable(int dayNum) {
      // Check if the index is within the valid range
        if (dayNum >= 0 && dayNum < this.isAvailable.length) {
            return isAvailable[dayNum];
        } 
      else {
            throw new IndexOutOfBoundsException("Invalid index");
        }
    }

      public void setAvailable(int dayNum,boolean available) {
          this.isAvailable[dayNum] = available;
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
    public void makeAvailable(int numDay) {
      this.isAvailable[numDay] = true;
    }
    // make room unavailable
    public void makeUnavailable(int numDay) {
      this.isAvailable[numDay] = false;
    }


  
}