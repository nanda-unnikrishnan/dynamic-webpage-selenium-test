package com.wazoku.qa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.wazoku.qa.base.PageBase;

public class DiscoverPage extends PageBase {

	@FindBy(xpath = "//div[@class='l-card__content']//div[@class='wk-card-header']//a")
	private List<WebElement> challengeList;

	public DiscoverPage(WebDriver driver) {
		super(driver);
	}

	public String getChallengeName(int index) {
		return challengeList.get(index)
				.getAttribute("title");
	}

	public ChallengePage navigateToChallenge(int index) {
		challengeList.get(index)
				.click();
		return new ChallengePage(getDriver());
	}

}
