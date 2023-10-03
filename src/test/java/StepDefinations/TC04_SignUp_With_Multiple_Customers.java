package StepDefinations;

import java.io.IOException;
import org.testng.annotations.Test;

import PageObject.LoginPage;
import PageObject.RegisterPage;
import Utilities.BaseClass;

public class TC04_SignUp_With_Multiple_Customers extends BaseClass {
	
	@Test(groups = "SignUP")
	public void createMultipleCustomers() throws IOException 
	{
		loginPageObject = new LoginPage(driver);
		loginPageObject.clickOnSignUp();
		
		RegisterPageObject = new RegisterPage(driver);
		RegisterPageObject.setFirstName();
		RegisterPageObject.setLastName();
		RegisterPageObject.setMailID();
		RegisterPageObject.setPhoneNumber();
		RegisterPageObject.setOccupation(getOccupation("config.properties"));
		RegisterPageObject.selectGenger("config.properties");
		RegisterPageObject.setPassword();
		RegisterPageObject.clickOnCheckBox();
		RegisterPageObject.clickOnRegisterBtn();
		RegisterPageObject.signUpSuccessfullMsg();
		
	}
}
