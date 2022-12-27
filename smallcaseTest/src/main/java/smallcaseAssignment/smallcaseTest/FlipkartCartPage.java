package smallcaseAssignment.smallcaseTest;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlipkartCartPage {
WebDriver driver;
	
	public FlipkartCartPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		
	}
	@FindBy(xpath = "//button[contains(.,'+')]") //div[@class='_26HdzL'] /following-sibling::button 
	private WebElement incQuantitybutton;
	
	@FindBy(xpath = "//div[@class='Ob17DV _3X7Jj1'] //span")
	private WebElement finalPrice;
	
	public void increaseQuantity() {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", incQuantitybutton);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(incQuantitybutton)).click();
	}
	
	public int finalPrice() {
		
		return Integer.parseInt(finalPrice.getText().replaceAll("[^0-9]", "").toString());
	}
}
