package jp.co.sss.lms.ct.f05_exam;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExamItLiteracy1Page {

	private WebDriver driver;
	
	private WebDriverWait wait;
	
	private JavascriptExecutor js;
	
	// WebElement
	@FindBy(xpath = "//input[@type='submit' and @value='確認画面へ進む']")
	private WebElement goToConfirmBtn;
	
	@FindBy(tagName = "h2")
	private WebElement h2;
	
	@FindBy(id = "sendButton")
	private WebElement sendAnswerBtn;
	
	public ExamItLiteracy1Page(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.js = (JavascriptExecutor) driver;
		PageFactory.initElements(driver, this);
	}

	public void clickGoToConfirmBtn() {
		js.executeScript("arguments[0].click();", goToConfirmBtn);
	}

	public String getH2Text() {
		return h2.getText();
	}

	public void clickSendAnswerBtn() {
		js.executeAsyncScript("arguments[0].click();", sendAnswerBtn);
		driver.switchTo().alert().accept();
	}
}
