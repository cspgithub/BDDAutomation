package pageObjects;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import managers.FileReaderManager;

public class LoginPage {

	WebDriver driver;
	private By loginLink = By.xpath("//a[@id='login_Layer']");
	private By loginPassword = By.xpath("//input[@placeholder='Enter your password']");
	private By loginButton = By.xpath("//button[@type='submit']");
	private By loginUsername = By.xpath("//input[@placeholder='Enter your active Email ID / Username']");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void navigateTo_LoginPage() {
		driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
		closePopUps();

	}

	public void enterCredentilas(String username, String pwd) {
		driver.findElement(loginLink).click();
		driver.findElement(loginUsername).sendKeys(username);
		driver.findElement(loginPassword).sendKeys(pwd);
		driver.findElement(loginButton).click();

	}

	public void closePopUps()  {
		// It will return the parent window name as a String
		String parent = driver.getWindowHandle();
		Set<String> s = driver.getWindowHandles();
		// Now iterate using Iterator
		Iterator<String> I1 = s.iterator();
		while (I1.hasNext()) {
			String child_window = I1.next();
			if (!parent.equals(child_window)) {
				driver.switchTo().window(child_window);
				//System.out.println(driver.switchTo().window(child_window).getTitle());
				driver.close();
					}
		}
		// switch to the parent window
		driver.switchTo().window(parent);

	}
}
