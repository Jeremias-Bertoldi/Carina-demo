package com.solvd.qa.carina.demo.demoblaze.test;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
//import com.qaprosoft.carina.core.foundation.retry.RetryAnalyzer;
import com.solvd.qa.carina.demo.demoblaze.services.IHomePageService;
import com.solvd.qa.carina.demo.demoblaze.services.IProductDetailService;
import com.solvd.qa.pages.demoblaze.CartPage;
import com.solvd.qa.pages.demoblaze.HomePage;
import com.solvd.qa.pages.demoblaze.ProductDetailPage;
import com.solvd.qa.pages.demoblaze.ProductElement;
import com.solvd.qa.utils.RetryAnalyzer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DemoBlazeTest implements IAbstractTest, IHomePageService, IProductDetailService {
    private static final Logger log = LogManager.getLogger(DemoBlazeTest.class);

    @Test(retryAnalyzer = com.solvd.qa.utils.RetryAnalyzer.class)
    public void VerifySignUpButtonTest() {
        HomePage homePage = goToSignUpModal(getDriver());
        assertEquals(homePage.getSignUpText(), "Sign up", "different text");
        assertEquals(homePage.getSignUpUserNameText(), "Username:", "different text");
        assertEquals(homePage.getSignUpPasswordText(), "Password:", "different text");
    }


   // @Test(retryAnalyzer = RetryAnalyzer.class)
   // public void VerifyCanEnterUsernameAndPasswordTest() {
   //     HomePage homePage = canEnterUsernameAndPassword(getDriver());
   //     assertEquals(homePage.getAlertText(), "Sign up successful.", "FATAL, not same");
   //     homePage.alert_clickAcceptButton();
   // }

    @Test(retryAnalyzer = com.solvd.qa.utils.RetryAnalyzer.class)
    public void verifyCanCloseModalTest() {
        HomePage homePage = canCloseModal(getDriver());
        assertEquals(homePage.getSingUpButtonText(), "Sign up", "FATAL!, not same");
    }

    @Test(retryAnalyzer = com.solvd.qa.utils.RetryAnalyzer.class)
    public void VerifyCannotSignUpWithAlreadyCreatedUserTest() {
        HomePage homePage = canEnterUsernameAndPassword(getDriver());
        assertEquals(homePage.getAlertText(), "This user already exist.", "FATAL, not same");
        homePage.alert_clickAcceptButton();
    }

   // @Test(retryAnalyzer = RetryAnalyzer.class)
   // public void VerifyCanClickLogInButtonTest() {
   //     HomePage homePage = goToLogInModal(getDriver());
   //     assertEquals(homePage.modal_getLogInText(), "Log in", "FATAL!, not same");
   // }

    @Test
    public void verifyCanLoggingIn(){
        HomePage homePage = canEnterUsernameAndPassword_logIn(getDriver());
        assertEquals(homePage.logIn_getWelcomeMessage(), "Welcome jeremias", "FATAL!, not same");
    }

   // @Test
   // public void verifyCanLogOut(){
   //     HomePage homePage =  canLogOut(getDriver());
   //     assertEquals(homePage.getLogInText(), "Log in", "FATAL!, not same");
   // }

    @Test
    public void verifyWrongUsername(){
        HomePage homePage = enterWrongUsername_logIn(getDriver());
        assertEquals(homePage.getAlertText(), "User does not exist.", "FATAL!, not same");
    }

    @Test
    public void verifyWrongPassword(){
        HomePage homePage = enterWrongPassword_logIn(getDriver());
        assertEquals(homePage.getAlertText(), "Wrong password.", "FATAL!, not same");
    }

    @Test
    public void verifyCanClickContactButton(){
        HomePage homePage = canClickContactButton(getDriver());
        assertEquals(homePage.contactModal_getModalTitle(), "New message");
    }

   // @Test
   // public void verifyCanSendAMessage(){
   //     HomePage homePage = canSendMessage(getDriver());
   //     assertEquals(homePage.getAlertText(), "Thanks for the message!!", "FATAL!, not same");
   // }


   // @Test
   // public void verifyCanDeleteProduct(){
   //     CartPage cartPage = canDeleteProduct(getDriver());
   //     assertEquals(cartPage.getProduct(), null, "FATAL!, product not deleted");
   // }
}
