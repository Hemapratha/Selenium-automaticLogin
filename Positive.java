package com.herokuapp.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Positive {
	@Test
	public void LoginTest() throws InterruptedException {
		// create webdriver
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		WebDriver d = new ChromeDriver();
		System.out.println("Webdrover is created");
		// open
		String url = "https://the-internet.herokuapp.com/login";
		d.get(url);
		Thread.sleep(3000);
		// maximize
		System.out.println("Maximizethe page");
		d.manage().window().maximize();
		Thread.sleep(2000);
		
		WebElement username = d.findElement(By.xpath("//input[@id='username']"));
		username.sendKeys("tomsmith");
		WebElement password = d.findElement(By.name("password"));
		password.sendKeys("SuperSecretPassword!");
		Thread.sleep(1000);
		WebElement login = d.findElement(By.tagName("button"));
		login.click();
		Thread.sleep(1000);
		String  expectedurl="https://the-internet.herokuapp.com/secure";
		String actualurl=d.getCurrentUrl();
		Assert.assertEquals(actualurl, expectedurl,"This page is not available");
		/*
		 * WebElement sucees=d.findElement(By.xpath("/html//div[@id='flash']")); String
		 * expectedMessage=" You logged into a secure area!"; String
		 * actualMessage=sucees.getText();
		 * Assert.assertTrue(actualMessage.contains(expectedMessage),
		 * "Ths is not as expected");
		 */
		WebElement logout = d.findElement(By.xpath("//div[@id='content']//a[@href='/logout']"));
		logout.click();
		d.quit();

	}
}
