package daotests;

import org.junit.Before;
import org.junit.Test;

import daos.EmployeeDAO;
import daos.EmployeeDAOmaria;
import daos.ReimbursementDAO;
import daos.ReimbursementDAOmaria;
import entities.Employee;
import entities.Reimbursement;

public class ReimbursementDAOtests {

	ReimbursementDAO rdao = new ReimbursementDAOmaria();

	
//	@Test
//	public void setup() {
//		EmployeeDAO edao = new EmployeeDAOmaria();
//		System.out.println("this is createEmployee setup");
//		Employee avi = new Employee();
//		avi.setEmployeeId(2);
//		avi.setName("Bishu");
//		avi.setUsername("bishu");
//		avi.setPassword("123");
//		avi.setManager(false);
//		System.out.println(edao.createEmployee(avi));
//	}

	@Test
	public void createReimbursementtest() {
		System.out.println("this is createReimbursement test");
		Reimbursement rbsmt = new Reimbursement();
		rbsmt.setrId(1);
		rbsmt.setAmount(500);
		rbsmt.setDescription("Testing Reimbursement DAO impl");
		rbsmt.setStatus("pending");
		rbsmt.setEmployeeId(1);
		System.out.println(rdao.createReimbursement(rbsmt));
		
//		System.out.println("this is createReimbursement test 2");
		Reimbursement rbsmt2 = new Reimbursement();
		rbsmt2.setrId(2);
		rbsmt2.setAmount(550);
		rbsmt2.setDescription("Testing Reimbursement DAO impl deletion");
		rbsmt2.setStatus("pending");
		rbsmt2.setEmployeeId(1);
		rdao.createReimbursement(rbsmt2);
	}
	
//	@Test
//	public void getAllReimbursementtest() {
//		System.out.println("this is getAllReimbursement test");
//		System.out.println(rdao.getAllReimbursement());
//	}
//	
	@Test
	public void getallReimbursementbyEmployeeIdtest() {
		System.out.println("this is getallReimbursementbyEmployeeId test");
		System.out.println(rdao.getallReimbursementbyEmployeeId(5));
	}
//	
//	@Test
//	public void getReimbursementByIdtest() {
//		System.out.println("this is getReimbursementById test");
//		System.out.println(rdao.getReimbursementById(1));
//	}
	
//	@Test
//	public void setReimbursementAmounttest() {
//		System.out.println("this is setReimbursementAmount test");
//		Reimbursement r1 = rdao.getReimbursementById(1);
//		r1.setAmount(2000);
//		System.out.println(rdao.setReimbursementAmount(r1));
//		
//	}
//	
//	@Test
//	public void setReimbursementDescriptiontest() {
//		System.out.println("this is setReimbursementDescription test");
//		Reimbursement r1 = rdao.getReimbursementById(1);
//		r1.setDescription("changed sedc from test");
//		System.out.println(rdao.setReimbursementDescription(r1));
//	}
//	
//	@Test
//	public void setReimbursementStatustest() {
//		System.out.println("this is setReimbursementStatus test");
//		Reimbursement r1 = rdao.getReimbursementById(1);
//		r1.setStatus("Granted");
//		System.out.println(rdao.setReimbursementStatus(r1));
//	}
	
//	@Test
//	public void removeReimbursementtest() {
//		System.out.println("this is removeReimbursement test");
//		Reimbursement r1 = rdao.getReimbursementById(3);
//		rdao.removeReimbursement(r1);
////		System.out.println(rdao.getAllReimbursement());
//		
//	}
//	
//	

}
