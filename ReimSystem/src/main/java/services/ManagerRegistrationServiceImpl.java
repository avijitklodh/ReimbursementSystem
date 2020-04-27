package services;

import daos.EmployeeDAO;
import daos.EmployeeDAOmaria;
import entities.Employee;

public class ManagerRegistrationServiceImpl implements ManagerRegistrationService{
	
	EmployeeDAO edao = new EmployeeDAOmaria();

	@Override
	public Employee registerManager(Employee employee) {
		
		Employee emp = new Employee();
		
		emp.setEmployeeId(0);
		emp.setManager(true);
		emp.setName(employee.getName());
		emp.setUsername(employee.getUsername());
		emp.setPassword(employee.getPassword());
		
		edao.createEmployee(emp);
		
		return emp;
	}

}
