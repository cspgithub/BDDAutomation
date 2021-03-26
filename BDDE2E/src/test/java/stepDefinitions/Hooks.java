package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

	
	  TestContext testContext;
	  
	  public Hooks(TestContext context) { testContext = context; }
	 
	@Before
	public void beforeScenario() {
		testContext.getDriverManager().getDriver();

	}

	@After
	public void afterScenario() {
		testContext.getDriverManager().closeDriver();

	}
}
