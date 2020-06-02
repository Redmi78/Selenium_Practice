package com.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.Select;

public class DynamicValue_Assignment {
	static {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
	}

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.cssSelector("input#checkBoxOption2")).click();
		String labelOfCheckBox = driver.findElement(By.xpath("//label[@for='benz']")).getText().trim();
		System.out.println(labelOfCheckBox);
		WebElement dropDown = driver.findElement(By.xpath("//select[@id='dropdown-class-example']"));
		Select s = new Select(dropDown);
		s.selectByVisibleText(labelOfCheckBox);
		driver.findElement(By.cssSelector("#name")).sendKeys(labelOfCheckBox);
		driver.findElement(By.cssSelector("#alertbtn")).click();
		String textInAlert = driver.switchTo().alert().getText();
		if(textInAlert.contains(labelOfCheckBox))
		{
			System.out.println("Pass");
			driver.switchTo().alert().accept();
		}	
		else
			System.out.println("Fail");
	}

}
