package tests;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import utils.Helper;

public class SpecialTests extends BaseTest {

    @Test
    public void testClickUsingJS() throws InterruptedException {
    	
        WebElement contactLink = driver.findElement(By.xpath("//a[contains(text(),'Contact us')]"));
        Helper.ClickOnElementUsingJS(driver, contactLink);
        log.info("clicked on  contacts button");
        Thread.sleep(4000);
        Assert.assertTrue(driver.getTitle().contains("Automation Exercise"));
        log.info("testcase testClickUsingJS passed");
    }

    @Test
    public void CaptureScreenshot() throws InterruptedException {
        Helper.captureScreenshot(driver, "HomePage");
        log.info("Captured Homepage Screenshot");
        Thread.sleep(2000);
    }



    @Test
    public void testHoverAction() throws InterruptedException {

    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement product = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//div[@class='product-overlay']")));
        
        Actions action = new Actions(driver);
        Thread.sleep(2000);
        action.moveToElement(product).perform();
        Thread.sleep(2000);
        WebElement addToCartBtn = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//a[contains(text(),'Add to cart')]")));
        Thread.sleep(2000);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addToCartBtn);
        Thread.sleep(2000);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addToCartBtn);
        Thread.sleep(2000);
        By viewCartBtn = By.xpath("//u[normalize-space()='View Cart']");
        driver.findElement(viewCartBtn).click();
        Thread.sleep(2000);
        log.info(" testcase testHoverAction passed");
     
    }



    @Test
    public void testAlertExample() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("alert('This is a custom alert!')");
        Thread.sleep(4000);
        Alert alert = driver.switchTo().alert();
        Thread.sleep(4000);
        Assert.assertEquals(alert.getText(), "This is a custom alert!");
       
        alert.accept();
        log.info(" testcase testAlertExample passed");
        Thread.sleep(4000);
    }
}
