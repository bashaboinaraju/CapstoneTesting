package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;
    By loginHeader = By.xpath("//h2[text()='Login to your account']");
    By emailField = By.xpath("//input[@data-qa='login-email']");
    By passwordField = By.xpath("//input[@data-qa='login-password']");
    By loginBtn = By.xpath("//button[@data-qa='login-button']");
    By logoutBtn = By.xpath("//a[text()=' Logout']");
    By loggedInAs = By.xpath("//a[contains(text(),'Logged in as')]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isLoginHeaderVisible() {
        return driver.findElement(loginHeader).isDisplayed();
    }
    public void login(String email, String password) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginBtn).click();
    }

    public boolean isLoggedInAsVisible() {
        return driver.findElement(loggedInAs).isDisplayed();
    }

    public void logout() {
        driver.findElement(logoutBtn).click();
    }

    public boolean isLoginPageVisible() {
        return driver.getCurrentUrl().contains("login");
    }
    
   
}

