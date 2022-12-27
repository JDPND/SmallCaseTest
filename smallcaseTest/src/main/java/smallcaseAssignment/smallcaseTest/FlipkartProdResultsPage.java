package smallcaseAssignment.smallcaseTest;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class FlipkartProdResultsPage {

	    WebDriver driver;

	public FlipkartProdResultsPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@FindBy(xpath = "//div[@class='_13oc-S'] //div[@data-id]")
	private List<WebElement> productList;
	
		
	public FlipkartProdDetailPage clickProduct(int prodIndex) {
		if(productList.size() != 0) {
			productList.get(prodIndex).click();
		}
		FlipkartProdDetailPage FProdDetailPage = new FlipkartProdDetailPage(driver);
		return FProdDetailPage;
	}

}