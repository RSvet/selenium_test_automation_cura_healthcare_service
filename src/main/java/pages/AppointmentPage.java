package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

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
}
