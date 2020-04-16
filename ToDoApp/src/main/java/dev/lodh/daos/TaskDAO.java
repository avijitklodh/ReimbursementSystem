package dev.lodh.daos;

import java.util.List;

import dev.lodh.entities.Task;

public interface TaskDAO {
	
	//CREATE
	Task createTask(Task task);
	
	//READ
	Task getTaskById(int id);
	List<Task> getAllTasks();
	List<Task> getCompletedTasks();
	List<Task> getPendingTasks();
	
	//UPDATE
	Task updateTask(Task task);
	
	//DELETE
	boolean deleteTask(Task task); 
	

}
