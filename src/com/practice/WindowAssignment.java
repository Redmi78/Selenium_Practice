package com.practice;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class WindowAssignment {
	static {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
	}

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://the-internet.herokuapp.com/");
		driver.findElement(By.xpath("//div[@id='content']/ul //a[text()='Multiple Windows']")).click();
		driver.findElement(By.xpath("//div[@id='content'] //a[text()='Click Here']")).click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> ids = windows.iterator();
		String parentWindow = ids.next();
		String childWindow = ids.next();
		driver.switchTo().window(childWindow);
		System.out.println("Title of the Child window: " + driver.getTitle());
		String textInChildWindow = driver.findElement(By.xpath("//h3[text()='New Window']")).getText();
		System.out.println("Text in Child Window: "+ textInChildWindow);
		driver.switchTo().window(parentWindow);
		System.out.println("Title of the Parent window: " + driver.getTitle());
		String textInParentWindow = driver.findElement(By.xpath("//h3[text()='Opening a new window']")).getText();
		System.out.println("Text in Parent window: "+textInParentWindow);
	}

}
