package com.wazoku.qa.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class PageBase {

	private WebDriver driver;

	public PageBase(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	protected WebDriver getDriver() {
		return this.driver;
	}

}
