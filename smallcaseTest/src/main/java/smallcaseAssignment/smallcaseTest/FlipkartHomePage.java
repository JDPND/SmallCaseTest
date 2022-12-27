package smallcaseAssignment.smallcaseTest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlipkartHomePage {

	WebDriver driver;
	
	public FlipkartHomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	@FindBy(css="._2KpZ6l._2doB4z")
	private WebElement closeLoginPrompt;
	
	@FindBy(css="._3704LK")
	private WebElement searchField;
	
	@FindBy(css = ".L0Z3Pu")
	private WebElement seachButton;
	
	
	public FlipkartProdResultsPage loginApplication(String productName)
	{
		closeLoginPrompt.click();
		searchField.sendKeys(productName);
		seachButton.click();
		FlipkartProdResultsPage selectProduct = new FlipkartProdResultsPage(driver);
		return selectProduct;
		
	}
	
}
