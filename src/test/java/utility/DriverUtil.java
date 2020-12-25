package utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverUtil {

    private static WebDriver driver;

    public static void openBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }


    public static void closeBrowser() {
        if(driver != null) {
            driver.quit();
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
