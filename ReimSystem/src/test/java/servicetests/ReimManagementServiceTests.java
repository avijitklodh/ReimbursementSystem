package servicetests;

import org.junit.Test;

import services.ReimManagementService;
import services.ReimManagementServiceImpl;

public class ReimManagementServiceTests {
	
	ReimManagementService rmser = new ReimManagementServiceImpl();

	@Test
	public void test() {
		System.out.println(rmser.viewAllReimbursements());
	}

}
