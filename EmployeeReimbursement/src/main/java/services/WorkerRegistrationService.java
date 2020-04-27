package services;

import entities.Employee;

public interface WorkerRegistrationService {
	
	Employee registrarWorker(String name, String username, String password);

}
