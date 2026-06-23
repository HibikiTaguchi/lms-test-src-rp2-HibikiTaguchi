package jp.co.sss.lms.ct.f01_login1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CourseDetailPage {
	
	private WebDriver driver;
	
	private WebDriverWait wait;
	
	private WebElement liActive;
	
	@FindBy(partialLinkText = "機能")
	private WebElement functionMenu;
	
	@FindBy(partialLinkText = "ヘルプ")
	private WebElement help;
	
	@FindBy(partialLinkText = "ようこそ受講生ＡＡ１さん")
	private WebElement userLink;
	
	public CourseDetailPage(WebDriver driver) { 
		 this.driver = driver;  
		 this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 PageFactory.initElements(driver, this); 
	}
	
	public String getLiActive() {
		liActive = driver.findElement(By.cssSelector(".active"));
		return liActive.getText();
	}

	public void clickHelpLink() {
		wait.until(ExpectedConditions.elementToBeClickable(functionMenu));
		functionMenu.click();
		
		wait.until(ExpectedConditions.elementToBeClickable(help));
		help.click();
	}
	
	public void waitFor() {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.tagName("title")));
	}

	public void clickUserLink() {
		wait.until(ExpectedConditions.elementToBeClickable(userLink)).click();
	}
}
