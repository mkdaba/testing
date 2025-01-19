package listeners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import base.Base;
import utilities.ExtentReportGenerator;

public class MyListeners extends Base implements ITestListener {
	
	ExtentReports report=ExtentReportGenerator.reportgenerator();
	ExtentTest etest;
	@Override
	public void onTestStart(ITestResult result) {
		String Testname = result.getName();
         etest= report.createTest(Testname);
          etest.log(Status.INFO,Testname+"execution started");
          report.flush();
			}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testname =result.getName();
		 etest= report.createTest(testname);
		etest.log(Status.PASS,testname+"got succesfully executed");
		report.flush();
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testname = result.getName();
		 etest= report.createTest(testname);
		etest.log(Status.FAIL,testname+"got failed");
		report.flush();
		
		WebDriver driver = null ;
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			etest.addScreenCaptureFromPath(takescreenshot(testname,driver),testname);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
	String Testname = result.getName();
	 etest= report.createTest(Testname);
	System.out.println(Testname+"was skipped");
	}
	
	

}
