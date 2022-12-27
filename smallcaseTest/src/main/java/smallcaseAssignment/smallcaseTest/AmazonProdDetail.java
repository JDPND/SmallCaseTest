package smallcaseAssignment.smallcaseTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonProdDetail {
	WebDriver driver;

	public AmazonProdDetail(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//span[contains(@class,'priceToPay')] //span[@class='a-price-whole']")
	private WebElement priceOfAProd;
	
	@FindBy(css = "#add-to-cart-button")	
	private WebElement addToACartButton;
	
	@FindBy(css = "#nav-cart")
	private WebElement cartPageButton;
	
	@FindBy(css = "#attach-close_sideSheet-link")
	private WebElement crossButton;
	
	public int printPrice() {
		String priceA = priceOfAProd.getText().replaceAll("[^0-9]", "").toString();
		return Integer.parseInt(priceA);
		
	}
	
	public void addItemToCart() {
		addToACartButton.click();
	}
	
	public void cartButton() {
		if(crossButton.isDisplayed()) {
			crossButton.click();
			cartPageButton.click();
		}else
		cartPageButton.click();
	}
	
	
}
