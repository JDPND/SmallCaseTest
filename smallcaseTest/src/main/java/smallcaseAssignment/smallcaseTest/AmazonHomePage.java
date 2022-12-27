package smallcaseAssignment.smallcaseTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonHomePage {
		
	WebDriver driver;
	
	public AmazonHomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	} 
	
	@FindBy(css="#twotabsearchtextbox")
	WebElement AsearchField;
	
	@FindBy(css = "#nav-search-submit-button")
	WebElement AseachButton;
	
	
	public void loginApplication(String AproductName)
	{
		
		AsearchField.sendKeys(AproductName);
		AseachButton.click();
		
	}
	
}
