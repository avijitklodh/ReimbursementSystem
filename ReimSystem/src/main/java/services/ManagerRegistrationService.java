package services;

import entities.Employee;

public interface ManagerRegistrationService {
	
	Employee registerManager(String name, String username, String password);

}
