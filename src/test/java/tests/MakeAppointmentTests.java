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

    @Test(priority = 2, retryAnalyzer = RetryAnalyzer.class)
    public void trySubmittingFormWithEnteredDate() {
        String firstFacilityOption = "Tokyo CURA Healthcare Center";
        String firstHealthcareProgramOption = "Medicare";
        appointmentPage.setTomorrowDate();
        Assert.assertEquals(appointmentPage.getSelectedFacilityText(), firstFacilityOption,
                "Selected option should be " + firstFacilityOption);
        Assert.assertTrue(appointmentPage.isFirstHealthCareSelected(), "First healthcare option is not selected");
        appointmentPage.clickBookAppointmentButton();
        wait
                .withMessage("User is not on the appointment summary page")
                .until(ExpectedConditions.urlToBe(baseUrl + "appointment.php#summary"));

        Assert.assertEquals(summaryPage.getAppointmentConfirmationText(), "Appointment Confirmation",
                "Title should be 'Appointment Confirmation'");
        Assert.assertEquals(summaryPage.getFacilityName(), firstFacilityOption,
                "Facility name should be " + firstFacilityOption);
        Assert.assertEquals(summaryPage.getProgramName(), firstHealthcareProgramOption,
                "Program should be " + firstHealthcareProgramOption);
        Assert.assertEquals(summaryPage.visitDate(), appointmentPage.tomorrowDate(),
                "Visit date should be tomorrow");

        summaryPage.clickOnGoToHomePageButton();
        wait
                .withMessage("User is not on the home page")
                .until(ExpectedConditions.urlToBe(baseUrl));

    }


}
