package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.ContactUsPage;
import pages.HomePage;

public class ContactUsTest extends TestBase{
	 ContactUsPage contactusObject;
	 HomePage homepageObject;
	 ;
	 
	 String Enquery="salam";
	 Faker fakeData =new Faker();
		String firstName = fakeData.name().firstName(); 
				String email = fakeData.internet().emailAddress(); 
		
	
	@Test
	public void UsercanContactUs() {
		contactusObject=new ContactUsPage(driver);
		homepageObject=new HomePage(driver);
		homepageObject.openContactUsPage();
		contactusObject.ContactUs(firstName, email, Enquery);
		Assert.assertTrue(contactusObject.successMessage.getText().contains("Your enquiry has been successfully sent to the store owner"));
				
		
	}

}
