package com.coherentsolutions.java.webauto.section02.basicclasses;

import com.codeborne.selenide.Configuration;
import com.coherentsolutions.java.webauto.section01.basicclasses.TestConfig;
import org.testng.annotations.BeforeMethod;

public abstract class TestBase {

    @BeforeMethod
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.browserVersion = "128.0.6613.84"; // Ensure this matches your Chrome version
        Configuration.baseUrl = TestConfig.getUrl();
        Configuration.timeout = 40000; // 40 seconds
    }

    // Selenide automatically handles browser closure, so no need for tearDown.
}