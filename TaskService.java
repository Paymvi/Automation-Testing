package main;

import java.util.Hashtable;

public class TaskService {
	
	Hashtable<String, Task> h = new Hashtable<>();
	
	// Adds task
	public void addTask(String taskID, String name, String description) {
		
		if(!h.containsKey(taskID)) {
			Task t = new Task(taskID, name, description);
			h.put(taskID, t);
			
		} else {
			 throw new IllegalArgumentException ("Your task ID is not unique");
		}
		
	}
	
	// Deletes task
	public void deleteTask (String taskID) {
		if(h.containsKey(taskID)) {
			h.remove(taskID);
		} else {
			throw new IllegalArgumentException ("This task does not exist");
		}
	}
	
	// Updates task
	public void updateTask (String taskID, String partToUpdate, String newInput) {
		
		if(h.containsKey(taskID)) {
			Task t = h.get(taskID);
			
			if (partToUpdate.equals("name")) {
				t.setName(newInput);
				
			}	else if (partToUpdate.equals("description")) {
				t.setDescription(newInput);
				
			}	else {
				throw new IllegalArgumentException ("Invalid input");
			}
		} else {
			throw new IllegalArgumentException ("This contact does not exist");
		}
		
	}
	
	// gets info
	public String getInfo(String taskID, String partToSee) {
		if(h.containsKey(taskID)) {
			Task t = h.get(taskID);
			
			if (partToSee.equals("taskID")) {
				return t.getTaskID();
				
			}	else if (partToSee.equals("name")) {
				return t.getName();
				
			}	else if (partToSee.equals("description")) {
				return t.getDescription();
				
			}	else {
				throw new IllegalArgumentException ("Invalid input");
			}
			
		} else {
			throw new IllegalArgumentException ("This contact does not exist");
		}
		
	}

	// returns the count of the tasks
	public int getCountofTasks() {
		return h.size();
	}
	
	

}
