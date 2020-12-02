import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.jupiter.api.Test;

public class ContactItemTest {
	@Test
	public void createFailsWithNoValues() {
		ContactItem item = new ContactItem("", "", "", "");

		assertNull(item.getfName());
	}

	@Test
	public void createSucceedsWithBlankEmail() {
		ContactItem item = new ContactItem("fname", "lname", "123-456-7981", "");

		// checks to see if the email object is initialized to the empty string
		assertNotNull(item.getEmail());
	}

	@Test
	public void createSucceedsWithBlankPhoneNumber() {
		ContactItem item = new ContactItem("fname", "lname", "", "abc@xy.z");

		// checks to see if the phone object is initialized to the empty string
		assertNotNull(item.getPhone());
	}

	@Test
	public void createSucceedsWithBlankLName() {
		ContactItem item = new ContactItem("fname", "", "123-456-7981", "abc@xy.z");

		// checks to see if the lName object is initialized to the empty string
		assertNotNull(item.getlName());
	}
	
	@Test
	public void editFailsWithNoValues() {
		ContactItem item = new ContactItem("fName", "lname", "123-456-7981", "abc@xy.z");
		ContactItem itemCheck = new ContactItem("fName", "lname", "123-456-7981", "abc@xy.z");

		item.editContact("", "", "", "");
		
		//compares the strings of the two objects to make sure the edit didn't go through
		assertEquals(item.toPrintString(), itemCheck.toPrintString());
	}

	@Test
	public void createSucceedsWithBlankFName() {
		ContactItem item = new ContactItem("", "lname", "123-456-7981", "abc@xy.z");

		// checks to see if the fName object is initialized to the empty string
		assertNotNull(item.getfName());
	}

	@Test
	public void editSucceedsWithBlankFName() {
		ContactItem item = new ContactItem("fName", "lname", "123-456-7981", "abc@xy.z");

		item.editContact("", "lName", "123-456-7891", "abc@xc.z");

		// checks to see if the fName object is initialized to the empty string
		assertNotNull(item.getfName());
	}

	@Test
	public void editSucceedsWithBlankLName() {
		ContactItem item = new ContactItem("fName", "lname", "123-456-7981", "abc@xy.z");

		item.editContact("fName", "", "123-456-7891", "abc@xc.z");

		// checks to see if the fName object is initialized to the empty string
		assertEquals(item.getlName(), "");
	}

	@Test
	public void editSucceedsWithBlankPhone() {
		ContactItem item = new ContactItem("fName", "lname", "123-456-7981", "abc@xy.z");

		item.editContact("fName", "lName", "", "abc@xc.z");

		// checks to see if the fName object is initialized to the empty string
		assertEquals(item.getPhone(), "");
	}

	@Test
	public void editSucceedsWithBlankEmail() {
		ContactItem item = new ContactItem("fName", "lname", "123-456-7981", "abc@xy.z");

		item.editContact("fName", "lName", "123-456-7891", "");

		// checks to see if the fName object is initialized to the empty string
		assertEquals(item.getEmail(), "");
	}
}
