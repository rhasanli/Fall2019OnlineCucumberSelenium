package com.vytrack.pages;


import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(id = "prependedInput")
    public WebElement username;

    @FindBy(id = "prependedInput2")
    public WebElement password;

    @FindBy(id = "_submit")
    public WebElement login;

    @FindBy(linkText = "Forgot your password?")
    public WebElement forgotPassword;

    @FindBy(css = "[class='alert alert-error']")
    public WebElement warningMessage;

    public LoginPage() {
        // to connect our webdriver, page class and page factory
        // PageFactory - usedto use @findBy annotations
        // PageFactory - helps to find elements easier
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public String getWarningMessageText() {
        return warningMessage.getText();
    }

    /**
     * Method to login, version #1
     * Login as a specific user
     *
     * @param usernameValue
     * @param passwordValue
     */
    public void login(String usernameValue, String passwordValue) {
        username.sendKeys(usernameValue);
        password.sendKeys(passwordValue, Keys.ENTER);
    }

    /**
     * Method to login, version #2
     * Login as a default user
     * Credentials will be retrieved from configuration.properties file
     */
    public void login()
    {
        username.sendKeys(ConfigurationReader.getProperty("store_manager"));
        password.sendKeys(ConfigurationReader.getProperty("password"), Keys.ENTER);
    }
}