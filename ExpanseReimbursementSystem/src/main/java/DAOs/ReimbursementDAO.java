package dev.lodh.DAOs;

import java.util.List;

import dev.lodh.entities.Reimbursement;

public interface ReimbursementDAO {
	
//	private int rId;
//	private int amount;
//	private String description;
	
	Reimbursement createReimbursement(Reimbursement reimbursement);
	List<Reimbursement> getAllReimbursement();
	List<Reimbursement> getallReimbursementbyEmployeeId(int id);
	Reimbursement getReimbursementById(int id);
	Reimbursement setReimbursementAmount(Reimbursement reimbursement);
	Reimbursement setReimbursementDescription(Reimbursement reimbursement);
	Reimbursement setReimbursementStatus(Reimbursement reimbursement);
	boolean removeReimbursement(Reimbursement reimbursement);
	

}
