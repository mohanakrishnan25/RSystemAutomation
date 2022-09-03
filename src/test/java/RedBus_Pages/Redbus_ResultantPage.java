package RedBus_Pages;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import Configuration.BaseTest;

public class Redbus_ResultantPage extends BaseTest{
	public WebDriver webdriver;
	public Map<String,String> TestData;
	private static final By Departure = By.xpath("//a[contains(.,'Departure')]");

	public Redbus_ResultantPage(WebDriver webdriver,Map<String,String> TestData) {
		this.webdriver=webdriver;
		this.TestData=TestData;
		PageFactory.initElements(webdriver, this);
	}
	public void Sort_Departure() throws ParseException {
		boolean flag=false;
		if(ElementVisibility(Departure)) {
			executeClick(Departure);
			do {
				if(ElementVisibility(By.xpath("//a[contains(.,'Departure')]//following-sibling::i[contains(@class,'icon-down-arrow')]")))
					break;
				else
					executeClick(Departure);
			}while(true);
		}
//		int totalBus=Integer.parseInt(GetText(By.xpath("//span[contains(@class,'busFound')]")).replaceAll("[^0-9]", ""));
		do {
			//		String ResultXpath="//div[contains(.,'Showing') and contains(@class,'section')]//descendant::span[1]";
			//		int totalshowing=Integer.parseInt(GetText(By.xpath(ResultXpath)).replaceAll("[^0-9]", ""));
			String FooterLink="//footer[contains(@id,'rh_footer') and contains(@style,'display: block')]";
			if(ElementVisibility(By.xpath(FooterLink)))
			{
				int totalbuses=webdriver.findElements(By.xpath("//div[contains(@class,'dp-time')]")).size();
				ArrayList<Date> list=new ArrayList<Date>();
				for (int i=1;i<=totalbuses;i++)
				{
					String DT=webdriver.findElement(By.xpath("(//div[contains(@class,'dp-time')])["+i+"]")).getText().trim();
					DateFormat format=new SimpleDateFormat("hh:mm");
					Date d=format.parse(DT);					
					list.add(d);
				}
				flag=TimeSortValidation_Descendending(list);
				if(flag)
					Print_Console("Sorted in Decending Order");
				else
					Print_Console("Not Displayed in Descending order");
				break;
			}
			else
			{
				ScrollDown();
			}
		}while(true);
	}
	public void ViewSeat() {
		String BusName=TestData.get("BusName");
		String BusTime=TestData.get("BusTime");
		String ViewSeatXpath="//div[contains(.,'View Seats')]//ancestor::li[contains(.,'"+BusName+"') and contains(.,'"+BusTime+"')]";
		if(ElementVisibility(By.xpath(ViewSeatXpath)))
			executeClick(By.xpath(ViewSeatXpath));
	}
}
