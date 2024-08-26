// File: Ex03InvalidLoginTestWithExternalData.java
// Package: com.coherentsolutions.java.webauto.section01

package com.coherentsolutions.java.webauto.section01;

import com.coherentsolutions.java.webauto.section01.basicclasses.TestBase;
import com.coherentsolutions.java.webauto.section01.basicclasses.TestConfig;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * This class demonstrates how to use an external Data Provider from another class.
 */
public class Ex03InvalidLoginTestWithExternalData extends TestBase {
    private LoginPage loginPage;
    private static final String LOGIN_PAGE_URL = TestConfig.getUrl();  // Load the login page URL from config


    @BeforeMethod
    public void setUpTest() {
        // Load the login page URL before each test
        driver.get(LOGIN_PAGE_URL);

        // Initialize the LoginPage object
        loginPage = new LoginPage();
    }
    /**
     * This test method uses the Data Provider named "invalidLoginData" from the Ex02DataProviderClass.
     * The test checks that the error message appears when an invalid username is entered.
     *
     * @param invalidUserName The invalid username provided by the Data Provider.
     */
    @Test(dataProvider = "invalidLoginData", dataProviderClass = Ex02DataProviderClass.class)
    public void invalidLoginDataErrorTest(String invalidUserName) {
        loginPage.inputUserName(invalidUserName);
        loginPage.clickLoginButton();
        String actualErrorMessage = loginPage.getInvalidUserNameErrorMessage();
        Assert.assertEquals(actualErrorMessage, "Uh oh, looks like something went wrong. Please try again later.");
    }
}
