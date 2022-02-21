package com.solvd.qa.carina.demo.gui.pages.demoblaze;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductDetailPage extends AbstractPage {

    public ProductDetailPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "name")
    private ExtendedWebElement productTitle;

    @FindBy(css = ".price-container")
    private ExtendedWebElement productPrice;

    @FindBy(xpath = "//a[text()='Add to cart']")
    private ExtendedWebElement addToCartButton;

    @FindBy(id = "cartur")
    private ExtendedWebElement cartButton;

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    public void clickAddToCartButton() {
        addToCartButton.click();
    }

    public ProductElement getProduct() {
        ProductElement productElement = new ProductElement();
        productElement.setPrice(Integer.parseInt(productPrice.getText().replaceAll("(?:(?!\\d|Free)(?s:.))*(\\d+(?:[.,]\\d+)*|Free)?", "$1")));
        productElement.setName(productTitle.getText());
        return productElement;
    }

    public CartPage clickCartButton() {
        cartButton.click();
        return new CartPage(driver);
    }

    public void alert_clickAccept(){
        new WebDriverWait(driver, 5).until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }

    public String alert_getText(){
        new WebDriverWait(driver, 5).until(ExpectedConditions.alertIsPresent());
        return driver.switchTo().alert().getText();
    }


}
