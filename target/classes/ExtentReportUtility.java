package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtility {
	static ExtentReports extent;
	public static  ExtentReports getReportConfig() {
	
	String path=System.getProperty("user.dir")+"\\Reports\\index.html";
	ExtentSparkReporter reporter = new ExtentSparkReporter(path);
	reporter.config().setReportName("web results");
	reporter.config().setDocumentTitle("sai");
	 extent= new ExtentReports();
	extent.attachReporter(reporter);
	extent.setSystemInfo("tester", "sai praneeth chowdary davuluri");
	return extent;
}
}