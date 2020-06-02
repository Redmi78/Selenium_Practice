package com.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.objectrepo.Rediff_SignInPage;

public class SignInPage {
	WebDriver driver;
	
	@BeforeTest
	public void browserInvoke()
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
	}

	@Test
	public void signInPage()
	{
		Rediff_SignInPage sign = new Rediff_SignInPage(driver);
		sign.signIn("Subba", "Reddy");
	}
}
