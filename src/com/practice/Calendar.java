package com.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class Calendar {
	static {
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
	}

	public static void main(String[] args) throws Throwable {
		WebDriver driver = new ChromeDriver();
		driver.get("https://book.spicejet.com/");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[contains(@id,'VieworiginStation1_CTXT')]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@id='dropdownGroup1'] //a[@value='BLR']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[contains(@id,'ViewdestinationStation1_CTNR')]/div //a[@value='MAA']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@class='ui-state-default ui-state-highlight ui-state-active ui-state-hover']")).click();
	}

}
