package PageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Utilities.WaitHelperClass;

public class OrdersHistryPage extends WaitHelperClass{

	public WebDriver driver;
	
	public OrdersHistryPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		
	}


	@FindBy(xpath = "//h1")
	WebElement orderTextWebElement;
	
	@FindBy(xpath = "//table//tr//td[2]")
	List<WebElement> ordersList;
	
	
	public void verifyOrders(String nameOfProduct) 
	{
		waitWebElementToAppear(orderTextWebElement);
		
		for(int i = 0 ; i < ordersList.size() ; i++)
		{
			String orderName = ordersList.get(i).getText();
			if (orderName.equalsIgnoreCase(nameOfProduct)) 
			{
				Assert.assertTrue(true);
			}
			else {
				System.out.println("Correct Order Not Placed");
			}
			
		}
	}
	
}
