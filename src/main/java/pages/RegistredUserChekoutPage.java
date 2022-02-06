package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


public class RegistredUserChekoutPage extends PageBase{

	public RegistredUserChekoutPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(id = "BillingNewAddress_FirstName")
	WebElement firsnameTxt;
	@FindBy(id = "BillingNewAddress_LastName")
	WebElement lastnameTxt;
	@FindBy(id = "BillingNewAddress_Email")
	WebElement emailTxt;
	@FindBy(id = "BillingNewAddress_CountryId")
	WebElement selectcountryListe;
	@FindBy(id = "BillingNewAddress_City")
	WebElement cityText;
	@FindBy(id = "BillingNewAddress_Address1")
	WebElement adresseoneTxt;
	@FindBy(id = "BillingNewAddress_ZipPostalCode")
	WebElement codepostalText;
	@FindBy(id = "BillingNewAddress_PhoneNumber")
	WebElement phonenumber;
	@FindBy(css = "button.button-1.new-address-next-step-button")
	WebElement continueLink;
	@FindBy(xpath = "//*[@id=\"shipping-method-buttons-container\"]/button")
	WebElement clicontinutwo;
	@FindBy(css = "button.button-1.payment-method-next-step-button")
	WebElement clicontinueThree;
	@FindBy(css = "button.button-1.payment-info-next-step-button")
	WebElement clcontinueconf;
	@FindBy(linkText = "Apple MacBook Pro 13-inch")
	public WebElement productname;
	@FindBy(css = "button.button-1.confirm-order-next-step-button")
	WebElement confirmelink;
	@FindBy(css = "div.page-title")
	public WebElement  thankymess;
	@FindBy(linkText = "Click here for order details.")
	WebElement orderdetail;
	@FindBy(css = "button.button-1.order-completed-continue-button")
	WebElement contnueOut;
	@FindBy(id = "BillingNewAddress_StateProvinceId")
	WebElement provincestate;

	public void BilingCkeout(String countryname,String provincestat,String city,String adresse,String codepostal,String phone) {
		setTextElementText(cityText, city);
		setTextElementText(adresseoneTxt, adresse);
		setTextElementText(codepostalText, codepostal);
		setTextElementText(phonenumber, phone);
		select =new Select(selectcountryListe);
		select.selectByVisibleText(countryname);
		select =new Select(provincestate);
		select.selectByVisibleText(provincestat);


	}
	public void ContinueLink(){
		clicbutton(continueLink);
		clicbutton(clicontinutwo);
		clicbutton(clicontinueThree);
		clicbutton(clcontinueconf);			
		clicbutton(confirmelink);

	}
	public void OpenOrderDetail() {
		clicbutton(orderdetail);
	}
	public void logoutt() {
		clicbutton(contnueOut);
	}

}


