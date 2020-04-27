package daotests;

import org.junit.Test;

import daos.EmployeeDAO;
import daos.EmployeeDAOmaria;
import entities.Employee;

public class EmployeeDAOtests {

EmployeeDAO edao = new EmployeeDAOmaria();
	

	@Test
	public void createEmployeetest() {
		System.out.println("this is createEmployee test");
		Employee avi = new Employee();
		avi.setEmployeeId(1);
		avi.setName("Avi");
		avi.setUsername("avi");
		avi.setPassword("123");
		avi.setManager(true);
		System.out.println(edao.createEmployee(avi));
		
		Employee avi2 = new Employee();
		avi2.setEmployeeId(1);
		avi2.setName("Tenmo");
		avi2.setUsername("tenmo");
		avi2.setPassword("123");
		avi2.setManager(true);
		edao.createEmployee(avi2);
		
		
	}
	
//	@Test
//	public void getAllEmployeetest() {
//		System.out.println("this is getAllEmployee test");
//		System.out.println(edao.getAllEmployee());
//	}
//	
//	@Test
//	public void getEmployeeByIdtest() {
//		System.out.println("this is getEmployeeById test");
//		System.out.println(edao.getEmployeeById(1));
//	}
////	
//	@Test
//	public void setEmployeeNametest() {
//		System.out.println("this is setEmployeeNametest test");
//		Employee avi = edao.getEmployeeById(1);
//		avi.setName("Avijit");
//		System.out.println(edao.setEmployeeName(avi));	
//	}
//	@Test
//	public void setEmployeeUsernametest() {
//		System.out.println("this is setEmployeeUsername test test");
//		Employee avi = edao.getEmployeeById(1);
//		avi.setUsername("avijit");
//		System.out.println(edao.setEmployeeUsername(avi));
//	}
//	@Test
//	public void setEmployeePasswordtest() {
//		System.out.println("this is setEmployeePassword test");
//		Employee avi = edao.getEmployeeById(1);
//		avi.setPassword("12345");
//		System.out.println(edao.setEmployeePassword(avi));
//	}
//	@Test
//	public void setEmployeeManagertest() {
//		System.out.println("this is setEmployeePassword test");
//		Employee avi = edao.getEmployeeById(1);
//		avi.setPassword("Avijit");
//		System.out.println(edao.setEmployeePassword(avi));
//	}
//	@Test
//	public void removeEmployeetest() {
//		System.out.println("this is removeEmployee test");
//		Employee avi = edao.getEmployeeById(3);
//		edao.removeEmployee(avi);
//		System.out.println(edao.getAllEmployee());
//	}
////	
//	
//
}
