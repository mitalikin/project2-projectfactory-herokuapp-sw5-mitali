package com.herokuapp.pages;

import com.aventstack.extentreports.Status;
import com.herokuapp.customlisteners.CustomListeners;
import com.herokuapp.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class LoginPage extends Utility {
    @CacheLookup
    @FindBy
            (xpath = "//input[@id='username']")
    WebElement userNameField;
    @CacheLookup
    @FindBy
            (id = "password")
    WebElement passwordField;
    @CacheLookup
    @FindBy
            (xpath = "//i[contains(text(),'Login')]")
    WebElement loginButton;
    @CacheLookup
    @FindBy
            (xpath = "//h2[normalize-space()='Secure Area']")
    WebElement textSecureArea;
    @CacheLookup
    @FindBy
            (xpath = "//div[@id='flash']")
    WebElement textUserNameInvalid;
    @CacheLookup
    @FindBy
            (xpath = "//div[@class = 'flash error']")
    WebElement textPasswordInvalid;

    public void enterUsernameField(String userName) {
        Reporter.log("Sending text to Username : " + userName.toString());
        sendTextToElement(userNameField, userName);
        CustomListeners.test.log(Status.PASS, "Enter Username " + userName);
    }

    public void enterPasswordField(String password) {
        Reporter.log("Sending text to Password Field : " + password.toString());
        CustomListeners.test.log(Status.PASS, "Enter password " + password);
        sendTextToElement(passwordField, password);
    }

    public void clickOnLoginButton() {
        Reporter.log("clicking on login button : " + loginButton.toString());
        CustomListeners.test.log(Status.PASS, "Click on loginButton");
        clickOnElement(loginButton);
    }

    public String getTextSecureArea() {
        Reporter.log("Getting Message : " + textSecureArea.toString());
        CustomListeners.test.log(Status.PASS, "Get Secure Area Message");
        return getTextFromElement(textSecureArea);
    }

    public String getTextUserNameInvalid() {
        Reporter.log("Getting Error Message : " + textUserNameInvalid.toString());
        CustomListeners.test.log(Status.PASS, "Username Error");
        return getTextFromElement(textUserNameInvalid);
    }

    public String getTextPasswordInvalid() {
        Reporter.log("Getting Error Message : " + textPasswordInvalid.toString());
        CustomListeners.test.log(Status.PASS, "Password error");
        return getTextFromElement(textPasswordInvalid);
    }
}



