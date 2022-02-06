package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends PageBase{

	public ProductDetailsPage(WebDriver driver) {
		super(driver);

	}
	@FindBy(xpath = "//*[@id=\"bar-notification\"]/div/p/a")
	public WebElement shoppincarteLink;
	@FindBy(xpath = "//*[@id=\"add-to-cart-button-4\"]")
	public WebElement addtcarteLink;
	@FindBy(css = "button.button-2.add-to-compare-list-button")
	WebElement addcomareLink;
	@FindBy(linkText = "product comparison")
	WebElement linkprodcomparison;
	@FindBy(id = "add-to-wishlist-button-4")
	public WebElement clAddwichlistLink;
	@FindBy(linkText = "wishlist")
	public WebElement wishlistLink;
	@FindBy(xpath = "//*[@id=\"product-details-form\"]/div[2]/div[1]/div[2]/div[3]/div[2]/a[2]")
	public WebElement cliaddrevieLink;
	@FindBy(id = "price-value-4")
	public WebElement veififycurrencyTxt;
	@FindBy(css = "div.product-name")
	public WebElement ProductNameBeradcrumb;
	@FindBy(css = "button.button-2.email-a-friend-button")
	WebElement cliemailefriend;
	public void openClicEmailfriend() {
		clicbutton(cliemailefriend);
	}
	public void openAddReviev() {
		clicbutton(cliaddrevieLink);
	}
	public void openAddWichList() {
		clicbutton(clAddwichlistLink);
		clicbutton(wishlistLink);
	}
	public void OpenproductComparison() {
		clicbutton(addcomareLink);
		clicbutton(linkprodcomparison);
	}
	public void OpenAddtoCarte() {
		clicbutton(addtcarteLink);
		clicbutton(shoppincarteLink);
	}
}