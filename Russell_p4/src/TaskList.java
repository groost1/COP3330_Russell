import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class TaskList {

	// should I make it private and put the managemet in this object?
	// or should I make it public and change it in a different class
	private ArrayList<Task> taskList;

	public TaskList() {
		this.taskList = new ArrayList<Task>();
	}

	public TaskList(String listTitle) {

	}

	// add tasks
	public void addTask(Task newTask) {
		taskList.add(newTask);
	}

	// remove tasks w/ index
	public void removeTask(int indexToRemove) {
		// checks if the index is in the proper range
		if (indexToRemove < 0 || indexToRemove >= taskList.size()) {
			System.out.println("WARNING: invalid index, task not removed");
			return;
		}

		taskList.remove(indexToRemove);
	}

	public Task getTask(int index) {
		if (index < 0 || index >= taskList.size()) {
			System.out.println("WARNING: INVALID INDEX");
			return null;
		}

		return taskList.get(index);
	}

	public void setTask(int index, Task newTask) {
		if (index < 0 || index >= taskList.size()) {
			System.out.println("WARNING: INVALID INDEX");
			return;
		}

		taskList.set(index, newTask);
	}

	// TO-DO put this in the App class
	public boolean saveList(String nameOfList) {
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(new File("TaskLists/" + nameOfList + ".txt")));

			// print all of the tasks in a parsable format
			for (Task curTask : taskList) {
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
			Scanner sc = new Scanner(new File("TaskLists/" + nameOfList));
			String in;
			
			//read in the parsable strings from the file
			while (!(in = sc.nextLine()).equals("EOF")) {
				taskList.add(new Task(in));
			}
			sc.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void markTask(int index) {
		// check if the index is in range
		if (index < 0 || index >= taskList.size()) {
			System.out.println("WARNING: INVALID INDEX");
			return;
		}

		taskList.get(index).setMarked("***");
	}

	public void unmarkTask(int index) {
		// check if the index is in range
		if (index < 0 || index >= taskList.size()) {
			System.out.println("WARNING: INVALID INDEX");
			return;
		}

		taskList.get(index).setMarked("");
	}

	public int getSize() {
		return taskList.size();
	}

	// converts the list to a string so it can be printed and saved
	public String toString() {
		String res = "";

		for (int i = 0; i < taskList.size(); i++) {
			res += i + ") " + taskList.get(i).toPrintString() + "\n";
		}

		return res;
	}

}
