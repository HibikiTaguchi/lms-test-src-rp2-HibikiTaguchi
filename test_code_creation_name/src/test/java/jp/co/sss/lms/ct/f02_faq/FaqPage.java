package jp.co.sss.lms.ct.f02_faq;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FaqPage {

	private WebDriver driver;
	
	private WebDriverWait wait;
	
	@FindBy(tagName = "h2")
	private WebElement h2Faq;
	
	public FaqPage(WebDriver driver) {
		this.driver = driver;  
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this); 
	}

	public String getH2Faq() {
		return h2Faq.getText();
	}
}
