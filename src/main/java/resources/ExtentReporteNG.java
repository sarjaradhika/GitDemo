package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporteNG {
	
	 static ExtentReports extent;

	
	public static ExtentReports getReportObject() {

	String path=System.getProperty("user.dir")+"\\reports\\index.html";
	ExtentSparkReporter reporter= new ExtentSparkReporter(path);
	reporter.config().setReportName("Web Automation");
	reporter.config().setDocumentTitle("Results");
	
	extent=new ExtentReports();
	extent.attachReporter(reporter);
	extent.setSystemInfo("tester", "Radhika");
	return extent;
}
}