package com.wazoku.qa.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.wazoku.qa.base.AppConfig;
import com.wazoku.qa.base.TestBase;
import com.wazoku.qa.utils.TestUtils;

public class LoginPageTest extends TestBase {

	LandingPage landingPage;
	LoginPage loginPage;
	HomePage homePage;

	@Override
	@BeforeMethod
	public void setUp() {
		super.setUp();
		landingPage = new LandingPage(getDriver());
		loginPage = landingPage.proceedToLoginPage();

		WebDriverWait wait = new WebDriverWait(getDriver(), 20);
		wait.until(ExpectedConditions.visibilityOf(loginPage.getEmail()));
	}

	@DataProvider
	private Object[][] getFailedLoginData() {
		return TestUtils.getTestData("InvalidLoginData");
	}

	@Test(dataProvider = "getFailedLoginData", priority = 1)
	public void failedLoginTest(String invalidEemail, String invalidPassword, String errorMessage) {

		homePage = loginPage.login(invalidEemail, invalidPassword);
		assertEquals(loginPage.getErrorMessageText(), errorMessage);
	}

	@Test
	public void succesfulLoginTest() {

		homePage = loginPage.login(AppConfig.getConfigValue(VALID_EMAIL_CONFIG_NAME),
				AppConfig.getConfigValue(VALID_PASSWORD_CONFIG_NAME));

		assertEquals(getDriver().getCurrentUrl(), AppConfig.getConfigValue(HOME_PAGE_URL));
	}

	@Override
	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	}
}
