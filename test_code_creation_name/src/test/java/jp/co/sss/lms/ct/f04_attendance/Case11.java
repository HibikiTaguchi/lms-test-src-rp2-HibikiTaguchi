package jp.co.sss.lms.ct.f04_attendance;

import static jp.co.sss.lms.ct.util.WebDriverUtils.*;
import static org.junit.Assert.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import jp.co.sss.lms.ct.f01_login1.CourseDetailPage;
import jp.co.sss.lms.ct.f01_login1.LoginPage;
import jp.co.sss.lms.util.Constants;

/**
 * 結合テスト 勤怠管理機能
 * ケース11
 * @author holy
 */
@TestMethodOrder(OrderAnnotation.class)
@DisplayName("ケース11 受講生 勤怠直接編集 正常系")
public class Case11 {

	private static LoginPage loginPage;
	
	private static CourseDetailPage courseDetailPage;
	
	private static AttendanceInfoManagementPage attendanceInfoManagementPage;
	
	/** 前処理 */
	@BeforeAll
	static void before() {
		createDriver();
		loginPage = new LoginPage(webDriver);
		courseDetailPage = new CourseDetailPage(webDriver);
		attendanceInfoManagementPage = new AttendanceInfoManagementPage(webDriver);
	}

	/** 後処理 */
	@AfterAll
	static void after() {
		closeDriver();
	}

	@Test
	@Order(1)
	@DisplayName("テスト01 トップページURLでアクセス")
	void test01() {
		goTo("http://localhost:8080/lms");
		
		assertEquals(Constants.TRUE_TITLE_LOGIN, webDriver.getTitle());
		assertEquals(Constants.TRUE_H2_LOGIN, loginPage.getH2());
		
		getEvidence(new Object(){});
	}

	@Test
	@Order(2)
	@DisplayName("テスト02 初回ログイン済みの受講生ユーザーでログイン")
	void test02() {
		loginPage.tryLogin(Constants.TRUE_LOGIN_ID, Constants.TRUE_PASSWORD);
		
		assertEquals(Constants.TRUE_TITLE_COURCE_DETAIL, webDriver.getTitle());
		
		getEvidence(new Object(){});
	}

	@Test
	@Order(3)
	@DisplayName("テスト03 上部メニューの「勤怠」リンクから勤怠管理画面に遷移")
	void test03() {
		courseDetailPage.clickAttendance();
		
		assertEquals(Constants.TRUE_TITLE_ATTENDANCE_INFO_MANAGEMENT, webDriver.getTitle());
		
		getEvidence(new Object(){});
	}

	@Test
	@Order(4)
	@DisplayName("テスト04 「勤怠情報を直接編集する」リンクから勤怠情報直接変更画面に遷移")
	void test04() {
		attendanceInfoManagementPage.clickChangeAttendanceInfoDirectly();
		
		assertNotNull(attendanceInfoManagementPage.getDefaultTimeBtns());

		getEvidence(new Object(){});
	}

	@Test
	@Order(5)
	@DisplayName("テスト05 すべての研修日程の勤怠情報を正しく更新し勤怠管理画面に遷移")
	void test05() {
		attendanceInfoManagementPage.clickAllDefaultTimeBtns();
		attendanceInfoManagementPage.clickUpdateBtn();
		
		assertEquals(Constants.TRUE_TITLE_ATTENDANCE_INFO_MANAGEMENT, webDriver.getTitle());
		assertNotNull(attendanceInfoManagementPage.getChangeAttendanceInfoDirectly());
		
		getEvidence(new Object(){});
	}

}
