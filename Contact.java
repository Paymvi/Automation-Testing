package main;

public class Contact {
	
	String contactID;
	String firstName;
	String lastName;
	String phoneString;
	String address;
	
	public static void testValidLength(String word, int charLimit) throws IllegalArgumentException {
		if ((word == null || !(word.length() <= charLimit))) throw new IllegalArgumentException ("The " + word + " is null or too long");
	}
	
	// Constructor
	public Contact (String contactID, String firstName, String lastName, String phoneString, String address ) throws IllegalArgumentException {
		
		testValidLength(contactID, 10);
		testValidLength(firstName, 10);
		testValidLength(lastName, 10);
		testValidLength(phoneString, 10);
		testValidLength(address, 30);
		
		this.contactID = contactID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneString = phoneString;
		this.address = address;
	}
	
	
	// Getters and Setters
	
	public String getContactID () {
		return contactID;
	}
	public void setContactID (String contactID) {
		testValidLength(contactID, 10);
		this.contactID = contactID;
	}
	
	public String getFirstName () {
		return firstName;
	}
	public void setFirstName (String firstName) {
		testValidLength(firstName, 10);
		this.firstName = firstName;
	}
	
	public String getLastName () {
		return lastName;
	}
	public void setLastName (String lastName) {
		testValidLength(lastName, 10);
		this.lastName = lastName;
	}
	
	public String getPhoneString () {
		return phoneString;
	}
	public void setPhoneString (String phoneString) {
		testValidLength(phoneString, 10);
		this.phoneString = phoneString;
	}
	
	public String getAddress () {
		return address;
	}
	public void setAddress (String address) {
		testValidLength(address, 30);
		this.address = address;
	}
	
	

}
