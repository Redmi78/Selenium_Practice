package com.testng;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class Assertion {
	private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "G:\\Selenium\\TestNG\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void succeeded() {
        driver.get("http://the-internet.herokuapp.com/login");
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector("button")).click();
        boolean message = driver.findElement(By.cssSelector(".flash.success")).isDisplayed();
        System.out.println(message);
        String actual = driver.findElement(By.xpath("//div[@id='flash-messages']/div")).getText();
        String expected = "You logged into a secure area!";
        Assert.assertEquals(actual, expected);
    }

	@AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
