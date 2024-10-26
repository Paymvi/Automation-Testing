package test;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import main.ContactService;

class ContactServiceTest {

	//The contact service shall be able to add contacts with a unique ID.
	@Test
	void testAddContact() {
		
		ContactService cs = new ContactService();
		
		int countBefore = cs.getCountofContacts();
		cs.addContact("12345", "Mary", "Jane", "6031231234", "15 Webster Rd");
		int countAfter = cs.getCountofContacts();
		// Check to see the number of contacts increased by 1
		assertTrue(countAfter - countBefore == 1);
		
		// Check if the added contact has all of the correct information
		assertTrue(cs.getInfo("12345", "firstName").equals("Mary"));
		assertTrue(cs.getInfo("12345", "lastName").equals("Jane"));
		assertTrue(cs.getInfo("12345", "phoneString").equals("6031231234"));
		assertTrue(cs.getInfo("12345", "address").equals("15 Webster Rd"));
		
	
	}
	
	// The contact service shall be able to delete contacts per contact ID.
	@Test
	void testDeleteContact() {
		ContactService cs = new ContactService();
		
		int countBefore = cs.getCountofContacts();
		cs.addContact("12345", "Mary", "Jane", "6031231234", "15 Webster Rd");
		int countAfter = cs.getCountofContacts();
		
		// Check to see the number of contacts increased by 1
		assertTrue(countAfter - countBefore == 1);
		
		countBefore = cs.getCountofContacts();
		// Test to see the contact was successfully made
		assertTrue(cs.getInfo("12345", "firstName").equals("Mary"));
		assertTrue(cs.getInfo("12345", "lastName").equals("Jane"));
		assertTrue(cs.getInfo("12345", "phoneString").equals("6031231234"));
		assertTrue(cs.getInfo("12345", "address").equals("15 Webster Rd"));
		// Deletes the contact
		cs.deleteContact("12345");
		countAfter = cs.getCountofContacts();
		
		// Check to see the number of contacts decreased by 1 after deletion
		assertTrue(countAfter - countBefore == -1);
		
		// Should error when trying to update a contact that doesn't exist
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			cs.updateContact("12345", "firstName", "Susan");
		}); 
		
	}
	
	// The contact service shall be able to update contact fields per contact ID. The following fields are updatable
	@Test
	void testUpdateContact() {
		ContactService cs = new ContactService();
		cs.addContact("12345", "Mary", "Jane", "6031231234", "15 Webster Rd");
		
		// update firstName
		cs.updateContact("12345", "firstName", "Susan");
		assertTrue(cs.getInfo("12345", "firstName").equals("Susan"));
		
		// update lastName
		cs.updateContact("12345", "lastName", "Smith");
		assertTrue(cs.getInfo("12345", "lastName").equals("Smith"));
		
		// update Number
		cs.updateContact("12345", "phoneString", "1231231234");
		assertTrue(cs.getInfo("12345", "phoneString").equals("1231231234"));
		
		// update Address
		cs.updateContact("12345", "address", "10 Daniel St");
		assertTrue(cs.getInfo("12345", "address").equals("10 Daniel St"));
		
		// contactID shall not be updatable
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			cs.updateContact("12345", "contactID", "54321");
		}); 
		
	}
	
	@Test
	void testNonUniqueContactID() {
		
		ContactService cs = new ContactService();
		
		// Should error when trying to use a non unique ID to add contact
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			cs.addContact("12345", "Mary", "Jane", "6031231234", "15 Webster Rd");
			cs.addContact("12345", "Jerry", "Winter", "9991231234", "10 Webster Rd");
		}); 
		
	}

}
