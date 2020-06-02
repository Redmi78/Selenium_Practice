package com.objectrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Rediff_SignInPage {
	WebDriver driver;
	
	//Declearation
	@FindBy(xpath="//input[@id='login1']")
	WebElement userName;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement password;
	
	@FindBy(name="proceed")
	WebElement signinButton;
	
	//Initialization
	public Rediff_SignInPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public void signIn(String username,String pass)
	{
		userName.sendKeys(username);
		password.sendKeys(pass);
		signinButton.click();
	}
	
}
