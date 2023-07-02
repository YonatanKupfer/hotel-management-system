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

	public void removeWorker(int workerID){//remove worker by worker ID
		Iterator<Worker> iterator = this.workers.iterator();
		while(iterator.hasNext()){
			Worker worker = iterator.next();
			if(worker.getWorkerID() == workerID){
				iterator.remove();
			}
		}
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
	// check if room is available
	public boolean isRoomAvailable(int roomNumber){
		for(Room room : this.rooms){
			if(room.getRoomNumber() == roomNumber){
				return room.isAvailable();
			}
		}
		return false;
	}
	// check if there is a cleaner available
	public boolean isCleanerAvailable(){
		for(Worker worker : this.workers){
			if(worker instanceof Cleaner){
				if(worker.getIsAvailable()){
					return true;
				}
			}
		}
		return false;
	}

	// assign next available cleaner to room
	public void assignCleanerToRoom(int roomNumber){
		boolean cleanerAvailable = false;
		for(Room room : this.rooms){
			if(room.getRoomNumber() == roomNumber){
				for(Worker worker : this.workers){
					if(worker instanceof Cleaner){
						if(worker.getIsAvailable()){
							room.assignCleaner((Cleaner)worker);
							worker.setIsAvailable(false);
							((Cleaner)worker).setRoomNumber(roomNumber);
							cleanerAvailable = true;
							System.out.println("Cleaner " + worker.getName() + ", ID " + worker.getWorkerID() + " assigned to room " + roomNumber);
							return;
						}
					}
				}
			}
		}
		if(!cleanerAvailable){
			System.out.println("No cleaner available");
		}
	}

	public void printSystemMenu(){
		System.out.println("Welcome to the Hotel Management System");
		System.out.println("Please select an option:");
		System.out.println("1. Add a room");
		System.out.println("2. Remove a room");
		System.out.println("3. Add a worker");
		System.out.println("4. Remove a worker");
		System.out.println("5. Print all rooms");
		System.out.println("6. Print all available rooms");
		System.out.println("7. Print all unavailable rooms");
		System.out.println("8. Print all workers");
		System.out.println("9. Print all workers with a given name");
		System.out.println("10. Assign a cleaner to a room");
		System.out.println("11. Check if a room is available");
		System.out.println("12. Exit");
		
	}

}
