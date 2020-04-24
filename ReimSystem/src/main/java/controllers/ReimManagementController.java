package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import entities.Employee;
import entities.Reimbursement;
import services.LoginService;
import services.LoginServiceImpl;
import services.ManagerRegistrationService;
import services.ManagerRegistrationServiceImpl;
import services.ReimManagementService;
import services.ReimManagementServiceImpl;
import services.ReimSubmissionService;
import services.ReimSubmissionServiceImpl;
import services.WorkerRegistrationService;
import services.WorkerRegistrationServiceImpl;

public class ReimManagementController {
	
	ReimManagementService rmserv = new ReimManagementServiceImpl();
	WorkerRegistrationService wrserv = new WorkerRegistrationServiceImpl();
	ManagerRegistrationService mrserv = new ManagerRegistrationServiceImpl();
	ReimSubmissionService rsserv = new ReimSubmissionServiceImpl();
	LoginService lgserv = new LoginServiceImpl();
	
	public void getAllReimbursement(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Gson gson = new Gson();		
		
		List<Reimbursement> Reimbursements = rmserv.viewAllReimbursements();
		
		
		PrintWriter pw = response.getWriter();
		String json = gson.toJson(Reimbursements);
				pw.append(json);			
//		String s = Reimbursements.toString();
//		System.out.println(s);
//		pw.append(s);
	}
	
	public void workerRegister(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String body = request.getReader().lines().reduce("", (accumulator,actual) ->accumulator+actual);
//		System.out.println(body);
		Gson gson = new Gson();
		Employee employee = gson.fromJson(body, Employee.class);
		System.out.println(employee);
		wrserv.registrarWorker(employee);
		response.getWriter().append("Successfully registered worker!!!");
	}
	
	public void managerRegister(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String body = request.getReader().lines().reduce("", (accumulator,actual) ->accumulator+actual);
//		System.out.println(body);
		Gson gson = new Gson();
		Employee employee = gson.fromJson(body, Employee.class);
		System.out.println(employee);
		mrserv.registerManager(employee);
		response.getWriter().append("Successfully registered manager!!!");
	}
	
	
	public void reimsubmission(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String body = request.getReader().lines().reduce("", (accumulator,actual) ->accumulator+actual);
//		System.out.println(body);
		Gson gson = new Gson();
		Reimbursement reimbursement = gson.fromJson(body, Reimbursement.class);
		System.out.println(reimbursement);
		rsserv.applyForReimbursement(reimbursement);
		response.getWriter().append("Successfully created a reimbursement!!!");
	}
	
	public void approveReim(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String body = request.getReader().lines().reduce("", (accumulator,actual) ->accumulator+actual);
//		System.out.println(body);
		Gson gson = new Gson();
		Reimbursement reimbursement = gson.fromJson(body, Reimbursement.class);
		System.out.println(reimbursement);
		rmserv.approveReim(reimbursement);
		response.getWriter().append("Successfully approved a reimbursement!!!");
	}
	
	public void denyReim(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String body = request.getReader().lines().reduce("", (accumulator,actual) ->accumulator+actual);
//		System.out.println(body);
		Gson gson = new Gson();
		Reimbursement reimbursement = gson.fromJson(body, Reimbursement.class);
		System.out.println(reimbursement);
		rmserv.denyReim(reimbursement);
		response.getWriter().append("Successfully denied a reimbursement!!!");
	}
	
	public void getEmployeeReimbursements(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String body = request.getReader().lines().reduce("", (accumulator,actual) ->accumulator+actual);
		Gson gson = new Gson();		
		int id = gson.fromJson(body,int.class);
		
		List<Reimbursement> Reimbursements = rmserv.viewAllMyReimbursements(id);
		PrintWriter pw = response.getWriter();
		String json = gson.toJson(Reimbursements);
				pw.append(json);			
	}
	
	public void getLoggedin(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String body = request.getReader().lines().reduce("", (accumulator,actual) ->accumulator+actual);
		Gson gson = new Gson();		
		Employee employee = gson.fromJson(body, Employee.class);
		Employee authemployee = lgserv.loggedIn(employee);
		authemployee.setUsername(null);
		authemployee.setPassword(null);
		String json = gson.toJson(authemployee);
		PrintWriter pw = response.getWriter();
		pw.append(json);
	}

}
