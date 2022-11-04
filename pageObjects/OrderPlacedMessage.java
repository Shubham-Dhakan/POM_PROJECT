package rahulShettyQaClass.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPlacedMessage {
	WebDriver driver;
		public OrderPlacedMessage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		@FindBy(xpath="//h1[text()=' Thankyou for the order. ']")
		WebElement OrderPlacedText;
		
	public String getOrderText() {
	    return OrderPlacedText.getText();
	 }
}
