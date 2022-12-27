package smallcaseAssignment.smallcaseTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonCartPage {
	
	WebDriver driver;

	public AmazonCartPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css = "#sc-subtotal-amount-activecart")
	WebElement finalpriceOfProd;
	
	public int finalPriceOfAProd() {
		String[] price = finalpriceOfProd.getText().trim().split("\\.");
		return Integer.parseInt(price[0].replaceAll("[^0-9]", "").toString());
	}
	
}
