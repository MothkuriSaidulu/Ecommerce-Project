package PageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Utilities.WaitHelperClass;

public class PaymentPage extends WaitHelperClass{
	
	// //input[@placeholder='Select Country']

	
	public WebDriver driver ;
	
	public PaymentPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@placeholder='Select Country']")
	@CacheLookup
	WebElement selectCountry;
	
	
	@FindBy(css = "section[class*='ng-star-inserted'] button")
	List<WebElement> countryNames;
	
	@FindBy(css = "a[class*='ng-star-inserted']")
	WebElement placeOrder;
	
	@FindBy(css = "h1")
	WebElement successMsg;
	

	
	public void selectCountryName(String countryName) 
	{
		selectCountry.sendKeys(countryName);
		
		for(int i = 0 ; i < countryNames.size(); i++)
		{
			String webCoutryName =  countryNames.get(i).getText();
			if(webCoutryName.equalsIgnoreCase(countryName))
			{
				countryNames.get(i).click();
				break;
			}
		}
				
	}
	
	public void clickOnPlaceOrder() 
	{
		placeOrder.click();
		
	}
	
	public void sucessfullMsg()
	{
		
		System.out.println(successMsg.getText());
		Assert.assertEquals(successMsg.getText(), "THANKYOU FOR THE ORDER." );
		
	}
	


	
}

