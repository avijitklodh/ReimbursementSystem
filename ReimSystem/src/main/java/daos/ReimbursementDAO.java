package daos;

import java.util.List;

import entities.Reimbursement;

public interface ReimbursementDAO {
	
	Reimbursement createReimbursement(Reimbursement reimbursement);
	List<Reimbursement> getAllReimbursement();
	List<Reimbursement> getallReimbursementbyEmployeeId(int id);
	Reimbursement getReimbursementById(int id);
	Reimbursement setReimbursementAmount(Reimbursement reimbursement);
	Reimbursement setReimbursementDescription(Reimbursement reimbursement);
	Reimbursement setReimbursementStatus(Reimbursement reimbursement);
	boolean removeReimbursement(Reimbursement reimbursement);

}
