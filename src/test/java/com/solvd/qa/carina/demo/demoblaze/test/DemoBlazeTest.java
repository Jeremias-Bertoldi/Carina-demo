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


    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void VerifyCanEnterUsernameAndPasswordTest() {
        HomePage homePage = canEnterUsernameAndPassword(getDriver());
        assertEquals(homePage.getAlertText(), "Sign up successful.", "FATAL, not same");
        homePage.alert_clickAcceptButton();
    }

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

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void VerifyCanClickLogInButtonTest() {
        HomePage homePage = goToLogInModal(getDriver());
        assertEquals(homePage.modal_getLogInText(), "Log in", "FATAL!, not same");
        assertEquals(true, false, "FATAL!, not same");
    }

    @Test
    public void verifyCanLoggingIn(){
        HomePage homePage = canEnterUsernameAndPassword_logIn(getDriver());
        assertEquals(homePage.logIn_getWelcomeMessage(), "Welcome jeremias", "FATAL!, not same");
    }

    @Test
    public void verifyCanLogOut(){
        HomePage homePage =  canLogOut(getDriver());
        assertEquals(homePage.getLogInText(), "Log in", "FATAL!, not same");
        assertEquals(true, false, "FATAL!, not same");
    }

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

    @Test
    public void verifyCanSendAMessage(){
        HomePage homePage = canSendMessage(getDriver());
        assertEquals(homePage.getAlertText(), "Thanks for the message!!", "FATAL!, not same");
    }

    @Test
    public void verifyCanClickPhonesButton(){
        HomePage homePage= canClickPhonesButton(getDriver());
        assertTrue(homePage.phones_getAllPhones().size() == 7);
    }

    @Test
    public void verifyCanBringTheCheapestPhone(){
        HomePage homePage = canClickPhonesButton(getDriver());
        var phone = homePage.getCheapestProduct();
        assertEquals(phone.getPrice(), 320, "FATAL!, not same");
        log.info("the cheapest price of phones is: $" + phone.getPrice());
    }

    @Test
    public void verifyCanBringTheMostExpensivePhone(){
        HomePage homePage = canClickPhonesButton(getDriver());
        var phone = homePage.getMostExpensiveProduct();
        assertEquals(phone.getPrice(), 820, "FATAL!, not same");
        log.info("the most expensive price of phones is: $" + phone.getPrice());
    }

    @Test
    public void verifyCanClickLaptopsButton(){
        HomePage homePage = canClickLaptopsButton(getDriver());
        assertTrue(homePage.laptops_getAllLaptops().size() == 6);
    }


    @Test
    public void verifyCanGetTheCheapestLaptopPrice(){
        HomePage homePage = canClickLaptopsButton(getDriver());
        var laptop = homePage.getCheapestProduct();
        assertEquals(laptop.getPrice(), 700, "FATAL!, not same");
    }

    @Test
    public void verifyCanGetTheMostExpensiveLaptopPrice(){
        HomePage homePage = canClickLaptopsButton(getDriver());
        var laptop = homePage.getMostExpensiveProduct();
        assertEquals(laptop.getPrice(), 1100, "FATAL!, not same");
    }

    @Test
    public void verifyCanGoToProductsPage(){
        ProductDetailPage detailPage = goToProductDetailPage(getDriver());
        assertTrue(detailPage.getUrl().contains("prod.html"), "Fatal!, not same");
    }

    @Test
    public void verifyCanClickAlertButton(){
        ProductDetailPage detailPage = canClickAlertButton(getDriver());
        assertEquals(detailPage.alert_getText(), "Product added", "FATAL!, not same");
    }

    @Test
    public void verifyCanAddAProduct(){
        ProductDetailPage detailPage = goToProductDetailPage(getDriver());
        ProductElement product1 = detailPage.getProduct();
        CartPage cartPage = canClickAddToCartButton(getDriver());
        ProductElement product2 = cartPage.getProduct();
        assertTrue(product1.equals(product2), "FATAL!, not same");
    }

    @Test
    public void verifyCanDeleteProduct(){
        CartPage cartPage = canDeleteProduct(getDriver());
        assertEquals(cartPage.getProduct(), null, "FATAL!, product not deleted");
    }
}
