package Utilities;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelperClass {

	public WebDriver driver;
	
	public WaitHelperClass(WebDriver driver)
	{
		this.driver = driver;
		
	}

	// Explicitly Waits
	public void waitWebElementListToAppear(List<WebElement> webElement) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
		wait.until(ExpectedConditions.visibilityOfAllElements(webElement));

	}

	public void waitWebElementToAppear(WebElement webElement) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
		wait.until(ExpectedConditions.visibilityOf(webElement));

	}

	public void waitWebElementToDissappear(WebElement webElement) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
		wait.until(ExpectedConditions.invisibilityOf(webElement));

	}

}
