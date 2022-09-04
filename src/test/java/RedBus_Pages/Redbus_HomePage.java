package RedBus_Pages;

import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import Configuration.BaseTest;

public class Redbus_HomePage extends BaseTest{
	public WebDriver webdriver;
	private static final int ElementWait=30;
	public WebDriverWait wait;
	public Map<String,String> TestData;
	private static final By RedbusHome=By.xpath("//img[contains(@class,'redbus-logo')]");
	private static final By Currency=By.xpath("//div[contains(@id,'curr_chosen')]");
	private static final By AcceptCookies =By.xpath("//button[contains(.,'Accept All')]");
	private static final By SOURCE = By.xpath("//input[contains(@id,'src')]");	
	private static final By DESTINATION=By.xpath("//input[contains(@id,'dest')]");

	private static final By STARTDATE = By.xpath("//input[contains(@id,'onward_cal')]");	
	private static final By RETURNDATE=By.xpath("//input[contains(@id,'r-date')]");

	private static final By SearchButton = By.xpath("//button[contains(@id,'search_butn')]");

	public Redbus_HomePage(WebDriver webdriver,Map<String,String> TestData) {
		this.webdriver=webdriver;
		this.TestData=TestData;
		wait=new WebDriverWait(webdriver, Duration.ofSeconds(50));
		PageFactory.initElements(webdriver, this);
	}

	public void RedBus_HomePageValidation() {
		if(ElementVisibility(RedbusHome))		
			Print_Console("Launched Redbus Application");
		else
			Print_Console("Unable to launch Redbus Apllication");
	}

	public void Choose_CuurencyType() {
		if(ElementVisibility(Currency))
		{
			executeClick(Currency);
			String CurrencyType=TestData.get("Currency");

			String CurrencyXpath="//li[contains(@data-currency,'"+CurrencyType+"')]";
			if(ElementVisibility(By.xpath(CurrencyXpath)))
			{
				executeClick(By.xpath(CurrencyXpath));
			}
			else
				Print_Console("Unable to find user specific Currency Type");
		}
		else
			Print_Console("Unable to find currency Field");
		if(ElementVisibility(AcceptCookies))		
			executeClick(AcceptCookies);
	}

	public void SearchBus() throws Exception {
		String src=TestData.get("Source");
		String Dst=TestData.get("Destination");
		String StartDate=TestData.get("StartDate");
		String RetDate=TestData.get("ReturnDate");
		SendKeys(SOURCE, src);
		//Thread.sleep(2000);
		//input[contains(@id,'src')]//following::div[contains(@class,'auto')][1]"
		robotKeyPress(KeyEvent.VK_ENTER);
		robotKeyRelease(KeyEvent.VK_ENTER);
		SendKeys(DESTINATION, Dst);
		Thread.sleep(3000);
		robotKeyPress(KeyEvent.VK_ENTER);
		robotKeyRelease(KeyEvent.VK_ENTER);
		//executeClick(By.xpath("//input[contains(@id,'src')]//following::div[contains(@class,'auto')][1]"));
		String Startdatexpath="//div[contains(@class,'DatePicker__MainBlock')][1]/descendant::span[text()='"+StartDate+"']";
		String Returndatexpath="//div[contains(@class,'DatePicker__MainBlock')][1]/descendant::span[text()='"+RetDate+"']";
		executeClick(STARTDATE);
		executeClick(By.xpath(Startdatexpath));
		executeClick(RETURNDATE);
		executeClick(By.xpath(Returndatexpath));
		executeClick(SearchButton);
	}
}
