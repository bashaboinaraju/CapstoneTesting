package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AccountPage {
    WebDriver driver;

    By enterAccountInfo = By.xpath("//b[text()='Enter Account Information']");
    By titleMr = By.id("id_gender1");
    By password = By.id("password");
    By days = By.id("days");
    By months = By.id("months");
    By years = By.id("years");
    By newsletter = By.id("newsletter");
    By offers = By.id("optin");
    By firstName = By.id("first_name");
    By lastName = By.id("last_name");
    By company = By.id("company");
    By address1 = By.id("address1");
    By address2 = By.id("address2");
    By country = By.id("country");
    By state = By.id("state");
    By city = By.id("city");
    By zipcode = By.id("zipcode");
    By mobile = By.id("mobile_number");
    By createAccountBtn = By.xpath("//button[text()='Create Account']");
    By accountCreatedText = By.xpath("//b[text()='Account Created!']");
    By continueBtn = By.xpath("//a[text()='Continue']");
    By loggedInAs = By.xpath("//a[contains(text(),'Logged in as')]");
    By deleteAccountBtn = By.xpath("//a[text()='Delete Account']");
    By accountDeletedText = By.xpath("//b[text()='Account Deleted!']");

    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isEnterAccountInfoVisible() {
        return driver.findElement(enterAccountInfo).isDisplayed();
    }

    public void fillAccountDetails() {
        driver.findElement(titleMr).click();
        driver.findElement(password).sendKeys("Test@123");

        new Select(driver.findElement(days)).selectByVisibleText("1");
        new Select(driver.findElement(months)).selectByVisibleText("January");
        new Select(driver.findElement(years)).selectByVisibleText("2000");

        driver.findElement(newsletter).click();
        driver.findElement(offers).click();

        driver.findElement(firstName).sendKeys("Bashaboina");
        driver.findElement(lastName).sendKeys("raju");
        driver.findElement(company).sendKeys("werg");
        driver.findElement(address1).sendKeys("wef");
        driver.findElement(address2).sendKeys("hgfdsa");
        new Select(driver.findElement(country)).selectByVisibleText("India");
        driver.findElement(state).sendKeys("banglore");
        driver.findElement(city).sendKeys("bangalore");
        driver.findElement(zipcode).sendKeys("2345");
        driver.findElement(mobile).sendKeys("1234567890");
    }

    public void clickCreateAccount() {
        driver.findElement(createAccountBtn).click();
    }

    public boolean isAccountCreatedVisible() {
        return driver.findElement(accountCreatedText).isDisplayed();
    }

    public void clickContinue() {
        driver.findElement(continueBtn).click();
    }

    public boolean isLoggedInAsVisible() {
        return driver.findElement(loggedInAs).isDisplayed();
    }


}
