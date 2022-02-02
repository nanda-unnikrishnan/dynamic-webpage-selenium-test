package com.wazoku.qa.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class PageBase {

	protected static final int EXPLICIT_WAIT_TIMEOUT_SECONDS = 20;
	private WebDriver driver;

	public PageBase(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	protected WebDriver getDriver() {
		return this.driver;
	}

}
