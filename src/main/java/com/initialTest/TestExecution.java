package com.initialTest;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestExecution {

	@BeforeMethod
	public void setUp() {

	}

	@Test
	public void test() {

		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage()
				.window()
				.maximize();
		driver.manage()
				.deleteAllCookies();

		driver.manage()
				.timeouts()
				.pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage()
				.timeouts()
				.implicitlyWait(30, TimeUnit.SECONDS);

		// Launching the url

		driver.get("https://automationtest.wazoku.com/ccc/test");

		// Clicking on the Login/Register button

		driver.findElement(By.xpath("//a[@title='Login or Register']"))
				.click();

		// Waiting for the login page to load

		WebDriverWait wait = new WebDriverWait(driver, 1000);

		WebElement email = driver.findElement(By.id("emailField"));
		WebElement password = driver.findElement(By.id("passwordField"));
		WebElement loginButton = driver.findElement(By.xpath("//button[contains(text(), 'Login')]"));

		wait.until(ExpectedConditions.visibilityOf(email));

		// Enter login details and click on loginButton

		email.sendKeys("automation@email.com");
		password.sendKeys("automationUser");
		loginButton.click();

		// Assertion to check the current url and validating it against the home-page
		// url

		assertEquals(driver.getCurrentUrl(),
				"https://automationtest.wazoku.com/community/e9678ec44f024b5c901d228a33c67139/home-page");

		// Click on the discover button
		driver.findElement(By.xpath("//div[@class='site-nav__btn-group']//a[contains(text(), 'Discover')]"))
				.click();

		// Discover page

		List<WebElement> challengeList = driver.findElements(By.xpath("//div[@class='l-card__content']"));
		List<WebElement> challengeHeaders = driver
				.findElements(By.xpath("//div[@class='l-card__content']//div[@class='wk-card-header']//a"));

		String expectedChallengeName = challengeHeaders.get(0)
				.getAttribute("title");

		System.out.println(expectedChallengeName);

		challengeHeaders.get(0)
				.click();

		assertEquals(driver.findElement(By.xpath("//div[@class='title-container title-container-shadow']"))
				.getText(), expectedChallengeName);

	}

	@AfterMethod
	public void tearDown() {

	}

}
