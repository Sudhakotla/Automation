package flightBooking;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import utility.Utilitymethods;

public class TestOrbit 
{
	
	static WebDriver driver;
			
	@Test
    @Parameters("browser")
	public static void verifyFlightbooking(String browserName)
	{	
	  
		
		  if(browserName.equalsIgnoreCase("firefox"))
			{
			    driver = new FirefoxDriver();

	    	   // System.setProperty("webdriver.chrome.driver", "E:\\SUDHA\\Selenium\\IEDriverServer.exe");

			  //driver = new InternetExplorerDriver();
			}
		     else if(browserName.equalsIgnoreCase("chrome"))
			{
	    	    System.setProperty("webdriver.chrome.driver", "E:\\SUDHA\\Selenium\\New folder\\chromedriver_win32\\chromedriver.exe");
				driver = new ChromeDriver();
			}
		     
		  //  driver = new FirefoxDriver();

			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		    driver.get("https://www.orbitz.com/");
			driver.manage().window().maximize();
		
		
	
	  //Capture screenshot
	  Utilitymethods.captureScreenShot(driver,"HomePage");		  
	  		  
	  driver.findElement(By.xpath("//a[@id='primary-header-flight']")).click();
	  
	  driver.findElement(By.xpath("//label[@id='flight-type-one-way-label']")).click();  

	  driver.findElement(By.xpath("//input[@id='flight-origin']")).sendKeys("Hyderabad, India (HYD-Rajiv Gandhi Intl.)");
	  
	  driver.findElement(By.xpath("//input[@id='flight-destination']")).sendKeys("Pune, India (PNQ-Lohegaon)");
	  
	  driver.findElement(By.xpath("//input[@id='flight-departing']")).click();
	  
      driver.findElement(By.xpath("(//*[text()='FEB 2018']/following::button[text()='20'])[1]")).click();
      
      Utilitymethods.captureScreenShot(driver,"FlightsHomePage");

      driver.findElement(By.xpath("//button[@id='search-button']")).click();
	  
	  driver.quit();
	
	}
}
