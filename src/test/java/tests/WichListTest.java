package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.WichListePage;

public class WichListTest extends TestBase{
	String productName="Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	ProductDetailsPage productdetailsObject;

	@Test(priority = 1)
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
	WichListePage wichlistObject;
	@Test(priority = 2)
	public void UserCanaddWichListe() {
		productdetailsObject=new ProductDetailsPage(driver);
		wichlistObject=new WichListePage(driver);
		productdetailsObject.openAddWichList();
		Assert.assertTrue(wichlistObject.verifwichliste.isDisplayed());
		
	}
	@Test(priority = 3)
	public void UserCanRemovewichList(){
		wichlistObject.RemovewichList();
		Assert.assertTrue(wichlistObject.result.getText().contains("The wishlist is empty!"));
	}
}
