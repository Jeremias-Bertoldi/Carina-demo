package com.solvd.qa.pages.demoblaze;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends AbstractPage {

    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "(//td)[2]")
    private ExtendedWebElement productName;

    @FindBy(xpath = "(//td)[3]")
    private ExtendedWebElement productPrice;

    @FindBy(xpath = "//a[text()='Delete']")
    private ExtendedWebElement deleteButton;

    public ProductElement getProduct(){
        ProductElement productElement = new ProductElement();
        productElement.setName(productName.getText());
        productElement.setPrice(Integer.parseInt(productPrice.getText().replaceAll("(?:(?!\\d|Free)(?s:.))*(\\d+(?:[.,]\\d+)*|Free)?", "$1")));
        return productElement;
    }

    public void clickDeleteButton(){
        deleteButton.click();
    }
}
