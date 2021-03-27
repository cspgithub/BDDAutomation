package managers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import enums.DriverType;
import enums.EnvironmentType;


public class DriverManager {

	private static WebDriver driver;
	private static DriverType driverType;
	private static EnvironmentType environmentType;

	public DriverManager() {
		driverType = FileReaderManager.getInstance().getConfigReader().getBrowser();
		environmentType = FileReaderManager.getInstance().getConfigReader().getEnvironment();
	}

	public static WebDriver getDriver() {
		if (driver == null)
			driver = createDriver();
		return driver;
		
	}

	private static WebDriver  createDriver() {
		switch (environmentType) {
		case LOCAL:
			driver = createLocalDriver();
			break;
		case REMOTE:
			driver = createRemoteDriver();
			break;
		}
		return driver;
	

	}

	private static WebDriver  createLocalDriver() {
		switch (driverType) {
		case FIREFOX:
			//WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case CHROME:
			// WebDriverManager.chromedriver().setup();
			// Setting system properties of ChromeDriver
			String path = FileReaderManager.getInstance().getConfigReader().getchromeDrivePath();
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + path);
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized");
			driver = new ChromeDriver(options);
			
			break;
		}
		Driver.SetDriver(driver);
		Driver.GetDriver().manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigReader().getImplicitWait(),
				TimeUnit.SECONDS);
		Driver.GetDriver().manage().deleteAllCookies();
		return Driver.GetDriver();
		
	}

	private static WebDriver createRemoteDriver() {
		throw new RuntimeException("RemoteWebDriver is not yet implemented");
	}

	public void closeDriver() {
	
		Driver.GetDriver().close();
		Driver.GetDriver().quit();
	}

}
