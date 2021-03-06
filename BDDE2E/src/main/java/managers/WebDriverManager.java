package managers;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import enums.DriverType;
import enums.EnvironmentType;

public class WebDriverManager {

	private  WebDriver driver;
	private static DriverType driverType;
	private static EnvironmentType environmentType;

	public WebDriverManager() {
		driverType = FileReaderManager.getInstance().getConfigReader().getBrowser();
		environmentType = FileReaderManager.getInstance().getConfigReader().getEnvironment();
	}

	public WebDriver getDriver() {
		if (Objects.isNull(driver)) {
			createDriver();
		}
		return driver;
	}

	public WebDriver createDriver() {
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

	public WebDriver createLocalDriver() {
		switch (driverType) {
		case FIREFOX:
			// WebDriverManager.firefoxdriver().setup();
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
		return Driver.GetDriver();

	}

	private static WebDriver createRemoteDriver() {
		throw new RuntimeException("RemoteWebDriver is not yet implemented");
	}

	public void closeDriver() {
		if (Driver.GetDriver() != null) {
			Driver.GetDriver().close();
			Driver.GetDriver().quit();
		}

	}

}
