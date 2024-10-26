package test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import main.AppointmentService;

class AppointmentServiceTest {

	// The appointment service shall be able to add appointments with a unique appointment ID
	@Test
	void testAddAppointment() {
		
		AppointmentService as = new AppointmentService();
		
		int countBefore = as.getCountofAppointments();
		as.addAppointment("12345", "12 2 2025", "Insert sample description here");
		int countAfter = as.getCountofAppointments();
		// Check to see the number of appointments increased by 1
		assertTrue(countAfter - countBefore == 1);
		
		// Check if the added appointment has all of the correct information
		assertTrue(as.getInfo("12345", "dateStr").equals("12 2 2025"));
		assertTrue(as.getInfo("12345", "description").equals("Insert sample description here"));
	}
	
	// The appointment service shall be able to delete appointments per appointment ID.
	
	@Test
	void testDeleteAppointment() {
		
		AppointmentService as = new AppointmentService();
		
		int countBefore = as.getCountofAppointments();
		as.addAppointment("12345", "12 2 2025", "Insert sample description here");
		int countAfter = as.getCountofAppointments();
		// Check to see the number of appointments increased by 1
		assertTrue(countAfter - countBefore == 1);
		
		// Check if the added appointment has all of the correct information
		assertTrue(as.getInfo("12345", "dateStr").equals("12 2 2025"));
		assertTrue(as.getInfo("12345", "description").equals("Insert sample description here"));
		
		countBefore = as.getCountofAppointments();
		// Deletes the appointment
		as.deleteAppointment("12345");
		countAfter = as.getCountofAppointments();
				
		// Check to see the number of appointments decreased by 1 after deletion
		assertTrue(countAfter - countBefore == -1);
		
				
	}
	
	@Test
	void testNonUniqueAppointmentID() {
		
		AppointmentService as = new AppointmentService();
		
		// Should error when trying to use a non unique ID to add appointment
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			as.addAppointment("12345", "12 2 2025", "Insert sample description here");
			as.addAppointment("12345", "12 2 2025", "Insert different description here");
		}); 
		
	}
	
	

}
