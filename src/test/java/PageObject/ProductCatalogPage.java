package PageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Utilities.WaitHelperClass;

public class ProductCatalogPage extends WaitHelperClass {
	
	public WebDriver driver;
	public ProductCatalogPage(WebDriver driver) 
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(xpath = "//section//h5")
	List<WebElement> productList;
	
	@FindBy(how = How.CSS, using = "div[class='card-body'] button:last-of-type")
	List<WebElement> addToCartBtn;
	
	@FindBy(css = "div#toast-container")
	WebElement addConfirmationMsg;
	
//	By toast = By.cssSelector("div#toast-container");

	@FindBy(css = ".ng-animating")
	WebElement invisable;
	
	@FindBy(xpath = "//button[@routerlink='/dashboard/cart']")
	WebElement cartBtn;

	
	public void clickOnProduct(String nameOfProduct) 
	{		
		for(int i =0 ; i<productList.size(); i++)
		{
			String name = productList.get(i).getText();
			if(name.contains(nameOfProduct))
			{
				addToCartBtn.get(i).click();
				break;
			}
		}	
		
		waitWebElementToAppear(addConfirmationMsg);
		waitWebElementToDissappear(invisable);
	}
	
	public void clickOnCartBtn() 
	{
		cartBtn.click();
		
	}
}
