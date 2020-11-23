package com.buildSettings;

import com.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.json.JSONObject;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.stream.Stream;


public class TestEnvironment {

    protected static Logger logger = LoggerFactory.getLogger(Logger.class);

    protected static final String ANSI_RED = "\u001B[31m";
    protected static final String ANSI_RESET = "\u001B[0m";
    protected static final String ANSI_BLUE = "\u001b[34m";
    protected static final String ANSI_GREEN = "\u001B[32m";
    protected static final String EXECUTOR = "GRADLE";
    public static final String HOME_URL = "https://www.booking.com/";

    protected static final String DEFAULT_REMOTE_BROWSER = System.getProperty
            ("remote.browser", "chrome");
    protected static final String DEFAULT_TESTS_EXECUTOR = System.getProperty
            ("tests.executor", "chrome");
    protected static final String SELENIUM_GRID_URL = System.getProperty
            ("selenium.gridURL", "http://localhost:4444/wd/hub");
    protected static final String BROWSERSTACK_HOST_URL = System.getProperty
            ("browserstack.hostURL", "https://localhost:3000");

    public static String getCurrentPath() {
        return Paths.get(".").toAbsolutePath().normalize().toString();
    }

    public void allureWriteProperties() {
        Properties properties = new Properties();
        properties.setProperty("All tests were executed on:", HOME_URL);
        properties.setProperty("Browser:", DEFAULT_TESTS_EXECUTOR);
        try {
            properties.store(new FileOutputStream("build/allure-results/environment.properties"), null);
        } catch (IOException e) {
            logger.error("Failed to create properties file!", e);
        }
    }

    public void allureWriteExecutors() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", EXECUTOR);
        jsonObject.put("type", EXECUTOR);
        try {
            FileWriter fileWriter = new FileWriter("build/allure-results/executor.json");
            fileWriter.write(jsonObject.toString());
            fileWriter.flush();
        } catch (IOException e) {
            logger.error("Failed to create json object!", e);
        }
    }

    @Attachment(value = "TestNG test FAIL logs", type = "text/plain")
    public String allureSaveTextLog(ITestResult iTestResult) {
        return logBuilder(MessageBuilder.getTestDescription(iTestResult));
    }

    @Attachment(value = "Scenario FAIL screenshot", type = "image/png")
    public byte[] allureSaveScreenshotPNG() {
        return ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
    }

    protected String logBuilder(String fileName) {
        String path = getCurrentPath()
                + File.separator
                + "logs"
                + File.separator;
        path += fileName + ".log";
        StringBuilder contentBuilder = new StringBuilder();
        try (Stream<String> stream = Files.lines(Paths.get(path), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        } catch (IOException e) {
            logger.error("Failed to attach .log file!", e);
        }
        return contentBuilder.toString();
    }

    public void deleteOldLogs() {
        try {
            FileUtils.deleteDirectory(new File(getCurrentPath()
                    + File.separator
                    + "logs"));
        } catch (IOException e) {
            logger.error("Failed to delete logs directory!", e);
        }
    }

    protected enum Timeouts {
        SCRIPT_TIMEOUT(15),
        PAGE_LOAD_TIMEOUT(30),
        CLICK_TIMEOUT(15),
        VISIBLE_TIMEOUT(30);

        public final int value;

        Timeouts(int value) {
            this.value = value;
        }
    }

    protected void displayWebDriverManagerBrowsersVersions(Boolean showBrowserVersions) {
        if (showBrowserVersions) {
            logger.info("ChromeDriver available versions: %s", WebDriverManager.chromedriver().getDriverVersions());
            logger.info("GeckoDriver available versions: %s", WebDriverManager.firefoxdriver().getDriverVersions());
            logger.info("OperaDriver available versions: %s ", WebDriverManager.operadriver().getDriverVersions());
            logger.info("EdgeDriver available versions: %s", WebDriverManager.edgedriver().getDriverVersions());
            logger.info("IEDriver available versions: %s", WebDriverManager.iedriver().getDriverVersions());
        }
    }
}