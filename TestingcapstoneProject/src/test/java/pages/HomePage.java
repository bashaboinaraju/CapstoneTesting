package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;
    By signupLoginBtn = By.xpath("//a[contains(text(),'Signup / Login')]");
    By productsBtn = By.xpath("//a[@href='/products']");
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isHomeVisible() {
        return driver.findElement(By.xpath("//body")).isDisplayed();
    }

    public void clickSignupLogin() {
        driver.findElement(signupLoginBtn).click();
    }
    public void clickProducts() {
        driver.findElement(productsBtn).click();
    }
}
