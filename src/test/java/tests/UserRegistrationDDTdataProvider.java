package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationDDTdataProvider extends TestBase{
	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	
	@DataProvider(name="testData")
	public static Object[][] userData(){
		return new Object[][] {{"moham","haje","medhkadj@gm.com","123456"},
			{"ahmad","ali","alikd@fl.com","123456789"}};
			
		}
		
	
	
	@Test(priority=1,alwaysRun=true,dataProvider = "testData")
	public void UserCanRegisterSuccssfully(String fname,String lname, String email, String mdp) {
		homeObject =new HomePage(driver);
		homeObject.OpenRegistrationPage();
		registerObject=new UserRegistrationPage(driver);
		registerObject.UserRegistration(fname,lname,email,mdp);
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
		registerObject.UserLogOut();
		homeObject.openLoginPage();
		loginObject=new LoginPage(driver);
		loginObject.UserLogin(email, mdp);
		Assert.assertTrue(registerObject.logoutLink.isDisplayed());
		registerObject.UserLogOut();
	}
	
	

}
