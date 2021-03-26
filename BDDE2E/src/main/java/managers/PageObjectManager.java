
package managers;

import org.openqa.selenium.WebDriver;

import pageObjects.DashBoardPage;
import pageObjects.LoginPage;

public class PageObjectManager {
	private WebDriver driver;
	private LoginPage loginPage;
	private DashBoardPage dashBoardPage;

	/* constructor */
	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}

	// Creating an Object of Page Class only if the object is null,
	// Supplying the already created object if it is not null:
	public LoginPage getLoginPage() {
		return (loginPage == null) ? loginPage = new LoginPage(driver) : loginPage;

	}

	public DashBoardPage getDashBoardPage() {
		
		return (dashBoardPage == null) ? dashBoardPage = new DashBoardPage(driver) : dashBoardPage;

	}
	
}
