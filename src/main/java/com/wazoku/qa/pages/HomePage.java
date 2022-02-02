package com.wazoku.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.wazoku.qa.base.PageBase;

public class HomePage extends PageBase {

	@FindBy(xpath = "//a[@data-selenium='discover']")
	private WebElement discoverLink;

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public DiscoverPage navigateToDiscoverPage() {
		getNewWaitInstance(EXPLICIT_WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.elementToBeClickable(discoverLink));

		discoverLink.click();
		return new DiscoverPage(getDriver());
	}

}
