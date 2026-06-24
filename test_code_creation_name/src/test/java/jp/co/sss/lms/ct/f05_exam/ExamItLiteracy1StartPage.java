package jp.co.sss.lms.ct.f05_exam;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExamItLiteracy1StartPage {
	
	private WebDriver driver;
	
	private WebDriverWait wait;
	
	private JavascriptExecutor js;
	
	// WebElement
	@FindBy(xpath = "//input[@type='submit' and @value='試験を開始する'")
	private WebElement startExamBtn;
	
	public ExamItLiteracy1StartPage(WebDriver webDriver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.js = (JavascriptExecutor) driver;
		PageFactory.initElements(driver, this);
	}

	public void clickStratExamBtn() {
		js.executeScript("arguments[0].click();", startExamBtn);
	}
}
