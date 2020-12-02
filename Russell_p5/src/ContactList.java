import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ContactList {
	private ArrayList<ContactItem> contactList;
	
	public ContactList() {
		contactList = new ArrayList<ContactItem>();
	}
	
	//adds a contact to the list
	public void addContact(ContactItem newContact) {
		contactList.add(newContact);
	}
	
	public void removeTask(int indexToRemove) {
		if (indexToRemove < 0 || indexToRemove >= contactList.size()) {
			System.out.println("WARNING: invalid index, contact not removed");
			return;
		}
		
		contactList.remove(indexToRemove);
	}
	
	public ContactItem getContact(int index) {
		if (index < 0 || index >= contactList.size()) {
			System.out.println("WARNING: INVALID INDEX");
			return null;
		}

		return contactList.get(index);
	}
	
	public void setTask(int index, ContactItem newContact) {
		if (index < 0 || index >= contactList.size()) {
			System.out.println("WARNING: INVALID INDEX");
			return;
		}

		contactList.set(index, newContact);
	}
	
	public boolean saveList(String nameOfList) {
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(new File("ContactLists/" + nameOfList + ".txt")));

			// print all of the tasks in a parsable format
			for (ContactItem curTask : contactList) {
				pw.println(curTask.toFileString());
			}
			pw.println("EOF");

			pw.flush();
			pw.close();
		} catch (IOException e) {
			return false;
		}

		return true;
	}
	
	public void loadList(String nameOfList) {
		try {
			Scanner sc = new Scanner(new File("ContactLists/" + nameOfList));
			String in;
			
			//read in the parsable strings from the file
			while (!(in = sc.nextLine()).equals("EOF")) {
				contactList.add(new ContactItem(in));
			}
			sc.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public String toString() {
		String res = "";

		for (int i = 0; i < contactList.size(); i++) {
			res += i + ") " + contactList.get(i).toPrintString() + "\n";
		}

		return res;
	}
	
	//TO-DO load contacts
	public boolean isEmpty() {
		return contactList.isEmpty();
	}
	
	
}
