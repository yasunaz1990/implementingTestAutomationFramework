package utility;

import base.TestBase;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    // Global Variables
    private ExtentReports extent;       // Report Manager
    private ExtentSparkReporter spark;  // Report Writer
    private ExtentTest testCaseSection; // Each Testcase section


    @Override
    public void onStart(ITestContext iTestContext) {
        extent = new ExtentReports();
        String filePath = System.getProperty("user.dir") + "/reports/result.html";
        spark = new ExtentSparkReporter(filePath);
        extent.attachReporter(spark);
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        extent.flush();  // saves the generated report content
    }


    // Before each test case is about to get executed
    @Override
    public void onTestStart(ITestResult iTestResult) {
        testCaseSection = extent.createTest(iTestResult.getName());

    }


    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        testCaseSection.pass("Test case was a success");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        testCaseSection.fail("Test case has failed");
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        testCaseSection.skip("Test case has skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        // DO NOTHING
    }
}
