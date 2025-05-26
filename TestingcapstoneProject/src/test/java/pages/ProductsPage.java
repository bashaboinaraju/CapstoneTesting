package pages;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsPage {
    WebDriver driver;
    Actions actions;
    WebDriverWait wait;
    JavascriptExecutor JS;
    By firstProduct = By.xpath("(//div[@class='productinfo text-center'])[1]");
    By secondProduct = By.xpath("(//div[@class='productinfo text-center'])[2]");
    By firstAddToCart = By.xpath("(//a[@data-product-id])[1]");
    By secondAddToCart = By.xpath("(//a[@data-product-id])[2]");
    By continueShoppingBtn = By.xpath("//button[text()='Continue Shopping']");
    By viewCartBtn = By.xpath("//u[normalize-space()='View Cart']");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
       this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
       this.JS= ((JavascriptExecutor) driver);
    }

    public void hoverAndAddFirstProductToCart() {
    	 WebElement product = driver.findElement(firstProduct);
    	    actions.moveToElement(product).perform();

    	    WebElement addToCartBtn = driver.findElement(firstAddToCart);
    	    
    	    wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn));

    	    JS.executeScript("arguments[0].click();", addToCartBtn);
    }
public void clickContinueShopping() {
        driver.findElement(continueShoppingBtn).click();
    }

    public void clickViewCart() {

    	driver.findElement(viewCartBtn).click();
       
    }

}
