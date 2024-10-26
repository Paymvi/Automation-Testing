package test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import main.TaskService;

class TaskServiceTest {

	//The task service shall be able to add tasks with a unique ID.
	@Test
	void testAddTask() {
		
		TaskService ts = new TaskService();
		
		int countBefore = ts.getCountofTasks();
		ts.addTask("12345", "Polly", "Insert sample description here");
		int countAfter = ts.getCountofTasks();
		// Check to see the number of tasks increased by 1
		assertTrue(countAfter - countBefore == 1);
		
		// Check if the added task has all of the correct information
		assertTrue(ts.getInfo("12345", "name").equals("Polly"));
		assertTrue(ts.getInfo("12345", "description").equals("Insert sample description here"));
	
	}
	
	@Test
	void testDeleteTask() {
		
		TaskService ts = new TaskService();
		
		int countBefore = ts.getCountofTasks();
		ts.addTask("12345", "Polly", "Insert sample description here");
		int countAfter = ts.getCountofTasks();
		// Check to see the number of tasks increased by 1
		assertTrue(countAfter - countBefore == 1);
		
		// Check if the added task has all of the correct information
		assertTrue(ts.getInfo("12345", "name").equals("Polly"));
		assertTrue(ts.getInfo("12345", "description").equals("Insert sample description here"));
		
		countBefore = ts.getCountofTasks();
		// Deletes the task
		ts.deleteTask("12345");
		countAfter = ts.getCountofTasks();
				
		// Check to see the number of task decreased by 1 after deletion
		assertTrue(countAfter - countBefore == -1);
		
				
		// Should error when trying to update a task that doesn't exist
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			ts.updateTask("12345", "name", "Natasha");
		}); 
	}
	

	// The task service shall be able to update task fields per task ID. The following fields are updatable
	@Test
	void testUpdateTask() {
		TaskService ts = new TaskService();
		ts.addTask("123", "Polly", "Insert sample description here");
		
		// update name
		ts.updateTask("123", "name", "Susan");
		assertTrue(ts.getInfo("123", "name").equals("Susan"));
		
		// update description
		ts.updateTask("123", "description", "Insert DIFFERENT sample description here");
		assertTrue(ts.getInfo("123", "description").equals("Insert DIFFERENT sample description here"));
		
		
		// taskID shall not be updatable
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			ts.updateTask("123", "taskID", "54321");
		}); 
		
	}
	
	@Test
	void testNonUniqueTaskID() {
		
		TaskService cs = new TaskService();
		
		// Should error when trying to use a non unique ID to add task
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			cs.addTask("12345", "Polly", "Insert sample description here");
			cs.addTask("12345", "Patty", "Insert different description here");
		}); 
		
	}

}
