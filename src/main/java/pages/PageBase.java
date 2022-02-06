package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageBase {

	protected WebDriver driver;
	public  JavascriptExecutor jse;
	public Select select;
	public Actions action ; 

	public PageBase(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	protected static void clicbutton(WebElement button) {
		button.click();

	}
	protected static void setTextElementText(WebElement textelemnt,String value) {
		textelemnt.sendKeys(value);
	}
	public void ScrollBott() {
		jse.executeScript("scrollBy(0,2500)");

	}
	public void clearTxt(WebElement  elements) {
		elements.clear();
	}
	
}