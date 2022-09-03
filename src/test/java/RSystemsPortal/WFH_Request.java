package RSystemsPortal;

import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Configuration.BaseTest;

public class WFH_Request extends BaseTest{
	public WebDriver webdriver;
	private static final int ElementWait=30;
	public WebDriverWait wait;
	public Map<String,String> TestData;
	private static final By WFH_Requset=By.xpath("(//div[contains(.,'Work From Home Request')])[last()]");
	private static final By WFHType= By.xpath("//select[contains(@id,'WFHType')]");
	private static final By StartDate= By.xpath("//input[contains(@id,'StartDate')]");
	private static final By ENDDate= By.xpath("//input[contains(@id,'EndDate')]");
	private static final By TabClick = By.xpath("(//td[contains(.,'End Date:')])[last()]");
	private static final By BtnSend= By.xpath("//a[contains(@onclick,'return SendRequest()')]/span[contains(.,'Send')]");
	private static final By ApprovalAuthority= By.xpath("//th[contains(.,'Approval Authority')]");
	private static final By CreateNewWFH_Req= By.xpath("//a[contains(.,'Create New WFH Request')]");
	
	
	public WFH_Request(WebDriver webdriver,Map<String,String> TestData) {
		this.webdriver=webdriver;
		this.TestData=TestData;
		wait=new WebDriverWait(webdriver, Duration.ofSeconds(50));
		PageFactory.initElements(webdriver, this);
	}
	public void Validate_WFH_RequestPage() {
		if(ElementVisibility(WFH_Requset))
			Print_Console("WFH Request Page is navigated or redirected");
		else
			Print_Console("Unable to redirect WFH Request Page");
	}
	public void Update_WFH_Request_Details() throws Exception {	
		String startdate=TestData.get("WFH_StartDate");
		String EndDate=TestData.get("WFH_EndDate");
		SelectValue(WFHType, TestData.get("WFH_Type"));
		SendKeys(StartDate, startdate);
		SendKeys(ENDDate, EndDate);
		executeClick(TabClick);
		SelectValue( By.xpath("//td[contains(.,'"+startdate+"')]/following-sibling::td/select[contains(@id,'startHr')][1]"), TestData.get("StartHr"));
		SelectValue( By.xpath("//td[contains(.,'"+startdate+"')]/following-sibling::td/select[contains(@id,'endHr')]"), TestData.get("EndHr"));
		SelectValue( By.xpath("//td[contains(.,'"+EndDate+"')]/following-sibling::td/select[contains(@id,'startHr')][1]"), TestData.get("StartHr"));		
		SelectValue( By.xpath("//td[contains(.,'"+EndDate+"')]/following-sibling::td/select[contains(@id,'endHr')]"), TestData.get("EndHr"));
		executeClick(BtnSend);
		waitFor().until(ExpectedConditions.alertIsPresent());
		webdriver.switchTo().alert().accept();
	}
	public void Validate_WFH_Request_Created() {
		if(ElementVisibility(ApprovalAuthority))
		{
			Print_Console("WFH Request Created");
			executeClick(CreateNewWFH_Req);
		}
		else
			Print_Console("WFH Request not created");
	}
	
}
