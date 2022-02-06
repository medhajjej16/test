package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


public class HomePage extends PageBase{

	public HomePage(WebDriver driver) {
		super(driver);
		jse= (JavascriptExecutor) driver;
		action = new Actions(driver); 

	}
	@FindBy(id = "customerCurrency")
	WebElement   CurrecnychanTxt;
	@FindBy(linkText ="Contact us")
	WebElement BtnContactUs;
	@FindBy(xpath = "/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a")
	WebElement registerLink;
	@FindBy(xpath = "/html/body/div[6]/div[2]/ul[1]/li[1]/a")
	WebElement ComputerMenu;
	@FindBy(xpath = "/html/body/div[6]/div[2]/ul[1]/li[1]/ul/li[2]/a")
	WebElement NotbooksMenu;
	public void OpenRegistrationPage() {

		clicbutton(registerLink);
	}

	@FindBy(linkText = "Log in")
	WebElement loginLink;

	public void openLoginPage() {
		clicbutton(loginLink);
	}
	public void openContactUsPage()
	{
		ScrollBott();
		clicbutton(BtnContactUs);
	}
	public void changeCurrency() {
		select=new Select(CurrecnychanTxt);
		select.selectByVisibleText("Euro");
	}
	public void selectNotebooksMenu() 
	{
		action.moveToElement(ComputerMenu).moveToElement(NotbooksMenu).click().build().perform();
	}

}
