package daotests;

import org.junit.Test;

import dev.lodh.daos.TaskDAO;
import dev.lodh.daos.TaskDAOmaria;
import dev.lodh.entities.Task;

public class TaskDAOTests {


	private TaskDAO tdao = new TaskDAOmaria();
	
	@Test
	public void test() {
		Task t = new Task(0,"Finish this example",2,false);	
		tdao.createTask(t);
		System.out.println(t);
	}

	@Test
	public void getAll() {
		System.out.println(tdao.getAllTasks());
	}
	
	@Test
	public void getTaskById() {
		System.out.println(tdao.getTaskById(1));
	}

}
