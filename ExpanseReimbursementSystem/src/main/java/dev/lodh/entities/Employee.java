package dev.lodh.entities;

public class Employee {
	
	private int employeeId;
	private String name;
	private String username;
	private String password;
	private boolean manager;
	
	public Employee(int employeeId, String name, String username, String password, boolean manager) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.username = username;
		this.password = password;
		this.manager = manager;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isManager() {
		return manager;
	}

	public void setManager(boolean manager) {
		this.manager = manager;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", name=" + name + ", username=" + username + ", password="
				+ password + ", manager=" + manager + "]";
	}
	
	

}
