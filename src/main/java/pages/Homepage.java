package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Homepage extends BasicPage {
    public Homepage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public WebElement getMakeAppointmentButton(){
        return driver.findElement(By.id("btn-make-appointment"));
    }
    public void clickMakeAppointmentButton(){
        getMakeAppointmentButton().click();
    }

}
