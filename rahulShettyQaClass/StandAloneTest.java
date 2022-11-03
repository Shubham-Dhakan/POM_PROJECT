package rahulShettyQaClass;

import java.time.Duration;
import java.util.*;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import static org.openqa.selenium.support.locators.RelativeLocator.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import rahulShettyQaClass.pageObjects.CartPage;
import rahulShettyQaClass.pageObjects.CheckOutPage;
import rahulShettyQaClass.pageObjects.LoginPage;
import rahulShettyQaClass.pageObjects.ProductCatalogue;


public class StandAloneTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();	// WebDriverManager is a Dependency which we have to add in POM file.  
		WebDriver driver = new ChromeDriver();

		String product = "IPHONE 13 PRO";
		LoginPage login = new LoginPage(driver);	// Sending chromeDriver Instance in another Class by passing that instance in arguments  
		login.goTo();														// Login Page
		login.loginApplication("kr3608149@gmail.com","FordMustang@12");		// Username, Password
		ProductCatalogue catalogue = new ProductCatalogue(driver);			// Product Page
		List<WebElement> productsList = catalogue.listOfProducts();		
		catalogue.addProductToCart(product);
		CartPage cartClassObject = new CartPage(driver);
		cartClassObject.goToCartPage(product);
		cartClassObject.goToCheckOut();
		CheckOutPage checkOutPageObject = new CheckOutPage(driver);
		checkOutPageObject.Email("abc@gmail.com");
		checkOutPageObject.Country("India");
		checkOutPageObject.Cvv("555");
		checkOutPageObject.cardHolderName("xyz");
		checkOutPageObject.PlaceOrder();
		}

}
