package services;

import java.util.List;

import entities.Reimbursement;

public interface ReimManagementService {
	
	List<Reimbursement> viewAllReimbursements();
	Reimbursement approveReim(Reimbursement reim);
	Reimbursement denyReim(Reimbursement reim);
	List<Reimbursement> viewAllMyReimbursements(int id);
}
