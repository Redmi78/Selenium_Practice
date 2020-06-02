package com.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.Assert;

public class TableAcendingValue {
	public static String name="";
	static {
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
	}

	public static void main(String[] args) throws Throwable {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		List<WebElement> vegNameColumn = driver.findElements(By.xpath("//tbody/tr/td[2]"));
		WebElement header = driver.findElement(By.xpath("//b[text()='Veg/fruit name']"));
		String ascending = driver.findElement(By.xpath("//b[text()='Veg/fruit name']/following-sibling::span")).getAttribute("class");
		while(!ascending.equalsIgnoreCase("sort-direction asc"))
		{
			header.click();
			ascending=driver.findElement(By.xpath("//b[text()='Veg/fruit name']/following-sibling::span")).getAttribute("class");
			
		}
		ArrayList<String> originalList = new ArrayList<String>();
		for (int i = 0; i < vegNameColumn.size(); i++) {
			name = vegNameColumn.get(i).getText();
			originalList.add(name);
			System.out.println(name);
		}
		System.out.println(originalList);
		ArrayList<String> copiedList = new ArrayList<>();
		copiedList.addAll(originalList);
		Collections.sort(copiedList);
		System.out.println(copiedList);
		Assert.assertTrue(copiedList.equals(originalList));
	}

}
