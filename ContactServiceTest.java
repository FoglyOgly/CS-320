package m3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ContactServiceTest {

	@Test
	void testAddContact() {
		// test that contact is added correctly
		ContactService contactService = new ContactService();
		Contact testContact = new Contact("1234", "firstName", "lastName", "1234567890", "address");
		contactService.newContact(testContact);
		
		assertTrue(contactService.contacts.containsKey(testContact.getContactId()));
		
		// test that adding duplicate event throws an exception
		Exception duplicateException = assertThrows(IllegalArgumentException.class, () -> {
			contactService.newContact(testContact);
		});
		
		String duplicateExpectedMessage = "Contact with given ID exists.";
		String duplicateActualMessage = duplicateException.getMessage();
		
		assertTrue(duplicateExpectedMessage.equals(duplicateActualMessage));
	}
	
	@Test
	void testRemoveContact() {
		// test that contact is removed correctly
		ContactService contactService = new ContactService();
		Contact testContact = new Contact("1234", "firstName", "lastName", "1234567890", "address");
		contactService.newContact(testContact);
		contactService.removeContact(testContact.getContactId());
		
		assertFalse(contactService.contacts.containsKey(testContact.getContactId()));
	}
	
	@Test
	void testUpdateContact() {
		// test that contact is updated correctly
		ContactService contactService = new ContactService();
		Contact testContact = new Contact("1234", "firstName", "lastName", "1234567890", "address");
		contactService.newContact(testContact);
		
		contactService.updateContactFirstName("1234", "newFirst");
		contactService.updateContactLastName("1234", "newLast");
		contactService.updateContactPhoneNumber("1234", "0987654321");
		contactService.updateContactAddress("1234", "newAddress");
		
		Contact updatedContact = contactService.contacts.get("1234");
		
		assertTrue(updatedContact.getFirstName().equals("newFirst"));
		assertTrue(updatedContact.getLastName().equals("newLast"));
		assertTrue(updatedContact.getPhoneNumber().equals("0987654321"));
		assertTrue(updatedContact.getAddress().equals("newAddress"));
	}

}
