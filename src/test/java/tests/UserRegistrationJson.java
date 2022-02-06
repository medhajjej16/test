package tests;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import data.JsonDataReader;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationJson extends TestBase{
	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	
	
	@Test(priority=1,alwaysRun=true)
	public void UserCanRegisterSuccssfully() throws FileNotFoundException, IOException, ParseException {
		JsonDataReader jsonReader= new JsonDataReader();
		jsonReader.JsonReader();
		homeObject =new HomePage(driver);
		homeObject.OpenRegistrationPage();
		registerObject=new UserRegistrationPage(driver);
		registerObject.UserRegistration(jsonReader.firstname,jsonReader.lastename,jsonReader.email,jsonReader.password);
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
		registerObject.UserLogOut();
		homeObject.openLoginPage();
		loginObject=new LoginPage(driver);
		loginObject.UserLogin(jsonReader.email,jsonReader.password);
		Assert.assertTrue(registerObject.logoutLink.isDisplayed());
		registerObject.UserLogOut();

	}
	
}
