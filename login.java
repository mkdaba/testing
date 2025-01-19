package tests;



import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class login {
	 static WebDriver driver;
	 @BeforeMethod
	 public void base(){
		 WebDriverManager.chromedriver().setup();
		    driver = new ChromeDriver();
		    driver.manage().window().maximize();
		    driver.get("https://tutorialsninja.com/demo/");
		 
	 }
	 
	@Test(priority=1)
	public  void loginwithvalidcredentials() {
		
	    driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")).click();
	    driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a")).click();
	    driver.findElement(By.xpath("//*[@id=\"input-email\"]")).sendKeys("akshaypuch99@gmail.com");
	    driver.findElement(By.xpath("//*[@id=\"input-password\"]")).sendKeys("987654321");
	    driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
	    
	    AssertJUnit.assertTrue(driver.findElement(By.xpath("//*[@id=\"content\"]/ul[1]/li[1]/a")).isDisplayed());
		
	}
	@Test(priority=2)
	public void loginwithinvalidcreentials() {
		 driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")).click();
		    driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a")).click();
		    driver.findElement(By.xpath("//*[@id=\"input-email\"]")).sendKeys("akshaypuch99"+timestamp()+"@gmail.com");
		    driver.findElement(By.xpath("//*[@id=\"input-password\"]")).sendKeys("987654321");
		    driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
		    
		    AssertJUnit.assertTrue(driver.findElement(By.xpath("//*[@id=\"account-login\"]/div[]")).isDisplayed());
		
	}
	@Test(priority=3)
	public void loginwithoutcredentials() {
		 driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")).click();
		    driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a")).click();
		    driver.findElement(By.xpath("//*[@id=\"input-email\"]")).sendKeys("");
		    driver.findElement(By.xpath("//*[@id=\"input-password\"]")).sendKeys("");
		    driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
		    
		    AssertJUnit.assertTrue(driver.findElement(By.xpath("//*[@id=\"account-login\"]/div[1]")).isDisplayed());
	
	}
	
	public String timestamp() {
		Date date = new Date();
	
	return  date.toString().replace(" ", "_").replace(":","_");
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
