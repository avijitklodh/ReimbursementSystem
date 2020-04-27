package services;

import java.util.List;

import daos.EmployeeDAO;
import daos.EmployeeDAOmaria;
import entities.Employee;

public class LoginServiceImpl implements LoginService{
	
	EmployeeDAO edao = new EmployeeDAOmaria();


	public Employee loggedIn(Employee employee) {
		
			String username = employee.getUsername();
			String password = employee.getPassword();
			
		
			List <Employee> allEmployee= edao.getAllEmployee();
		
			for(Employee emp : allEmployee) {
				String dbUsername = emp.getUsername();
				String dbPassword = emp.getPassword();
				if(dbUsername.equals(username) & dbPassword.equals(password)) {
				return emp;
			}
		}
			return null;
	}

}
