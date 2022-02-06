package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.AddReviewPage;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.UserRegistrationPage;

public class AddProductReviewTest extends TestBase{
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
		try {

			searchObject=new SearchPage(driver);
			productdetailsObject=new ProductDetailsPage(driver);
			searchObject.SearchUsingAutoSuggest("mac");
			Assert.assertTrue(productdetailsObject.ProductNameBeradcrumb.getText().equalsIgnoreCase(productName));
		} catch (Exception e) {
			System.out.println("error ocuered"+e.getMessage());
		}
	}
	AddReviewPage addreviwObject;
	String title="mac";
	String messrevie="for y";
	@Test(priority = 3)
	public void UserCanAddRevie() {
		productdetailsObject.openAddReviev();
		addreviwObject=new AddReviewPage(driver);
		addreviwObject.AddReiwProdut(title, messrevie);
		Assert.assertTrue(addreviwObject.succsesMessaReview.getText().contains("Product review is successfully added"));
	}
	@Test(priority=4)
	public void UserLogout() 
	{
		registerObject.UserLogOut();
	}
	
}
