package PageObject;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Utilities.WaitHelperClass;

public class CartPage extends WaitHelperClass{
	
	public WebDriver driver;
	
	public CartPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH , using = "//h1")
	WebElement MyCartText;
	
	@FindBy(xpath = "//div[@class='cartSection'] //h3")
	List<WebElement> orders;
	
	@FindBy(xpath = "//div[contains(@class,'ng-star-inserted')] //button")
	WebElement checkOutBtn;
	
	public void verifyOrder(String nameOfProduct) 
	{
		waitWebElementToAppear(MyCartText);
		
		for(int i = 0 ; i<orders.size(); i++ )
		{
			String orderName = orders.get(i).getText();
			if (orderName.equalsIgnoreCase(nameOfProduct)) 
			{
				Assert.assertTrue(true);
			}
		}
	}
	
	public void clickOnCheckOutBtn() 
	{
		checkOutBtn.click();		
	}
	
	
	
}
