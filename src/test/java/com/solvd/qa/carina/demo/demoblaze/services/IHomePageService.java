package com.solvd.qa.carina.demo.demoblaze.services;

import com.solvd.qa.pages.demoblaze.HomePage;
import org.openqa.selenium.WebDriver;

public interface IHomePageService {

    default HomePage goToSignUpModal(WebDriver driver) {
        HomePage homePage = new HomePage(driver);
        homePage.clickSingUpButton();
        return homePage;
    }

    default HomePage canEnterUsernameAndPassword(WebDriver driver) {
        HomePage homePage = goToSignUpModal(driver);
        homePage.clickSignUpUsernameInput();
        homePage.setSignUpUsername("chavito33");
        homePage.clickSignUpPasswordInput();
        homePage.setSignUpPassword("chavito33");
        homePage.clickSignUpModalButton();
        homePage.getAlertText();
        return homePage;
    }

    default HomePage canCloseModal(WebDriver driver) {
        HomePage homePage = goToSignUpModal(driver);
        homePage.signUp_closeModal();
        homePage.getSingUpButtonText();
        return homePage;
    }

    default HomePage goToLogInModal(WebDriver driver) {
        HomePage homePage = new HomePage(driver);
        homePage.clickLogInButton();
        homePage.modal_getLogInText();
        return homePage;
    }

    default HomePage canEnterUsernameAndPassword_logIn(WebDriver driver) {
        HomePage homePage = goToLogInModal(driver);
        homePage.logIn_clickUsernameInput();
        homePage.logIn_setUsername("jeremias");
        homePage.logIn_clickPasswordInput();
        homePage.logIn_SetPassword("bertoldi");
        homePage.logIn_clickLogInButton();
        String welcome = homePage.logIn_getWelcomeMessage();
        return homePage;
    }

    default HomePage canLogOut(WebDriver driver) {
        HomePage homePage = canEnterUsernameAndPassword_logIn(driver);
        homePage.clickLogOut();
        return homePage;
    }

    default HomePage enterWrongUsername_logIn(WebDriver driver) {
        HomePage homePage = goToLogInModal(driver);
        homePage.logIn_clickUsernameInput();
        homePage.logIn_setUsername("asdasd1234123asd");
        homePage.logIn_clickPasswordInput();
        homePage.logIn_SetPassword("bertoldi");
        homePage.logIn_clickLogInButton();
        return homePage;
    }

    default HomePage enterWrongPassword_logIn(WebDriver driver) {
        HomePage homePage = goToLogInModal(driver);
        homePage.logIn_clickUsernameInput();
        homePage.logIn_setUsername("jeremias");
        homePage.logIn_clickPasswordInput();
        homePage.logIn_SetPassword("asdahsdg");
        homePage.logIn_clickLogInButton();
        return homePage;
    }

    default HomePage canClickContactButton(WebDriver driver) {
        HomePage homePage = new HomePage(driver);
        homePage.clickContactButton();
        return homePage;
    }

    default HomePage canSendMessage(WebDriver driver) {
        HomePage homePage = canClickContactButton(driver);
        homePage.contactModal_clickEmailInput();
        homePage.contactModal_typeEmailInput("example@gmail.com");
        homePage.contactModal_clickNameInput();
        homePage.contactModal_typeNameInput("snow");
        homePage.contactModal_clickMessageInput();
        homePage.contactModal_typeMessageInput("Hi I really enjoy automating their page");
        homePage.contactModal_clickSendMessage();
        var alertText = homePage.getAlertText();
        return homePage;
    }

    default HomePage canClickPhonesButton(WebDriver driver) {
        HomePage homePage = new HomePage(driver);
        homePage.phones_clickPhonesButton();
        return homePage;
    }

    default HomePage canClickLaptopsButton(WebDriver driver) {
        HomePage homePage = new HomePage(driver);
        homePage.laptops_clickLaptopsButton();
        return homePage;
    }



}
