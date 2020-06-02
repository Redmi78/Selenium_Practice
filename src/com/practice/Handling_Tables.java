package com.practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class Handling_Tables {
	static {
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
	}

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.cricbuzz.com/live-cricket-scorecard/22663/rsa-vs-aus-3rd-odi-australia-tour-of-south-africa-2020");
		driver.manage().window().maximize();
		WebElement scoreCard = driver.findElement(By.xpath("(//div[@class='cb-col cb-col-100 cb-ltst-wgt-hdr'])[1]"));
		List<WebElement> row = scoreCard.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms']"));
		int runs = scoreCard.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)")).size();
		for(int i=0;i<runs-2;i++)
		{
			String text = scoreCard.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)")).get(i).getText();
			System.out.println(text);
		}
		int extras = scoreCard.findElements(By.xpath("//div[@class='cb-col cb-col-60']/following-sibling::div[1]")).size();
		for(int j=0;j<extras;j++)
		{
			String extraRuns = scoreCard.findElements(By.xpath("//div[@class='cb-col cb-col-60']/following-sibling::div[1]")).get(j).getText();
			System.out.println(extraRuns);
		}
	}

}
