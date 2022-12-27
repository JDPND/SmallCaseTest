package smallcaseAssignment.smallcaseTest;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;


public class scenarioTwo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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
		fProdDetailPage.enterPincode("500072");
		
		Thread.sleep(2000);
		FlipkartCartPage fCartPage = fProdDetailPage.addItemToCart();
		System.out.println("Final Price of the Product: " + fCartPage.finalPrice());
		int flipPrice = fCartPage.finalPrice();

		driver.get("https://www.amazon.in");

		AmazonHomePage AhomePage = new AmazonHomePage(driver);
		AhomePage.loginApplication("macbook air");

		AmazonProdResPage AProdResults = new AmazonProdResPage(driver);
		Thread.sleep(2000);
		AProdResults.clickProduct("Apple M1 chip");

		Thread.sleep(1000);
		AmazonProdDetail AProdDetail = new AmazonProdDetail(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		while (iterator.hasNext()) {
			String ChildWindow = iterator.next();
			if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
				driver.switchTo().window(ChildWindow);
			}
		}
		
		Thread.sleep(2000);
		System.out.println("Price of Amazon Product: " + AProdDetail.printPrice());
		AProdDetail.addItemToCart();
		AProdDetail.cartButton();

		AmazonCartPage ACartPage = new AmazonCartPage(driver);
		System.out.println("Final Price of Amazon product: " + ACartPage.finalPriceOfAProd());
		int AmazonPrice = ACartPage.finalPriceOfAProd();
		System.out.println(Math.min(flipPrice, AmazonPrice));
		driver.quit();
	}

}
