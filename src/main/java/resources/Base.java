package resources;

import java.io.File ;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class Base {
	
	public WebDriver driver;
	public Properties prop;
	public WebDriver initializeDriver() throws IOException
	{
		 prop=new Properties();
	FileInputStream fis = new FileInputStream("C:\\Users\\ASUS 15 BQ 1221\\Desktop\\automation\\academy\\src\\main\\java\\Resources\\data.properties");
	prop.load(fis);
	String browserName=prop.getProperty("browser");
	
	if(browserName.equals("chrome"))
	{
		System.setProperty("webdriver.chrome.driver",(System.getProperty("user.dir")+"\\src\\main\\java\resources\\chromedriver.exe"));
		 driver=new ChromeDriver();
		
	}
	else if(browserName.contentEquals("firefox"))
	{
		System.setProperty("webdriver.gecko.driver","C:\\Program Files\\selenium\\geckodriver.exe");
		driver=new FirefoxDriver();
	}
	else if (browserName.equals("ie"))
	{
		System.setProperty("webdriver.ie.driver","C:\\Program Files\\selenium\\iedriver.exe");
		 driver=new InternetExplorerDriver();
		
	}
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	
	return driver;
	}
	
	
public String takeScreenshot(String failuremethodName, WebDriver driver) throws IOException
{
	
TakesScreenshot ts= (TakesScreenshot)driver;
File src=ts.getScreenshotAs(OutputType.FILE);
String destFile=System.getProperty("user.dir")+"\\reports\\"+failuremethodName+".png";
FileUtils.copyFile(src,new File(destFile));
return destFile;





}
}
