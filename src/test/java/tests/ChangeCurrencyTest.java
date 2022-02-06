package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class ChangeCurrencyTest extends TestBase{
	
	
	HomePage homepageObject;
	
	@Test(priority = 1)
	public void UserCanchangeCuree() {
		homepageObject=new HomePage(driver);
		homepageObject.changeCurrency();
		
	}
	String productName="Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	ProductDetailsPage productdetailsObject;
	@Test(priority = 2)
	public void userCansearchWithAutoSugg() {
		try {
				
		searchObject=new SearchPage(driver);
		productdetailsObject=new ProductDetailsPage(driver);
		searchObject.SearchUsingAutoSuggest("mac");
		Assert.assertTrue(productdetailsObject.ProductNameBeradcrumb.getText().equalsIgnoreCase(productName));
		Assert.assertTrue(productdetailsObject.veififycurrencyTxt.getText().contains("€"));
		System.out.println(productdetailsObject.veififycurrencyTxt.getText());
		} catch (Exception e) {
			System.out.println("error ocuered"+e.getMessage());
		}
	}
}
