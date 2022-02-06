package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.AddtoCartePage;
import pages.HomePage;
import pages.OrderDetailPage;
import pages.ProductDetailsPage;
import pages.RegistredUserChekoutPage;
import pages.SearchPage;
import pages.UserRegistrationPage;

public class RegistredUserChekoutTest extends TestBase{
	HomePage homeObject ; 
	UserRegistrationPage registerObject ; 
		
	Faker fakeData =new Faker();
	String firstname = fakeData.name().firstName(); 
	String lastname = fakeData.name().lastName(); 
	String email = fakeData.internet().emailAddress(); 
	String oldpassword = fakeData.number().digits(8).toString();
	String newpassword = fakeData.number().digits(8).toString();


	@Test(priority=1)
	public void UserCanRegisterSuccssfully() 
	{
		homeObject = new HomePage(driver); 
		homeObject.OpenRegistrationPage();
		registerObject = new UserRegistrationPage(driver); 
		registerObject.UserRegistration(firstname, lastname, email, oldpassword);
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
	}

	String productName="Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	ProductDetailsPage productdetailsObject;
	@Test(priority = 2)
	public void userCansearchWithAutoSugg() {

		searchObject=new SearchPage(driver);
		productdetailsObject=new ProductDetailsPage(driver);
		searchObject.SearchUsingAutoSuggest("mac");
		Assert.assertTrue(productdetailsObject.ProductNameBeradcrumb.getText().equalsIgnoreCase(productName));
		productdetailsObject.OpenAddtoCarte();

	}
	AddtoCartePage addtocarteObject;
	String quan="3";
	@Test(priority = 3)
	public void CanAddProducttoCarte() 
	{
		addtocarteObject=new AddtoCartePage(driver);
		addtocarteObject.UpdateProductQuantity(quan);
		Assert.assertTrue(addtocarteObject.totalProduct.getText().contains("$5,400.00"));
		addtocarteObject.OpenChekoutPage();
	}

	OrderDetailPage orderdetailObject;         
	RegistredUserChekoutPage chekoutObject;

	@Test(priority = 4)
	public void UserCanChekOut() throws InterruptedException {
		chekoutObject=new RegistredUserChekoutPage(driver);
		chekoutObject.BilingCkeout("United States","AA (Armed Forces Americas)", "cair", "sdvdf", "svdsdv", "111111111111");
		chekoutObject.ContinueLink();
		Assert.assertTrue(chekoutObject.productname.getText().contains("Apple MacBook Pro 13-inch"));	
		Assert.assertTrue(chekoutObject.thankymess.isDisplayed());
		chekoutObject.OpenOrderDetail();
		orderdetailObject=new OrderDetailPage(driver);
		orderdetailObject.printorder();
		orderdetailObject.dawnloadprintPdf();

	}
	@Test(priority=5)
	public void UserLogout() 
	{
		registerObject.UserLogOut();
	}

}
