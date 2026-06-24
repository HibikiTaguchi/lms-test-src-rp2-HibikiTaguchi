package jp.co.sss.lms.ct.f05_exam;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SectionDetailPage {
	
	private WebDriver driver;
	
	private WebDriverWait wait;
	
	private JavascriptExecutor js;
	
	// WebElement
	@FindBy(xpath = "//h3[contains(text(),'本日の試験')]/following-sibling::table//input[@type='submit']")
	private WebElement detailBtnInTodaysExam;
	
	public SectionDetailPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.js = (JavascriptExecutor) driver;
		PageFactory.initElements(driver, this);
	}

	public void clickDetailBtnInTodaysExam() {
		js.executeScript("arguments[0].click();", detailBtnInTodaysExam);
	}
}
