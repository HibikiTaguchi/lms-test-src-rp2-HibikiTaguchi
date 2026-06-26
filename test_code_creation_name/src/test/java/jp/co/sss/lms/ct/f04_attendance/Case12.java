package jp.co.sss.lms.ct.f04_attendance;

import static jp.co.sss.lms.ct.util.WebDriverUtils.*;
import static org.assertj.core.api.Assertions.assertThat;
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
 * ケース12
 * @author holy
 */
@TestMethodOrder(OrderAnnotation.class)
@DisplayName("ケース12 受講生 勤怠直接編集 入力チェック")
public class Case12 {

	private static LoginPage loginPage;
	
	private static CourseDetailPage courseDetailPage;
	
	private static AttendanceInfoManagementPage attendanceInfoManagementPage;
	
	private static AttendanceInfoManagementDirectlyPage attendanceInfoManagementDirectlyPage;
	
	/** 前処理 */
	@BeforeAll
	static void before() {
		createDriver();
		loginPage = new LoginPage(webDriver);
		courseDetailPage = new CourseDetailPage(webDriver);
		attendanceInfoManagementPage = new AttendanceInfoManagementPage(webDriver);
		attendanceInfoManagementDirectlyPage = new AttendanceInfoManagementDirectlyPage(webDriver);
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
	@DisplayName("テスト05 不適切な内容で修正してエラー表示：出退勤の（時）と（分）のいずれかが空白")
	void test05() {
		attendanceInfoManagementDirectlyPage.inputAttendanceInfo("09", "00", "18", "", "", "");
		
		assertThat(attendanceInfoManagementDirectlyPage.getErrorMsg().contains(Constants.ERROR_MESSAGE_ATTENDANCE_ILLEGAL_TIME));
		
		getEvidence(new Object(){});
	}

	@Test
	@Order(6)
	@DisplayName("テスト06 不適切な内容で修正してエラー表示：出勤が空白で退勤に入力あり")
	void test06() {
		attendanceInfoManagementDirectlyPage.inputAttendanceInfo("", "", "18", "00", "", "");
		
		assertThat(attendanceInfoManagementDirectlyPage.getErrorMsg().contains(Constants.ERROR_MESSAGE_ATTENDANCE_NONE_PUNCH_IN));
		
		getEvidence(new Object(){});
	}

	@Test
	@Order(7)
	@DisplayName("テスト07 不適切な内容で修正してエラー表示：出勤が退勤よりも遅い時間")
	void test07() {
		attendanceInfoManagementDirectlyPage.inputAttendanceInfo("18", "00", "09", "00", "", "");
		
		assertThat(attendanceInfoManagementDirectlyPage.getErrorMsg().contains(Constants.ERROR_MESSAGE_ATTENDANCE_CONTRADICTORY_TIME));
		
		getEvidence(new Object(){});
	}

	@Test
	@Order(8)
	@DisplayName("テスト08 不適切な内容で修正してエラー表示：出退勤時間を超える中抜け時間")
	void test08() {
		attendanceInfoManagementDirectlyPage.inputAttendanceInfo("13", "00", "18", "00", "5時間", "");
		
		assertThat(attendanceInfoManagementDirectlyPage.getErrorMsg().contains(Constants.ERROR_MESSAGE_ATTENDANCE_IMPOSSIBLE_BLANKTIME));
		
		getEvidence(new Object(){});
	}

	@Test
	@Order(9)
	@DisplayName("テスト09 不適切な内容で修正してエラー表示：備考が100文字超")
	void test09() {
		attendanceInfoManagementDirectlyPage.inputAttendanceInfo("09", "00", "18", "00", "", Constants.ATTENDANCE_NOTE_OVER_100);
		
		assertThat(attendanceInfoManagementDirectlyPage.getErrorMsg().contains(Constants.ERROR_MESSAGE_ATTENDANCE_NOTE_OVER));
		
		getEvidence(new Object(){});
	}

}
