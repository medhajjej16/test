package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddComparePage extends PageBase{

	public AddComparePage(WebDriver driver) {
		super(driver);
	}
	@FindBy(css = "div.no-data")
	public WebElement noData;
	@FindBy(css = "a.clear-list")
	WebElement  ClearlistBtn;
	@FindBy(css = "table.compare-products-table")
	WebElement tableCompareProd;
	@FindBy(tagName = "tr")
	public List<WebElement>  allRow;
	@FindBy(tagName = "td")
	public List<WebElement> allCol;

	public  void clearListe() {
		clicbutton(ClearlistBtn);
	}
	public void afficheCompareListe() {
		System.out.println(allRow.size());

		for(WebElement row:allRow) {
			System.out.println(row.getText() +"\t");
			for(WebElement col:allCol) {
				System.out.println(col.getText() +"\t");
			}
		}
	}

}