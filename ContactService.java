package main;
import java.util.Hashtable;
import java.util.Scanner;

public class ContactService {
	
	Hashtable<String, Contact> h = new Hashtable<>();
	
	
	public void addContact(String contactID, String firstName, String lastName, String phoneNum, String address) {
		
		if(!h.containsKey(contactID)) {
			Contact c = new Contact(contactID, firstName, lastName, phoneNum, address);
			h.put(contactID, c);
			
			
		} else {
			 throw new IllegalArgumentException ("Your contact ID is not unique");
		}
		
	}
	
	public void deleteContact (String contactID) {
		if(h.containsKey(contactID)) {
			h.remove(contactID);
		} else {
			throw new IllegalArgumentException ("This contact does not exist");
		}
	}
	
	public void updateContact (String contactID, String partToUpdate, String newInput) {
		
		if(h.containsKey(contactID)) {
			Contact c = h.get(contactID);
			
			if (partToUpdate.equals("firstName")) {
				c.setFirstName(newInput);
				
			}	else if (partToUpdate.equals("lastName")) {
				c.setLastName(newInput);
				
			}	else if (partToUpdate.equals("phoneString")) {
				c.setPhoneString(newInput);
				
			}	else if (partToUpdate.equals("address")) {
				c.setAddress(newInput);
				
			}	else {
				throw new IllegalArgumentException ("Invalid input");
			}
		} else {
			throw new IllegalArgumentException ("This contact does not exist");
		}
		
	}
	
	
	public String getInfo(String contactID, String partToSee) {
		if(h.containsKey(contactID)) {
			Contact c = h.get(contactID);
			
			if (partToSee.equals("firstName")) {
				return c.getFirstName();
				
			}	else if (partToSee.equals("lastName")) {
				return c.getLastName();
				
			}	else if (partToSee.equals("phoneString")) {
				return c.getPhoneString();
				
			}	else if (partToSee.equals("address")) {
				return c.getAddress();
				
			}	else {
				throw new IllegalArgumentException ("Invalid input");
			}
			
		} else {
			throw new IllegalArgumentException ("This contact does not exist");
		}
		
	}
	
	
	public int getCountofContacts() {
		return h.size();
	}

	

}
