package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import retry.RetryAnalyzer;

public class UserLoginTests extends BasicTest{
    @Test(priority=1, retryAnalyzer = RetryAnalyzer.class)
    public void tryToLoginPageWithoutCredentials(){
        sideNavPage.clickOnHamburgerButton();
        sideNavPage.waitForSideNav();
        sideNavPage.clickOnLoginButton();
        wait
                .withMessage("Url should be "+baseUrl+"profile.php#login")
                .until(ExpectedConditions.urlToBe(baseUrl+"profile.php#login"));
        loginPage.clickOnLoginButton();
        loginPage.waitForErrorMessage();
        Assert.assertEquals(loginPage.getErrorMessage(), "Login failed! Please ensure the username and password are valid.",
                "Error message is not present or correct");
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl+"profile.php#login", "User is not on the login page");
    }

    @Test(priority=2, retryAnalyzer = RetryAnalyzer.class)
    public void tryToLoginWithWrongUsername(){
        String username = "Wrong username";
        String password = "ThisIsNotAPassword";

        sideNavPage.clickOnHamburgerButton();
        sideNavPage.waitForSideNav();
        sideNavPage.clickOnLoginButton();
        wait
                .withMessage("Url should be "+baseUrl+"profile.php#login")
                .until(ExpectedConditions.urlToBe(baseUrl+"profile.php#login"));
        loginPage.getUsernameInput().sendKeys(username);
        loginPage.getPasswordInput().sendKeys(password);
        loginPage.clickOnLoginButton();
        loginPage.waitForErrorMessage();
        Assert.assertEquals(loginPage.getErrorMessage(), "Login failed! Please ensure the username and password are valid.",
                "Error message is not present or correct");
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl+"profile.php#login", "User is not on the login page");
    }

    @Test(priority=3, retryAnalyzer = RetryAnalyzer.class)
    public void tryToLoginWithWrongPassword(){
        String username = "John Doe";
        String password = "WrongPassword";

        sideNavPage.clickOnHamburgerButton();
        sideNavPage.waitForSideNav();
        sideNavPage.clickOnLoginButton();
        wait
                .withMessage("Url should be "+baseUrl+"profile.php#login")
                .until(ExpectedConditions.urlToBe(baseUrl+"profile.php#login"));
        loginPage.getUsernameInput().sendKeys(username);
        loginPage.getPasswordInput().sendKeys(password);
        loginPage.clickOnLoginButton();
        loginPage.waitForErrorMessage();
        Assert.assertEquals(loginPage.getErrorMessage(), "Login failed! Please ensure the username and password are valid.",
                "Error message is not present or correct");
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl+"profile.php#login", "User is not on the login page");
    }

    @Test(priority=4, retryAnalyzer = RetryAnalyzer.class)
    public void tryToLoginWithCorrectCredentials(){
        String username = "John Doe";
        String password = "ThisIsNotAPassword";

        sideNavPage.clickOnHamburgerButton();
        sideNavPage.waitForSideNav();
        sideNavPage.clickOnLoginButton();
        wait
                .withMessage("Url should be "+baseUrl+"profile.php#login")
                .until(ExpectedConditions.urlToBe(baseUrl+"profile.php#login"));
        loginPage.getUsernameInput().sendKeys(username);
        loginPage.getPasswordInput().sendKeys(password);
        loginPage.clickOnLoginButton();

        Assert.assertEquals(driver.getCurrentUrl(), baseUrl+"#appointment", "User is not logged in");

        sideNavPage.clickOnHamburgerButton();
        Assert.assertTrue(sideNavPage.isLogoutPresent(),"Logout is not present");
        sideNavPage.clickLogout();

        wait
                .withMessage("User did not log out")
                .until(ExpectedConditions.urlToBe(baseUrl));

    }
}
