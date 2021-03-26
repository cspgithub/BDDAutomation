package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelemiumAction {

	WebDriverWait wait;
	WebDriver driver;
	
	public SelemiumAction(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	protected void sleep(long ms) {
		try {
			Thread.sleep(ms);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void navigateTo(String url) {
		driver.get(url);
	}

	protected WebElement getWebElement(By by) {
		wait = new WebDriverWait(driver, 40);
		return wait.until(ExpectedConditions.presenceOfElementLocated(by));
	}

	protected void click(By by) {
		getWebElement(by).click();

	}

	protected void type(By by, String value) {
		clearWebField(getWebElement(by));
		getWebElement(by).sendKeys(value);

	}

	protected void clearWebField(WebElement element) {
		while (!element.getAttribute("value").equals("")) {
			element.sendKeys(Keys.BACK_SPACE);
		}
	}

}
