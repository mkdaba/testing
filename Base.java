package base;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Base {

	public String takescreenshot(String testname,WebDriver driver) throws IOException {
		File srcfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File destinationfile = new File(System.getProperty("user.dir")+"\\screenshots"+testname+".png");	
        FileUtils.copyFile(srcfile, destinationfile);
        
        return destinationfile.getAbsolutePath();
	}
}
