// File: Ex01InvalidLoginDataTest.java
// Package: com.coherentsolutions.java.webauto.section01

package com.coherentsolutions.java.webauto.section01;

import com.coherentsolutions.java.webauto.section01.basicclasses.TestBase;
import com.coherentsolutions.java.webauto.section01.basicclasses.TestConfig;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * This class demonstrates how to use a Data Provider within the same class to supply test data.
 */
public class Ex01InvalidLoginDataTest extends TestBase {

    private static final String USER_NAME = TestConfig.getUsername();
    private static final String PASSWORD = TestConfig.getPassword();
    private static final String LOGIN_PAGE_URL = TestConfig.getUrl();  // Load the login page URL from config

    private static final String INCORRECT_PASSWORD_ERROR_MESSAGE_TEXT = "Invalid password. Please try again";
    private static final String EMPTY_USER_NAME_ERROR_MESSAGE_TEXT = "Sorry, we don't recognize this email.";

    private UserAccountPage userAccountPage;
    private LoginPage loginPage;

    @BeforeMethod
    public void setUpTest() {
        // Load the login page URL before each test
        driver.get(LOGIN_PAGE_URL);

        // Initialize the LoginPage object
        loginPage = new LoginPage();
    }

    /**
     * Test with Data Provider to check multiple incorrect password scenarios.
     *
     * @param userName The username to input.
     * @param password The password to input.
     * @param expectedErrorMessage The expected error message.
     */
    @Test(dataProvider = "loginDataProvider")
    public void loginWithMultipleDataProviderTest(String userName, String password, String expectedErrorMessage) {
        loginPage.inputUserName(userName);
        loginPage.clickLoginButton();
        loginPage.inputUserPassword(password);
        userAccountPage = loginPage.clickPasswordFormLoginButton();
        String actualErrorText = loginPage.getIncorrectPasswordErrorMessage();
        Assert.assertEquals(actualErrorText, expectedErrorMessage);
    }

    /**
     * Data Provider method to supply multiple sets of username and password combinations.
     *
     * @return Object[][] containing different sets of login data.
     */
    @DataProvider(name = "loginDataProvider")
    public Object[][] loginDataProvider() {
        return new Object[][] {
                { USER_NAME, "wrongPassword1", INCORRECT_PASSWORD_ERROR_MESSAGE_TEXT },
                { USER_NAME, "wrongPassword2", INCORRECT_PASSWORD_ERROR_MESSAGE_TEXT },
                { USER_NAME, "wrongPassword3", INCORRECT_PASSWORD_ERROR_MESSAGE_TEXT },
                { "nonExistentUser", PASSWORD, EMPTY_USER_NAME_ERROR_MESSAGE_TEXT }
        };
    }
}