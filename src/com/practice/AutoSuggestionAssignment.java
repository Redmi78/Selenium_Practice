package com.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class AutoSuggestionAssignment {
	static {
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");	
	}
	public static void main(String[] args) throws Throwable {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		WebElement autoSuggestionBox = driver.findElement(By.xpath("//input[@id='autocomplete']"));
		autoSuggestionBox.sendKeys("Ind");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String script = "return document.getElementById('autocomplete').value;";
		String textInBox=(String) js.executeScript(script);
		while (!textInBox.equals("India")) {
			autoSuggestionBox.sendKeys(Keys.DOWN);
			textInBox=(String) js.executeScript(script);
			System.out.println(textInBox);
		}
	}
}
