package com.solvd.qa.carina.demo.demoblaze.test;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.solvd.qa.carina.demo.demoblaze.services.IHomePageService;
import com.solvd.qa.carina.demo.demoblaze.services.IProductDetailService;
import com.solvd.qa.pages.demoblaze.CartPage;
import com.solvd.qa.pages.demoblaze.HomePage;
import com.solvd.qa.pages.demoblaze.ProductDetailPage;
import com.solvd.qa.pages.demoblaze.ProductElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DemoBlazeProductsTest implements IAbstractTest, IHomePageService, IProductDetailService {
    private static final Logger log = LogManager.getLogger(DemoBlazeTest.class);

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
}
