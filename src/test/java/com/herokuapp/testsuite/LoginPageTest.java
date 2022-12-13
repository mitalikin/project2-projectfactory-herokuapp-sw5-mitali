package com.herokuapp.testsuite;

import com.herokuapp.customlisteners.CustomListeners;
import com.herokuapp.pages.LoginPage;
import com.herokuapp.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(CustomListeners.class)
public class LoginPageTest extends BaseTest {
    LoginPage loginPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        loginPage = new LoginPage();
    }

    @Test(groups = {"sanity", "regression"})
    public void UserShouldLoginSuccessfullyWithValidCredentials() {
        //Enter “tomsmith” username
        loginPage.enterUsernameField("tomsmith");
        //Enter “SuperSecretPassword!” password
        loginPage.enterPasswordField("SuperSecretPassword!");
        //Click on ‘LOGIN’ button
        loginPage.clickOnLoginButton();
        //Verify the text “Secure Area”
        String expectedMessage = "Secure Area";
        Assert.assertEquals(loginPage.getTextSecureArea(), expectedMessage, "Message is not displayed");

    }

    @Test(groups = {"smoke", "regression"})
    public void verifyTheUsernameErrorMessage() {
        //* Enter “tomsmith1” username
        loginPage.enterUsernameField("tomsmith1");
        // Enter “SuperSecretPassword!” password
        loginPage.enterPasswordField("SuperSecretPassword!");
        //Click on ‘LOGIN’ button
        loginPage.clickOnLoginButton();
        //Verify the error message “Your username is invalid!”
        String expectedMessage = "Your username is invalid!\n" +
                "×";
        Assert.assertEquals(loginPage.getTextUserNameInvalid(), expectedMessage, "Message is not displayed");

    }

    @Test(groups = {"regression"})
    public void verifyThePasswordErrorMessage() {
        //* Enter “tomsmith” username
        loginPage.enterUsernameField("tomsmith");
        // * Enter “SuperSecretPassword” password
        loginPage.enterPasswordField("SuperSectomsmithretPassword");
        // * Click on ‘LOGIN’ button
        loginPage.clickOnLoginButton();
        // * Verify the error message “Your password is invalid!
        String expectedErrorMessage1 = "Your password is invalid!\n" +
                "×";
        Assert.assertEquals(loginPage.getTextPasswordInvalid(), expectedErrorMessage1, "Error message not displayed");


    }


}






