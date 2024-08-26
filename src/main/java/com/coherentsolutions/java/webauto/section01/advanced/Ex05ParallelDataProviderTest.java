// File: Ex05ParallelDataProviderTest.java
// Package: com.coherentsolutions.java.webauto.section01.advanced

package com.coherentsolutions.java.webauto.section01.advanced;

import com.coherentsolutions.java.webauto.section01.LoginPage;
import com.coherentsolutions.java.webauto.section01.UserAccountPage;
import com.coherentsolutions.java.webauto.section01.basicclasses.TestBase;
import com.coherentsolutions.java.webauto.section01.basicclasses.TestConfig;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * This class demonstrates the use of a parallel Data Provider in TestNG.
 * Parallel execution can speed up tests that are independent of each other.
 */
public class Ex05ParallelDataProviderTest extends TestBase {
    private static final String LOGIN_PAGE_URL = TestConfig.getUrl();  // Load the login page URL from config


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
     * This test method uses a Data Provider with parallel execution enabled.
     *
     * @param username The username for login.
     * @param password The password for login.
     */
    @Test(dataProvider = "parallelLoginData", threadPoolSize = 3)
    public void parallelLoginTest(String username, String password) {
        loginPage.inputUserName(username);
        loginPage.clickLoginButton();
        loginPage.inputUserPassword(password);
        loginPage.clickPasswordFormLoginButton();
        String actualMessage = loginPage.getIncorrectPasswordErrorMessage();
        Assert.assertEquals(actualMessage, "Invalid username or password.");
    }

    /**
     * This Data Provider supplies login data and is configured to support parallel execution.
     *
     * @return A two-dimensional array of objects, where each sub-array represents a test case.
     */
    @DataProvider(name = "parallelLoginData", parallel = true)
    public Object[][] getParallelLoginData() {
        return new Object[][]{
                {"user1", "password1"},
                {"user2", "password2"},
                {"validUser", "wrongPassword"},
                {"user3", "password3"},
                {"user4", "password4"}
        };
    }
}
