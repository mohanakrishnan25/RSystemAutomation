package Configuration;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WrapsDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserHandling{


	private static final String FirefoxPath=System.getProperty("user.dir")+"/DriverPath/geckodriver.exe";
	private static final String EdgePath=System.getProperty("user.dir")+"/DriverPath/msedgedriver.exe";
	private static final String ChromeDriver=System.getProperty("user.dir")+"webdriver.chrome.driver";
	private static final String IEDriver_=System.getProperty("user.dir")+"webdriver.ie.driver";
	private static final String FirefoxDriver=System.getProperty("user.dir")+"webdriver.gecko.driver";
	private static final String EdgeDriver=System.getProperty("user.dir")+"webdriver.edge.driver";
	public WebDriver webdriver;
	public Map<String, String> TestData = BaseTest.getTestData();

	public WebDriver getDriver()
	{
		return wrapDriver(webdriver);
	}
	private WebDriver wrapDriver(WebDriver webdriver2) {
		if(webdriver instanceof WrapsDriver)
			return ((WrapsDriver) webdriver).getWrappedDriver();
		return webdriver;
	}
	public WebDriver ChromeDriver() {
		WebDriverManager.chromedriver().setup();
		webdriver = new ChromeDriver();
		return webdriver;
	}
	public WebDriver EdgeDriver() {
		WebDriverManager.edgedriver().setup();
		webdriver = new EdgeDriver();
		return webdriver;
	}
}
