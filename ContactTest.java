package m3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ContactTest {

	@Test
	public void testContactId() {
		// test that null ID throws an exception
		Exception nullException = assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, "firstName", "lastName", "1234567890", "address");
		});
		
		String nullExpectedMessage = "Contact ID must not be null and must be no longer than " + Contact.NAME_NUMBER_ID_LENGTH + " characters";
		String nullActualMessage = nullException.getMessage();
		
		assertTrue(nullActualMessage.equals(nullExpectedMessage));
		
		// test that 11+ character contact ID throws an exception
		Exception lengthException = assertThrows(IllegalArgumentException.class, () -> {
			new Contact("elevenChars", "firstName", "lastName", "1234567890", "address");
		});
		
		String lengthExpectedMessage = "Contact ID must not be null and must be no longer than " + Contact.NAME_NUMBER_ID_LENGTH + " characters";
		String lengthActualMessage = lengthException.getMessage();
		
		assertTrue(lengthActualMessage.equals(lengthExpectedMessage));
		
		// test that updating contact ID throws an exception
		IllegalAccessError updateException = assertThrows(IllegalAccessError.class, () -> {
			Contact testContact = new Contact("1234", "firstName", "lastName", "1234567890", "address");
			testContact.setContactId("newId");
		});
		
		String updateExpectedMessage = "Contact ID cannot be changed";
		String updateActualMessage = updateException.getMessage();
		
		assertTrue(updateActualMessage.equals(updateExpectedMessage));
	}
	
	@Test
	public void testFirstName() {
		// test that null first name throws an exception
		Exception nullException = assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567890", null, "lastName", "1234567890", "address");
		});
		
		String nullExpectedMessage = "First name must not be null and must be no longer than " + Contact.NAME_NUMBER_ID_LENGTH + " characters";
		String nullActualMessage = nullException.getMessage();
		
		assertTrue(nullActualMessage.equals(nullExpectedMessage));
		
		// test that 11+ character first name throws an exception
		Exception lengthException = assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567890", "elevenChars", "lastName", "1234567890", "address");
		});
		
		String lengthExpectedMessage = "First name must not be null and must be no longer than " + Contact.NAME_NUMBER_ID_LENGTH + " characters";
		String lengthActualMessage = lengthException.getMessage();
		
		assertTrue(lengthActualMessage.equals(lengthExpectedMessage));
	}
	
	@Test
	public void testLastName() {
		// test that null last name throws an exception
		Exception nullException = assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567890", "firstName", null, "1234567890", "address");
		});
		
		String nullExpectedMessage = "Last name must not be null and must be no longer than " + Contact.NAME_NUMBER_ID_LENGTH + " characters";
		String nullActualMessage = nullException.getMessage();
		
		assertTrue(nullActualMessage.equals(nullExpectedMessage));
		
		// test that 11+ character last name throws an exception
		Exception lengthException = assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567890", "firstName", "elevenChars", "1234567890", "address");
		});
		
		String lengthExpectedMessage = "Last name must not be null and must be no longer than " + Contact.NAME_NUMBER_ID_LENGTH + " characters";
		String lengthActualMessage = lengthException.getMessage();
		
		assertTrue(lengthActualMessage.equals(lengthExpectedMessage));
	}
	
	@Test
	public void testPhoneNumber() {
		// test that null phone number throws an exception
		Exception nullException = assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567890", "firstName", "lastName", null, "address");
		});
		
		String nullExpectedMessage = "Phone number must not be null and must be no longer than " + Contact.NAME_NUMBER_ID_LENGTH + " characters";
		String nullActualMessage = nullException.getMessage();
		
		assertTrue(nullActualMessage.equals(nullExpectedMessage));
		
		// test that 11+ character phone number throws an exception
		Exception lengthException = assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567890", "firstName", "lastName", "elevenChars", "address");
		});
		
		String lengthExpectedMessage = "Phone number must not be null and must be no longer than " + Contact.NAME_NUMBER_ID_LENGTH + " characters";
		String lengthActualMessage = lengthException.getMessage();
		
		assertTrue(lengthActualMessage.equals(lengthExpectedMessage));
	}
	
	@Test
	public void testAddress() {
		// test that null address throws an exception
		Exception nullException = assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567890", "firstName", "lastName", "1234567890", null);
		});
		
		String nullExpectedMessage = "Address must not be null and must be no longer than " + Contact.ADDRESS_LENGTH + " characters";
		String nullActualMessage = nullException.getMessage();
		
		assertTrue(nullActualMessage.equals(nullExpectedMessage));
		
		// test that 31+ character address throws an exception
		Exception lengthException = assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567890", "firstName", "lastName", "1234567890", "thirty-one characters istoomany");
		});
		
		String lengthExpectedMessage = "Address must not be null and must be no longer than " + Contact.ADDRESS_LENGTH + " characters";
		String lengthActualMessage = lengthException.getMessage();
		
		assertTrue(lengthActualMessage.equals(lengthExpectedMessage));
	}
	
	@Test
	public void testGoodContact() {
		// test that a good contact is instantiated correctly
		Contact testContact = new Contact("1234", "firstName", "lastName", "1234567890", "address");
				
		assertTrue(testContact.getContactId().equals("1234"));
		assertTrue(testContact.getFirstName().equals("firstName"));
		assertTrue(testContact.getLastName().equals("lastName"));
		assertTrue(testContact.getPhoneNumber().equals("1234567890"));
		assertTrue(testContact.getAddress().equals("address"));
	}

}
