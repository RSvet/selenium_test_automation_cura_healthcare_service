package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasicPage{
    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getLoginButton(){
        return driver.findElement(By.id("btn-login"));
    }

    public void clickOnLoginButton(){
        getLoginButton().click();
    }

    public void waitForErrorMessage(){
        wait
                .withMessage("Error message is not visible")
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("p.lead.text-danger")));
    }

    public String getErrorMessage(){
        return driver.findElement(By.cssSelector("p.lead.text-danger")).getText();
    }


}
