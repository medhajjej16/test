package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTest extends TestBase{
	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	
	
	@Test(priority=1,alwaysRun=true)
	public void UserCanRegisterSuccssfully() {
		homeObject =new HomePage(driver);
		homeObject.OpenRegistrationPage();
		registerObject=new UserRegistrationPage(driver);
		registerObject.UserRegistration("mmml", "hckfajfjej", "mmm@gmail.com", "00000000");
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
		loginObject.UserLogin("mmm@gmail.com", "00000000");
		Assert.assertTrue(registerObject.logoutLink.isDisplayed());
	}
	

}
