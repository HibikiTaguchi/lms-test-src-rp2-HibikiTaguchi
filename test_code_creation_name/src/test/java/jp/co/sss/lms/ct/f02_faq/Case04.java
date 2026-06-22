package jp.co.sss.lms.ct.f02_faq;

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
 * 結合テスト よくある質問機能
 * ケース04
 * @author holy
 */
@TestMethodOrder(OrderAnnotation.class)
@DisplayName("ケース04 よくある質問画面への遷移")
public class Case04 {
	
	private static LoginPage loginPage;
	
	private static CourseDetailPage courseDetailPage;
	
	private static HelpPage helpPage;
	
	private static FaqPage faqPage;
	
	/** 前処理 */
	@BeforeAll
	static void before() {
		createDriver();
		loginPage = new LoginPage(webDriver);
		courseDetailPage = new CourseDetailPage(webDriver);
		helpPage = new HelpPage(webDriver);
		faqPage = new FaqPage(webDriver);
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
		assertEquals(Constants.TRUE_LI_ACTIVE, courseDetailPage.getLiActive());
		
		getEvidence(new Object(){});
	}

	@Test
	@Order(3)
	@DisplayName("テスト03 上部メニューの「ヘルプ」リンクからヘルプ画面に遷移")
	void test03() {
		courseDetailPage.clickHelpLink();
		 
		assertEquals(Constants.TRUE_TITLE_HELP, webDriver.getTitle());
		assertEquals(Constants.TRUE_LINK_TEXT_FAQ, helpPage.getLinkToFaq());
		
		getEvidence(new Object(){});
	}

	@Test
	@Order(4)
	@DisplayName("テスト04 「よくある質問」リンクからよくある質問画面を別タブに開く")
	void test04() {
		helpPage.clickFaqLink();
		
		changeTab(1);
		
		assertEquals(Constants.TRUE_TITLE_FAQ, webDriver.getTitle());
		assertEquals(Constants.TRUE_H2_FAQ, faqPage.getH2Faq());
		
		getEvidence(new Object(){});
	}

}
