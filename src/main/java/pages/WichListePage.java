package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WichListePage extends PageBase{

	public WichListePage(WebDriver driver) {
		super(driver);

	}
	@FindBy(css = "div.no-data")
	public WebElement result;
	@FindBy(linkText = "Apple MacBook Pro 13-inch")
	public WebElement verifwichliste;
	@FindBy(css = "button.remove-btn")
	WebElement removeBtn;
	public void RemovewichList() {
		clicbutton(removeBtn);
	}
}
