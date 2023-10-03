package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportClass {
	
	public static ExtentReports createReport() 
	{
		
		String reportPath = System.getProperty("user.dir")+ "//Reports//report.html";
		
		ExtentSparkReporter sparkReport = new ExtentSparkReporter(reportPath);
		sparkReport.config().setReportName(" Saidachary ");
		sparkReport.config().setDocumentTitle("Automation Report");
		
		ExtentReports testResult = new ExtentReports();
		testResult.attachReporter(sparkReport);
		testResult.setSystemInfo("Tester", "Saidachary");
		return testResult;
		
	}

}
