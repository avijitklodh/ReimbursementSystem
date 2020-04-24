package services;

import daos.ReimbursementDAO;
import daos.ReimbursementDAOmaria;
import entities.Reimbursement;

public class ReimSubmissionServiceImpl implements ReimSubmissionService{
	
	ReimbursementDAO rdao = new ReimbursementDAOmaria();

	@Override
	public Reimbursement applyForReimbursement(int amount, String description, int employee_id) {
		
		Reimbursement reim = new Reimbursement();
		
		reim.setAmount(amount);
		reim.setDescription(description);
		reim.setEmployeeId(employee_id);
		reim.setStatus("Pending");
		rdao.createReimbursement(reim);
		
		return reim;
	}

}
