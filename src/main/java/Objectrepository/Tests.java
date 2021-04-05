package Objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Tests {

	WebDriver driver;
	public Tests(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By loginButton=By.xpath("//a[@href= 'https://rahulshettyacademy.com/sign_in/']");
	By textForCourse=By.xpath("//div[@class= 'text-center']/h2");
	
	public WebElement clickOnLogin()
	{
		return driver.findElement(loginButton);
	}
	public WebElement retrieveText()
	{
		return driver.findElement(textForCourse);
	}
}

