package Utilities;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import PageObject.LoginPage;
import PageObject.OrdersHistryPage;
import PageObject.PaymentPage;
import PageObject.CartPage;
import PageObject.ProductCatalogPage;
import PageObject.RegisterPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public WebDriver driver;
	public LoginPage loginPageObject;
	public ProductCatalogPage ProductCatalogPageObject; 
	public CartPage MyCartPageObject; 
	public PaymentPage PaymentPageObject;
	public OrdersHistryPage OrdersHistryPageObject;
	public JsonDataReader jsonObject;
	public RegisterPage RegisterPageObject; 
	
	public WebDriver IntiateBrowser() throws IOException 
	{
		// this done by y perosn
		
		
		FileInputStream file = new FileInputStream("config.properties");		
		Properties property = new Properties();
		property.load(file);
		
		String browserName = System.getProperty("Browser") != null ? System.getProperty("Browser")
				: property.getProperty("Browser");
		
//		if (System.getProperty("Browser") != null)  // CMD MVN command having browser then get the browser from there or else get the browser from config file.
//			{
//				System.getProperty("Browser");
//			}else
//			{
//				property.getProperty("Browser");
//			}
		
		
		
		//String browserName = property.getProperty("Browser");
		
		if (browserName.contains("Chrome")) 
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if (browserName.contains("Edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		return driver;	
	}

	public String getCountryName(String filePath) throws IOException 
	{
		FileInputStream file = new FileInputStream(filePath);
		Properties property = new Properties();
		property.load(file);
		String countryName = property.getProperty("Country");
		return countryName;
	}
	
	public String getOccupation(String filePath) throws IOException
	{
		FileInputStream file = new FileInputStream(filePath);
		Properties prop = new Properties();
		prop.load(file);
		String occupation = prop.getProperty("Occupation");
		return occupation;	
	}
	
	@BeforeMethod(alwaysRun = true)
	public LoginPage launchApplication() throws IOException 
	{
		driver = IntiateBrowser();
		loginPageObject = new LoginPage(driver);
		loginPageObject.gotoURL();
		return loginPageObject;
		
	}
	


	public String takeScreenShotOfFailed(String testCaseName , WebDriver driver) throws IOException 
	{
		File screenshotFile = ( (TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		File filePath = new File((System.getProperty("user.dir") + "//Reports//" + testCaseName + ".png"));
		
		FileUtils.copyFile(screenshotFile, filePath);
		
		return System.getProperty("user.dir") + "//Reports//"+ testCaseName + ".png";
	}
	
	
// Create Random data
	public String RandomStringData() 
	{
		String ramdomStringData = RandomStringUtils.randomAlphabetic(4);
		return ramdomStringData;
	}
	
	public String RandomIntegerData() {
		
		String randomInteger = RandomStringUtils.randomNumeric(5);
		return randomInteger;
		
		
//		Random randomInteger = new Random();
//		int randomNumeric = randomInteger.nextInt(5);
//		return randomNumeric;
	}
	
	
	
	@AfterMethod(alwaysRun = true)  // use alwaysRun = true for groups
	public void closeBrowser() 
	{
		driver.close();		
	}

}
