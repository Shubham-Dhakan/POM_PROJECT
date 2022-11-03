package rahulShettyQaClass.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CartPage {
	WebDriver driver;
	public CartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//button[@routerlink='/dashboard/cart']")
	WebElement cartPageButton;
	
	@FindBy(xpath="//div[@class='cartSection']/h3")
	List <WebElement> cartPageProducts;
	
	@FindBy(xpath="(//button[@type='button'])[2]")
	WebElement checkOutButton;
	
	public void goToCartPage(String product) {
		WebElement button = cartPageButton;
		button.click();
		
		List <WebElement> cartProducts = cartPageProducts;
		Boolean match = cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equals(product));  
		Assert.assertTrue(match);
		
	}
	
	public void goToCheckOut() {
		WebElement checkOutPage = checkOutButton;
		checkOutPage.click();
	} 

}
