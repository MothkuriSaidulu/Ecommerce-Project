package PageObject;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import Utilities.BaseClass;

public class RegisterPage extends BaseClass {

	public WebDriver driver;
	public RegisterPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(how = How.CSS, using = "input#firstName")
	WebElement firstName;
	
	@FindBy(css = "input[id='lastName']")
	WebElement lastName;
	
	@FindBy(xpath = "//input[@id='userEmail']")
	WebElement userMailId;
	
	@FindBy(xpath = "//input[@id='userMobile']")
	WebElement phoneNumber;
	
	@FindBy(css = "select[class*='custom-select']")
	WebElement occupation;
	
	@FindBy(xpath = "//input[@value='Male']")
	WebElement maleRadioBtn;
	
	@FindBy(xpath = "//input[@value='Female']")
	WebElement femaleRadioBtn;
	
	@FindBy(id = "userPassword")
	WebElement userPassword;
	
	@FindBy(id = "confirmPassword")
	WebElement confirmPassword;
	
	@FindBy(xpath = "//input[@type='checkbox']")
	WebElement checkbox;
	
	@FindBy(css = "input[id='login']")
	WebElement clickOnRegisterBtn;
	
	@FindBy(xpath = "//h1[text()='Account Created Successfully']")
	WebElement signUpSuccessfullMsg;
	
	public void setFirstName() {
		
		String F_Name = "saida" + RandomStringData();
		
		firstName.sendKeys(F_Name);

	}
	
	
	public void setLastName() {
		
		String L_Name = "Chary" + RandomStringData();
		lastName.sendKeys(L_Name);
	}
	
	public void setMailID() {
		
		String emailID = "saidachary" + RandomStringData() + "@gmail.com" ;
		userMailId.sendKeys(emailID);
		System.out.println("User Email ID   : " + emailID);
		
	}
	
	public void setPhoneNumber() {
		
		 String ph_number =  "90101" + RandomIntegerData();
		 
		 phoneNumber.sendKeys(ph_number);
		
	}
	
	public void setOccupation(String Occupation) 
	{

		Select sel = new Select(occupation);
		sel.selectByVisibleText(Occupation);
	}
	
	public void selectGenger(String filepath) throws IOException {
		
		FileInputStream file = new FileInputStream(filepath);
		Properties prop = new Properties();
		prop.load(file);
		String gender = prop.getProperty("Gender");
		if (gender.equalsIgnoreCase("Male")) 
		{
			maleRadioBtn.click();
			
		}
		else if (gender.equalsIgnoreCase("Female")) 
		{
			femaleRadioBtn.click();
		} 
		
	}
	
	public void setPassword() {
//		userPassword
		String password =  "Chary" + RandomIntegerData();
		 userPassword.sendKeys(password);
		 confirmPassword.sendKeys(password);
		 System.out.println("User Password  : "  +  password);
		
	}

	public void clickOnCheckBox() 
	{
		checkbox.click();		
	}
	
	public void clickOnRegisterBtn() {
		clickOnRegisterBtn.click();
		
	}
	
	public void signUpSuccessfullMsg() 
	{
		Assert.assertEquals(signUpSuccessfullMsg.getText(), "Account Created Successfully");
		
	}
	
}
