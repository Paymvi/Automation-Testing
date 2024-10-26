package test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import main.Task;

class TaskTest {

	@Test
	void testMakeTask() {

		Task t = new Task("12345", "Polly", "Insert sample description here");
		
		// Check if the added task has all of the correct information
		assertTrue(t.getTaskID().equals("12345"));
		assertTrue(t.getName().equals("Polly"));
		assertTrue(t.getDescription().equals("Insert sample description here"));
		
	}
	
	
	// Checks if too long
	
	@Test
	void testTaskIDTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Task("12345678999999999", "Polly", "Insert sample description here");
		}); 
	}
	
	@Test
	void testNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Task("12345", "PollyPollyPollyPollyPolly1111111111111111111111111111111", "Insert sample description here");
		}); 
	}
	
	@Test
	void testDescriptionTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Task("12345", "Polly", "Insert sample description here11111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111");
		}); 
	}
	
	// Checks if given null input
	
	@Test
	void testTaskIDisNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Task(null, "Polly", "Insert sample description here");
		}); 
	}
	
	@Test
	void testNameisNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Task("12345", null, "Insert sample description here");
		}); 
	}
	
	@Test
	void testDescriptionisNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Task("12345", "Polly", null);
		}); 
	}
	
	

}
