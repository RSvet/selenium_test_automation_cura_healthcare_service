package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SideNavPage extends BasicPage{
    public SideNavPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public WebElement getHamburgerButton(){
        return driver.findElement(By.id("menu-toggle"));
    }
    public void clickOnHamburgerButton(){
        getHamburgerButton().click();
    }

    public void waitForSideNav(){
        wait
                .withMessage("Sidenav is not visible")
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#sidebar-wrapper.active")));
    }

    public WebElement getLoginButton(){
        return driver.findElement(By.linkText("Login"));
    }

    public void clickOnLoginButton(){
        getLoginButton().click();
    }

}