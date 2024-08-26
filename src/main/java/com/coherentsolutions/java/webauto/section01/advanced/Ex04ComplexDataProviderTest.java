// File: Ex04ComplexDataProviderTest.java
// Package: com.coherentsolutions.java.webauto.section01.advanced

package com.coherentsolutions.java.webauto.section01.advanced;

import com.coherentsolutions.java.webauto.section01.LoginPage;
import com.coherentsolutions.java.webauto.section01.basicclasses.TestBase;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * This class demonstrates an advanced use of Data Providers where each test case is provided with multiple parameters.
 */
public class Ex04ComplexDataProviderTest extends TestBase {

    /**
     * This test method uses a complex Data Provider that supplies multiple parameters to each test run.
     *
     * @param username The username for login.
     * @param password The password for login.
     * @param expectedMessage The expected error or success message.
     */
    @Test(dataProvider = "loginData")
    public void loginTest(String username, String password, String expectedMessage) {
        LoginPage loginPage = new LoginPage();
        loginPage.inputUserName(username);
        loginPage.clickLoginButton();
        loginPage.inputUserPassword(password);
        loginPage.clickPasswordFormLoginButton();
        String actualMessage = loginPage.getIncorrectPasswordErrorMessage();
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    /**
     * This Data Provider supplies a combination of usernames, passwords, and expected messages.
     *
     * @return A two-dimensional array of objects, where each sub-array represents a test case.
     */
    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {
        return new Object[][]{
                {"user1", "password1", "Invalid username or password."},
                {"user2", "password2", "Invalid username or password."},
                {"validUser", "wrongPassword", "Invalid username or password."},
                {"", "password", "Username cannot be empty."},
                {"validUser", "", "Password cannot be empty."}
        };
    }
}
