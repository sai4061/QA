package academy;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.Base;
import resources.ExtentReportUtility;

public class Listeners extends Base  implements ITestListener{
	ExtentTest test;
	 ExtentReports extent=	ExtentReportUtility.getReportConfig();
ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	public void onTestFailure(ITestResult result) {
		test.fail(result.getThrowable());
		
		// TODO Auto-generated method stub
		WebDriver driver=null;
		String methodName=result.getMethod().getMethodName();
		try {
			driver=(WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch(Exception e)
		{
			
		}
		
			// TODO Auto-generated catch block	
	
		try {
			extentTest.get().addScreenCaptureFromPath(takeScreenshot(methodName,driver));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
	
}

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
	 
	test=extent.createTest(result.getMethod().getMethodName());
	extentTest.set(test);
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		extentTest.get().log(Status.PASS, "Test case Passed");

	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
	}
}

