package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import retry.RetryAnalyzer;

public class CheckHistoryPageTests extends BasicTest{
    @Test(priority=1, retryAnalyzer = RetryAnalyzer.class)
    public void checkHistoryPageWithoutAppointment(){
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

        sideNavPage.clickOnHistoryButton();

        wait
                .withMessage("Url should be "+baseUrl+"history.php#history")
                .until(ExpectedConditions.urlToBe(baseUrl+"history.php#history"));

        Assert.assertEquals(historyPage.getNoAppointmentElementText(), "No appointment.",
                "There should be no appointment text");
    }

    @Test(priority=2, retryAnalyzer = RetryAnalyzer.class)
    public void checkHistoryPageWithAppointment(){

        String facility = "Hongkong CURA Healthcare Center";
        String healthcare = "Medicare";

        appointmentPage.selectFacility(facility);
        appointmentPage.selectHealthcare(healthcare);
        appointmentPage.setTomorrowDate();
        appointmentPage.clickBookAppointmentButton();
        wait
                .withMessage("User is not on the appointment summary page")
                .until(ExpectedConditions.urlToBe(baseUrl+"appointment.php#summary"));


        sideNavPage.clickOnHamburgerButton();

        sideNavPage.clickOnHistoryButton();

        wait
                .withMessage("Url should be "+baseUrl+"history.php#history")
                .until(ExpectedConditions.urlToBe(baseUrl+"history.php#history"));
        Assert.assertTrue(historyPage.isAppointmentPanelPresent(), "Pannel with appointment info is not present");
        Assert.assertEquals(historyPage.getFacilityText(), facility,
                "Facility should be "+facility);

    }
}
