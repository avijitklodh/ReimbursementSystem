package services;

import daos.EmployeeDAO;
import daos.EmployeeDAOmaria;
import entities.Employee;

public class WorkerRegistrationServiceImpl implements WorkerRegistrationService {
	
	EmployeeDAO edao = new EmployeeDAOmaria();

	@Override
	public Employee registrarWorker(Employee employee) {
		
		Employee emp = new Employee();
		
		emp.setEmployeeId(0);
		emp.setManager(false);
		emp.setName(employee.getName());
		emp.setUsername(employee.getUsername());
		emp.setPassword(employee.getPassword());
		
		edao.createEmployee(emp);
		
		return emp;
	}

}
