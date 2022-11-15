package rahulShetty.TestComponents;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulShettyQaClass.pageObjects.LoginPage;

public class BaseTest {
	public WebDriver driver;
	public LoginPage landingPage;
	
	public WebDriver initiallizeDriver() throws IOException {
		
	Properties prop = new Properties();
	FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\rahulShettyQaClass\\resources\\GlobalData.properties");
	prop.load(fis);	
	String BrowserName = prop.getProperty("browser");
	
	WebDriverManager.chromedriver().setup();	// WebDriverManager is a Dependency which we have to add in POM file.  
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().window().maximize();
	return driver;
	}
	
	@BeforeMethod(alwaysRun=true)
	public LoginPage launchApplication() throws IOException {
		driver = initiallizeDriver();
		landingPage = new LoginPage(driver);
		landingPage.goTo();
		return landingPage;
	}
	
	@AfterMethod(alwaysRun=true)
	public void close() {
		driver.close();
	}
}
