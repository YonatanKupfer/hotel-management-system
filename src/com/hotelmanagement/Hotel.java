package com.hotelmanagement;

import java.util.ArrayList;

public class Hotel {
	private ArrayList<Room> rooms;
	private ArrayList<Worker> workers;
	
	public Hotel(){
		this.rooms = new ArrayList<Room>();
		this.workers  = new ArrayList<Worker>();
	}
}
