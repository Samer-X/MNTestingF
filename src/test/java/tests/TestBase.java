package tests;

import io.cucumber.java.Before;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utilities.Helper;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class TestBase extends AbstractTestNGCucumberTests {

    public static WebDriver driver;

    public static String downloadPath = "Testing_Framework\\downloads";

    @BeforeSuite
    @Parameters({"browser"})
    public void startDriver(@Optional("chrome") String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            String chromePath = "drivers\\chromedriver.exe";
            System.setProperty("webdriver.chrome.driver", chromePath);

            // We can all these in one method that return options with type ChromeOptions
            ChromeOptions options = new ChromeOptions();
            HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
            chromePrefs.put("profile.default_content_settings.popups", 0);
            chromePrefs.put("download.default_directory", downloadPath);
            options.setExperimentalOption("prefs", chromePrefs);
            options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

            driver = new ChromeDriver(options);

        } else if (browserName.equalsIgnoreCase("firefox")) {
            String geckoPath = "drivers\\geckodriver.exe";
            System.setProperty("webdriver.gecko.driver", geckoPath);

            // We can all these in one method that return options with type ChromeOptions
            FirefoxOptions options = new FirefoxOptions();
            options.addPreference("browser.download.folderList",2);
            options.addPreference("browser.download.dir",downloadPath);
            options.addPreference("browser.helperApps.neverAsk.saveToDisk","application/pdf");
            options.addPreference("pdfjs.disabled", true);

            driver = new FirefoxDriver(options);

        } else if (browserName.equalsIgnoreCase("ie")) {
            String IEPath = "drivers\\IEDriverServer.exe";
            System.setProperty("webdriver.ie.driver", IEPath);
            driver = new InternetExplorerDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        driver.navigate().to("https://demo.nopcommerce.com/");
    }


    @AfterSuite
    public void stopDriver() {
        driver.quit();
    }

    @AfterMethod
    public void takeScreenshotOnFailure(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            System.out.println("Failed");
            System.out.println("Taking Screenshot...");
            Helper.takeSnapShot(driver, result.getName());

        }

    }
}
