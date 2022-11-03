package rahulShettyQaClass.pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulShettyQaClass.AbstractComponents.AbstractComponent;

public class CheckOutPage extends AbstractComponent {
	WebDriver driver;
	public CheckOutPage(WebDriver driver) {				// Constructor of Class
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}

	@FindBy(xpath="(//input[@type='text'])[5]")
	WebElement userEmail;
	
	@FindBy(xpath="//input[@placeholder='Select Country']")
	WebElement selectCountry;
	
	@FindBy(xpath="(//button[@type='button'])[2]")
	WebElement confirmCountry;

	@FindBy(xpath="(//input[@class='input txt'])[1]")
	WebElement cvvNumber;
	
	@FindBy(xpath="(//input[@class='input txt'])[2]")
	WebElement cardName;
	
	@FindBy(xpath="(//a[contains(@class,action__submit)])[2]")
	WebElement placeOrderButton;
	
	public void Email(String email) throws InterruptedException {
		userEmail.sendKeys(email);;
		userEmail.clear();
		Thread.sleep(1000);
	}
	public void Country(String country) {
		selectCountry.sendKeys(country);
		selectCountry.sendKeys(Keys.ARROW_DOWN.ENTER);
		confirmCountry.click();
	}
	public void Cvv(String cvv) {
		cvvNumber.sendKeys(cvv);
	}
	public void cardHolderName(String nameOnCard) {
		cardName.sendKeys(nameOnCard);
	}
	public void PlaceOrder() throws InterruptedException {
		javaScriptExecutor();
		Thread.sleep(5000);					// This Element is taking long time to load so longTimeout is given
		WebElement placeOrder = placeOrderButton;
		placeOrder.click();
	}
}
