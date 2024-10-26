package main;
import java.util.Date;


public class Appointment {
	
	
	
	String appointmentID;
	String dateStr;
	String description;
	
	public static void testValidLength(String word, int charLimit) throws IllegalArgumentException {
		if ((word == null || !(word.length() <= charLimit))) throw new IllegalArgumentException ("The " + word + " is null or too long");
	}
	
	public static void testIfNull (String word) throws IllegalArgumentException{
		if (word == null) throw new IllegalArgumentException ("The field is null");
	}
	
	public static void checkDate(String dateStr) throws IllegalArgumentException {
		
		String d = dateStr;
		String[] arr = d.split(" ");   
		
		
		int month = Integer.parseInt(arr[0]) - 1;
		int day = Integer.parseInt(arr[1]);
		int year = (Integer.parseInt(arr[2]) - 1900);
		

		Date givenDate = new Date(year, month, day);
		
		Date currentDate = new Date();
		
		if (givenDate.before(currentDate)) {
			throw new IllegalArgumentException ("The given date is in the past");
		} 
		
	}
	
	//constructor
	public Appointment (String appointmentID, String dateStr, String description) {
		
		testValidLength(appointmentID, 10);
		testIfNull(dateStr);
		checkDate(dateStr);
		testValidLength(description, 50);
		
		this.appointmentID = appointmentID;
		this.dateStr = dateStr;
		this.description = description;
		
		
	}
	
	
	

	// Getters and Setters
	public String getAppointmentID () {
		return appointmentID;
	}
	public void setAppointmentID (String appointmentID) {
		this.appointmentID = appointmentID;
	}
	
	public String getDate () {
		return dateStr;
	}
	public void setDate (String date) {
		this.dateStr = date;
	}
	
	public String getDescription () {
		return description;
	}
	public void setDescription (String description) {
		this.description = description;
	}

}
