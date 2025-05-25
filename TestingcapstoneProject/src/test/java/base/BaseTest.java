package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import pages.LoginPage;
import pages.ProductsPage;
import pages.RegisterPage;
import pages.SignupPage;
import pages.AccountPage;
import pages.CartPage;
import pages.HomePage;
import utils.Helper;

public class BaseTest {
	public LoginPage login;
	public ProductsPage productpage ;
	public RegisterPage register;
	public SignupPage signup;
	public  HomePage home;
   public	AccountPage account;
   public CartPage cart;
	 
    public WebDriver driver;
    public static WebDriverWait wait;
    public Properties prop;
    public Logger log = Logger.getLogger(BaseTest.class);


    @BeforeSuite
    public void loadConfig() throws IOException {
        prop = new Properties();
        FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
        prop.load(fis);
    }

    @BeforeMethod
    public void setup() {
    	
    	wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        String browser = prop.getProperty("browser");
        boolean headless = Boolean.parseBoolean(prop.getProperty("headless"));
        log.info("Launching browser: " + browser);
        
        
        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            if (headless) options.addArguments("--headless=new");
            driver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("edge")) {
            EdgeOptions options = new EdgeOptions();
            if (headless) options.addArguments("--headless=new");
            driver = new EdgeDriver(options);
        }

        
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get(prop.getProperty("baseUrl"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        log.info("Browser launched with URL: " + prop.getProperty("baseUrl"));
        
    	
        // Create a page objects
       
        login = new LoginPage(driver);
        productpage = new ProductsPage(driver);
        register = new RegisterPage(driver);
        signup = new SignupPage(driver);
         home = new HomePage(driver);
         account = new AccountPage(driver);
          cart = new CartPage(driver);
    }

    
    @AfterMethod
    public void tearDown(ITestResult result) {
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    	
        if (ITestResult.FAILURE == result.getStatus()) {
            Helper.captureScreenshot(driver, result.getName());
            log.error("Test failed. Screenshot captured.");
        }
        driver.quit();
    }
}
