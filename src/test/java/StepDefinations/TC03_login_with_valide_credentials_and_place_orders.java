package StepDefinations;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import PageObject.PaymentPage;
import PageObject.CartPage;
import PageObject.LoginPage;
import PageObject.OrdersHistryPage;
import PageObject.ProductCatalogPage;
import Utilities.BaseClass;
import Utilities.JsonDataReader;

public class TC03_login_with_valide_credentials_and_place_orders extends BaseClass {

	String loginText = "Log in";

	@Test(dataProvider = "getData")
	public void placeOrderTest(HashMap<String, String> input) throws IOException {
	//	String countryName = "India";

		loginPageObject = new LoginPage(driver);

		loginPageObject.loginPageValidation(loginText);
		loginPageObject.enterLoginDetails(input.get("EmailID"), input.get("PWD"));

		ProductCatalogPageObject = new ProductCatalogPage(driver);
		ProductCatalogPageObject.clickOnProduct(input.get("Product"));
		ProductCatalogPageObject.clickOnCartBtn();

		MyCartPageObject = new CartPage(driver);
		MyCartPageObject.clickOnCheckOutBtn();

		PaymentPageObject = new PaymentPage(driver);
		PaymentPageObject.selectCountryName(getCountryName("config.properties"));
		PaymentPageObject.clickOnPlaceOrder();
		PaymentPageObject.sucessfullMsg();

	}

	@Test(dataProvider = "getData" , dependsOnMethods = { "placeOrderTest" })
	public void orderHistryVerification(HashMap<String, String> input) {

		loginPageObject = new LoginPage(driver);
		loginPageObject.enterLoginDetails(input.get("EmailID"), input.get("PWD"));
		loginPageObject.clickOnOrders();

		OrdersHistryPageObject = new OrdersHistryPage(driver);
		OrdersHistryPageObject.verifyOrders(input.get("Product"));

	}

	@DataProvider
	public Object[][] getData() throws IOException {
		// return new Object[][] { {"charym695@gamil.com", "Chary@123", "ZARA COAT 3" },
		// {"charym694@gamil.com", "Chary@123" , "ADIDAS ORIGINAL"}};

//		HashMap<String, String> map1 = new HashMap<String, String>();
//		map1.put("EmailID", "charym695@gamil.com");
//		map1.put("PWD", "Chary@123");
//		map1.put("Product", "ZARA COAT 3");
//		HashMap<String, String> map2 = new HashMap<String, String>();
//		map2.put("EmailID", "charym694@gamil.com");
//		map2.put("PWD", "Chary@123");
//		map2.put("Product", "ADIDAS ORIGINAL");
		
		jsonObject = new JsonDataReader();
		List<HashMap<String, String>> map = jsonObject.readJsonData(System.getProperty("user.dir") + "//src//test//java//Utilities//DataFile.json");
		
//		List<HashMap<String, String>> map = jsonObject.readJsonData();

		
		return new Object[][] { { map.get(0) }, { map.get(1) } };
	}
}