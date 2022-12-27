package smallcaseAssignment.smallcaseTest;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class assignmentTest {


	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.flipkart.com/");
		
		FlipkartHomePage homePage = new FlipkartHomePage(driver);
		
		FlipkartProdResultsPage selectProduct = homePage.loginApplication("macbook air");
		FlipkartProdDetailPage fProdDetailPage = selectProduct.clickProduct(0);
		
		String mainWindowHandle = driver.getWindowHandle();
		Set<String> allWindowHandles = driver.getWindowHandles();
		Iterator<String> iterator = allWindowHandles.iterator();
		while (iterator.hasNext()) {
			String ChildWindow = iterator.next();
			if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
				driver.switchTo().window(ChildWindow);
			}
		}
		
		System.out.println("Price Of the Product: " + fProdDetailPage.printPrice());
		String nameOfProd = fProdDetailPage.prodTitle();
		System.out.println("Name of the Product: " + nameOfProd);
		Thread.sleep(2000);
		fProdDetailPage.enterPincode("500072");
		
		
		FlipkartCartPage fCP = fProdDetailPage.addItemToCart();
		fCP.increaseQuantity();
		Thread.sleep(2000);
		System.out.println("Final Price of the Product: " + fCP.finalPrice());
		driver.quit();
	}

}
