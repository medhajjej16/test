package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.UserRegistrationPage;

public class MyAccountTest extends TestBase
{
	HomePage homeObject ; 
	UserRegistrationPage registerObject ; 
	LoginPage loginObject ; 
	MyAccountPage myAccountObject ; 
		
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
	
	@Test(priority=2)
	public void RegisteredUserCanChangePassword() 
	{
		myAccountObject = new MyAccountPage(driver) ; 
		registerObject.openMyAccountPage();
		myAccountObject.openchangePasswordPage();
		myAccountObject.changePassword(oldpassword, newpassword);
		Assert.assertTrue(myAccountObject.resultlbl.isDisplayed());
		myAccountObject.CloseBtnV();
	}
	
	@Test(priority=3)
	public void RegisteredUserCanLogout() 
	{
		registerObject.UserLogOut();
	}
	
	@Test(priority=4)
	public void RegisteredUserCanLogin() 
	{
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver); 
		loginObject.UserLogin(email, newpassword);
		Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
	}
	
	@Test(priority=5)
	public void UserLogout() 
	{
		registerObject.UserLogOut();
	}
	
}
