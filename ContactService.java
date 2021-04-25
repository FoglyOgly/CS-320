package m3;

import java.util.TreeMap;

public class ContactService {
	
	TreeMap<String, Contact> contacts = new TreeMap<String, Contact>(); // TreeMap allows for access by key
	
	public void newContact(Contact contact) {
		// method to add new contact, per requirement
		if ((this.contacts.get(contact.getContactId()) == null)) { // requirement: IDs must be unique
			this.contacts.put(contact.getContactId(), contact);
		} else {
			throw new IllegalArgumentException("Contact with given ID exists.");
		}
	}
	
	public void removeContact(String contactId) {
		// method to remove contact by ID, per requirement
		this.contacts.remove(contactId);
	}
	
	public void updateContactFirstName(String contactId, String firstName) {
		// method to update contact first name, per requirement
		Contact contact = contacts.get(contactId);
		contact.setFirstName(firstName);
	}
	
	public void updateContactLastName(String contactId, String lastName) {
		// method to update contact last name, per requirement
		Contact contact = contacts.get(contactId);
		contact.setLastName(lastName);
	}
	
	public void updateContactPhoneNumber(String contactId, String phoneNumber) {
		// method to update contact phone number, per requirement
		Contact contact = contacts.get(contactId);
		contact.setPhoneNumber(phoneNumber);
	}
	
	public void updateContactAddress(String contactId, String address) {
		// method to update contact address, per requirement
		Contact contact = contacts.get(contactId);
		contact.setAddress(address);
	}

}
