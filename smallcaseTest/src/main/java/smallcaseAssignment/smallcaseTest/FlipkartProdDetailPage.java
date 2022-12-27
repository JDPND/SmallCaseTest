package smallcaseAssignment.smallcaseTest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import smallcaseAssignment.smallcaseTest.reusableComponents.*;

public class FlipkartProdDetailPage extends ReusableComponents {
	
	WebDriver driver;

	public FlipkartProdDetailPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}
	
	@FindBy(css = "._30jeq3._16Jk6d")
	private WebElement priceOfProd;
	
	@FindBy(css = "._2KpZ6l._2U9uOA._3v1-ww")
	private WebElement addToCartButton;
	
	@FindBy(css = "#pincodeInputId")
	private WebElement pinCodeField;
	
	@FindBy(css = "._2P_LDn")
	private WebElement changePinButton;
	
	@FindBy(css = ".B_NuCI")
	private WebElement titleOfProd;
	
	public void enterPincode(String pin) {
		pinCodeField.sendKeys(pin);
		changePinButton.click();
	}
	public String printPrice() {
		return priceOfProd.getText().replaceAll("[^0-9]", "").toString();
	}
	
	public String prodTitle() {
		return titleOfProd.getText();
	}
	
	public FlipkartCartPage addItemToCart() {
		retryingFindClick(addToCartButton);
		addToCartButton.click();
	    FlipkartCartPage fCartPage = new FlipkartCartPage(driver);
	    return fCartPage;
	}

}
