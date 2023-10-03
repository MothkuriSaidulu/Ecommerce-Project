package StepDefinations;


import org.testng.Assert;
import org.testng.annotations.Test;
import Utilities.BaseClass;

public class TC02_login_with_invalide_credentials extends BaseClass 
{

	
	 String loginText =  "Log in";
	
	 String EmailID = "charym69@gamil.com";
	 
	 String PWD = "Chary@123"; 
	
	@Test(groups = {"errorTest"})
	public void invalideLoginDetails() {
		
		loginPageObject.gotoURL();
		loginPageObject.enterLoginDetails(EmailID, PWD);
		
		Assert.assertEquals(loginPageObject.validateLoginError(), "Incorrect email or passwordd.");
		
	}
}
