// File: Ex02DataProviderClass.java
// Package: com.coherentsolutions.java.webauto.section01

package com.coherentsolutions.java.webauto.section01;

import org.testng.annotations.DataProvider;

/**
 * This class contains Data Providers that can be used by multiple test classes.
 * It demonstrates how to move data to a separate class for better organization.
 */
public class Ex02DataProviderClass {

    /**
     * This Data Provider supplies a set of invalid usernames.
     *
     * @return An array of invalid usernames.
     */
    @DataProvider(name = "invalidLoginData")
    public Object[][] getInvalidLoginData() {
        return new Object[][]{
                {"@@@@"},
                {"!!!!!!"},
                {"######"},
                {"$$$$$$"},
                {"&!$#@@@"}
        };
    }

    /**
     * This Data Provider supplies a set of invalid passwords.
     *
     * @return An array of invalid passwords.
     */
    @DataProvider(name = "invalidPasswordData")
    public Object[][] getInvalidPasswordData() {
        return new Object[][]{
                {"@@@@"},
                {"!!!!!!"},
                {"######"},
                {"$$$$$$"},
                {"&!$#@@@"}
        };
    }
}
