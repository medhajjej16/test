package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.EmailFriendPage;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.UserRegistrationPage;

public class EmailFriendTest extends TestBase{
	HomePage homeObject ; 
	UserRegistrationPage registerObject ; 
		
	Faker fakeData =new Faker();
	String firstname = fakeData.name().firstName(); 
	String lastname = fakeData.name().lastName(); 
	String email = fakeData.internet().emailAddress(); 
	String oldPassword = fakeData.number().digits(8).toString();
	String newPassword = fakeData.number().digits(8).toString();


	@Test(priority=1)
	public void UserCanRegisterSuccssfully() 
	{
		homeObject = new HomePage(driver); 
		homeObject.OpenRegistrationPage();
		registerObject = new UserRegistrationPage(driver); 
		registerObject.UserRegistration(firstname, lastname, email, oldPassword);
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
	}

	String productName="Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	ProductDetailsPage productdetailsObject;
	@Test(priority=2)
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
	EmailFriendPage emailfriendObject;	
	String friendemail=email;
	String message="hello";
	@Test(priority=3)

	public void UsercanSendemail() {
		productdetailsObject.openClicEmailfriend();
		emailfriendObject =new EmailFriendPage(driver);
		emailfriendObject.sendEmailFriend(friendemail, message);
		Assert.assertTrue(emailfriendObject.messageNotification.getText().contains("Your message has been sent."));

	}
	@Test(priority=4)
	public void UserLogout() 
	{
		registerObject.UserLogOut();
	}
}
