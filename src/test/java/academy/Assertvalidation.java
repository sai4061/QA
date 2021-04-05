package academy;

import org.testng.annotations.AfterTest; 
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Objectrepository.Loginpage;
import Objectrepository.Tests;
import resources.Base;


public class Assertvalidation  extends Base {
	public static Logger log= LogManager.getLogger(Base.class.getName());
	public WebDriver driver;
	@BeforeTest()
	public void initialization() throws IOException
	{
		driver=initializeDriver();
	}

	@Test
	public void validateMessage( ) throws IOException
	{
	
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		Tests t1=new Tests(driver);
		Loginpage lp = new Loginpage(driver);
		AssertJUnit.assertEquals(t1.retrieveText().getText(),"FEATURED COURSES123");
		log.info("msgs was validated");
		}
	 @AfterTest()
		public void closeTheBrowser()
		{
			driver.close();
		}
}
