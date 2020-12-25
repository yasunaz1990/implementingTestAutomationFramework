package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.DriverUtil;

public class RegistrationPage {
    private WebDriver driver = DriverUtil.getDriver();

    // --- List of Element locations
    private By first_name = By.id("customer.firstName");
    private By last_name = By.id("customer.lastName");
    private By street_addr = By.id("customer.address.street");
    private By user_city = By.id("customer.address.city");
    private By user_sate = By.id("customer.address.state");
    private By user_zipcode = By.id("customer.address.zipCode");
    private By phone_num = By.id("customer.phoneNumber");
    private By user_ssn = By.id("customer.ssn");
    private By user_name = By.id("customer.username");
    private By pass_word = By.id("customer.password");
    private By pass_confirm = By.id("repeatedPassword");
    private By register_bttn = By.cssSelector("[value='Register']");
    private By comfirmation_text = By.cssSelector("#rightPanel p");

    // --- List of Methods ( User actions )
    public void enterName(String firstName, String lastName) {
        // Entering first name
        WebElement firstNameInput = driver.findElement(first_name);
        firstNameInput.sendKeys(firstName);

        // Entering last name
        WebElement lastNameInput = driver.findElement(last_name);
        lastNameInput.sendKeys(lastName);
    }

    public void enterAddress(String street, String city, String state, String zipcode) {
        // Entering Address
        WebElement streetAddrInput = driver.findElement(street_addr);
        streetAddrInput.sendKeys(street);

        // Entering City
        WebElement cityInput = driver.findElement(user_city);
        cityInput.sendKeys(city);

        // Entering Sate
        WebElement stateInput = driver.findElement(user_sate);
        stateInput.sendKeys(state);

        // Entering zip code
        WebElement zipcodeInput = driver.findElement(user_zipcode);
        zipcodeInput.sendKeys(zipcode);
    }

    public void enterUserInfo(String phone, String ssn) {
        // Entering phone number
        WebElement phoneNumber = driver.findElement(phone_num);
        phoneNumber.sendKeys(phone);

        // Entering SSN
        WebElement ssnInput = driver.findElement(user_ssn);
        ssnInput.sendKeys(ssn);
    }

    public void enterCredential(String username, String password) {
        // Entering Username
        WebElement userNameInput = driver.findElement(user_name);
        userNameInput.sendKeys(username);

        // Entering Password
        WebElement passwordInput = driver.findElement(pass_word);
        passwordInput.sendKeys(password);

        // Confirming Password
        WebElement passwordConfirm = driver.findElement(pass_confirm);
        passwordConfirm.sendKeys(password);
    }

    public void clickRegistration() {
        // Clicking REGISTER button
        WebElement registerButton = driver.findElement(register_bttn);
        registerButton.click();
    }

    public String getConfirmationText() {
        // Extracting confirmation text
        WebElement comfirmation = driver.findElement(comfirmation_text);
        String actualMessage = comfirmation.getText();
        return actualMessage;
    }
}
