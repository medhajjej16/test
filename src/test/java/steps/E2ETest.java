package steps;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.AddtoCartePage;
import pages.HomePage;
import pages.OrderDetailPage;
import pages.ProductDetailsPage;
import pages.RegistredUserChekoutPage;
import pages.SearchPage;
import pages.UserRegistrationPage;
import tests.TestBase;

public class E2ETest extends TestBase{
	HomePage homeObject;
	UserRegistrationPage registerObject;
	@Given("^user is on Home Page    user registration I entered \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
	public void user_is_on_Home_Page_user_registration_I_entered(String firstname, String lastname, String email, String password) throws InterruptedException {
		homeObject=new HomePage(driver);
		homeObject.OpenRegistrationPage();
		registerObject=new UserRegistrationPage(driver);
		registerObject.UserRegistration(firstname, lastname, email, password);
	}
	String productName="Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	ProductDetailsPage  detailObject;
	@When("^he search for \"([^\"]*)\"$")
	public void he_search_for(String productName) throws InterruptedException {
		searchObject=new SearchPage(driver);
		detailObject=new ProductDetailsPage(driver);
		searchObject.ProductSearch(productName);
		
		
	}

	@When("^choose to buy Two items$")
	public void choose_to_buy_Two_items() throws InterruptedException {
		detailObject.OpenAddtoCarte();
	}
	AddtoCartePage addcarteObject;
	RegistredUserChekoutPage chekoutObject;
	@When("^moves to checkout cart and enter personal details on checkout page and place the order$")
	public void moves_to_checkout_cart_and_enter_personal_details_on_checkout_page_and_place_the_order() throws InterruptedException {
		addcarteObject=new AddtoCartePage(driver);
		addcarteObject.OpenChekoutPage();
		chekoutObject=new RegistredUserChekoutPage(driver);
		chekoutObject.BilingCkeout("United States","AA (Armed Forces Americas)", "cair", "sdvdf", "svdsdv", "111111111111");
		chekoutObject.ContinueLink();
		Assert.assertTrue(chekoutObject.thankymess.isDisplayed());
	}
	OrderDetailPage orderObject;
	@Then("^he can view the order and download the invoice$")
	public void he_can_view_the_order_and_download_the_invoice()  throws InterruptedException{
		chekoutObject.OpenOrderDetail();
	    orderObject=new OrderDetailPage(driver);
	    orderObject.printorder();
	    orderObject.dawnloadprintPdf();
	    registerObject.UserLogOut();
	}	
	
}

	






