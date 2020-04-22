package services;

import java.util.List;

import daos.ReimbursementDAO;
import daos.ReimbursementDAOmaria;
import entities.Reimbursement;

public class ReimManagementServiceImpl implements ReimManagementService {
	
	ReimbursementDAO rdao = new ReimbursementDAOmaria();

	@Override
	public List<Reimbursement> viewAllReimbursements() {
		List<Reimbursement> reims = rdao.getAllReimbursement();
		return reims;
	}

	@Override
	public Reimbursement approveReim(Reimbursement reim) {
		reim.setStatus("Approved");
		rdao.setReimbursementStatus(reim);
		return reim;
	}

	@Override
	public Reimbursement denyReim(Reimbursement reim) {
		reim.setStatus("Denied");
		rdao.setReimbursementStatus(reim);
		return reim;
	}

	@Override
	public List<Reimbursement> viewAllMyReimbursements(int id) {
		List<Reimbursement> reims = rdao.getallReimbursementbyEmployeeId(id);
		return reims;
	}

}
