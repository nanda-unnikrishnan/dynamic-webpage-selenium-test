package com.wazoku.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.wazoku.qa.base.PageBase;

public class ChallengePage extends PageBase {

	@FindBy(xpath = "//div[@class='title-container title-container-shadow']")
	private WebElement challengeTitle;

	public ChallengePage(WebDriver driver) {
		super(driver);
	}

	public String getChallengeTitle() {
		return challengeTitle.getText();
	}

}
