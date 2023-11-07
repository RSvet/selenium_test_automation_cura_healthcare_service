package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SummaryPage extends BasicPage{
    public SummaryPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public WebElement appointmentConfirmation(){
        return driver.findElement(By.tagName("h2"));
    }
    public String getAppointmentConfirmationText(){
        return appointmentConfirmation().getText();
    }
    public String getFacilityName(){
        return driver.findElement(By.id("facility")).getText();
    }
    public String getProgramName(){
        return driver.findElement(By.id("program")).getText();
    }
    public String visitDate(){
        return driver.findElement(By.id("visit_date")).getText();
    }
    public WebElement getGoToHomePageButton(){
        return driver.findElement(By.linkText("Go to Homepage"));
    }

    public void clickOnGoToHomePageButton(){
        getGoToHomePageButton().click();
    }
}
