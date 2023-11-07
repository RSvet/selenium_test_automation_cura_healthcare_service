package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import retry.RetryAnalyzer;

public class MakeAppointmentTests extends BasicTest{
    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void trySubmittingFormWithoutDate() {
        String username = "John Doe";
        String password = "ThisIsNotAPassword";
        sideNavPage.clickOnHamburgerButton();
        sideNavPage.waitForSideNav();
        sideNavPage.clickOnLoginButton();
        wait
                .withMessage("Url should be " + baseUrl + "profile.php#login")
                .until(ExpectedConditions.urlToBe(baseUrl + "profile.php#login"));
        loginPage.getUsernameInput().sendKeys(username);
        loginPage.getPasswordInput().sendKeys(password);
        loginPage.clickOnLoginButton();
        wait
                .withMessage("User is not logged in")
                .until(ExpectedConditions.urlToBe(baseUrl + "#appointment"));

        appointmentPage.clickBookAppointmentButton();
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "#appointment", "User is redirected");
    }

}
