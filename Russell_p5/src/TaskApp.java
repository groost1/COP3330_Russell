import java.io.File;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TaskApp {

	public Scanner sc;
	private TaskList mainList;

	public TaskApp(Scanner sc) {
		this.sc = sc;
		mainList = new TaskList();

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
			mainList = new TaskList();
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
					"1) view the list\n2) add an item\n3) edit an item\n4) remove an item\n5) mark an item as completed\n6) unmark an item as completed\n7) save the current list\n8) quit to the main menu");

			int input = getIntRange(1, 8);
			switch (input) {
			case 1:
				printTasks();
				break;
			case 2:
				addTask();
				break;
			case 3:
				editTask();
				break;
			case 4:
				removeTask();
				break;
			case 5:
				markTask();
				break;
			case 6:
				unMarkTask();
				break;
			case 7:
				saveList();
				break;
			case 8:
				break listLoop;
			}
		}

		printMainMenu();
	}

	public void printTasks() {
		System.out.println("Current Tasks\n---------\n");
		System.out.println(mainList.toString());
		// TO-DO print tasks
	}

	public void addTask() {
		String title, desc, date;

		// gets task info from user
		System.out.print("Task title: ");
		title = sc.nextLine();
		System.out.print("Task description: ");
		desc = sc.nextLine();
		System.out.print("Task due date (YYYY-MM-DD): ");
		date = sc.nextLine();

		// checks for proper info input
		if (!isProperDate(date)) {
			System.out.println("WARNING: improper date format; task not created");
			return;
		}
		if (title.length() < 1) {
			System.out.println("WARNING: IMPROPER TITLE; task not created");
		}

		// TO-DO actually make and add task
		mainList.addTask(new Task(title, desc, date));
	}

	public void editTask() {
		printTasks();

		// check if there are any tasks to edit
		if (mainList.getSize() == 0) {
			System.out.println("There are no tasks to edit, please select something else");
			return;
		}

		// get task to edit
		System.out.print("Which task will you edit? ");
		int index = sc.nextInt();
		sc.nextLine();
		Task inputTask = mainList.getTask(index);

		// get replacement info
		String title, desc, date;

		System.out.print("new Task title for " + inputTask.getTitle() + ": ");
		title = sc.nextLine();
		System.out.print("new Task description for " + inputTask.getTitle() + ": ");
		desc = sc.nextLine();
		System.out.print("new Task due date for " + inputTask.getTitle() + " (YYYY-MM-DD) : ");
		date = sc.nextLine();

		// checks for proper info input
		if (!isProperDate(date)) {
			System.out.println("WARNING: improper date format; task not editted");
			return;
		}
		if (title.length() < 1) {
			System.out.println("WARNING: IMPROPER TITLE; task not editted");
		}

		// replace with new task
		mainList.setTask(index, new Task(title, desc, date));
	}

	public void markTask() {
		printTasks();

		// check if there are any tasks to mark
		if (mainList.getSize() == 0) {
			System.out.println("There are no tasks to mark, please select something else");
			return;
		}

		// get the task
		System.out.print("Which task will you like to mark? ");
		mainList.markTask(getInt());
	}

	public void unMarkTask() {
		printTasks();

		// check if there are any tasks to unmark
		if (mainList.getSize() == 0) {
			System.out.println("There are no tasks to unmark, please select something else");
			return;
		}

		// get the task
		System.out.print("Which task will you like to unmark? ");
		mainList.unmarkTask(getInt());
	}

	public void removeTask() {
		printTasks();

		// check if there are any tasks to remove
		if (mainList.getSize() == 0) {
			System.out.println("There are no tasks to remove, please select something else");
			return;
		}

		// remove the task
		System.out.print("which task would you like to remove? ");
		mainList.removeTask(getInt());
	}

	public void saveList() {
		System.out.print("What would you like to name the taskList?");
		mainList.saveList(sc.nextLine());
	}

	public void loadList() {
		// get the folder of lists
		File taskListFolder = new File("TaskLists/");
		String[] names = taskListFolder.list();

		// get the desired list from the user
		System.out.println("Which tasklist would you like to load? ");
		for (int i = 0; i < names.length; i++) {
			System.out.println(i + ") " + names[i]);
		}
		int input = getIntRange(0, names.length - 1);

		mainList = new TaskList();
		mainList.loadList(names[input]);
	}

	public boolean isProperDate(String date) {
		String[] split = date.split("-");

		// check if there are enough spots to check
		if (split.length != 3) {
			return false;
		}

		// checks if all of the date info are integers
		try {
			Integer.parseInt(split[0]);
			Integer.parseInt(split[1]);
			Integer.parseInt(split[2]);
		} catch (InputMismatchException e) {
			return false;
		}

		return true;
	}

}
