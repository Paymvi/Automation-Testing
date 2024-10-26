package main;

import java.util.Hashtable;

public class AppointmentService {
	
	
	
	Hashtable<String, Appointment> h = new Hashtable<>();

	// Adds appointment
	public void addAppointment(String appointmentID, String dateStr, String description) {
		
		if(!h.containsKey(appointmentID)) {
			Appointment a = new Appointment(appointmentID, dateStr, description);
			h.put(appointmentID, a);
			
		} else {
			 throw new IllegalArgumentException ("Your appointment ID is not unique"); // Adds appointment only with unique ID
		}
	
	}
	
	// Deletes appointment
	public void deleteAppointment (String appointmentID) {
		if(h.containsKey(appointmentID)) {
			h.remove(appointmentID);
		} else {
			throw new IllegalArgumentException ("This appointment does not exist");
		}
	}
	
	// gets info
	public String getInfo(String appointmentID, String partToSee) {
		if(h.containsKey(appointmentID)) {
			Appointment a = h.get(appointmentID);
			
			if (partToSee.equals("appointmentID")) {
				return a.getAppointmentID();
				
			}	else if (partToSee.equals("dateStr")) {
				return a.getDate();
				
			}	else if (partToSee.equals("description")) {
				return a.getDescription();
				
			}	else {
				throw new IllegalArgumentException ("Invalid input");
			}
			
		} else {
			throw new IllegalArgumentException ("This appointment does not exist");
		}
		
	}

	// returns the count of the appointments
	public int getCountofAppointments() {
		return h.size();
	}
	

}
