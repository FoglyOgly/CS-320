package m3;

public class Contact {
	
	static final int NAME_NUMBER_ID_LENGTH = 10;
	static final int ADDRESS_LENGTH = 30;
	private String contactId;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String address;
	
	private static boolean validateNameNumberId(String nameNumberId) {
		// method to validate name, phone number, or ID meet requirements
		if (nameNumberId == null) { // requirement: ID cannot be null
			return false;
		} else if (nameNumberId.length() > NAME_NUMBER_ID_LENGTH) { // requirement: ID cannot exceed this length
			return false; 
		} else {
			return true;
		}
	}
	
	private static boolean validateAddress(String address) {
		// method to validate address meets requirements
		if (address == null) { // requirement: address cannot be null
			return false;
		} else if (address.length() > ADDRESS_LENGTH) { // requirement: address cannot exceed this length
			return false;
		} else {
			return true;
		}
	}
	
	public Contact(String contactId, String firstName, String lastName, String phoneNumber, String address) {
		if (validateNameNumberId(contactId)) {
			this.contactId = contactId;
		} else {
			throw new IllegalArgumentException("Contact ID must not be null and must be no longer than " + NAME_NUMBER_ID_LENGTH + " characters");
		}
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setPhoneNumber(phoneNumber);
		this.setAddress(address);
	}

	public String getContactId() {
		return contactId;
	}
	
	public String setContactId(String contactId) {
		throw new IllegalAccessError("Contact ID cannot be changed"); // requirement: ID cannot be changed
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		// validates and sets first name
		if (validateNameNumberId(firstName)) {
			this.firstName = firstName;
		} else {
			throw new IllegalArgumentException("First name must not be null and must be no longer than " + NAME_NUMBER_ID_LENGTH + " characters");
		}
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		// validates and sets last name
		if (validateNameNumberId(lastName)) {
			this.lastName = lastName;
		} else {
			throw new IllegalArgumentException("Last name must not be null and must be no longer than " + NAME_NUMBER_ID_LENGTH + " characters");
		}
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		// validates and sets phone number
		if (validateNameNumberId(phoneNumber)) {
			this.phoneNumber = phoneNumber;
		} else {
			throw new IllegalArgumentException("Phone number must not be null and must be no longer than " + NAME_NUMBER_ID_LENGTH + " characters");
		}
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		// validates and sets address
		if (validateAddress(address)) {
			this.address = address;
		} else {
			throw new IllegalArgumentException("Address must not be null and must be no longer than " + ADDRESS_LENGTH + " characters");
		}
	}
	
	
	
	

}
