package parallel;

import cucumber.TestContext;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.LoginPage;

public class HomePageSteps {

	LoginPage loginPage;
	TestContext testContext;

	public HomePageSteps(TestContext context) {
		testContext = context;
		loginPage = testContext.getPageObjectManager().getLoginPage();
	}

	@When("I enter url on browser")
	public void i_enter_url_on_browser() throws InterruptedException {
		loginPage.navigateTo_LoginPage();

	}

	@Then("I enter credentials")
	public void i_enter_credentials() {
		loginPage.enterCredentilas("reach2shekhar@gmail.com", "Naukri@2021@");
		//loginPage.enterCredentilas("77378", "Cfg@march2021");
	}

}
