package dev.lodh.DAOs;

import java.util.List;

import dev.lodh.entities.Employee;

public interface EmployeeDAO {
	
	Employee createEmployee(Employee employee);
	List<Employee> getAllEmployee();
	Employee getEmployeeById(int id);
	Employee getEmployeeByName(String Name);
	Employee setEmployeeName(Employee employee);
	Employee setEmployeeUsername(Employee employee);
	Employee setEmployeePassword(Employee employee);
	Employee setEmployeeManager(Employee employee);
	boolean removeEmployee(Employee employee);

}
