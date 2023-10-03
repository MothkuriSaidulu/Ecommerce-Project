package Utilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;


public class ITestListners extends BaseClass implements ITestListener{
	

	ExtentReports extent = ExtentReportClass.createReport();
	ExtentTest test;
	ThreadLocal<ExtentTest> extentThread = new ThreadLocal<ExtentTest>();
	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
		
		extentThread.set(test);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		extentThread.get().log(Status.PASS, " Test is Pass");
		
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		extentThread.get().fail(result.getThrowable());
		
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e) {
			e.printStackTrace();
		} 
				
		 String filePath = null;
		try {
			filePath = takeScreenShotOfFailed(result.getMethod().getMethodName(), driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		extentThread.get().addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		extentThread.get().skip(result.getThrowable());
	}


	@Override
	public void onFinish(ITestContext arg0) {
		// we need to flush at the end of the test otherwise it will not create report
		extent.flush();

	}
}
