package com.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.Select;

public class Cleartrip {

	static {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
	}
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.cleartrip.com/");
		driver.manage().window().maximize();
		// Select adults
		WebElement adults = driver.findElement(By.xpath("//select[@name='adults']"));
		Select s = new Select(adults);
		s.selectByValue("4");
		// Select Children
		WebElement children = driver.findElement(By.xpath("//select[@name='childs']"));
		Select s1 = new Select(children);
		s1.selectByValue("2");
		// select Depart date
		driver.findElement(By.xpath("//input[@id='DepartDate']")).click();
		driver.findElement(By.xpath("//a[contains(@class,'highlight ui-state-active ')]")).click();	
		//Click on More options
		driver.findElement(By.id("MoreOptionsLink")).click();
		driver.findElement(By.id("AirlineAutocomplete")).sendKeys("Indigo");
		//Click on Search Flights
		driver.findElement(By.id("SearchBtn")).click();
		//validate error message
		String errorMsg = driver.findElement(By.id("homeErrorMessage")).getText();
		System.out.println(errorMsg);
	}

}
