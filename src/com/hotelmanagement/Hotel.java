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

	public Room getRoomByNumber(int roomNumber){
		for(Room room : this.rooms){
			if(room.getRoomNumber() == roomNumber){
				return room;
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



	public void sortRoomsByRoomNumber(){//sort rooms by room number attribute
		this.rooms.sort((Room room1, Room room2) -> room1.getRoomNumber() - room2.getRoomNumber());
	}
	

	public void printAllRooms(){
		for(Room room : this.rooms){
			if(room instanceof GuestRoom){
				System.out.println("Guest room number: " + room.getRoomNumber() + ", Room type: " + room.getType() + ", Number of beds: " + ((GuestRoom)room).getNumberOfBeds());
			}
			else if(room instanceof FunctionHall){
				System.out.println("Function hall number: " + room.getRoomNumber() + ", Room type: " + room.getType() + ", Purpose: " + ((FunctionHall)room).getPurpose() + ", Capacity: " + ((FunctionHall)room).getCapacity());
			}
		}
	}

	public void printAllAvailableRooms(int dayNum){
		for(Room room : this.rooms){
			if(room.checkIsAvailable(dayNum)){
				if(room instanceof GuestRoom){
				System.out.println("Guest room number: " + room.getRoomNumber() + ", Room type: " + room.getType() + ", Number of beds: " + ((GuestRoom)room).getNumberOfBeds());
				}
				else if(room instanceof FunctionHall){
					System.out.println("Function hall number: " + room.getRoomNumber() + ", Room type: " + room.getType() + ", Purpose: " + ((FunctionHall)room).getPurpose() + ", Capacity: " + ((FunctionHall)room).getCapacity());
				}
			}
		}
	}

	public void printAllUnavailableRooms(int dayNum){
		for(Room room : this.rooms){
			if(!room.checkIsAvailable(dayNum)){
				if(room instanceof GuestRoom){
				System.out.println("Guest room number: " + room.getRoomNumber() + ", Room type: " + room.getType() + ", Number of beds: " + ((GuestRoom)room).getNumberOfBeds());
				}
				else if(room instanceof FunctionHall){
					System.out.println("Function hall number: " + room.getRoomNumber() + ", Room type: " + room.getType() + ", Purpose: " + ((FunctionHall)room).getPurpose() + ", Capacity: " + ((FunctionHall)room).getCapacity());
				}
			}
		}
	}

	
	// check if room is available
	public boolean isRoomAvailable(int roomNumber, int dayNum){
		for(Room room : this.rooms){
			if(room.getRoomNumber() == roomNumber){
				return room.checkIsAvailable(dayNum);
			}
		}
		return false;
	}

	// find available room in a given day
	public int findAvailableRoom(int dayNum, String type){
		for(Room room : this.rooms){
			if(room.getType().equals(type)){
				if(room.checkIsAvailable(dayNum)){
					return room.getRoomNumber();
				}
			}
		}
		return -1;
	}

	// assign room to guest
	public void assignRoomToGuest(int roomNumber, int dayNum){
		for(Room room : this.rooms){
			if(room.getRoomNumber() == roomNumber){
				room.setAvailable(dayNum, false);
				System.out.println("Room " + roomNumber + " assigned to guest");
			}
		}
	}

	// leave room
	public void leaveRoom(int roomNumber, int dayNum){
		for(Room room : this.rooms){
			if(room.getRoomNumber() == roomNumber){
				if(assignCleanerToRoom(roomNumber, dayNum%7)){
					room.setAvailable(dayNum, true);
					System.out.println("Room " + roomNumber + " is now available");
				}
				else{
					room.setAvailable((dayNum+1)%31, false);
					System.out.println("Room " + roomNumber + " is still unavailable, try again tomorrow");
				}
			}
		}

	}

//workers

    public void addWorker(Worker worker){
        this.workers.add(worker);
    }

	public void removeWorker(int workerID){	//remove worker by worker ID
    	Iterator<Worker> iterator = this.workers.iterator();
    	while(iterator.hasNext()){
    		Worker worker = iterator.next();
        	if(worker.getWorkerID() == workerID){
            	iterator.remove();
        	}
    	}
    }

    public Worker getWorkerByID(int workerID){
        for(Worker worker : this.workers){
            if(worker.getWorkerID() == workerID){
                return worker;
            }
        }
        return null;
    }

	
	public void printAllWorkers(){
		for(Worker worker : this.workers){
			if(worker instanceof Cleaner){
				System.out.println("Cleaner name: " + worker.getName() + ", ID: " + worker.getWorkerID() + ", Day shift: " + ((Cleaner)worker).getDayShift() + ", Room number: " + ((Cleaner)worker).getRoomNumber());
			}
			else if(worker instanceof Waiter){
				System.out.println("Waiter name: " + worker.getName() + ", ID: " + worker.getWorkerID() + ", Day shift: " + ((Waiter)worker).getDayShift());
			}
			else if(worker instanceof Security){
				System.out.println("Security name: " + worker.getName() + ", ID: " + worker.getWorkerID());
			}
			else if(worker instanceof Chef){
				System.out.println("Chef name: " + worker.getName() + ", ID: " + worker.getWorkerID());
			}
		}
	}

    //cheke for not enough cleaning staff and print the days in the week that need more cleaning staff
    public void checkCleaningStaff(){
        int[] cleaningStaff = new int[7];
        for(Worker worker : this.workers){
            if(worker instanceof Cleaner){
                int dayShift = ((Cleaner) worker).getDayShift();
                cleaningStaff[dayShift-1]++;
            }
        }
        for(int i=0;i<cleaningStaff.length;i++){
            if(cleaningStaff[i] < 2){
                System.out.println("Not enough cleaning staff on day " + (i+1));
            }
        }
    }

    //check for not enough waiter staff and print the days in the week that need more waiter staff
    public void checkWaiterStaff(){
        int[] waiterStaff = new int[7];
        for(Worker worker : this.workers){
            if(worker instanceof Waiter){
                int dayShift = ((Waiter) worker).getDayShift();
                waiterStaff[dayShift-1]++;
            }
        }
        for(int i=0;i<waiterStaff.length;i++){
            if(waiterStaff[i] < 2){
                System.out.println("Not enough waiter staff on day " + (i+1));
            }
        }
    }

    //check for not enough security staff and print warning if there is not enough security staff
    public void checkSecurityStaff(){
        int securityStaff = 0;
        for(Worker worker : this.workers){
            if(worker instanceof Security){
                securityStaff++;
            }
        }
        if(securityStaff < 2){
            System.out.println("Not enough security staff");
        }
    }

    //check if there is a chef in th hotel
    public void checkChef(){
        boolean chef = false;
        for(Worker worker : this.workers){
            if(worker instanceof Chef){
                chef = true;
            }
        }
        if(!chef){
            System.out.println("There is no chef in the hotel");
        }
        else{
            System.out.println("There is a chef in the hotel");
        }
    }

    public boolean searchWorkerBoolean(int workerID){
		for(Worker worker : this.workers){
			if(worker.getWorkerID() == workerID){
				return true;
			}
		}
		return false;
	}

    public void printAllWorkersWithName(String name){
		for(Worker worker : this.workers){
			if(worker.getName().equals(name)){
				if(worker instanceof Cleaner){
					System.out.println("Cleaner name: " + worker.getName() + ", ID: " + worker.getWorkerID() + ", Day shift: " + ((Cleaner)worker).getDayShift() + ", Room number: " + ((Cleaner)worker).getRoomNumber());
				}
				else if(worker instanceof Waiter){
					System.out.println("Waiter name: " + worker.getName() + ", ID: " + worker.getWorkerID() + ", Day shift: " + ((Waiter)worker).getDayShift());
				}
				else if(worker instanceof Security){
					System.out.println("Security name: " + worker.getName() + ", ID: " + worker.getWorkerID());
				}
				else if(worker instanceof Chef){
					System.out.println("Chef name: " + worker.getName() + ", ID: " + worker.getWorkerID());
				}
			}
		}
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
	public boolean assignCleanerToRoom(int roomNumber, int shift){
		boolean cleanerAvailable = false;
		for(Room room : this.rooms){
			if(room.getRoomNumber() == roomNumber){
				for(Worker worker : this.workers){
					if(worker instanceof Cleaner){
						if(((Cleaner)worker).getDayShift() == shift){
							if(worker.getIsAvailable()){
								room.assignCleaner((Cleaner)worker);
								worker.setIsAvailable(false);
								((Cleaner)worker).setRoomNumber(roomNumber);
								cleanerAvailable = true;
								System.out.println("Cleaner " + worker.getName() + ", ID " + worker.getWorkerID() + " assigned to room " + roomNumber);
								return true;
							}
						}
					}
				}
			}
		}
		if(!cleanerAvailable){
			System.out.println("No cleaner available");
		}
		return false;
	}

	// set all cleaners and waiters to available if it is their day shift and all the other to unavailable
	public void setWorkersAvailable(int dayNum){
		for(Worker worker : this.workers){
			if(worker instanceof Cleaner){
				if(((Cleaner)worker).getDayShift() == dayNum){
					worker.setIsAvailable(true);
				}
				else{
					worker.setIsAvailable(false);
				}
			}
			else if(worker instanceof Waiter){
				if(((Waiter)worker).getDayShift() == dayNum){
					worker.setIsAvailable(true);
				}
				else{
					worker.setIsAvailable(false);
				}
			}
		}
	}


	public void printHotelMenu(){
		System.out.println("1. Add a room");
		System.out.println("2. Remove a room");
		System.out.println("3. Sort rooms by room number");
		System.out.println("4. Print all rooms");
		System.out.println("5. Print all available rooms in a given day");
		System.out.println("6. Print all unavailable rooms in a given day");
		System.out.println("7. Check if a room is available");
		System.out.println("8. Book a room for a guest");
		System.out.println("9. Guest leaves a room");
		System.out.println("10. return to main menu");
	}
	public void printWorkersMenu(){
		System.out.println("1. Add a worker");
		System.out.println("2. Remove a worker");
		System.out.println("3. Print all workers");
		System.out.println("4. Print all workers with a given name");
		System.out.println("5. Assign a cleaner to a room");
		System.out.println("6. Check sufficient of workers");
		System.out.println("7. return to main menu");

	}
	public void printSystemMenu(){
		System.out.println("Welcome to the Hotel Management System");
		System.out.println("Please select an option:");
		System.out.println("1. Hotel");
		System.out.println("2. Workers");
		System.out.println("3. Exit the program");
	}
		

}
