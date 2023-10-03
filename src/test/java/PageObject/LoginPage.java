package PageObject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {
	
	public WebDriver driver;
	
	// Constructor to access methods of this class
	public LoginPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);		
	}
	
	
	
	//Type1
	//By welcomePageText = By.xpath("//h1");
	
	@FindBy(xpath = "//h1[text()='Log in']")
	WebElement loginPageValidation;
	
	//Type 2
	@FindBy(xpath = "//input[@id='userEmail']")
	@CacheLookup
	WebElement emailID;
	
	//Type 3
	@FindBy(how = How.CSS, using = "input[id='userPassword']")
	@CacheLookup
	WebElement passwrod;
	
	@FindBy(how = How.XPATH , using = "//input[@name='login']")
	@CacheLookup
	WebElement loginBtn;
	
	@FindBy(xpath = "//button[@routerlink='/dashboard/myorders']")
	WebElement ordersButton;
	
	@FindBy(xpath = "//div[@id='toast-container']")
	WebElement loginErrorText;
	
	@FindBy(xpath = "//a[@class='text-reset']")
	WebElement signUp;
	
	public void gotoURL() 
	{
		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		
	}
	
	public void loginPageValidation(String loginText) 
	{
		//strong[contains(.,'Welcome, please sign in!')]
		
		Assert.assertEquals(loginPageValidation.getText(), loginText);
		System.out.println("******* We are on login page *******");
	}
	
	public void enterLoginDetails(String userid, String pwd) 
	{
		emailID.clear();
		emailID.sendKeys(userid);
		passwrod.clear();
		passwrod.sendKeys(pwd);
		loginBtn.click();
		
	}
	
	public void clickOnOrders() 
	{
		ordersButton.click();
	}
	
	public String validateLoginError() 
	{
		String errorText = loginErrorText.getText();
		return errorText;
	}
	
	
	public void clickOnSignUp() 
	{
		signUp.click();
		
	}
	
	
	
	

}
