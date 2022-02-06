package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import data.loadProperties;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationDDTfileProprities extends TestBase{
	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	String firstname= loadProperties.userData.getProperty("firtename");
	String lastname=loadProperties.userData.getProperty("lastname");
	String email=loadProperties.userData.getProperty("email");
	String mdp=loadProperties.userData.getProperty("password");
	
	@Test(priority=1,alwaysRun=true)
	public void UserCanRegisterSuccssfully() {
		homeObject =new HomePage(driver);
		homeObject.OpenRegistrationPage();
		registerObject=new UserRegistrationPage(driver);
		registerObject.UserRegistration(firstname, lastname, email,mdp);
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
	
	}
	@Test(dependsOnMethods= {"UserCanRegisterSuccssfully"})
	public void UserRegistreCanLogout() {
		registerObject.UserLogOut();
	}
	@Test(dependsOnMethods= {"UserRegistreCanLogout"})
	public void UserRegistreCanLogin() {
		
		homeObject.openLoginPage();
		loginObject=new LoginPage(driver);
		loginObject.UserLogin(email, mdp);
		Assert.assertTrue(registerObject.logoutLink.isDisplayed());
	}
	

}
