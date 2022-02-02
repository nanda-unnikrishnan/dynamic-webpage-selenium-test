package com.wazoku.qa.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class PageBase {

	protected static final int EXPLICIT_WAIT_TIMEOUT_SECONDS = 30;
	private WebDriver driver;

	public PageBase(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	protected WebDriver getDriver() {
		return this.driver;
	}

	protected WebDriverWait getNewWaitInstance(int maxTimeInSecondsToWait) {
		WebDriverWait wait2 = new WebDriverWait(getDriver(), maxTimeInSecondsToWait);
		return wait2;
	
	}

	protected void setImplicitWaitTime(int time, TimeUnit timeUnit) {
		getDriver().manage().timeouts().implicitlyWait(time, timeUnit);
	
	}

}
