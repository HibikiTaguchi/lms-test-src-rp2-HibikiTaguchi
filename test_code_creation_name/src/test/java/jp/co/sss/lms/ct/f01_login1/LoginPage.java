package jp.co.sss.lms.ct.f01_login1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	private WebDriver webDriver;
	
	private WebDriverWait wait;

	
	@FindBy(tagName = "h2")
	private WebElement h2;
	
	@FindBy(id = "loginId")
	private WebElement loginIdTextBox;
	
	@FindBy(id = "password")
	private WebElement passwordTextBox;
	
	@FindBy(className = "help-inline")
	private WebElement error;
	
	private WebElement loginBtn;
	
	public LoginPage(WebDriver driver) { 
		 this.webDriver = driver; 
		 this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 PageFactory.initElements(driver, this); 
	}
	
	public void waitH2() {
		wait.until(ExpectedConditions.visibilityOfAllElements(h2));
	}
	
	public String getH2() {
		return h2.getText();
	}
	
	public String getError() {
		error = webDriver.findElement(By.cssSelector(".help-inline.error"));
		return error.getText();
	}
	
	public void tryLogin(String loginId, String password) {
		loginIdTextBox.clear();
		loginIdTextBox.sendKeys(loginId);
		passwordTextBox.clear();
		passwordTextBox.sendKeys(password);
		
		loginBtn = webDriver.findElement(By.cssSelector(".btn.btn-primary"));
		wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
		loginBtn.click();
	}
}
