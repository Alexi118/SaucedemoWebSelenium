package testscases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import pages.HomePage;
import pages.LoginPage;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;

import utils.Constants;

public class BaseTest {
    protected WebDriver driver;
    protected LoginPage loginPage;
    protected HomePage homePage;
    protected WebDriverWait shortWait;
    protected WebDriverWait normalWait;
    protected WebDriverWait longWait;

    @Parameters({"browserName"})
    @BeforeMethod
    public void setUp(String browserName) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();

        if (browserName.equalsIgnoreCase("ff")) {
            driver = new FirefoxDriver();
        } else {
            /* (Add Options to run with Chrome (headless))
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--no-sandbox");
            chromeOptions.addArguments("--headless");
            chromeOptions.addArguments("disable-gpu");
            driver = new ChromeDriver(chromeOptions);
            */
            driver = new ChromeDriver();
        }

        driver.manage().window().maximize();
        driver.get(Constants.baseURL);

        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);

        shortWait = new WebDriverWait(driver, Duration.ofSeconds(Constants.Short));
        normalWait = new WebDriverWait(driver, Duration.ofSeconds(Constants.Normal));
        longWait = new WebDriverWait(driver, Duration.ofSeconds(Constants.Long));
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws IOException{
        if(result.getStatus() == ITestResult.FAILURE){
            DateFormat formatter = new SimpleDateFormat("yyyyMMddhhmmss");
            Calendar cal = Calendar.getInstance();
            String timeStamp = formatter.format(cal.getTime());
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(srcFile, new File("src\\screenshot\\screenshot-" + timeStamp + ".png"));
        }
        //driver.quit();
    }
}