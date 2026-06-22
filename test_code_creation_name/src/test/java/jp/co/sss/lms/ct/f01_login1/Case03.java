package jp.co.sss.lms.ct.f01_login1;

import static jp.co.sss.lms.ct.util.WebDriverUtils.*;
import static org.junit.Assert.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import jp.co.sss.lms.util.Constants;

/**
 * 結合テスト ログイン機能①
 * ケース03
 * @author holy
 */
@TestMethodOrder(OrderAnnotation.class)
@DisplayName("ケース03 受講生 ログイン 正常系")
public class Case03 {

	private static LoginPage loginPage;
	
	private static CourseDetailPage courseDetailPage;
	
	/** 前処理 */
	@BeforeAll
	static void before() {
		createDriver();
		loginPage = new LoginPage(webDriver);
		courseDetailPage = new CourseDetailPage(webDriver);
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
		courseDetailPage.waitFor();
		
		assertEquals(Constants.TRUE_TITLE_COURCE_DETAIL, webDriver.getTitle());
		assertEquals(Constants.TRUE_LI_ACTIVE, courseDetailPage.getLiActive());
		
		getEvidence(new Object(){});
	}

}
