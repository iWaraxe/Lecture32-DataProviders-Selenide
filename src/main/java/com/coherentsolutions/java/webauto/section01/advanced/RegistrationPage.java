// File: RegistrationPage.java
// Package: com.coherentsolutions.java.webauto.section01.advanced

package com.coherentsolutions.java.webauto.section01.advanced;

import com.coherentsolutions.java.webauto.section01.basicclasses.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.coherentsolutions.java.webauto.section01.basicclasses.DriverManager;

/**
 * This class models the registration page and provides methods to interact with it using Selenium.
 * It includes methods for entering the username, password, and submitting the registration form.
 */
public class RegistrationPage extends PageBase {

    private WebDriver driver;

    // Locators for the registration form elements
    private final By USERNAME_FIELD = By.id("username");
    private final By PASSWORD_FIELD = By.id("password");
    private final By CONFIRM_PASSWORD_FIELD = By.id("confirmPassword");
    private final By REGISTER_BUTTON = By.id("registerButton");

    /**
     * Constructor for RegistrationPage.
     */
    public RegistrationPage() {
        this.driver = DriverManager.getDriver();
    }

    /**
     * Inputs the username into the username field.
     *
     * @param username The username to input.
     */
    public void inputUserName(String username) {
        WebElement userNameField = driver.findElement(USERNAME_FIELD);
        userNameField.clear();
        userNameField.sendKeys(username);
    }

    /**
     * Inputs the password into the password field.
     *
     * @param password The password to input.
     */
    public void inputPassword(String password) {
        WebElement passwordField = driver.findElement(PASSWORD_FIELD);
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    /**
     * Inputs the confirmation password into the confirmation password field.
     *
     * @param confirmPassword The password to confirm.
     */
    public void inputConfirmPassword(String confirmPassword) {
        WebElement confirmPasswordField = driver.findElement(CONFIRM_PASSWORD_FIELD);
        confirmPasswordField.clear();
        confirmPasswordField.sendKeys(confirmPassword);
    }

    /**
     * Clicks the register button to submit the registration form.
     */
    public void clickRegisterButton() {
        WebElement registerButton = driver.findElement(REGISTER_BUTTON);
        registerButton.click();
    }

    /**
     * Registers a new user by filling in the username and password fields, confirming the password,
     * and then submitting the registration form.
     *
     * @param username The username for registration.
     * @param password The password for registration.
     */
    public void register(String username, String password) {
        inputUserName(username);
        inputPassword(password);
        inputConfirmPassword(password);
        clickRegisterButton();
    }
}