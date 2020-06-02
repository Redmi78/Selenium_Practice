package com.practice;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class LinksCount {
	static {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
	}

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		String parent = driver.getWindowHandle();

		// To get all links in the webpage
		int linkCountInEntirePage = driver.findElements(By.tagName("a")).size();
		System.out.println(linkCountInEntirePage);

		// To get the links present in footer sction
		WebElement footer = driver.findElement(By.id("gf-BIG"));
		int linkCountInFooterSection = footer.findElements(By.tagName("a")).size();
		System.out.println(linkCountInFooterSection);

		//// To get the links present in first column
		WebElement firstSection = footer.findElement(By.xpath("//div[@id='gf-BIG'] //td[1]/ul"));
		int linkCountInFirstSection = firstSection.findElements(By.tagName("a")).size();
		System.out.println(linkCountInFirstSection);

		// Click on each link
		for (int i = 1; i < linkCountInFirstSection; i++) {
			firstSection.findElements(By.tagName("a")).get(i).sendKeys(Keys.CONTROL, Keys.ENTER);
		}

		// To get Title of each page
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		while (it.hasNext()) {
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}
	}

}
