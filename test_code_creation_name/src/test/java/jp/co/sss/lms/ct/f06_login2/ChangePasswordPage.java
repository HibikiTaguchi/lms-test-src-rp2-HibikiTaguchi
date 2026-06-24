package jp.co.sss.lms.ct.f06_login2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChangePasswordPage {

	private WebDriver driver;
	
	private WebDriverWait wait;
	
	private JavascriptExecutor js;
	
	// WebElement
	private WebElement changeBtn;
	
	@FindBy(id = "upd-btn")
	private WebElement changeBtnInMordalWindow;
	
	@FindBy(xpath = "//*[@id=\"upd-form\"]/div[1]/fieldset/div[1]/div/ul/li")
	private WebElement error1;
	
	@FindBy(xpath = "//*[@id=\"upd-form\"]/div[1]/fieldset/div[2]/div/ul/li")
	private WebElement error2;
	
	@FindBy(xpath = "//*[@id=\"upd-form\"]/div[1]/fieldset/div[3]/div/ul/li")
	private WebElement error3;
	
	@FindBy(id = "currentPassword")
	private WebElement currentPasswordTextBox;
	
	@FindBy(id = "password")
	private WebElement newPasswordTextBox;
	
	@FindBy(id = "passwordConfirm")
	private WebElement comfirmPasswordTextBox;
	
	public ChangePasswordPage(WebDriver driver) {
		this.driver = driver;  
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.js = (JavascriptExecutor) driver;
		PageFactory.initElements(driver, this);
	}

	public void clickChangeBtn() {
		changeBtn = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/form/div[1]/fieldset/div[4]/div/button[2]"));
		js.executeScript("arguments[0].click();", changeBtn);
	}

	public String getError1Text() {
		return error1.getText();
	}
	
	public String getError2Text() {
		return error2.getText();
	}
	
	public String getError3Text() {
		return error3.getText();
	}

	public void ckickChangeBtnInMordalWindow() {
		js.executeScript("arguments[0].click();", changeBtnInMordalWindow);
	}

	public void inputCurrentPasword(String inputCurrentPassword) {
		currentPasswordTextBox.clear();
		currentPasswordTextBox.sendKeys(inputCurrentPassword);
	}

	public void inputNewPassword(String inputNewPassword) {
		newPasswordTextBox.clear();
		newPasswordTextBox.sendKeys(inputNewPassword);
	}

	public void inputComfirmPassword(String inputComfirmPassword) {
		comfirmPasswordTextBox.clear();
		comfirmPasswordTextBox.sendKeys(inputComfirmPassword);
	}
}
