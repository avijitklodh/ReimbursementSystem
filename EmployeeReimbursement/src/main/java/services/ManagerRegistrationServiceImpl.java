package services;

import daos.EmployeeDAO;
import daos.EmployeeDAOmaria;
import entities.Employee;

public class ManagerRegistrationServiceImpl implements ManagerRegistrationService{
	
	EmployeeDAO edao = new EmployeeDAOmaria();

	@Override
	public Employee registerManager(String name, String username, String password) {
		
		Employee emp = new Employee();
		
		emp.setEmployeeId(0);
		emp.setManager(true);
		emp.setName(name);
		emp.setUsername(username);
		emp.setPassword(password);
		
		edao.createEmployee(emp);
		
		return emp;
	}

}
