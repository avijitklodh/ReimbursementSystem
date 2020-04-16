package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entities.Employee;
import utils.ConncetionUtil;

public class EmployeeDAOmaria implements EmployeeDAO {

	public Employee createEmployee(Employee employee) {

		try(Connection conn = ConncetionUtil.createConnection()){
			String sql = "INSERT INTO EMPLOYEE VALUES (?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, 0);
			ps.setString(2, employee.getName());
			ps.setString(3, employee.getUsername());
			ps.setString(4, employee.getPassword());
			ps.setBoolean(5, employee.isManager());
			ps.execute();
			
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			
			int key = rs.getInt("EMPLOYEE_ID");
			employee.setEmployeeId(key);
			return employee;		
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return null;
	}

	public List<Employee> getAllEmployee() {
		try(Connection conn = ConncetionUtil.createConnection()){
			String sql = "SELECT * FROM EMPLOYEE";
					PreparedStatement ps = conn.prepareStatement(sql);
					ResultSet rs = ps.executeQuery();
					List<Employee> employees = new ArrayList();
				while(rs.next()) {
					
					Employee emp = new Employee();
					
					emp.setEmployeeId(rs.getInt("EMPLOYEE_ID"));
					
					employees.add(emp);
				}
					return employees;
					
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Employee getEmployeeById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Employee getEmployeeByName(String Name) {
		// TODO Auto-generated method stub
		return null;
	}

	public Employee setEmployeeName(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

	public Employee setEmployeeUsername(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

	public Employee setEmployeePassword(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

	public Employee setEmployeeManager(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean removeEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
