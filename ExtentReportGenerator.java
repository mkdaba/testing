package utilities;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportGenerator {
	
	public static ExtentReports reportgenerator() {
		
		ExtentReports reports = new ExtentReports();
		File file = new File(System.getProperty("user.dir")+"\\Extentreport\\ereport.html");
		ExtentSparkReporter sparkreporter = new ExtentSparkReporter(file);
		reports.attachReporter(sparkreporter);
		
		reports.flush();
		return reports;

	}

}
