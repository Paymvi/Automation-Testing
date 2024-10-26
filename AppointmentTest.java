package test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import main.Appointment;

class AppointmentTest {

	@Test
	void testMakeAppointment() {

		Appointment a = new Appointment("12345", "12 2 2025", "Insert sample description here");
		
		// Check if the added appointment has all of the correct information
		assertTrue(a.getAppointmentID().equals("12345"));
		assertTrue(a.getDate().equals("12 2 2025"));
		assertTrue(a.getDescription().equals("Insert sample description here"));
		
	}
	
	
	// Checks if too long
	
	@Test
	void testAppointmentIDTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Appointment("12345678999999999", "12 2 2025", "Insert sample description here");
		}); 
	}
	
	
	@Test
	void testDescriptionTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Appointment("12345", "12 2 2025", "Insert sample description here11111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111");
		}); 
	}
	
	// Checks if it rejects a date in the past
	@Test
	void testDateisinPast() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Appointment("12345", "12 2 2023", "Insert sample description here");
		}); 
	}
	
	
	// Checks if given null input
	
	@Test
	void testAppointmentIDisNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Appointment(null, "12 2 2025", "Insert sample description here");
		}); 
	}
	
	@Test
	void testDateisNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Appointment("12345", null, "Insert sample description here");
		}); 
	}
	
	@Test
	void testDescriptionisNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Appointment("12345", "Polly", null);
		}); 
	}
	
	
}
