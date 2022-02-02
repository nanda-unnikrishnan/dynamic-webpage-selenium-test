package com.wazoku.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wazoku.qa.base.PageBase;

public class LoginPage extends PageBase {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoginPage.class);

	@FindBy(id = "emailField")
	private WebElement email;

	@FindBy(id = "passwordField")
	private WebElement password;

	@FindBy(xpath = "//button[contains(text(), 'Login')]")
	private WebElement loginButton;

	@FindBy(xpath = "//div[@ng-messages='vm.loginForm.$error']/span[@ng-message]")
	private WebElement errorMessageBlock;

	@FindBy(xpath = "//div[@class='modal']")
	private WebElement modalBlock;

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public HomePage login(String emailInput, String passwordInput) {

		WebDriverWait wait = new WebDriverWait(getDriver(), EXPLICIT_WAIT_TIMEOUT_SECONDS);
		wait.until(ExpectedConditions.visibilityOf(email));

		email.clear();
		email.sendKeys(emailInput);
		password.clear();
		password.sendKeys(passwordInput);
		loginButton.click();

		if (!hasModalDisappeared()) {
			LOGGER.warn("Login unsuccessful.");
			return null;
		}

		return new HomePage(getDriver());

	}

	private boolean hasModalDisappeared() {
		// Reduce timeout so as to fail fast when element is not found
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
		try {
			WebDriverWait wait = new WebDriverWait(getDriver(), 1);
			wait.until(ExpectedConditions.invisibilityOf(modalBlock));
			return !modalBlock.isDisplayed();
		} catch (NoSuchElementException | TimeoutException e) {
			// Ignore this error as the modal window is not seen on successfull login
		}
		// Reset timeout
		getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return true;

	}

	public String getErrorMessageText() {
		return errorMessageBlock.getText();
	}

}
