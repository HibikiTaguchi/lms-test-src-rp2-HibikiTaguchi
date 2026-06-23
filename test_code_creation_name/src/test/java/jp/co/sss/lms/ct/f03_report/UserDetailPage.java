package jp.co.sss.lms.ct.f03_report;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserDetailPage {
	
	private WebDriver driver;
	
	private WebDriverWait wait;
	
	private List<WebElement> reviseWeeklyReport;
	
	public UserDetailPage(WebDriver driver) { 
		 this.driver = driver;  
		 this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 PageFactory.initElements(driver, this); 
	}

	public void clickReviseWeeklyReport() {
		reviseWeeklyReport = driver.findElements(By.xpath("//input[@value='修正する']"));
		wait.until(ExpectedConditions.elementToBeClickable(reviseWeeklyReport.get(0))).click();
	}	
}
