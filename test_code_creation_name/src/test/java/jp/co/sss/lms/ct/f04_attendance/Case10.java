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
 * ケース10
 * @author holy
 */
@TestMethodOrder(OrderAnnotation.class)
@DisplayName("ケース10 受講生 勤怠登録 正常系")
public class Case10 {
	
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
	@DisplayName("テスト04 「出勤」ボタンを押下し出勤時間を登録")
	void test04() throws InterruptedException {
		attendanceInfoManagementPage.clickPunchInBtn();
		
		assertNotNull(attendanceInfoManagementPage.getThePunchIn());
		
		getEvidence(new Object(){});
	}

	@Test
	@Order(5)
	@DisplayName("テスト05 「退勤」ボタンを押下し退勤時間を登録")
	void test05() {
		// TODO ここに追加
	}

}
