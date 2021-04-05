package academy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.IOException;

import org.testng.annotations.Test;

import Objectrepository.Tests;
import resources.Base;


public class HomepageTest extends Base {
	public static Logger log= LogManager.getLogger(Base.class.getName());
public WebDriver driver;
	
	@BeforeTest()
	public void initialization() throws IOException
	{
		log.info("initializing the driver");
		driver=initializeDriver();
	}

	@Test
	public void clicklogin() throws IOException
	{
		log.info("navigating to url");
		driver.get("http://qaclickacademy.com/");
		Tests t1= new Tests(driver);
		t1.clickOnLogin().click();
		
	}
	
	 @AfterTest()
		public void closeTheBrowser()
		{
		 log.info("closing the browser");
			driver.close();
		}
}
