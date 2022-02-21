package com.solvd.qa.carina.demo.demoblaze.services;

import com.solvd.qa.carina.demo.gui.pages.demoblaze.CartPage;
import com.solvd.qa.carina.demo.gui.pages.demoblaze.HomePage;
import com.solvd.qa.carina.demo.gui.pages.demoblaze.ProductDetailPage;
import com.solvd.qa.carina.demo.gui.pages.demoblaze.ProductElement;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;

public interface IProductDetailService {

    default ProductDetailPage goToProductDetailPage(WebDriver driver) {
        HomePage homePage = new HomePage(driver);
        ProductDetailPage productDetailPage = homePage.clickProductDetail();
        return productDetailPage;
    }

    default ProductDetailPage canClickAlertButton(WebDriver driver) {
        ProductDetailPage productDetailPage = goToProductDetailPage(driver);
        productDetailPage.clickAddToCartButton();
        return productDetailPage;
    }

    default CartPage canClickAddToCartButton(WebDriver driver) {
        ProductDetailPage productDetailPage = canClickAlertButton(driver);
        productDetailPage.alert_clickAccept();
        var cart = productDetailPage.clickCartButton();
        return cart;
    }

    default CartPage canDeleteProduct(WebDriver driver) {
        CartPage cartPage = canClickAddToCartButton(driver);
        cartPage.clickDeleteButton();
        var product = cartPage.getProduct();
        product = null;
        return cartPage;
    }

}
