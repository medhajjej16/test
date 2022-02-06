package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailFriendPage extends PageBase{

	public EmailFriendPage(WebDriver driver) {
		super(driver);

	}
	@FindBy(id = "FriendEmail")
	WebElement  frirndemeailTxt;
	@FindBy(id = "PersonalMessage")
	WebElement persmessaheTxt;
	@FindBy(css = "button.button-1.send-email-a-friend-button")
	WebElement subbemeilbtn;
	@FindBy(css = "div.result")
	public WebElement messageNotification;
	public void sendEmailFriend(String friendemail,String message) {
				setTextElementText(frirndemeailTxt, friendemail);
				setTextElementText(persmessaheTxt, message);
				clicbutton(subbemeilbtn);
	}

}
