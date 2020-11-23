package com.buildListeners;

import com.DriverFactory;
import com.buildSettings.MessageBuilder;
import com.buildSettings.TestEnvironment;
import io.cucumber.java.Scenario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class TestNGListener implements ITestListener {

    public static List<String> passedTests = new ArrayList<>();
    public static List<String> failedTests = new ArrayList<>();

    private final MessageBuilder messageBuilder = new MessageBuilder();
    private final TestEnvironment testEnvironment = new TestEnvironment();
    protected static Logger logger = LoggerFactory.getLogger(Logger.class);


    @Override
    public synchronized void onStart(ITestContext iTestContext) {
        testEnvironment.deleteOldLogs();
        messageBuilder.messageStartSuite(iTestContext);
    }

    @Override
    public synchronized void onFinish(ITestContext iTestContext) {
        messageBuilder.messageEndSuite(iTestContext);
        testEnvironment.allureWriteExecutors();
        testEnvironment.allureWriteProperties();
    }

    @Override
    public synchronized void onTestStart(ITestResult iTestResult) {
        messageBuilder.messageStartTest(iTestResult);
    }

    @Override
    public synchronized void onTestSuccess(ITestResult iTestResult) {
        messageBuilder.messageSuccessTest();
        passedTests.add(MessageBuilder.getTestDescription(iTestResult));
    }

    @Override
    public synchronized void onTestFailure(ITestResult iTestResult) {
        messageBuilder.messageFailTest();
        failedTests.add(MessageBuilder.getTestDescription(iTestResult));
        logger.error(String.valueOf(iTestResult.getThrowable()));
        if (DriverFactory.getDriver() != null) {
            testEnvironment.allureSaveScreenshotPNG();
        }
        testEnvironment.allureSaveTextLog(iTestResult);
    }

    public void onScenarioStart(Scenario scenario) {
        messageBuilder.messageStartScenario(scenario);
    }

    public void onScenarioFinish(Scenario scenario) throws IOException {
        messageBuilder.messageFinishScenario(scenario);
    }

}