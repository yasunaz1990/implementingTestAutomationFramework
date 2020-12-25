package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.DriverUtil;

public class LandingPage {
    private WebDriver driver = DriverUtil.getDriver();
    private String url = "https://parabank.parasoft.com/parabank/index.htm";

    // --- List of Element locations
    private By register_link = By.linkText("Register");

    // --- List of Methods ( User actions )
    public void open() {
        driver.get(url);
    }

    public void goToRegistration() {
        WebElement registerLink = driver.findElement(register_link);
        registerLink.click();
    }
}
