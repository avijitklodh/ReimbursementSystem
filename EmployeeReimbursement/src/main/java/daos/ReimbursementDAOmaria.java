package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entities.Reimbursement;
import utils.ConncetionUtil;

public class ReimbursementDAOmaria implements ReimbursementDAO{

	public Reimbursement createReimbursement(Reimbursement reimbursement) {
		try(Connection conn = ConncetionUtil.createConnection()){
			String sql = "INSERT INTO REIMBURSEMENT VALUES (?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, 0);
			ps.setInt(2, reimbursement.getAmount());
			ps.setString(3, reimbursement.getDescription());
			ps.setString(4, reimbursement.getStatus());
			ps.setInt(5, reimbursement.getEmployeeId());
			ps.execute();
			
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			
			int key = rs.getInt("REIMBURSEMENT_ID");
			reimbursement.setrId(key);
			return reimbursement;		
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		
		
	}

	public List<Reimbursement> getAllReimbursement() {
		try(Connection conn = ConncetionUtil.createConnection()){
			String sql = "SELECT * FROM REIMBURSEMENT";
					PreparedStatement ps = conn.prepareStatement(sql);
					ResultSet rs = ps.executeQuery();
					List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
				while(rs.next()) {
					
					Reimbursement reimbursement = new Reimbursement();
					
					reimbursement.setrId(rs.getInt("REIMBURSEMENT_ID"));
					reimbursement.setAmount(rs.getInt("AMOUNT"));
					reimbursement.setDescription(rs.getString("DESCRIPTION"));
					reimbursement.setStatus(rs.getString("STATUS"));
					reimbursement.setEmployeeId(rs.getInt("EMPLOYEE_ID"));
					
					reimbursements.add(reimbursement);
				}
					return reimbursements;
					
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Reimbursement> getallReimbursementbyEmployeeId(int id) {
		try(Connection conn = ConncetionUtil.createConnection()){
			String sql = "SELECT * FROM REIMBURSEMENT WHERE EMPLOYEE_ID = ?";
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.setInt(1, id);
					ResultSet rs = ps.executeQuery();
					List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
				while(rs.next()) {
					
					Reimbursement reimbursement = new Reimbursement();
					
					reimbursement.setrId(rs.getInt("REIMBURSEMENT_ID"));
					reimbursement.setAmount(rs.getInt("AMOUNT"));
					reimbursement.setDescription(rs.getString("DESCRIPTION"));
					reimbursement.setStatus(rs.getString("STATUS"));
					reimbursement.setEmployeeId(rs.getInt("EMPLOYEE_ID"));
					
					reimbursements.add(reimbursement);
				}
					return reimbursements;
					
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Reimbursement getReimbursementById(int id) {
		try(Connection conn = ConncetionUtil.createConnection()){
			String sql = "SELECT * FROM REIMBURSEMENT WHERE REIMBURSEMENT_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			
			Reimbursement reimbursement = new Reimbursement();
			
			reimbursement.setrId(rs.getInt("REIMBURSEMENT_ID"));
			reimbursement.setAmount(rs.getInt("AMOUNT"));
			reimbursement.setDescription(rs.getString("DESCRIPTION"));
			reimbursement.setStatus(rs.getString("STATUS"));
			reimbursement.setEmployeeId(rs.getInt("EMPLOYEE_ID"));
			return reimbursement;
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public Reimbursement setReimbursementAmount(Reimbursement reimbursement) {
		try(Connection conn = ConncetionUtil.createConnection()){
			String sql = "UPDATE REIMBURSEMENT SET AMOUNT = ? WHERE REIMBURSEMENT_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, reimbursement.getAmount());
			ps.setInt(2, reimbursement.getrId());
			ps.execute();
			
			return reimbursement;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Reimbursement setReimbursementDescription(Reimbursement reimbursement) {
		try(Connection conn = ConncetionUtil.createConnection()){
			String sql = "UPDATE REIMBURSEMENT SET DESCRIPTION = ? WHERE REIMBURSEMENT_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, reimbursement.getDescription());
			ps.setInt(2, reimbursement.getrId());
			ps.execute();
			
			return reimbursement;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Reimbursement setReimbursementStatus(Reimbursement reimbursement) {
		try(Connection conn = ConncetionUtil.createConnection()){
			String sql = "UPDATE REIMBURSEMENT SET STATUS = ? WHERE REIMBURSEMENT_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, reimbursement.getStatus());
			ps.setInt(2, reimbursement.getrId());
			ps.execute();
			
			return reimbursement;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean removeReimbursement(Reimbursement reimbursement) {
		try(Connection conn = ConncetionUtil.createConnection()){
			
			String sql = "DELETE FROM REIMBURSEMENT WHERE REIMBURSEMENT_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, reimbursement.getrId());
			
			boolean success = ps.execute();
			return success;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

}
