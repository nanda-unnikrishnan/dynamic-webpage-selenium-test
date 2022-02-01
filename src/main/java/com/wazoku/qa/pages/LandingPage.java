package com.wazoku.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.wazoku.qa.base.PageBase;

public class LandingPage extends PageBase {

	// Object Repository

	@FindBy(xpath = "//a[@title='Login or Register']")
	private WebElement loginRegisterLink;

	public LandingPage(WebDriver driver) {
		super(driver);
	}

	public LoginPage proceedToLoginPage() {
		loginRegisterLink.click();
		return new LoginPage(getDriver());
	}

}
