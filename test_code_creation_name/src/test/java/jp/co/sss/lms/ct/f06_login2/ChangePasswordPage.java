package jp.co.sss.lms.ct.f06_login2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChangePasswordPage {

	private WebDriver driver;
	
	private WebDriverWait wait;
	
	private JavascriptExecutor js;
	
	// WebElement
	private WebElement changeBtn;
	
	private List<WebElement> errorElements;
	
	public ChangePasswordPage(WebDriver driver) {
		this.driver = driver;  
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.js = (JavascriptExecutor) driver;
		PageFactory.initElements(driver, this);
	}

	public void clickChangeBtn() {
		changeBtn = driver.findElement(By.xpath("/body/div/form/div/fieldset/div/button[@type='submit']"));
		js.executeScript("arguments[0].click();", changeBtn);
	}

	public WebElement getErrorElements(int arrayIndex) {
		errorElements = driver.findElements(By.cssSelector(".error"));
		return errorElements.get(arrayIndex);
	}
}
