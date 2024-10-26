package test;


//import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import main.Contact;


class ContactTest {

	@Test
	void testContact() {
		
		Contact sample = new Contact("12345", "Mary", "Jane", "6031231234", "15 Webster Rd");
		// Check if the added contact has all of the correct information
		assertTrue(sample.getContactID().equals("12345"));
		assertTrue(sample.getFirstName().equals("Mary"));
		assertTrue(sample.getLastName().equals("Jane"));
		assertTrue(sample.getPhoneString().equals("6031231234"));
		assertTrue(sample.getAddress().equals("15 Webster Rd"));
		
	}
	
	
	// Checks if too long
	
	@Test
	void testContactIDTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Contact("999123456789", "Mary", "Jane", "6031231234", "15 Webster Rd");
		}); 
	}
	
	@Test
	void testFirstNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Contact("99123", "Mary123456789", "Jane", "6031231234", "15 Webster Rd");
		}); 
	}
	
	@Test
	void testLastNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Contact("999123", "Mary", "Jane1234566789", "6031231234", "15 Webster Rd");
		}); 
	}
	
	@Test
	void testPhoneStringTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Contact("999123", "Mary", "Jane", "603123123456789", "15 Webster Rd");
		}); 
	}
	
	@Test
	void testAddressTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Contact("999123", "Mary", "Jane", "603 123 1234", "15 Webster Rd 123456789123456789123456789123456789");
		}); 
	}
	
	
	
	// Checks if Null
	
	@Test
	void testContactIDisNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Contact(null, "Mary", "Jane1234566789", "6031231234", "15 Webster Rd");
		}); 
	}
	
	@Test
	void testFirstNameisNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Contact("12345", null, "Jane", "6031231234", "15 Webster Rd");
		}); 
	}
	
	@Test
	void testLastNameisNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Contact("12345", "Mary", null, "6031231234", "15 Webster Rd");
		}); 
	}
	
	@Test
	void testPhoneStringisNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Contact("12345", "Mary", "Jane", null, "15 Webster Rd");
		}); 
	}
	
	@Test
	void testAddressisNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Contact("12345", "Mary", "Jane", "6031231234", null);
		}); 
	}
	
	
	

}
