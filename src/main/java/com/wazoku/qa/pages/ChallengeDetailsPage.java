package com.wazoku.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.wazoku.qa.base.PageBase;

public class ChallengeDetailsPage extends PageBase {

	@FindBy(xpath = "//h1[@data-selenium='banner-title']")
	private WebElement challengeTitle;

	public ChallengeDetailsPage(WebDriver driver) {
		super(driver);
	}

	public String getChallengeTitle() {
		return challengeTitle.getText();
	}

}
