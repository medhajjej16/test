package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddtoCartePage extends PageBase{

	public AddtoCartePage(WebDriver driver) {
		super(driver);
	}
	@FindBy(id = "termsofservice")
	WebElement agreeBtn;
	@FindBy(id = "checkout")
	WebElement checkoutLink;
	@FindBy(css = "div.no-data")
	public WebElement messageempty;
			
	@FindBy(css = "button.remove-btn")
	WebElement removeProduct;
	@FindBy(css = "input.qty-input")
	WebElement QuantitProduct;
	@FindBy(css = "span.product-subtotal")
	public WebElement totalProduct;
	@FindBy(id = "updatecart")
	WebElement updateQuantite;
	
	
		
		public  void UpdateProductQuantity(String quantite){
			clearTxt(QuantitProduct);
			setTextElementText(QuantitProduct, quantite);
			clicbutton(updateQuantite);
		}
		public void RemovUpProduct() {
			clicbutton(removeProduct);
					}
		public void OpenChekoutPage() {
			clicbutton(agreeBtn);
			clicbutton(checkoutLink);
		}
	}
