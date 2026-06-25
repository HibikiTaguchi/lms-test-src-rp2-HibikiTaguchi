package jp.co.sss.lms.ct.f04_attendance;

import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import jp.co.sss.lms.ct.util.WebDriverUtils;
import jp.co.sss.lms.util.DateUtil;

public class AttendanceInfoManagementPage {

	private WebDriver driver;
	
	private WebDriverWait wait;
	
	private JavascriptExecutor js;

	// WebElement
	@FindBy(xpath = "//input[@type='submit' and @name='punchIn']")
	private WebElement punchInBtn;
	
	private WebElement thePunchTime;

	@FindBy(xpath = "//input[@type='submit' and @name='punchOut']")
	private WebElement punchOutBtn;
	
	@FindBy(partialLinkText = "勤怠情報を直接編集する")
	private WebElement changeAttendanceInfoDirectly;
	
	@FindBy(name = "attendanceForm")
	private WebElement attendanceForm;

	@FindBy(xpath = "//button[contains(text(),'定時')]")
	private List<WebElement> defaultTimeBtns;
	
	public AttendanceInfoManagementPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.js = (JavascriptExecutor) driver;
		PageFactory.initElements(driver, this);
	}

	public void clickPunchInBtn() throws InterruptedException {
		WebDriverUtils.clickElement(punchInBtn);
		WebDriverUtils.acceptAlert();
	}

	public WebElement getThePunchTime() {
		DateUtil dateUtil = new DateUtil();
		Date now = new Date();
		
		String today = dateUtil.toString(now, "yyyy年M月d日");
		String punchInTime = dateUtil.dateToString(now, "HH:mm");
		
		thePunchTime = driver.findElement(By.xpath(
			"//td[contains(text(),'" + today + "')]/following-sibling::td[contains(text(),'" + punchInTime + "')]"));
		
		wait.until(ExpectedConditions.visibilityOf(punchInBtn));
		
		return thePunchTime;
	}

	public void clickPunchOutBtn() {
		WebDriverUtils.clickElement(punchOutBtn);
		WebDriverUtils.acceptAlert();
	}

	public void clickChangeAttendanceInfoDirectly() {
		WebDriverUtils.clickElement(changeAttendanceInfoDirectly);
	}

	public List<WebElement> getDefaultTimeBtns() {
		return defaultTimeBtns;
	}

	public WebElement getChangeAttendanceInfoDirectly() {
		return changeAttendanceInfoDirectly;
	}
}
