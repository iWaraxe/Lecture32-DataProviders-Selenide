package com.coherentsolutions.java.webauto.section02;

import com.codeborne.selenide.SelenideElement;
import com.coherentsolutions.java.webauto.section02.basicclasses.PageBase;

import static com.codeborne.selenide.Selenide.*;

public class LoginPage extends PageBase {

    // Elements
    private SelenideElement userNameField = $("[name='username']");
    private SelenideElement userNameFormLoginButton = $("#login-signin");
    private SelenideElement userPasswordField = $("#login-passwd");
    private SelenideElement passwordFormLoginButton = $("#login-signin");
    private SelenideElement emptyPasswordErrorMessage = $x("//p[@class='error-msg' and @data-error='messages.ERROR_EMPTY_PASSWORD']");
    private SelenideElement incorrectPasswordErrorMessage = $x("//p[@class='error-msg' and @data-error='messages.ERROR_INVALID_PASSWORD']");
    private SelenideElement invalidUserNameErrorMessage = $x("//p[@id='username-error' and @class='error-msg']");

    // Methods
    public void inputUserName(String userName) {
        userNameField.setValue(userName);
    }

    public void clickLoginButton() {
        userNameFormLoginButton.click();
    }

    public void inputUserPassword(String userPassword) {
        userPasswordField.setValue(userPassword);
    }

    public UserAccountPage clickPasswordFormLoginButton() {
        passwordFormLoginButton.click();
        return page(UserAccountPage.class);
    }

    public String getEmptyPasswordErrorMessage() {
        return emptyPasswordErrorMessage.text();
    }

    public String getIncorrectPasswordErrorMessage() {
        return incorrectPasswordErrorMessage.text();
    }

    public String getInvalidUserNameErrorMessage() {
        return invalidUserNameErrorMessage.text();
    }
}