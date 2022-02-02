package com.wazoku.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.wazoku.qa.base.PageBase;

public class LoginPage extends PageBase {

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

		email.clear();
		email.sendKeys(emailInput);
		password.clear();
		password.sendKeys(passwordInput);
		loginButton.click();

		return new HomePage(getDriver());

	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	public String getErrorMessageText() {
		return errorMessageBlock.getText();
	}

}
