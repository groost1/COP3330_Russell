import java.io.File;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ContactApp {
	private Scanner sc;
	private ContactList contactList;

	public ContactApp(Scanner sc) {
		this.sc = sc;
		contactList = new ContactList();

		printMainMenu();
	}

	public int getIntRange(int bottom, int top) {
		while (true) {
			try {
				int input = sc.nextInt();

				// check if input is within given range
				if (input >= bottom && input <= top) {
					sc.nextLine();
					return input;
				} else {
					System.out.println("Please try again.");
				}
			} catch (Exception e) {
				System.out.println("Please try again");
			}
		}
	}

	public int getInt() {
		while (true) {
			try {
				return sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Invalid integer, please try again");
			}
		}
	}

	public void printMainMenu() {
		System.out.println("Main Menu\n---------\n");
		System.out.println("1) create a new list\n2) load an existing list\n3) quit");

		int input = getIntRange(1, 3);
		switch (input) {
		case 1:
			contactList = new ContactList();
			printListOpMenu();
			break;
		case 2:
			loadList();
			printListOpMenu();
			break;
		case 3:
			break;
		}
	}

	public void printListOpMenu() {
		listLoop: while (true) {
			System.out.println("List Operation Menu\n---------\n");
			System.out.println(
					"1) view the list\n2) add an item\n3) edit an item\n4) remove an item\n5) save the current list\n6) quit to the main menu");

			int input = getIntRange(1, 8);
			switch (input) {
			case 1:
				printContacts();
				break;
			case 2:
				addContact();
				break;
			case 3:
				editTask();
				break;
			case 4:
				removeContact();
				break;
			case 5:
				saveList();
				break listLoop;
			case 6:
				break listLoop;
			}
		}

		printMainMenu();
	}

	public void printContacts() {
		System.out.println("Current Tasks\n---------\n");
		System.out.println(contactList.toString());
		// TO-DO print tasks
	}

	public void addContact() {
		String fName, lName, phone, email;

		// gets task info from user
		System.out.print("first name: ");
		fName = sc.nextLine();
		System.out.print("last name: ");
		lName = sc.nextLine();
		System.out.print("phone number (XXX-XXX-XXXX): ");
		phone = sc.nextLine();
		System.out.print("email address (abc@xy.z): ");
		email = sc.nextLine();

		// TO-DO actually make and add task
		contactList.addContact(new ContactItem(fName, lName, phone, email));
	}

	public void editTask() {
		printContacts();

		// check if there are any tasks to edit
		if (contactList.isEmpty()) {
			System.out.println("There are no tasks to edit, please select something else");
			return;
		}

		// get task to edit
		System.out.print("Which task will you edit? ");
		ContactItem contact = contactList.getContact(sc.nextInt());
		sc.nextLine();

		// get replacement info
		String fName, lName, phone, email;

		System.out.print("new first name: ");
		fName = sc.nextLine();
		System.out.print("new last name: ");
		lName = sc.nextLine();
		System.out.print("new phone number (XXX-XXX-xxxx) : ");
		phone = sc.nextLine();
		System.out.print("new email (abc@xy.z) : ");
		email = sc.nextLine();

		// replace with new task
		contact.editContact(fName, lName, phone, email);
	}

	public void removeContact() {
		printContacts();

		// check if there are any tasks to remove
		if (contactList.isEmpty()) {
			System.out.println("There are no tasks to remove, please select something else");
			return;
		}

		// remove the task
		System.out.print("which task would you like to remove? ");
		contactList.removeTask(getInt());
	}

	public void saveList() {
		System.out.print("What would you like to name the taskList?");
		contactList.saveList(sc.nextLine());
	}

	public void loadList() {
		// get the folder of lists
		File taskListFolder = new File("ContactLists/");
		String[] names = taskListFolder.list();

		// get the desired list from the user
		System.out.println("Which tasklist would you like to load? ");
		for (int i = 0; i < names.length; i++) {
			System.out.println(i + ") " + names[i]);
		}
		int input = getIntRange(0, names.length - 1);

		contactList = new ContactList();
		contactList.loadList(names[input]);
	}
}
