package jp.co.sss.lms.ct.f06_login2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AgreeSecurityPage {
	
	private WebDriver driver;
	
	private WebDriverWait wait;
	
	private JavascriptExecutor js;
	
	// WebElement
	private WebElement nextBtn;
	
	public AgreeSecurityPage(WebDriver driver) {
		this.driver = driver;  
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.js = (JavascriptExecutor) driver;
		PageFactory.initElements(driver, this); 
	}

	public void clickNextBtn() {
		nextBtn = driver.findElement(By.xpath("//button[@type='submit']"));
		js.executeScript("arguments[0].click();", nextBtn);
	}

	public WebElement getErrorElement() {
		return driver.findElement(By.xpath("//div[@class='error']"));
	}
	
	
}
