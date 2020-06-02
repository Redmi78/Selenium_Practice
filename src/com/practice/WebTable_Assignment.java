package com.practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class WebTable_Assignment {
	static {
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
	}

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.qaclickacademy.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[contains(text(),'Practice')]")).click();
		WebElement table = driver.findElement(By.xpath("//table[@id='product']"));
		//Number of Rows
		List<WebElement> rows = table.findElements(By.xpath("//table[@id='product']/tbody/tr"));
		int rowCount = rows.size();
		System.out.println("Number of Rows present in Table: " + rowCount);
		
		//Number of Columns
		List<WebElement> columns = table.findElements(By.xpath("//table[@id='product']/tbody/tr/th"));
		int columnsCount = columns.size();
		System.out.println("Number of columns present in table: " + columnsCount);
		
		//Print values present in second row
		 List<WebElement> secondRow = table.findElements(By.xpath("//table[@id='product']/tbody/tr[3]/td"));
		 int valuesCount = secondRow.size();
		 
		 for(int i=0;i<valuesCount;i++)
		 {
			 String values = secondRow.get(i).getText();
			 System.out.println(values);
		 }
	}

}
