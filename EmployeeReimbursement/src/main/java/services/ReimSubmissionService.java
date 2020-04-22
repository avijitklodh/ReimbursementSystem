package services;

import entities.Reimbursement;

public interface ReimSubmissionService {
	
	Reimbursement applyForReimbursement(int amount,String description, int employee_id);

}
