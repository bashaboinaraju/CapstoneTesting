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
//    By viewCartBtn = By.xpath("//a[@href='/view_cart']");
    By viewCartBtn = By.xpath("//u[normalize-space()='View Cart']");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
       this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
       this.JS= ((JavascriptExecutor) driver);
    }

    public void hoverAndAddFirstProductToCart() {
//        actions.moveToElement(driver.findElement(firstProduct)).perform();
//        driver.findElement(firstAddToCart).click();
    	 WebElement product = driver.findElement(firstProduct);
    	    actions.moveToElement(product).perform();

    	    WebElement addToCartBtn = driver.findElement(firstAddToCart);
    	    
    	    wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn));

    	    JS.executeScript("arguments[0].click();", addToCartBtn);
    }

//    public void hoverAndAddSecondProductToCart() throws InterruptedException {
//        // Find the product container and scroll into view
//        WebElement product = driver.findElement(secondProduct);
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", product);
//        Thread.sleep(500); // let UI stabilize
//
//        // Hover over product to reveal 'Add to Cart'
//        actions.moveToElement(product).perform();
//
//        // Find the actual 'Add to Cart' button
//        WebElement addToCartBtn = driver.findElement(secondAddToCart);
//
//        // Wait until it's visible AND clickable
//        wait.until(ExpectedConditions.visibilityOf(addToCartBtn));
//        wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn));
//
//        // Check if the element is overlapped (optional safeguard)
//        if (!addToCartBtn.isDisplayed() || !addToCartBtn.isEnabled()) {
//            System.out.println("Add to Cart button not interactable");
//        }
//
//        // Try clicking via JavaScript to avoid hidden overlays
//        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addToCartBtn);
//    }





    public void clickContinueShopping() {
        driver.findElement(continueShoppingBtn).click();
    }

    public void clickViewCart() {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//        // Wait until modal is no longer visible
//        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("cartModal")));
//
//        WebElement viewCartBtn = driver.findElement(By.xpath("//a[@href='/view_cart']"));
//        wait.until(ExpectedConditions.elementToBeClickable(viewCartBtn));
    	driver.findElement(viewCartBtn).click();
        // or use JS click if still blocked
//         ((JavascriptExecutor) driver).executeScript("arguments[0].click();", viewCartBtn);
    }

}
