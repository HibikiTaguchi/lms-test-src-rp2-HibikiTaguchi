package jp.co.sss.lms.ct.f04_attendance;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import jp.co.sss.lms.ct.util.WebDriverUtils;

public class AttendanceInfoManagementDirectlyPage {

	private WebDriver driver;
	
	private WebDriverWait wait;
	
	private JavascriptExecutor js;
	
	// WebElement
	@FindBy(id = "startHour0")
	private WebElement startHour0;
	
	@FindBy(id = "startMinute0")
	private WebElement startMinute0;
	
	@FindBy(id = "endHour0")
	private WebElement endHour0;
	
	@FindBy(id = "endMinute0")
	private WebElement endMinute0;
	
	@FindBy(name = "attendanceList[0].blankTime")
	private WebElement blankTime0;
	
	@FindBy(name = "attendanceList[0].note")
	private WebElement note0;
	
	@FindBy(xpath = "//input[@type='submit' and @name='complete']")
	private WebElement updateBtn;
	
	@FindBy(css = ".error")
	private WebElement errorMsg;
	
	public AttendanceInfoManagementDirectlyPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.js = (JavascriptExecutor) driver;
		PageFactory.initElements(driver, this);
	}

	public void inputSelect(WebElement selectElement, String punchTime) {
		Select dropDown = new Select(selectElement);
		dropDown.selectByVisibleText(punchTime);
	}

	public void inputNote(String note) {
		note0.clear();
		note0.sendKeys(note);
	}
	
	public void inputAttendanceInfo(String punchInHour, String punchInMinute,
	  String punchOutHour, String punchOutMinute, String blankTime, String note) {
		inputSelect(startHour0, punchInHour);
		inputSelect(startMinute0, punchInMinute);
		inputSelect(endHour0, punchOutHour);
		inputSelect(endMinute0, punchOutMinute);
		inputSelect(blankTime0, blankTime);
		inputNote(note);
		WebDriverUtils.clickElement(updateBtn);
		WebDriverUtils.acceptAlert();
	}

	public String getErrorMsg() {
		return errorMsg.getText();
	}
}
