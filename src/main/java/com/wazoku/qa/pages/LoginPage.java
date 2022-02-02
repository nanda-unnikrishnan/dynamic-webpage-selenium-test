package com.wazoku.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wazoku.qa.base.PageBase;

public class LoginPage extends PageBase {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoginPage.class);

	@FindBy(xpath = "//div[@uib-modal-window='modal-window']")
	private WebElement loginModal;

	@FindBy(id = "emailField")
	private WebElement email;

	@FindBy(id = "passwordField")
	private WebElement password;

	@FindBy(xpath = "//button[contains(text(), 'Login')]")
	private WebElement loginButton;

	@FindBy(xpath = "//div[@ng-messages='vm.loginForm.$error']/span[@ng-message]")
	private WebElement errorMessageBlock;

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public HomePage login(String emailInput, String passwordInput) {

		WebDriverWait wait = new WebDriverWait(getDriver(), EXPLICIT_WAIT_TIMEOUT_SECONDS);
		wait.until(ExpectedConditions.visibilityOf(loginModal));

		email.clear();
		email.sendKeys(emailInput);
		password.clear();
		password.sendKeys(passwordInput);
		loginButton.click();

		if (isErrorMessagePresent()) {
			LOGGER.warn("Login unsuccessful");
			return null;
		}

		LOGGER.info("Login button clicked.");

		try {
			getDriver().manage()
					.timeouts()
					.implicitlyWait(10, TimeUnit.MILLISECONDS);
			wait.until(ExpectedConditions.invisibilityOf(loginModal));

		} catch (NoSuchElementException | TimeoutException e) {
			getDriver().manage()
					.timeouts()
					.implicitlyWait(20, TimeUnit.SECONDS);
		}

		return new HomePage(getDriver());

	}

	public boolean isErrorMessagePresent() {
		getDriver().manage()
				.timeouts()
				.implicitlyWait(10, TimeUnit.MILLISECONDS);
		boolean isErrorMessagePresent;
		try {
			isErrorMessagePresent = errorMessageBlock.isDisplayed();
		} catch (NoSuchElementException e) {
			isErrorMessagePresent = false;
		}
		getDriver().manage()
				.timeouts()
				.implicitlyWait(20, TimeUnit.SECONDS);
		return isErrorMessagePresent;
	}

	public String getErrorMessageText() {
		return errorMessageBlock.getText();
	}

}
