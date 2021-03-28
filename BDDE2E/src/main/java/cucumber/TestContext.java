
package cucumber;

import managers.WebDriverManager;
import managers.PageObjectManager;

public class TestContext {
	private WebDriverManager driverManager;
	private PageObjectManager pageObjectManager;

	public TestContext() {
		driverManager = new WebDriverManager();
		pageObjectManager = new PageObjectManager(driverManager.getDriver());
	}

	
	public PageObjectManager getPageObjectManager() {
		return pageObjectManager;
	}


	public WebDriverManager getDriverManager() {
		return driverManager;
	}
}
