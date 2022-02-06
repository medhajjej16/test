package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchProductusingAuto extends TestBase{
	String productName="Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	ProductDetailsPage productdetailsObject;
	@Test
	public void userCansearchWithAutoSugg() {
		try {
				
		searchObject=new SearchPage(driver);
		productdetailsObject=new ProductDetailsPage(driver);
		searchObject.SearchUsingAutoSuggest("mac");
		Assert.assertTrue(productdetailsObject.ProductNameBeradcrumb.getText().equalsIgnoreCase(productName));
		} catch (Exception e) {
			System.out.println("error ocuered"+e.getMessage());
		}
	}
}
