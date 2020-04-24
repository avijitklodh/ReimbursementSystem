package entities;

public class Reimbursement extends Employee {
	
	private int rId;
	private int amount;
	private String description;
	private String Status;
	public Reimbursement() {
		super();
	}

	public Reimbursement(int employeeId, String name, String username, String password, boolean manager) {
		super(employeeId, name, username, password, manager);
		// TODO Auto-generated constructor stub
	}

	public Reimbursement(int employeeId, String name, String username, String password, boolean manager, int rId,
			int amount, String description, String status) {
		super(employeeId, name, username, password, manager);
		this.rId = rId;
		this.amount = amount;
		this.description = description;
		Status = status;
	}

	public int getrId() {
		return rId;
	}

	public void setrId(int rId) {
		this.rId = rId;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	@Override
	public String toString() {
		return "Reimbursement [rId=" + rId + ", amount=" + amount + ", description=" + description + ", Status="
				+ Status + "]";
	}



}
