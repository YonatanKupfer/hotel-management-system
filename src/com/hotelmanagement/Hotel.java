package com.hotelmanagement;

import java.util.ArrayList;
import java.util.Iterator;
//import java.util.Collection;

public class Hotel {
	private ArrayList<Room> rooms;
	private ArrayList<Worker> workers;
	
	public Hotel(){
		this.rooms = new ArrayList<Room>();
		this.workers  = new ArrayList<Worker>();
	}

	public void addRoom(Room room){
		this.rooms.add(room);
	}

	public void removeRoom(int roomNumber){//remove room by room number
		Iterator<Room> iterator = this.rooms.iterator();
		while(iterator.hasNext()){
			Room room = iterator.next();
			if(room.getRoomNumber() == roomNumber){
				iterator.remove();
			}
		}
	}

	public void addWorker(Worker worker){
		this.workers.add(worker);
	}

	public void removeWorker(Worker worker){
		this.workers.remove(worker);
	}

	public Room getRoomByNumber(int roomNumber){
		for(Room room : this.rooms){
			if(room.getRoomNumber() == roomNumber){
				return room;
			}
		}
		return null;
	}

	public Worker getWorkerByID(int workerID){
		for(Worker worker : this.workers){
			if(worker.getWorkerID() == workerID){
				return worker;
			}
		}
		return null;
	}

	public int getNextAvailableRoomNumber(){
		int roomNumber = 1;
		while(true){
			if(this.getRoomByNumber(roomNumber) == null){
				return roomNumber;
			}
			roomNumber++;
		}
	}

	public boolean searchRoomBoolean(int roomNumber){
		for(Room room : this.rooms){
			if(room.getRoomNumber() == roomNumber){
				return true;
			}
		}
		return false;
	}

	public boolean searchWorkerBoolean(int workerID){
		for(Worker worker : this.workers){
			if(worker.getWorkerID() == workerID){
				return true;
			}
		}
		return false;
	}

	public void sortRoomsByRoomNumber(){//sort rooms by room number attribute
		this.rooms.sort((Room room1, Room room2) -> room1.getRoomNumber() - room2.getRoomNumber());
	}
	
	public void printAllWorkers(){
		for(Worker worker : this.workers){
			System.out.println(worker);
		}
	}

	public void printAllRooms(){
		for(Room room : this.rooms){
			System.out.println(room);
		}
	}

	public void printAllAvailableRooms(){
		for(Room room : this.rooms){
			if(room.isAvailable()){
				System.out.println(room);
			}
		}
	}

	public void printAllUnavailableRooms(){
		for(Room room : this.rooms){
			if(!room.isAvailable()){
				System.out.println(room);
			}
		}
	}

	public void printAllWorkersWithName(String name){
		for(Worker worker : this.workers){
			if(worker.getName().equals(name)){
				System.out.println(worker);
			}
		}
	}

}
