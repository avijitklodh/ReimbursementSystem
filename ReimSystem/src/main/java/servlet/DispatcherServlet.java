package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controllers.ReimManagementController;


public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DispatcherServlet() {
        super();
    }
    
    ReimManagementController rmcont = new ReimManagementController();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		System.out.println(uri);
		
//		response.getWriter().append("You hit dispatcher");
		
		switch(uri) {
		case "/ReimSystem/api/reimbursements" : rmcont.getAllReimbursement(request, response);break;/*only get*/
		case "/ReimSystem/api/registeremployee" : rmcont.workerRegister(request, response);break;
		case "/ReimSystem/api/registermanager" : rmcont.managerRegister(request, response);break;
		case "/ReimSystem/api/reimbursementapplication" : rmcont.reimsubmission(request, response);break;
		case "/ReimSystem/api/approveReimbursement" : rmcont.approveReim(request, response);break;
		case "/ReimSystem/api/denyReimbursement" : rmcont.denyReim(request, response);break;
		case "/ReimSystem/api/reimbursementbyid" : rmcont.getEmployeeReimbursements(request, response);break; /*this is a post request*/
		case "/ReimSystem/api/login" : rmcont.getLoggedin(request, response);break;
		default : response.getWriter().append("your request uri did not match anything");break;
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
