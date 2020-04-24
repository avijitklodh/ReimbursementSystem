package services;

import daos.ReimbursementDAO;
import daos.ReimbursementDAOmaria;
import entities.Reimbursement;

public class ReimSubmissionServiceImpl implements ReimSubmissionService{
	
	ReimbursementDAO rdao = new ReimbursementDAOmaria();

	@Override
	public Reimbursement applyForReimbursement(Reimbursement reimbursement) {
		
		Reimbursement reim = new Reimbursement();
		
		reim.setAmount(reimbursement.getAmount());
		reim.setDescription(reimbursement.getDescription());
		reim.setEmployeeId(reimbursement.getEmployeeId());
		reim.setStatus("Pending");
		rdao.createReimbursement(reim);
		
		return reim;
	}

}
