package servicetests;

import org.junit.Test;

import dev.lodh.entities.Task;
import dev.lodh.services.TaskService;
import dev.lodh.services.TaskServiceImpl;

public class TaskServiceTests {

	TaskService tserv = new TaskServiceImpl();
	@Test
	public void test() {
		
		Task t = tserv.getTaskById(1);
		System.out.println(t);
		tserv.markTaskComplete(t);
	}

}
