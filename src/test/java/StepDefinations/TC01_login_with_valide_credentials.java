package StepDefinations;

import org.testng.annotations.Test;

import Utilities.BaseClass;

public class TC01_login_with_valide_credentials extends BaseClass 
{

	
	public String loginText =  "Log in";
	
	public String EmailID = "charym695@gamil.com";
	public String PWD = "Chary@123"; 
	
	@Test
	public void valideLoginDetails() {
		//loginPageObject = new LoginPage(driver);		
		loginPageObject.gotoURL();
		loginPageObject.enterLoginDetails(EmailID, PWD);
			
	}
}
