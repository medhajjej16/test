package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageBase{

	
	public MyAccountPage(WebDriver driver) {
		super(driver);
		
	}
@FindBy(linkText = "Change password")
WebElement changePasswordLink;
@FindBy(id = "OldPassword")
WebElement oldPasswordTxt;
@FindBy(id = "NewPassword")
WebElement newPasswordTxt;
@FindBy(id = "ConfirmNewPassword")
WebElement confiremPasswordTxt;
@FindBy(css = "button.button-1.change-password-button")
WebElement changePassswordBtn;
@FindBy(xpath = "//*[@id=\"bar-notification\"]/div/p")
public WebElement resultlbl;
@FindBy(css = "span.close")
public WebElement closeBtnVert;

public void openchangePasswordPage(){
	clicbutton(changePasswordLink);
}
public void changePassword(String oldpassword, String newpassword) {
	setTextElementText(oldPasswordTxt,oldpassword);
	setTextElementText(newPasswordTxt, newpassword);
	setTextElementText(confiremPasswordTxt, newpassword);
	clicbutton(changePassswordBtn);
}

public void CloseBtnV()
{
	clicbutton(closeBtnVert);
}
}
