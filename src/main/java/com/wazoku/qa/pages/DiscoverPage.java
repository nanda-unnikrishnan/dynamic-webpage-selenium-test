package com.wazoku.qa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.wazoku.qa.base.PageBase;

public class DiscoverPage extends PageBase {

	@FindBy(xpath = "//a[@data-selenium='card-header-title']")
	private List<WebElement> challengeList;

	public DiscoverPage(WebDriver driver) {
		super(driver);
	}

	public String getChallengeName(int index) {
		return challengeList.get(index)
				.getAttribute("title");
	}

	public ChallengeDetailsPage navigateToChallenge(int index) {
		challengeList.get(index)
				.click();
		return new ChallengeDetailsPage(getDriver());
	}

}
