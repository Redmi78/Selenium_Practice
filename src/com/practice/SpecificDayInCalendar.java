package com.practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class SpecificDayInCalendar {
	public static String month = "";
	public static WebDriver driver;
	
	static {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
	}

	public static String monthIteration() {
		month = driver.findElement(By.xpath("//table[@class=' table-condensed'] //th[@class='datepicker-switch']"))
				.getText();
		return month;
	}

	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.path2usa.com/travel-companions");
		driver.findElement(By.cssSelector("#travel_date")).click();

		while (!monthIteration().contains("July")) {
			driver.findElement(By.xpath("//table[@class=' table-condensed'] //th[@class='next']")).click();
			monthIteration();
		}
		List<WebElement> days = driver.findElements(By.xpath("//td[@class='day' or @class='new']"));
		for (int i = 0; i < days.size(); i++) {
			String text = days.get(i).getText();
			if ("24".equals(text)) {
				days.get(i).click();
				break;
			}
		}
	}

}
