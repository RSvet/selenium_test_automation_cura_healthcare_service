package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HistoryPage extends BasicPage{
    public HistoryPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public String getNoAppointmentElementText(){
        return driver.findElement(By.cssSelector("#history div p:nth-child(3)")).getText();
    }
}
