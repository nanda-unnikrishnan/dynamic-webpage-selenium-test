package com.wazoku.qa.pages;

import static org.testng.Assert.assertEquals;

import org.testng.ITestResult;
import org.testng.annotations.*;

import com.wazoku.qa.base.AppConfig;
import com.wazoku.qa.base.TestBase;
import com.wazoku.qa.utils.TestUtils;

public class ChallengesTest extends TestBase {

	LandingPage landingPage;

	DiscoverPage discoverPage;

	ChallengeDetailsPage challengeDetailsPage;

	@Override
	@BeforeMethod
	public void setUp() {
		super.setUp();

		landingPage = new LandingPage(getDriver());

		discoverPage = landingPage.proceedToLoginPage().login(AppConfig.getConfigValue(LOGIN_EMAIL_CONFIG_NAME),
				AppConfig.getConfigValue(LOGIN_PASSWORD_CONFIG_NAME)).navigateToDiscoverPage();
	}

	@Test
	public void testDiscoverPageUrl() {
		String currentUrlWithoutQueryParameters = getUrlWithoutQueryParameters();

		assertEquals(currentUrlWithoutQueryParameters, AppConfig.getConfigValue(DISCOVER_PAGE_URL));
	}

	@Test
	public void selectFirstChallengeTest() {
		// Getting the name of the first challenge to validate in details page
		String challengeName = discoverPage.getChallengeName(0);

		// Navigating to the first challenge details page
		challengeDetailsPage = discoverPage.navigateToChallenge(0);

		assertEquals(challengeDetailsPage.getChallengeTitle(), challengeName);
	}

	@Override
	@AfterMethod
	public void tearDown(ITestResult result) {
		TestUtils.takeScreenshot(getDriver(), getScreenshotName(result));
		super.tearDown(result);
	}

}
