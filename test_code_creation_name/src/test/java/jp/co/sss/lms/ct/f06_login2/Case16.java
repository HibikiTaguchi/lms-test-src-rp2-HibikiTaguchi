package jp.co.sss.lms.ct.f06_login2;

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

import jp.co.sss.lms.ct.f01_login1.LoginPage;
import jp.co.sss.lms.util.Constants;

/**
 * 結合テスト ログイン機能②
 * ケース16
 * @author holy
 */
@TestMethodOrder(OrderAnnotation.class)
@DisplayName("ケース16 受講生 初回ログイン 変更パスワード未入力")
public class Case16 {

	private static LoginPage loginPage;
	
	private static AgreeSecurityPage agreeSecurityPage;
	
	private static ChangePasswordPage changePasswordPage;
	
	/** 前処理 */
	@BeforeAll
	static void before() {
		createDriver();
		loginPage = new LoginPage(webDriver);
		agreeSecurityPage = new AgreeSecurityPage(webDriver);
		changePasswordPage = new ChangePasswordPage(webDriver);
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
	@DisplayName("テスト02 DBに初期登録された未ログインの受講生ユーザーでログイン")
	void test02() {
		loginPage.tryLogin(Constants.TRUE_LOGIN_ID, Constants.TRUE_PASSWORD_DEFAULT);
		
		assertEquals(Constants.TRUE_TITLE_AGREE_SECURITY, webDriver.getTitle());
		
		getEvidence(new Object(){});
	}

	@Test
	@Order(3)
	@DisplayName("テスト03 「同意します」チェックボックスにチェックを入れ「次へ」ボタン押下")
	void test03() {
		agreeSecurityPage.checkAgree();
		agreeSecurityPage.clickNextBtn();
		
		assertEquals(Constants.TRUE_TITLE_CHANGE_PASSWORD, webDriver.getTitle());
		
		getEvidence(new Object(){});
	}

	@Test
	@Order(4)
	@DisplayName("テスト04 パスワードを未入力で「変更」ボタン押下")
	void test04() {
		changePasswordPage.clickChangeBtn();
		changePasswordPage.ckickChangeBtnInMordalWindow();
		
		assertEquals(Constants.ERROR_MESSAGE_CURRENT_PASSWORD_REQUIRED, changePasswordPage.getError1Text());
		assertThat(changePasswordPage.getError2Text()).contains(Constants.ERROR_MESSAGE_NEW_PASSWORD_REQUIRED);
		assertEquals(Constants.ERROR_MESSAGE_COMFIRM_PASSWORD_REQUIRED, changePasswordPage.getError3Text());
		
		getEvidence(new Object(){});
	}

	@Test
	@Order(5)
	@DisplayName("テスト05 20文字以上の変更パスワードを入力し「変更」ボタン押下")
	void test05() {
		changePasswordPage.inputCurrentPasword(Constants.TRUE_PASSWORD_DEFAULT);
		changePasswordPage.inputNewPassword(Constants.ERROR_NEW_PASSWORD_OVER_20);
		changePasswordPage.inputComfirmPassword(Constants.ERROR_NEW_PASSWORD_OVER_20);
		changePasswordPage.clickChangeBtn();
		changePasswordPage.ckickChangeBtnInMordalWindow();
		
		assertEquals(Constants.ERROR_MESSAGE_NEW_PASSWORD_OVER_20, changePasswordPage.getError2Text());
		
		getEvidence(new Object(){});
	}

	@Test
	@Order(6)
	@DisplayName("テスト06 ポリシーに合わない変更パスワードを入力し「変更」ボタン押下")
	void test06() {
		changePasswordPage.inputCurrentPasword(Constants.TRUE_PASSWORD_DEFAULT);
		changePasswordPage.inputNewPassword(Constants.ERROR_NEW_PASSWORD_ILLEGAL);
		changePasswordPage.inputComfirmPassword(Constants.ERROR_NEW_PASSWORD_ILLEGAL);
		changePasswordPage.clickChangeBtn();
		changePasswordPage.ckickChangeBtnInMordalWindow();
		
		assertEquals(Constants.ERROR_MESSAGE_NEW_PASSWORD_ILLEGAL, changePasswordPage.getError2Text());
		
		getEvidence(new Object(){});
	}

	@Test
	@Order(7)
	@DisplayName("テスト07 一致しない確認パスワードを入力し「変更」ボタン押下")
	void test07() {
		changePasswordPage.inputCurrentPasword(Constants.TRUE_PASSWORD_DEFAULT);
		changePasswordPage.inputNewPassword(Constants.TRUE_PASSWORD);
		changePasswordPage.inputComfirmPassword(Constants.TRUE_PASSWORD_DEFAULT);
		changePasswordPage.clickChangeBtn();
		changePasswordPage.ckickChangeBtnInMordalWindow();
		
		assertEquals(Constants.ERROR_MESSAGE_PASSWORD_NOT_SAME, changePasswordPage.getError2Text());
		
		getEvidence(new Object(){});
	}

}
