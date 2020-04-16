package dev.lodh.services;

import java.util.List;

import dev.lodh.daos.TaskDAO;
import dev.lodh.daos.TaskDAOmaria;
import dev.lodh.entities.Task;

public class TaskServiceImpl implements TaskService {


	private TaskDAO tdao = new TaskDAOmaria();
	
	
	public Task createTask(Task task) {
		tdao.createTask(task);
		return task;
	}

	
	public Task markTaskComplete(Task task) {
		task.setDone(true);
		tdao.updateTask(task);
		return task;
	}

	
	public List<Task> retrieveAllTasks() {		
		return tdao.getAllTasks();
	}

	
	public List<Task> retrievePendingTasks() {
		return tdao.getPendingTasks();
	}

	
	public List<Task> retrieveCompletedTasks() {
		return tdao.getCompletedTasks();
	}

	
	public Task getTaskById(int id) {		
		return tdao.getTaskById(id);
	}

	
}
