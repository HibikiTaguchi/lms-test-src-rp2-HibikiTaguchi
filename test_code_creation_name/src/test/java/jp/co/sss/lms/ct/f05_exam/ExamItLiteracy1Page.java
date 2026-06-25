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
	
	@FindBy(xpath = "//input[@type='submit' and @value='戻る']")
	private WebElement backBtn;
	
	@FindBy(id = "answer-0-2")
	private WebElement answer1RadioButton;
	
	@FindBy(id = "answer-1-2")
	private WebElement answer2RadioButton;
	
	@FindBy(id = "answer-2-0")
	private WebElement answer3RadioButton;
	
	@FindBy(id = "answer-3-0")
	private WebElement answer4RadioButton;
	
	@FindBy(id = "answer-4-1")
	private WebElement answer5RadioButton;
	
	@FindBy(id = "answer-5-1")
	private WebElement answer6RadioButton;
	
	@FindBy(id = "answer-6-0")
	private WebElement answer7RadioButton;
	
	@FindBy(id = "answer-7-0")
	private WebElement answer8RadioButton;
	
	@FindBy(id = "answer-8-0")
	private WebElement answer9RadioButton;
	
	@FindBy(id = "answer-9-0")
	private WebElement answer10RadioButton;

	@FindBy(id = "answer-10-0")
	private WebElement answer11RadioButton;
	
	@FindBy(id = "answer-11-0")
	private WebElement answer12RadioButton;
	
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

	public void clickBackBtn() {
		js.executeScript("arguments[0].click();", backBtn);
	}

	public void selectAnswer() {
		answer1RadioButton.click();
		answer2RadioButton.click();
		answer3RadioButton.click();
		answer4RadioButton.click();
		answer5RadioButton.click();
		answer6RadioButton.click();
		answer7RadioButton.click();
		answer8RadioButton.click();
		answer9RadioButton.click();
		answer10RadioButton.click();
		answer11RadioButton.click();
		answer12RadioButton.click();
	}
}
