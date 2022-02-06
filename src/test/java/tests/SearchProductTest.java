package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchProductTest extends TestBase{
	String productName="Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	ProductDetailsPage productdetailsObject;
	
	@Test
	public void UserCanSearchForProducts() {
		searchObject =new SearchPage(driver);
		searchObject.ProductSearch(productName);
		productdetailsObject=new ProductDetailsPage(driver);
		Assert.assertTrue(productdetailsObject.ProductNameBeradcrumb.getText().equalsIgnoreCase(productName));
		
	}

}
