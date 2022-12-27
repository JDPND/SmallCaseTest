package smallcaseAssignment.smallcaseTest.reusableComponents;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReusableComponents {
		
	WebDriver driver;
	
	public ReusableComponents(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void waitForElementToBeClickable(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
	
	public boolean retryingFindClick(WebElement ele) {
	    boolean result = false;
	    int attempts = 0;
	    while(attempts < 2) {
	        try {
	            ele.click();
	            result = true;
	            break;
	        } catch(NoSuchElementException e) {
	        }
	        attempts++;
	    }
	    return result;
	}
	
}
