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
 * ケース01
 * @author holy
 */
@TestMethodOrder(OrderAnnotation.class)
@DisplayName("ケース01 ログイン画面への遷移")
public class Case01 {
	
	private static LoginPage page;
	
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
	void test01() throws InterruptedException {
		String trueTitle = "ログイン | LMS";
		String trueH2 = "ログイン";
		
		goTo("http://localhost:8080/lms");
		
		assertEquals(trueTitle, webDriver.getTitle());
		assertEquals(trueH2, page.getH2());
		
		getEvidence(new Object(){});
	}

}
