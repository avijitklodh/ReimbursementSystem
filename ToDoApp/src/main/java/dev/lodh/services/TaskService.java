package dev.lodh.services;

import java.util.List;

import dev.lodh.entities.Task;

public interface TaskService {
	
	Task createTask(Task task);
	Task markTaskComplete(Task task);
	Task getTaskById(int id);
	
	List<Task> retrieveAllTasks();
	List<Task> retrievePendingTasks();
	List<Task> retrieveCompletedTasks();

}
