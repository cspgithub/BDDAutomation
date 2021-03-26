
package cucumber;

import managers.DriverManager;
import managers.PageObjectManager;

public class TestContext {
	private DriverManager driverManager;
	private PageObjectManager pageObjectManager;

	public TestContext() {
		driverManager = new DriverManager();
		pageObjectManager = new PageObjectManager(driverManager.getDriver());
	}

	
	public PageObjectManager getPageObjectManager() {
		return pageObjectManager;
	}


	public DriverManager getDriverManager() {
		return driverManager;
	}
}
