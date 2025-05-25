package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class RegisterPage {
	WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    By nameInput = By.xpath("//input[@data-qa='signup-name']");
    By emailInput = By.xpath("//input[@data-qa='signup-email']");
    By signupBtn = By.xpath("//button[@data-qa='signup-button']");
    
    public void fillSignupForm(String name, String email) {
        driver.findElement(nameInput).sendKeys(name);
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(signupBtn).click();
    }
    

    public boolean isAccountInfoPageDisplayed() {
        return driver.getPageSource().contains("Enter Account Information");
    }

}
