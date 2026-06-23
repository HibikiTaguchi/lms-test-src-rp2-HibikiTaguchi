package jp.co.sss.lms.ct.f03_report;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserDetailPage {
	
	private WebDriver driver;
	
	private WebDriverWait wait;
	
	private JavascriptExecutor js;
	
	private List<WebElement> reviseReports;
	
	public UserDetailPage(WebDriver driver) { 
		 this.driver = driver;  
		 this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 this.js = (JavascriptExecutor) driver;
		 PageFactory.initElements(driver, this); 
	}

	public void clickReviseWeeklyReport() {
		reviseReports = driver.findElements(By.xpath("//input[@value='修正する']"));
		WebElement reviseWeeklyReport = reviseReports.get(0);
		wait.until(ExpectedConditions.elementToBeClickable(reviseWeeklyReport));
		
		js.executeScript("arguments[0].click();", reviseWeeklyReport);
	}	
}
