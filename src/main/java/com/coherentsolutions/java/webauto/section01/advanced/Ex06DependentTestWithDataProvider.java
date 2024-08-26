// File: Ex06DependentTestWithDataProvider.java
// Package: com.coherentsolutions.java.webauto.section01.advanced

package com.coherentsolutions.java.webauto.section01.advanced;

import com.coherentsolutions.java.webauto.section01.LoginPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * This class demonstrates using a Data Provider with a test that depends on another test's results.
 * This is useful when you need to ensure a certain sequence of operations.
 */
public class Ex06DependentTestWithDataProvider {

    private boolean isUserRegistered = false;

    /**
     * This test method simulates user registration.
     *
     * @param username The username for registration.
     * @param password The password for registration.
     */
    @Test(dataProvider = "registrationData")
    public void registerUserTest(String username, String password) {
        RegistrationPage registrationPage = new RegistrationPage();
        registrationPage.register(username, password);
        isUserRegistered = true; // Simulate successful registration
        Assert.assertTrue(isUserRegistered, "User should be registered successfully.");
    }

    /**
     * This test method depends on the successful execution of registerUserTest.
     * It checks the login functionality after registration.
     *
     * @param username The username for login.
     * @param password The password for login.
     */
    @Test(dependsOnMethods = "registerUserTest", dataProvider = "registrationData")
    public void loginAfterRegistrationTest(String username, String password) {
        if (isUserRegistered) {
            LoginPage loginPage = new LoginPage();
            loginPage.inputUserName(username);
            loginPage.inputUserPassword(password);
            loginPage.clickLoginButton();
            String actualMessage = loginPage.getIncorrectPasswordErrorMessage();
            Assert.assertEquals(actualMessage, "Welcome, " + username + "!");
        }
    }

    /**
     * This Data Provider supplies registration data and can be used for both registration and login tests.
     *
     * @return A two-dimensional array of objects, where each sub-array represents a test case.
     */
    @DataProvider(name = "registrationData")
    public Object[][] getRegistrationData() {
        return new Object[][]{
                {"newUser1", "password1"},
                {"newUser2", "password2"},
                {"newUser3", "password3"}
        };
    }
}
