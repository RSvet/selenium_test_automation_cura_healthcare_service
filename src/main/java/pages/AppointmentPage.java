package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AppointmentPage extends BasicPage{
    public AppointmentPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public WebElement getBookAppointmentButton(){
        return driver.findElement(By.id("btn-book-appointment"));
    }
    public void clickBookAppointmentButton(){
        getBookAppointmentButton().click();
    }

    public WebElement getDateInput(){
        return driver.findElement(By.id("txt_visit_date"));
    }

    public String tomorrowDate(){
        return LocalDate.now().plusDays(1).format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
    public void setTomorrowDate(){
        getDateInput().sendKeys(tomorrowDate());
    };

    public String getSelectedFacilityText(){
        return new Select(driver.findElement(By.id("combo_facility"))).getFirstSelectedOption().getText();
    }
    public WebElement getFirstHealthcareProgram(){
        return driver.findElement(By.xpath("//label[@class='radio-inline'][1]/input[@name='programs']"));
    }
    public void setYesterdayDate(){
        LocalDate yesterday = LocalDate.now().minusDays(1);
        String dateInput = yesterday.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        getDateInput().sendKeys(dateInput);
    }

    public boolean isFirstHealthCareSelected(){
        return getFirstHealthcareProgram().isSelected();
    }


}
