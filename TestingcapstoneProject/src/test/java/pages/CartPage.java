package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    WebDriver driver;

    By cartTable = By.id("cart_info_table");
    By productRows = By.xpath("//tr[contains(@id,'product-')]");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean areProductsInCart(int expectedCount) {
        return driver.findElements(productRows).size() == expectedCount;
    }

    public boolean verifyProductDetails(int index, String expectedPrice, String expectedQty, String expectedTotal) {
        String price = driver.findElement(By.xpath("//tr[" + index + "]/td[3]/p")).getText();
        String qty = driver.findElement(By.xpath("//tr[" + index + "]/td[4]/button")).getText();
        String total = driver.findElement(By.xpath("//tr[" + index + "]/td[5]/p")).getText();
        return price.equals(expectedPrice) && qty.equals(expectedQty) && total.equals(expectedTotal);
    }
}
