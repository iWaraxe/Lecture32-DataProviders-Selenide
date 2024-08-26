package com.coherentsolutions.java.webauto.section02;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.coherentsolutions.java.webauto.section02.basicclasses.TestBase;
import com.coherentsolutions.java.webauto.section02.basicclasses.TestConfig;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class LoginTest extends TestBase {

    private static final String USER_NAME = TestConfig.getUsername();
    private static final String PASSWORD = TestConfig.getPassword();
    private static final String LOGIN_PAGE_URL = TestConfig.getUrl();

    private static final String EXPECTED_ERROR_MESSAGE_TEXT = "Please provide password.";
    private static final String INCORRECT_PASSWORD_ERROR_MESSAGE_TEXT = "Invalid password. Please try again";
    private static final String EMPTY_USER_NAME_ERROR_MESSAGE_TEXT = "Sorry, we don't recognize this email.";
    private static final String EXPECTED_TITLE = "Yahoo | Mail, Weather, Search, Politics, News, Finance, Sports & Videos";

    private UserAccountPage userAccountPage;
    private LoginPage loginPage;

    @BeforeMethod
    public void setUpTest() {
        open(LOGIN_PAGE_URL);
        loginPage = new LoginPage();
    }

    @Test
    public void loginTest() {
        loginPage.inputUserName(USER_NAME);
        loginPage.clickLoginButton();
        loginPage.inputUserPassword(PASSWORD);
        userAccountPage = loginPage.clickPasswordFormLoginButton();
        Assert.assertTrue(userAccountPage.isDisplayedMailLink(), "User Account page is not displayed");
    }

    @Test
    public void emptyPasswordTest() {
        loginPage.inputUserName(USER_NAME);
        loginPage.clickLoginButton();
        loginPage.inputUserPassword("");
        userAccountPage = loginPage.clickPasswordFormLoginButton();
        String actualErrorText = loginPage.getEmptyPasswordErrorMessage();
        Assert.assertEquals(actualErrorText, EXPECTED_ERROR_MESSAGE_TEXT);
    }

    @Test
    public void incorrectPasswordTest() {
        loginPage.inputUserName(USER_NAME);
        loginPage.clickLoginButton();
        loginPage.inputUserPassword(RandomStringUtils.randomAlphabetic(10));
        userAccountPage = loginPage.clickPasswordFormLoginButton();
        String actualErrorText = loginPage.getIncorrectPasswordErrorMessage();
        Assert.assertEquals(actualErrorText, INCORRECT_PASSWORD_ERROR_MESSAGE_TEXT);
    }

    @Test
    public void emptyUserNameFieldTest() {
        loginPage.clickLoginButton();
        String actualErrorText = loginPage.getInvalidUserNameErrorMessage();
        Assert.assertEquals(actualErrorText, EMPTY_USER_NAME_ERROR_MESSAGE_TEXT);
    }
}