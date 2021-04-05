package Objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Loginpage {

	

	WebDriver driver;
	public Loginpage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By email=By.xpath("//input[@type='email']");
	By password=By.xpath("//input[@type='password']");
	By loginbutton=By.xpath("//input[@type='submit']");
	
	
	public WebElement emailField()
	{
		
		return driver.findElement(email);
}

	public WebElement passwordField()
	{
		return driver.findElement(password);
	}

	public WebElement clickloginButton()
	{
		return driver.findElement(loginbutton);
	}
}
