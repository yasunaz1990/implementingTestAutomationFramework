package base;

import com.aventstack.extentreports.ExtentTest;
import com.github.javafaker.Faker;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utility.DriverUtil;

public abstract class TestBase {

    private Faker faker;

    @BeforeMethod
    public void setUp() {
        DriverUtil.openBrowser();
    }

    @AfterMethod
    public void cleanUp() {
        DriverUtil.closeBrowser();
    }

    public Faker faker() {
       if(faker == null) {
           faker = new Faker();
           return faker;
       }
       return faker;
    }

    public String getRandomeUserName() {
        return faker.name().username();
    }

}
