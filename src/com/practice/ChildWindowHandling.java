package com.practice;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class ChildWindowHandling {
	static {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
	}
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://accounts.google.com/signup/v2/webcreateaccount?hl=en&flowName=GlifWebSignIn&flowEntry=SignUp");
		System.out.println("Title of Parent window: "+driver.getTitle());
		driver.findElement(By.xpath("//ul[@class='Bgzgmd'] //a[text()='Help']")).click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> ids = windows.iterator();
		String parentWindow=ids.next();
		String childWindow=ids.next();
		driver.switchTo().window(childWindow);
		System.out.println("Title of Child window: "+driver.getTitle());
	}

}
