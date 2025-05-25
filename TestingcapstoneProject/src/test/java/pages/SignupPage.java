package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignupPage {
    WebDriver driver;

    By newUserSignupText = By.xpath("//h2[text()='New User Signup!']");
    By nameField = By.name("name");
    By emailField = By.xpath("//input[@data-qa='signup-email']");
    By signupButton = By.xpath("//button[text()='Signup']");

    public SignupPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isNewUserSignupVisible() {
        return driver.findElement(newUserSignupText).isDisplayed();
    }

    public void enterNameAndEmail(String name, String email) {
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(emailField).sendKeys(email);
    }

    public void clickSignupButton() {
        driver.findElement(signupButton).click();
    }
}
