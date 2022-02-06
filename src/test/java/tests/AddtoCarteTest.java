package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AddtoCartePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class AddtoCarteTest extends TestBase{
	String productName="Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	ProductDetailsPage productdetailsObject;
	@Test(priority = 1)
	public void userCansearchWithAutoSugg() {
					
		searchObject=new SearchPage(driver);
		productdetailsObject=new ProductDetailsPage(driver);
		searchObject.SearchUsingAutoSuggest("mac");
		Assert.assertTrue(productdetailsObject.ProductNameBeradcrumb.getText().equalsIgnoreCase(productName));
		productdetailsObject.OpenAddtoCarte();
		
}
	AddtoCartePage addtocarteObject;
	String quan="3";
	@Test(priority = 2)
	public void CanAddProducttoCarte() 
	{
		addtocarteObject=new AddtoCartePage(driver);
		addtocarteObject.UpdateProductQuantity(quan);
		Assert.assertTrue(addtocarteObject.totalProduct.getText().contains("$5,400.00"));
				
	}
	@Test(priority = 3)
	public void canremove() {
		addtocarteObject=new AddtoCartePage(driver);
		driver.navigate().to("http://demo.nopcommerce.com" + "/cart");
		addtocarteObject.RemovUpProduct();
		Assert.assertTrue(addtocarteObject.messageempty.getText().contains("Your Shopping Cart is empty!"));
	}
}