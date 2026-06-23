package jp.co.sss.lms.ct.f02_faq;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FaqPage {

	private WebDriver driver;
	
	private WebDriverWait wait;
	
	@FindBy(tagName = "h2")
	private WebElement h2Faq;
	
	@FindBy(id = "form")
	private WebElement textBox;
	
	private WebElement searchBtn;
	
	@FindBy(tagName = "dt")
	private WebElement faqTitle;
	
	private WebElement clearBtn;
	
	private List<WebElement> questionsAboutSeminor = new ArrayList<WebElement>();
	
	private WebElement questionAboutCancel;
	
	private WebElement answerAboutCancel;
	
	@FindBy(partialLinkText = "【研修関係】")
	private WebElement aboutSeminor;
	
	public FaqPage(WebDriver driver) {
		this.driver = driver;  
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	public String getH2Faq() {
		return h2Faq.getText();
	}

	public void searchBy(String keyword) {
		textBox.sendKeys(keyword);
		searchBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='submit' and @value='検索']")));
		searchBtn.click();
	}

	public Integer countTr() {
		return driver.findElements(By.tagName("tr")).size();
	}

	public String getDt() {
		return faqTitle.getText();
	}

	public void clickClear() {
		clearBtn = driver.findElement(By.xpath("//input[@type='button' and @value='クリア']"));
		clearBtn.click();
	}

	public String getTextBox() {
		return textBox.getText();
	}
	
	public String getQuestionText(Integer arrayNumber) {
		questionsAboutSeminor = driver.findElements(By.tagName("dt"));
		return questionsAboutSeminor.get(arrayNumber).getText();
	}

	public void clickAboutSeminor() {
		aboutSeminor.click();
	}

	public void clickQuestionAboutCancel() {
		questionAboutCancel = driver.findElement(By.xpath("//dt[1]"));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", questionAboutCancel);
	}

	public String getAnswerText() {
		answerAboutCancel = driver.findElement(By.xpath("//dd[1]"));
		return answerAboutCancel.getText();
	}
	
	public void waitForTitle() {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.tagName("title")));
	}
	
	public void waitForDd() {
		answerAboutCancel = driver.findElement(By.xpath("//dd[1]"));
		wait.until(ExpectedConditions.visibilityOf(answerAboutCancel));
	}
}
