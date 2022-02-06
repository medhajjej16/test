package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddReviewPage extends PageBase {

	public AddReviewPage(WebDriver driver) {
		super(driver);
			}
@FindBy(id = "AddProductReview_Title")
WebElement titlereviewText;
@FindBy(id = "AddProductReview_ReviewText")
WebElement addProdrevText;
@FindBy(id  ="addproductrating_4")
WebElement rediochoiBtn;
@FindBy(css = "button.button-1.write-product-review-button")
WebElement subRevBtn;
@FindBy(css = "div.result")
public WebElement succsesMessaReview;
public void AddReiwProdut(String title, String messrevie) {
	setTextElementText(titlereviewText, title);
	setTextElementText(addProdrevText, messrevie);
	clicbutton(rediochoiBtn);
	clicbutton(subRevBtn);
}
}
