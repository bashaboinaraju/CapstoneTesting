package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;

public class RegisterUserTest extends BaseTest {
	
	
    @Test
    public void testRegisterUser() throws InterruptedException {
    	
            Assert.assertTrue(home.isHomeVisible(), "Home page not visible");
            log.info("home page is opened");
            
            home.clickSignupLogin();
            log.info("clicked on  Signup/Login button");
        	Thread.sleep(4000);
          
            Assert.assertTrue(signup.isNewUserSignupVisible(), "'New User Signup!' not visible");
            log.info("New User Signup! is visible");
            
         String randomEmail = "sravan123"+ "@test.com";
          String name= "sravan";
            signup.enterNameAndEmail(name, randomEmail);
            signup.clickSignupButton();
            log.info("signup successfully with email and name are " + randomEmail +" "+ name);
            
            Assert.assertTrue(account.isEnterAccountInfoVisible(), "'ENTER ACCOUNT INFORMATION' not visible");
            log.info("ENTER ACCOUNT INFORMATION is visible");
            
            
            account.fillAccountDetails();
            log.info("Filled AccountDetails successfully");
            
            account.clickCreateAccount();
            log.info("clicked on CreateAccount button");
            
            Assert.assertTrue(account.isAccountCreatedVisible(), "'ACCOUNT CREATED!' not visible");
            log.info("ACCOUNT CREATED! successfully");
            
            account.clickContinue();
            log.info("clicked on Contintue button");

            Assert.assertTrue(account.isLoggedInAsVisible(), "'Logged in as username' not visible");
            log.info("Logged in  name as " + name);


        
    }

}
