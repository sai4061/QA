package academy;

import org.testng.annotations.Test; 
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Objectrepository.Loginpage;
import Objectrepository.Tests;
import resources.Base;


public class LoginpageTest extends Base {
	public WebDriver driver;
	public static Logger log= LogManager.getLogger(Base.class.getName());
	@BeforeTest()
	public void initialization() throws IOException
	{
		driver=initializeDriver();
	}
	
	@Test(dataProvider="getData")
	public void enterUnamePassword( String userName,String password) throws IOException
	{
	
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		Tests t1=new Tests(driver);
		Loginpage lp = new Loginpage(driver);
		t1.clickOnLogin().click();
		log.info("user trying to login");
		lp.emailField().sendKeys(userName);
		lp.passwordField().sendKeys(password);
		lp.clickloginButton().click();;
		
	}
  @AfterTest()
	public void closeTheBrowser()
	{
		driver.close();
	}
	
	@DataProvider
	public Object[][] getData()
	{
		
		Object[] [] data =new Object[2][2];
		data[0][0]="sai";
		data[0][1]="praneeth";
		
		data[1][0]="sai";
		data[1][1]="praneeth";
		return data;
				
				
	}
	
}
