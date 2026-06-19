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

/**
 * 結合テスト ログイン機能①
 * ケース02
 * @author holy
 */
@TestMethodOrder(OrderAnnotation.class)
@DisplayName("ケース02 受講生 ログイン 認証失敗")
public class Case02 {

	private static LoginPage page;
	
	private static final String TRUE_TITLE = "ログイン | LMS";
	
	private static final String TRUE_H2 = "ログイン";
	
	private static final String TRUE_ERROR = "* ログインに失敗しました。";
	
	private static final String WRONG_ID = "student";
	
	private static final String WRONG_PASS = "1111";
	
	/** 前処理 */
	@BeforeAll
	static void before() {
		createDriver();
		page = new LoginPage(webDriver);
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
		
		assertEquals(TRUE_TITLE, webDriver.getTitle());
		assertEquals(TRUE_H2, page.getH2());
		
		getEvidence(new Object(){});
	}

	@Test
	@Order(2)
	@DisplayName("テスト02 DBに登録されていないユーザーでログイン")
	void test02() {
		
		page.tryLogin(WRONG_ID, WRONG_PASS);
	
		page.waitH2();
		assertEquals(TRUE_TITLE, webDriver.getTitle());
		assertEquals(TRUE_ERROR, page.getError());
		
		getEvidence(new Object(){});
	}

}
