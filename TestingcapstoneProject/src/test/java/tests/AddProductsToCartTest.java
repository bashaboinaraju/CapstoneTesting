package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;

public class AddProductsToCartTest extends BaseTest {

    @Test
    public void testAddProductsToCart() throws InterruptedException {

        Assert.assertTrue(home.isHomeVisible(), "Home page is not visible");
    	log.info("home page is opened");

        home.clickProducts();
        log.info("clicked on  Products button");

     
        productpage.hoverAndAddFirstProductToCart();
        log.info("one Product is added to cart");
        Thread.sleep(4000);  

        productpage.clickViewCart();
        log.info(" Cart page is opened to see products");
        Thread.sleep(4000); 
     
        Assert.assertTrue(cart.areProductsInCart(1), "one product not present in cart");

        log.info("one product present in cart");

        Assert.assertTrue(cart.verifyProductDetails(1, "Rs. 500", "1", "Rs. 500"), "First product details mismatch");
        log.info("Product Details are price:\"Rs. 500\", Quantity:\"1\",  total_price:\"Rs. 500\" ");
    }
}

