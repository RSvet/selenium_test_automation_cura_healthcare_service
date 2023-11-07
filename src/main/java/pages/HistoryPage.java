package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HistoryPage extends BasicPage{
    public HistoryPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public String getNoAppointmentElementText(){
        return driver.findElement(By.cssSelector("#history div p:nth-child(3)")).getText();
    }

    public boolean isAppointmentPanelPresent(){
        List<WebElement> appointmentPanel = driver.findElements(By.className("panel-info"));
        return !appointmentPanel.isEmpty();
    }

    public String getFacilityText(){
        return   driver.findElement(By.id("facility")).getText();
    }

    public String getAppointmentDate(){
        return driver.findElement(By.className("panel-heading")).getText();
    }
    public String getHealthcareProgram(){
        return driver.findElement(By.id("program")).getText();
    }
    public String getHospitalReadmission(){
        return driver.findElement(By.id("hospital_readmission")).getText();
    }
    public String getComment(){
        return driver.findElement(By.id("comment")).getText();
    }
}
