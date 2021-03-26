package stepDefinitions;

import org.junit.Assert;

import cucumber.TestContext;
import cucumber.api.java.en.Then;
import pageObjects.DashBoardPage;

public class DashBoardSteps {

	DashBoardPage dashBoard;
	TestContext testContext;

	public DashBoardSteps(TestContext context) {
		testContext = context;
		dashBoard = testContext.getPageObjectManager().getDashBoardPage();
	}

	@Then("I verify user logged successfully")
	public void i_verify_user_logged_successfully() {
		Assert.assertEquals("Jobs - Recruitment - Job Search - Employment -Job Vacancies - Naukri.com", dashBoard.getTitle_DashBoardpage());

	}

}
