package tests;

import helper.Helper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.AppointmentPage;
import pages.Homepage;
import pages.LoginPage;
import pages.SideNavPage;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

public abstract class BasicTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected String baseUrl = "https://katalon-demo-cura.herokuapp.com/";
    protected Homepage homepage;
    protected SideNavPage sideNavPage;
    protected LoginPage loginPage;
    protected AppointmentPage appointmentPage;



    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        homepage = new Homepage(driver, wait);
        sideNavPage = new SideNavPage(driver,wait);
        loginPage = new LoginPage(driver, wait);
        appointmentPage = new AppointmentPage(driver, wait);
    }
    @BeforeMethod
    public void beforeMethod(){
        driver.navigate().to(baseUrl);
    }

    @AfterMethod
    public void afterMethod(ITestResult testResult) throws IOException {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            Date date = Calendar.getInstance().getTime();
            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh-mm-ss");
            String currentDate = dateFormat.format(date);
            Helper.takeAScreenshot(driver, "screenshots/" + testResult.getName() +"_"+currentDate+".jpg");
        }
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
