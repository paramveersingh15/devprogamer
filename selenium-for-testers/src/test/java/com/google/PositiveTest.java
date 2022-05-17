package com.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveTest {

	@Test
	public void googletest() {
		System.out.println("Opened the Amazon Page"); // invoke the Facebook page

		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		String url = "https://the-internet.herokuapp.com/login";
		driver.get(url);
		driver.manage().window().maximize();
		System.out.println("Opened Successfully");

		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("tomsmith");

		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("SuperSecretPassword!");

		WebElement loginButton = driver.findElement(By.tagName("button"));
		loginButton.click();

		String expectedUrl = "https://the-internet.herokuapp.com/secure";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl, "the page is same as expedted");

		WebElement link;
		link = driver.findElement(By.linkText("Elemental Selenium"));
		link.click();

		WebElement logOutButton = driver.findElement(By.xpath("//div[@id='content']//a[@href='/logout']"));
		logOutButton.click();

		// WebElement successMessage = driver.findElement(By.className("flash
		// success"));
		WebElement successMessage = driver.findElement(By.xpath("/html//div[@id='flash']"));
		String exptectedMessage = "You logged into a secure area!";
		String ActualMessage = successMessage.getText();

		driver.quit();

	}

}
