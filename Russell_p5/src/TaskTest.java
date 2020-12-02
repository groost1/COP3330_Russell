import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class TaskTest {
	@Test
	public void createTaskCorrectParams() {
		Task task = new Task("task 0", "desc 0", "2020-10-10");
		
		assertEquals(task.toFileString(), "task 0\tdesc 0\t2020-10-10\t");
	}
	
	@Test
	public void setTaskInvalidTitle() {
		Task task = new Task();
		task.setTitle("");
		
		assertEquals(task.getTitle(), null);
	}
	
	@Test
	public void setTaskInvalidDate() {
		Task task = new Task();
		task.setDateDue("");
		
		assertEquals(task.getTitle(), null);
	}
	
	
}