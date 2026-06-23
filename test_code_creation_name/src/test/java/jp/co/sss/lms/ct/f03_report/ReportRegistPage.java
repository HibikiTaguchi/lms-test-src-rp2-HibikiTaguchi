package jp.co.sss.lms.ct.f03_report;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReportRegistPage {
	
	// ドライバ等必須のフィールド
	private WebDriver driver;
	
	private WebDriverWait wait;
	
	private JavascriptExecutor js;
	
	private Actions act;
	
	// WebElement
	private WebElement learningContent;
	
	private WebElement registBtn;
	
	@FindBy(id = "intFieldValue_0")
	private WebElement selectComprehension;
	
	@FindBy(id = "content_0")
	private WebElement levelOfAchievement;
	
	public ReportRegistPage(WebDriver driver) { 
		 this.driver = driver;  
		 this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 this.js = (JavascriptExecutor) driver;
		 this.act = new Actions(driver);
		 PageFactory.initElements(driver, this); 
	}

	public void clearLearningContent() {
		learningContent = driver.findElement(By.xpath("//input[@type='text' and @id='intFieldName_0']"));
		learningContent.clear();
	}

	public void clickRegist() {
		registBtn = driver.findElement(By.xpath("//button[@type='submit']"));
		wait.until(ExpectedConditions.elementToBeClickable(registBtn));
		js.executeScript("arguments[0].click();", registBtn);
	}
	
	public WebElement getErrorElement() {
		return driver.findElement(By.cssSelector(".form-control.errorInput"));
	}

	public void inputLearningContent(String inputLearningContent) {
		learningContent = driver.findElement(By.xpath("//input[@type='text' and @id='intFieldName_0']"));
		learningContent.clear();
		learningContent.sendKeys(inputLearningContent);
	}

	public void selectComprehension(String optionsValue) {
		Select dropdown = new Select(selectComprehension);
		dropdown.selectByValue(optionsValue);
	}

	public void inputLevelOfAchievement(String errorLevelOfAchievement) {
		levelOfAchievement.clear();
		levelOfAchievement.sendKeys(errorLevelOfAchievement);
	}
}