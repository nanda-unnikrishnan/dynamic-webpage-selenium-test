package com.wazoku.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.wazoku.qa.base.PageBase;

public class HomePage extends PageBase {

	private String homePageURL = "https://automationtest.wazoku.com/community/e9678ec44f024b5c901d228a33c67139/home-page";

	@FindBy(xpath = "//div[@class='site-nav__btn-group']//a[contains(text(), 'Discover')]")
	WebElement discoverLink;

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public String getHomePageURL() {
		return homePageURL;
	}

	public DiscoverPage navigateToDiscoverPage() {
		discoverLink.click();
		return new DiscoverPage(getDriver());
	}

}
