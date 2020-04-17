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
					List<Employee> employees = new ArrayList<Employee>();
				while(rs.next()) {
					
					Employee emp = new Employee();
					
					emp.setEmployeeId(rs.getInt("EMPLOYEE_ID"));
					emp.setName(rs.getString("NAME"));
					emp.setUsername(rs.getString("USERNAME"));
					emp.setPassword(rs.getString("PASSWORD"));
					emp.setManager(rs.getBoolean("MANAGER"));
					
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
		try(Connection conn = ConncetionUtil.createConnection()){
			String sql = "SELECT * FROM EMPLOYEE WHERE EMPLOYEE_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			
			Employee emp = new Employee();
			
			emp.setEmployeeId(rs.getInt("EMPLOYEE_ID"));
			emp.setName(rs.getString("NAME"));
			emp.setUsername(rs.getString("USERNAME"));
			emp.setPassword(rs.getString("PASSWORD"));
			emp.setManager(rs.getBoolean("MANAGER"));
			return emp;
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public Employee setEmployeeName(Employee employee) {
		try(Connection conn = ConncetionUtil.createConnection()){
			String sql = "UPDATE EMPLOYEE SET NAME = ? WHERE EMPLOYEE_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, employee.getName());
			ps.setInt(2, employee.getEmployeeId());
			ps.execute();
			
			return employee;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Employee setEmployeeUsername(Employee employee) {
		try(Connection conn = ConncetionUtil.createConnection()){
			String sql = "UPDATE EMPLOYEE SET USERNAME = ? WHERE EMPLOYEE_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, employee.getUsername());
			ps.setInt(2, employee.getEmployeeId());
			ps.execute();
			
			return employee;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Employee setEmployeePassword(Employee employee) {
		try(Connection conn = ConncetionUtil.createConnection()){
			String sql = "UPDATE EMPLOYEE SET PASSWORD = ? WHERE EMPLOYEE_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, employee.getPassword());
			ps.setInt(2, employee.getEmployeeId());
			ps.execute();
			return employee;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Employee setEmployeeManager(Employee employee) {
		try(Connection conn = ConncetionUtil.createConnection()){
			String sql = "UPDATE EMPLOYEE SET MANAGER = ? WHERE EMPLOYEE_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setBoolean(1, employee.isManager());
			ps.setInt(2, employee.getEmployeeId());
			ps.execute();
			
			return employee;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean removeEmployee(Employee employee) {
		try(Connection conn = ConncetionUtil.createConnection()){
			
			String sql = "DELETE FROM EMPLOYEE WHERE EMPLOYEE_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, employee.getEmployeeId());
			
			boolean success = ps.execute();
			return success;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	

}
