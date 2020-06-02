package com.practice;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.server.handler.ImplicitlyWait;

public class GreenCart {

	public static String productText;
	public static WebDriver driver;
	public static int i = 0;
	public static int j = 0;
	public static int numberOfProducts;

	static {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	public static void product(List<String> listOfProducts) {
		List<WebElement> productNames = driver.findElements(By.xpath("//h4[@class='product-name']"));
		numberOfProducts = productNames.size();
		System.out.println("Number of products in Page: " + numberOfProducts);
		for (; i < productNames.size(); i++) {
			String[] pro = productNames.get(i).getText().split("-");
			productText = pro[0].trim();
			System.out.println(productText);

			if (listOfProducts.contains(productText)) {
				driver.findElements(By.xpath("//div[@class='product-action']//button")).get(i).click();
				j++;
				if (j == listOfProducts.size())
					break;
			}
		}
	}
	
	public static void cart()
	{
		driver.findElement(By.xpath("//img[@alt='Cart']")).click();
		driver.findElement(By.xpath("//div[@class='action-block']/button[text()='PROCEED TO CHECKOUT']")).click();
		driver.findElement(By.xpath("//input[@class='promoCode']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//button[@class='promoBtn']")).click();
		String promoMsg = driver.findElement(By.xpath("//span[@class='promoInfo']")).getText();
		System.out.println(promoMsg);
	}

	public static void main(String[] args) {
		String[] names = { "Brocolli", "Cucumber", "Tomato", "Beans" };
		List<String> listOfProducts = Arrays.asList(names);
		GreenCart.product(listOfProducts);
		System.out.println(listOfProducts);
		GreenCart.cart();

	}

}
