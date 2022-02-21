package com.solvd.qa.carina.demo.gui.pages.demoblaze;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage extends AbstractPage {

    //ALL ELEMENTS RELATED WITH SIGNING UP

    @FindBy(id = "signin2")
    private ExtendedWebElement signUpButton;

    @FindBy(xpath = "//h5[@class='modal-title' and @id='signInModalLabel']")
    private ExtendedWebElement signUpModalTitle;

    @FindBy(xpath = "//label[@for='sign-username']")
    private ExtendedWebElement signUpUserNameFieldText;

    @FindBy(xpath = "//label[@for='sign-password']")
    private ExtendedWebElement signUpPasswordFieldText;

    @FindBy(id = "sign-username")
    private ExtendedWebElement signUpUsernameInputField;

    @FindBy(id = "sign-password")
    private ExtendedWebElement signUpPasswordInputField;

    @FindBy(xpath = "//button[text()='Sign up']")
    private ExtendedWebElement signUpModalButton;

    @FindBy(xpath = "(//button[@data-dismiss='modal'])[4]")
    private ExtendedWebElement signUp_closeModalButton;

    public HomePage(WebDriver driver) {
        super(driver);
        open();
    }

    public void clickSingUpButton() {
        signUpButton.click();
    }

    public String getSingUpButtonText() {
        return signUpButton.getText();
    }

    public String getSignUpText() {
        return signUpModalTitle.getText();
    }

    public String getSignUpUserNameText() {
        return signUpUserNameFieldText.getText();
    }

    public String getSignUpPasswordText() {
        return signUpPasswordFieldText.getText();
    }

    public void clickSignUpUsernameInput() {
        signUpUsernameInputField.click();
    }

    public void setSignUpUsername(String username) {
        signUpUsernameInputField.type(username);
    }

    public void clickSignUpPasswordInput() {
        signUpPasswordInputField.click();
    }

    public void setSignUpPassword(String password) {
        signUpPasswordInputField.type(password);
    }

    public void clickSignUpModalButton() {
        signUpModalButton.click();
    }

    public String getAlertText() {
        new WebDriverWait(driver, 5).until(ExpectedConditions.alertIsPresent());
        return driver.switchTo().alert().getText();
    }

    public void alert_clickAcceptButton() {
        driver.switchTo().alert().accept();
    }

    public void signUp_closeModal() {
        signUp_closeModalButton.click();
    }

    //-------------------------------------------------------------
    //ALL ELEMENTS RELATED WITH LOGGING IN

    @FindBy(id = "login2")
    private ExtendedWebElement loginButton;

    @FindBy(xpath = "//h5[text()='Log in']")
    private ExtendedWebElement modal_logInText;

    @FindBy(id = "loginusername")
    private ExtendedWebElement modal_usernameInput;

    @FindBy(id = "loginpassword")
    private ExtendedWebElement modal_passwordInput;

    @FindBy(xpath = "//button[@onClick='logIn()']")
    private ExtendedWebElement modal_logInButton;

    @FindBy(id = "nameofuser")
    private ExtendedWebElement welcomeMessage;

    @FindBy(id = "logout2")
    private ExtendedWebElement logOut;


    public void clickLogInButton() {
        loginButton.click();
    }

    public String getLogInText() {
        return loginButton.getText();
    }

    public String modal_getLogInText() {
        return modal_logInText.getText();
    }

    public void logIn_clickUsernameInput() {
        modal_usernameInput.click();
    }

    public void logIn_setUsername(String username) {
        modal_usernameInput.type(username);
    }

    public void logIn_clickPasswordInput() {
        modal_passwordInput.click();
    }

    public void logIn_SetPassword(String password) {
        modal_passwordInput.type(password);
    }

    public String logIn_getWelcomeMessage() {
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(welcomeMessage.getElement()));
        return welcomeMessage.getText();
    }

    public void logIn_clickLogInButton() {
        modal_logInButton.click();
    }

    public void clickLogOut() {
        logOut.click();
    }

    //------------------------------------------------
    //CONTACT US ELEMENTS

    @FindBy(xpath = "//a[text()='Contact']")
    private ExtendedWebElement contactUsButton;

    @FindBy(xpath = "//h5[text()='New message']")
    private ExtendedWebElement contactModal_modalTitle;

    @FindBy(id = "recipient-email")
    private ExtendedWebElement contactModal_emailInput;

    @FindBy(id = "recipient-name")
    private ExtendedWebElement contactModal_nameInput;

    @FindBy(id = "message-text")
    private ExtendedWebElement contactModal_messageInput;

    @FindBy(xpath = "//button[text()='Send message']")
    private ExtendedWebElement contactModal_sendMessageButton;

    public void clickContactButton() {
        contactUsButton.click();
    }

    public String getTextContactButton() {
        return contactUsButton.getText();
    }

    public String contactModal_getModalTitle() {
        return contactModal_modalTitle.getText();
    }

    public void contactModal_clickEmailInput() {
        contactModal_emailInput.click();
    }

    public void contactModal_typeEmailInput(String text) {
        contactModal_emailInput.type(text);
    }

    public void contactModal_clickNameInput() {
        contactModal_nameInput.click();
    }

    public void contactModal_typeNameInput(String text) {
        contactModal_nameInput.type(text);
    }

    public void contactModal_clickMessageInput() {
        contactModal_messageInput.click();
    }

    public void contactModal_typeMessageInput(String text) {
        contactModal_messageInput.type(text);
    }

    public void contactModal_clickSendMessage() {
        contactModal_sendMessageButton.click();
    }

    //-------------------------------------------
    //PHONE ELEMENTS

    @FindBy(xpath = "//a[@id='itemc' and text()='Phones']")
    private ExtendedWebElement phonesSection;

    @FindBy(xpath = "//div[@class='card h-100']")
    private List<ExtendedWebElement> allPhonesBoxes;

    @FindBy(xpath = ("//h4[@class='card-title']/a"))
    private List<ExtendedWebElement> productsName;

    @FindBy(xpath = ("//h4[@class='card-title']/a"))
    private ExtendedWebElement productName;

    @FindBy(xpath = ("//div[@class='card-block']/h5"))
    private List<ExtendedWebElement> productsPrice;

    public void phones_clickPhonesButton() {
        phonesSection.click();
    }

    public List<ExtendedWebElement> phones_getAllPhones() {
        new WebDriverWait(driver, 6).until(ExpectedConditions.numberOfElementsToBe(By.xpath("//h4[@class='card-title']/a"), 7));
        return allPhonesBoxes;
    }

    public ProductElement getCheapestProduct() {
        new WebDriverWait(driver, 4);
        ProductElement productElement = new ProductElement("Nn", 1200);
        for (ExtendedWebElement element :
                productsPrice) {
            int price = Integer.parseInt(element.getText().replaceAll("(?:(?!\\d|Free)(?s:.))*(\\d+(?:[.,]\\d+)*|Free)?", "$1"));
            if (price < productElement.getPrice()) {
                productElement.setPrice(price);
            }
        }
        return productElement;
    }

    public ProductElement getMostExpensiveProduct() {
        new WebDriverWait(driver, 4);
        ProductElement productElement = new ProductElement("Nn", 0);
        for (ExtendedWebElement element :
                productsPrice) {
            int price = Integer.parseInt(element.getText().replaceAll("(?:(?!\\d|Free)(?s:.))*(\\d+(?:[.,]\\d+)*|Free)?", "$1"));
            if (price > productElement.getPrice()) {
                productElement.setPrice(price);
            }
        }

        return productElement;
    }

    //------------------------------------------------
    //LAPTOPS
    @FindBy(xpath = "//a[@id='itemc' and text()='Laptops']")
    private ExtendedWebElement laptopsSection;

    @FindBy(id = "next2")
    private ExtendedWebElement nextButton;

    public void laptops_clickLaptopsButton() {
        laptopsSection.click();
    }

    public void laptops_clickNextButton(){
        laptopsSection.click();
    }

    public List<ExtendedWebElement> laptops_getAllLaptops(){
        new WebDriverWait(driver, 6).until(ExpectedConditions.numberOfElementsToBe(By.xpath("//h4[@class='card-title']/a"), 6));
        return productsName;
    }

    //------------------------------------------
    //PRODUCT DETAIL PAGE


    public ProductDetailPage clickProductDetail(){
        productName.click();
        return new ProductDetailPage(driver);
    }

    public String getUrl(){
        return driver.getTitle();
    }


}
