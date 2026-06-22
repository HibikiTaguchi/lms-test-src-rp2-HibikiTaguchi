package jp.co.sss.lms.ct.f02_faq;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelpPage {

	private WebDriver driver;
	
	private WebDriverWait wait;
	
	@FindBy(partialLinkText = "よくある質問")
	private WebElement faqLink;
	
	public HelpPage(WebDriver driver) {
		this.driver = driver;  
		new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this); 
	}

	public String getLinkToFaq() {
		return faqLink.getText();
	}

	public void clickFaqLink() {
		faqLink.click();
	}

}
