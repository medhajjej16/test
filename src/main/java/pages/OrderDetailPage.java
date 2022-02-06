package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderDetailPage extends PageBase{

	public OrderDetailPage(WebDriver driver) {
		super(driver);

	}
	@FindBy(css = "a.button-2.print-order-button")
	WebElement orderdetBtn;
	@FindBy(css = "a.button-2.pdf-invoice-button")
	WebElement pdfprnter;
	public void printorder() {
		clicbutton(orderdetBtn);
	}
	public void dawnloadprintPdf() throws InterruptedException
	{
		clicbutton(pdfprnter);
		Thread.sleep(2000);
	}
}
