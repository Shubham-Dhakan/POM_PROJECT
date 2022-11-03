package rahulShettyQaClass.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class OrderPlacedMessage {
	WebDriver driver;
		public OrderPlacedMessage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		
}
