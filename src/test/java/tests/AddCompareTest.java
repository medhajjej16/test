package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AddComparePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class AddCompareTest extends TestBase{
	String productName="Apple MacBook Pro 13-inch";
	String SecondproductNale="Asus N551JK-XO076H Laptop";
	SearchPage searchObject;
	ProductDetailsPage productdetailsObject;
	AddComparePage addcompareObject;
	@Test
	public void userCansearchWithAutoSugg() {
		addcompareObject =new AddComparePage(driver);
		searchObject=new SearchPage(driver);
		productdetailsObject=new ProductDetailsPage(driver);
		searchObject.SearchUsingAutoSuggest("mac");		
		Assert.assertTrue(productdetailsObject.ProductNameBeradcrumb.getText().equalsIgnoreCase(productName));
		productdetailsObject.OpenproductComparison();
		addcompareObject.afficheCompareListe();
		
		searchObject.SearchUsingAutoSuggest("asus");
		Assert.assertTrue(productdetailsObject.ProductNameBeradcrumb.getText().equalsIgnoreCase(SecondproductNale));
		productdetailsObject.OpenproductComparison();
		addcompareObject.afficheCompareListe();
	}
	
@Test
public void usercanclear() {
	addcompareObject.clearListe();
	
}
}
