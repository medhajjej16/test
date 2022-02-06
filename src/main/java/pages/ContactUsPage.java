package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends PageBase{

	public ContactUsPage(WebDriver driver) {
		super(driver);	
	}
	@FindBy(id = "FullName")
	WebElement fullnametxtBox;
	@FindBy(id = "Email")
	WebElement emailcTxtBox;
	@FindBy(id = "Enquiry")
	WebElement Enquirytxtbox;
	@FindBy(css = "button.button-1.contact-us-button")
	WebElement subbbmitBtn;
	@FindBy(css = "div.result")
	public WebElement successMessage;
	public void ContactUs(String fullName,String Email,String Enquery) {
		setTextElementText(fullnametxtBox, fullName);
		setTextElementText(emailcTxtBox, Email);
		setTextElementText(Enquirytxtbox,Enquery);
		clicbutton(subbbmitBtn);
	}
}
