package tests;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import utils.Helper;
public class LoginTest extends BaseTest {
	@Test
    public void loginWithValidCredentials() {
        try {
        	Thread.sleep(4000);
        	
        	Assert.assertTrue(home.isHomeVisible(), "Home page is not visible");
        	log.info("home page is opened");
        	
        	home.clickSignupLogin();
        	log.info("clicked on  Signup/Login button");
        	Thread.sleep(4000);
        	
        	
        	 Assert.assertTrue(login.isLoginHeaderVisible(), "'Login to your account' is not visible");
        	 log.info("Login to your account page is opened");

            String email = "bashaboinaraju939@gmail.com";   // Use real registered credentials
            String password = "Capstone@123";

            login.login(email, password);
            log.info("logged with email and password are " + email +" "+password);
            
           
            Assert.assertTrue(login.isLoggedInAsVisible(), "Login failed - 'Logged in as username' is not visible.");
            log.info("Login test is passed");
            
            Thread.sleep(4000);
            login.logout();
            log.info("Successfully clicked on  Logout button");

            
            Assert.assertTrue(login.isLoginPageVisible(), "Logout failed or not redirected to login page.");
            log.info("redirected to login page");
} catch (Exception e) {
            Helper.captureScreenshot(driver, "LoginFailure");
            Assert.fail("Test failed: " + e.getMessage());
        }
    }
}

    
   

