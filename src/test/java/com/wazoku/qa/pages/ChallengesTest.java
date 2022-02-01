package com.wazoku.qa.pages;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.wazoku.qa.base.AppConfig;
import com.wazoku.qa.base.TestBase;
import com.wazoku.qa.utils.TestUtils;

public class ChallengesTest extends TestBase {

	LandingPage landingPage;
	DiscoverPage discoverPage;
	ChallengePage challengePage;

	@Override
	@BeforeMethod
	public void setUp() {

		super.setUp();

		landingPage = new LandingPage(getDriver());

		discoverPage = landingPage.proceedToLoginPage()
				.login(AppConfig.getConfigValue(VALID_EMAIL_CONFIG_NAME),
						AppConfig.getConfigValue(VALID_PASSWORD_CONFIG_NAME))
				.navigateToDiscoverPage();
	}

	@Test
	public void selectFirstChallengeTest() {

		// Getting the name of the first challenge
		String challengeName = discoverPage.getChallengeName(0);

		// Navigating to the first challenge
		challengePage = discoverPage.navigateToChallenge(0);

		assertEquals(challengePage.getChallengeTitle(), challengeName);
	}

	@Override
	@AfterMethod
	public void tearDown() {
		TestUtils.takeScreenshot(getDriver(), "WazokuFirstChallengeScreenshot.png");
		getDriver().quit();
	}
}
