package tests;

import base.TestBase;
import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.java.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LandingPage;
import pages.RegistrationPage;
import utility.DriverUtil;

public class ParabankSmokeTest extends TestBase {

    @Test
    public void registerTestCase() {
        // --- Test Data
        String firstName = faker().name().firstName();
        String lastName = faker().name().lastName();
        String streeAddr = faker().address().streetAddress();
        String cityVal = faker().address().city();
        String stateVal = faker().address().state();
        String zipcodeVal = faker().address().zipCode();
        String phoneNumVal = faker().phoneNumber().cellPhone();
        String ssnVal = faker().idNumber().ssnValid();
        String usernameVal = getRandomeUserName();
        String passwordVal = faker().internet().password();
        String expectedMessage = "Your account was created successfully.";


        // --- Test Steps
        LandingPage landing = new LandingPage();
        landing.open();
        landing.goToRegistration();


        RegistrationPage register = new RegistrationPage();
        register.enterName(firstName, lastName);
        register.enterAddress(streeAddr, cityVal, stateVal, zipcodeVal);
        register.enterUserInfo(phoneNumVal, ssnVal);
        register.enterCredential(usernameVal, passwordVal);
        register.clickRegistration();

        String actualMessage = register.getConfirmationText();


        // Test Assertion
        Assert.assertEquals(actualMessage, expectedMessage);
    }


}
