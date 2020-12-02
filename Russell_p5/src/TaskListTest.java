import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TaskListTest {
	@Test
	public void newTaskListEmpty() {
		TaskList list = new TaskList();

		assertEquals(list.getSize(), 0);
	}

	@Test
	public void addTaskIncreasesSize() {
		TaskList list = new TaskList();

		list.addTask(new Task("task 0", "description 0", "2020-10-10"));
		assertEquals(list.getSize(), 1);
	}

	@Test
	public void removeTaskCorrectParams() {
		TaskList list = new TaskList();
		list.addTask(new Task("task 0", "description 0", "2020-10-10"));

		list.removeTask(0);
		assertEquals(list.getSize(), 0);
	}

	@Test
	public void removeTaskIncorrectParams() {
		TaskList list = new TaskList();
		list.addTask(new Task("task 0", "description 0", "2020-10-10"));

		list.removeTask(-1);
		assertEquals(list.getSize(), 1);
	}

	@Test
	public void setTaskCorrectParams() {
		TaskList list = new TaskList();
		list.addTask(new Task("task 0", "description 0", "2020-10-10"));

		list.setTask(0, new Task("task 1", "new desc", "1010-20-20"));
		assertEquals(list.getTask(0).toFileString(), "task 1\tnew desc\t1010-20-20\t");
	}

	@Test
	public void setTaskIncorrectParams() {
		TaskList list = new TaskList();
		list.addTask(new Task("task 0", "description 0", "2020-10-10"));

		list.setTask(-1, new Task("task 1", "new desc", "1010-20-20"));
		assertEquals(list.getTask(0).toFileString(), "task 0\tdescription 0\t2020-10-10\t");
	}

	@Test
	public void loadListIsSuccessful() {
		TaskList list = new TaskList();
		list.loadList("firstList.txt");

		assertEquals(list.getSize(), 1);
	}

	@Test
	public void getTaskCorrectParams() {
		TaskList list = new TaskList();
		list.addTask(new Task("task 0", "description 0", "2020-10-10"));

		assertEquals(list.getTask(0).toFileString(), "task 0\tdescription 0\t2020-10-10\t");
	}

	@Test
	public void getTaskIncorrectParams() {
		TaskList list = new TaskList();
		list.addTask(new Task("task 0", "description 0", "2020-10-10"));

		assertEquals(list.getTask(-1), null);
	}

	@Test
	public void markTaskCorrectParams() {
		TaskList list = new TaskList();
		list.addTask(new Task("task 0", "description 0", "2020-10-10"));

		list.markTask(0);
		assertEquals(list.getTask(0).toFileString(), "task 0\tdescription 0\t2020-10-10\t***");
	}

	@Test
	public void markTaskIncorrectParams() {
		TaskList list = new TaskList();
		list.addTask(new Task("task 0", "description 0", "2020-10-10"));

		list.markTask(-1);
		assertEquals(list.getTask(0).toFileString(), "task 0\tdescription 0\t2020-10-10\t");
	}

	@Test
	public void unmarkTaskCorrectParams() {
		TaskList list = new TaskList();
		list.addTask(new Task("task 0", "description 0", "2020-10-10"));

		list.markTask(0);
		assertEquals(list.getTask(0).toFileString(), "task 0\tdescription 0\t2020-10-10\t***");
		list.unmarkTask(0);
		assertEquals(list.getTask(0).toFileString(), "task 0\tdescription 0\t2020-10-10\t");
	}

	@Test
	public void unmarkTaskIncorrectParams() {
		TaskList list = new TaskList();
		list.addTask(new Task("task 0", "description 0", "2020-10-10"));

		list.markTask(0);
		assertEquals(list.getTask(0).toFileString(), "task 0\tdescription 0\t2020-10-10\t***");
		list.unmarkTask(-1);
		assertEquals(list.getTask(0).toFileString(), "task 0\tdescription 0\t2020-10-10\t***");
	}
}

/*
 * completingTaskItemChangesStatus() completingTaskItemFailsWithInvalidIndex()
 * uncompletingTaskItemChangesStatus()
 * uncompletingTaskItemFailsWithInvalidIndex()
 */