package tests;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ParabankSmokeTest {

    @Test
    public void registerTestCase() {
        // --- Test Data
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String streeAddr = faker.address().streetAddress();
        String cityVal = faker.address().city();
        String stateVal = faker.address().state();
        String zipcodeVal = faker.address().zipCode();
        String phoneNumVal = faker.phoneNumber().cellPhone();
        String ssnVal = faker.idNumber().ssnValid();
        String usernameVal = faker.name().username();
        String passwordVal = faker.internet().password();
        String expectedMessage = "Your account was created successfully.";

        // --- Test Steps
        WebDriverManager.chromedriver().setup();  // download
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
        By register_link = By.linkText("Register");
        WebElement registerLink = driver.findElement(register_link);
        registerLink.click();

        // Entering first name
        By first_name = By.id("customer.firstName");
        WebElement firstNameInput = driver.findElement(first_name);
        firstNameInput.sendKeys(firstName);

        // Entering last name
        By last_name = By.id("customer.lastName");
        WebElement lastNameInput = driver.findElement(last_name);
        lastNameInput.sendKeys(lastName);

        // Entering Address
        By street_addr = By.id("customer.address.street");
        WebElement streetAddrInput = driver.findElement(street_addr);
        streetAddrInput.sendKeys(streeAddr);

        // Entering City
        By city = By.id("customer.address.city");
        WebElement cityInput = driver.findElement(city);
        cityInput.sendKeys(cityVal);

        // Entering Sate
        By sate = By.id("customer.address.state");
        WebElement stateInput = driver.findElement(sate);
        stateInput.sendKeys(stateVal);

        // Entering zip code
        By zipcode = By.id("customer.address.zipCode");
        WebElement zipcodeInput = driver.findElement(zipcode);
        zipcodeInput.sendKeys(zipcodeVal);

        // Entering phone number
        By phone_num = By.id("customer.phoneNumber");
        WebElement phoneNumber = driver.findElement(phone_num);
        phoneNumber.sendKeys(phoneNumVal);

        // Entering SSN
        By user_ssn = By.id("customer.ssn");
        WebElement ssn = driver.findElement(user_ssn);
        ssn.sendKeys(ssnVal);

        // Entering Username
        By user_name = By.id("customer.username");
        WebElement userName = driver.findElement(user_name);
        userName.sendKeys(usernameVal);

        // Entering Password
        By pass_word = By.id("customer.password");
        WebElement password = driver.findElement(pass_word);
        password.sendKeys(passwordVal);

        // Confirming Password
        By pass_confirm = By.id("repeatedPassword");
        WebElement passwordConfirm = driver.findElement(pass_confirm);
        passwordConfirm.sendKeys(passwordVal);

        // Clicking REGISTER button
        By register_bttn = By.cssSelector("[value='Register']");
        WebElement registerButton = driver.findElement(register_bttn);
        registerButton.click();

        // Extracting confirmation text
        By comfirmation_text = By.cssSelector("#rightPanel p");
        WebElement comfirmation = driver.findElement(comfirmation_text);
        String actualMessage = comfirmation.getText();

        driver.quit();

        // Test Assertion
        Assert.assertEquals(actualMessage, expectedMessage);
    }

}
