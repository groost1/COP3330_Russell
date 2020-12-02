
public class ContactItem {
	private String fName, lName, phone, email;

	public ContactItem(String fName, String lName, String phone, String email) {
		//checks to ensure at least one value has non-zero length
		if (fName.length() > 0 || lName.length() > 0 || phone.length() > 0 || email.length() > 0) {
			setfName(fName);
			setlName(lName);
			setPhone(phone);
			setEmail(email);
		}
	}

	// Takes in the file string and parses it appropriately
	public ContactItem(String parseString) {
		String[] splitParse = parseString.split("\t");

		fName = splitParse[0];
		lName = splitParse[1];
		phone = splitParse[2];
		email = splitParse[3];
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String name) {
		this.fName = name;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String name) {
		this.lName = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		if (phone.length() != 12 && phone.length() != 0) {
			System.out.println("Incorrect phone number, not set.");
		}
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if (email.length() != 0 && (!email.contains("@") || !email.contains("."))) {
			System.out.println("Not valid email, email not set.");
		} else
			this.email = email;
	}
	
	public void editContact(String fName, String lName, String phone, String email) {
		//checks to ensure at least one value has non-zero length
		if (fName.length() > 0 || lName.length() > 0 || phone.length() > 0 || email.length() > 0) {
			setfName(fName);
			setlName(lName);
			setPhone(phone);
			setEmail(email);
		}
	}

	public String toFileString() {
		return fName + "\t" + lName + "\t" + phone + "\t" + email;
	}

	public String toPrintString() {
		return String.format("Name: %s %s\nPhone: %s\nEmail: %s", fName, lName, phone, email);
	}

}
