package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegistrationPage extends PageBase{

	public UserRegistrationPage(WebDriver driver) {
		super(driver);

	}
	@FindBy(id = "gender-male")
	WebElement genderRadioButton;
	@FindBy(id = "FirstName")
	WebElement fntxBox;
	@FindBy(id = "LastName")
	WebElement lntxBox;
	@FindBy(id = "Email")
	WebElement emailTextBox;
	@FindBy(id = "Password")
	WebElement passwordTxtBox;
	@FindBy(id = "ConfirmPassword")
	WebElement confirmeTxtPassword;
	@FindBy(id = "register-button")
	WebElement registreBtn;
	@FindBy(css = "div.result")
	public WebElement successMessage;
	@FindBy(xpath = "/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a")
	public WebElement logoutLink;
	@FindBy(linkText = "My account")
	public WebElement MyaccountLink;
	

	public void UserRegistration(String firstName,String lastName,String email,String password)
	{
		clicbutton(genderRadioButton);	
		setTextElementText(fntxBox, firstName);
		setTextElementText(lntxBox, lastName);
		setTextElementText(emailTextBox, email);
		setTextElementText(passwordTxtBox, password);
		setTextElementText(confirmeTxtPassword, password);
		clicbutton(registreBtn);
	}

public void UserLogOut() {
clicbutton(logoutLink);
}
public void openMyAccountPage() {
	clicbutton(MyaccountLink);
}
}
