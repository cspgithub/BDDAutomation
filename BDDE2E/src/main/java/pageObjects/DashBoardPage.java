package pageObjects;

import org.openqa.selenium.WebDriver;

public class DashBoardPage {

	WebDriver driver;

	public DashBoardPage(WebDriver driver) {
		this.driver=driver;
		//PageFactory.initElements(driver, this);
	}

	public String getTitle_DashBoardpage() {
		
		return driver.getTitle();
	}



}
