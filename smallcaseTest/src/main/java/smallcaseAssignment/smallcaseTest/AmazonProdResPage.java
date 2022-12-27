package smallcaseAssignment.smallcaseTest;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonProdResPage {

	    WebDriver driver;
	    String namesOfProds;

	public AmazonProdResPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[@class='a-size-medium a-color-base a-text-normal']")
	List<WebElement> productList;
	

		
	public void clickProduct(String nameOfAProd) {
		for(int i = 0; i <= productList.size() - 1; i++) {
			namesOfProds = productList.get(i).getText();
			
			if(namesOfProds.contains(nameOfAProd)) {
				productList.get(i).click();
				break;
			}
		}
	}
}
