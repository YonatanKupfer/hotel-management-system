package com.hotelmanagement;

public class Cleaner extends Worker {
	private int dayShift;//1-7
	private int roomNumber;
	
	public Cleaner(String name, int age, int workerID, int dayShift,boolean isAvailable, int roomNumber) throws CloneNotSupportedException {
		super(name, age, workerID, isAvailable);
		this.dayShift = dayShift;
		this.roomNumber = roomNumber;
	}

	public int getDayShift() {
		return dayShift;
	}
	public void setDayShift(int dayShift) {
		this.dayShift = dayShift;
	}
	public int getRoomNumber(){
		return roomNumber;
	}
	public void setRoomNumber(int roomNumber){
		this.roomNumber = roomNumber;
	}

}
