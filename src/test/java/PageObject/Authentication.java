package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Authentication {
	
	@Test
	public void name() {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		
//		driver.get("https://the-internet.herokuapp.com");
//		driver.findElement(By.linkText("Basic Auth")).click();  //admin
		
		// Authentication 
		
		driver.get("https://admin:admin@the-internet.herokuapp.com");
		driver.findElement(By.linkText("Basic Auth")).click();
	}
	
	
	

}
