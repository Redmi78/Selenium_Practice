package com.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.Assert;

public class Enabling_Disabling {

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
		driver.findElement(By.xpath("//div[@class='dropdownDiv'] //a[@value='DEL']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[contains(@id,'ViewdestinationStation1_CTNR')]/div //a[@value='MAA']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@class='ui-state-default ui-state-highlight ui-state-active ui-state-hover']")).click();
		if(driver.findElement(By.xpath("//div[@id='marketDate_2']")).getAttribute("style").contains("0.5"))
		{
			System.out.println("Its disabled");
			Assert.assertTrue(true);
		}
		
		else
		{
			System.out.println("Its Enabled");
			Assert.assertFalse(false);
		}
		
		driver.findElement(By.xpath("//div[@id='divpaxinfo']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//select[@id='ControlGroupSearchView_AvailabilitySearchInputSearchView_DropDownListPassengerType_ADT']")).click();;
		driver.findElement(By.xpath("//span//input[contains(@name,'ButtonSubmit')]")).click();
	}

}
