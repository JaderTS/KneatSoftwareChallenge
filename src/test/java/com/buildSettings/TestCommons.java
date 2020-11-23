package com.buildSettings;

import com.DriverFactory;
import com.google.common.collect.ImmutableMap;
import org.apache.xmlbeans.SchemaTypeLoader;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.Command;
import org.openqa.selenium.remote.CommandExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class TestCommons extends TestEnvironment {

    public void waitForElementToBeClickable(WebElement webElement) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Timeouts.CLICK_TIMEOUT.value);
            wait.until(ExpectedConditions.elementToBeClickable(webElement));
        } catch (ElementNotInteractableException e) {
            logger.error("Couldn't click on element \"%S\"!", webElement);
        }
    }

    public void waitForElementToBeVisible(WebElement webElement) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Timeouts.VISIBLE_TIMEOUT.value);
            wait.until(ExpectedConditions.visibilityOf(webElement));
        } catch (ElementNotVisibleException e) {
            logger.error("Couldn't display element \"%S\"!", webElement);
        }
    }


    public boolean isElementVisible(WebElement webElement) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Timeouts.VISIBLE_TIMEOUT.value);
            wait.until(ExpectedConditions.visibilityOf(webElement));
            return true;
        } catch (ElementNotVisibleException e) {
            logger.error(String.format("Couldn't display element \"%S\"!", webElement));
            return false;
        }
    }

    public void selectFromDropdownByValue(String textValue, WebElement webElement) {
        try {
            Select dropdown = new Select(webElement);
            dropdown.selectByValue(textValue);
        } catch (ElementNotSelectableException e) {
            logger.error(String.format("Error", textValue, webElement));
        }
    }

    public int getRandomIntValue(int max, int min) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }

    public String getRandomStringValue(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        SecureRandom secureRandom = new SecureRandom();
        StringBuilder stringBuilder = new StringBuilder(length);
        for (int i = 0; i < length; i++)
            stringBuilder.append(characters.charAt(secureRandom.nextInt(characters.length())));
        return stringBuilder.toString();
    }

    public static boolean isPageReady() {
        try {
            WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Timeouts.PAGE_LOAD_TIMEOUT.value);
            wait.until(webDriver ->
                    ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        } catch (WebDriverException e) {
            logger.error("Page wasn't ready to execute tests: %s!", DriverFactory.getDriver().getCurrentUrl());
            return false;
        }
        return true;
    }

    public void customClick(WebElement webElement) {
        waitForElementToBeClickable(webElement);
        try {
            webElement.click();
        } catch (ElementNotInteractableException e) {
            logger.error(String.format("Couldn't click on element \"%S\"!", webElement), e);
        }
    }


    public void customSendKeys(WebElement webElement, String whatToSend) {
        waitForElementToBeVisible(webElement);
        try {
            webElement.sendKeys(whatToSend);
        } catch (ElementNotInteractableException e) {
            logger.error(String.format("Couldn't send \"%S\" on element \"%S\"!", whatToSend, webElement), e);
        }
    }

    public void networkThrottling(boolean enableThrottling) throws IOException {
        Map<String, Object> map = new HashMap<>();
        if (enableThrottling) {
            map.put("offline", true);
            map.put("latency", 10000);
            map.put("download_throughput", 0);
            map.put("upload_throughput", 0);
            CommandExecutor executor = ((ChromeDriver) DriverFactory.getDriver()).getCommandExecutor();
            executor.execute(new Command(((ChromeDriver) DriverFactory.getDriver()).getSessionId(), "setNetworkConditions",
                    ImmutableMap.of("network_conditions", ImmutableMap.copyOf(map)))
            );
        }
    }

    public void test(WebElement webElement) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.MONTH, +3);

        Date d = c.getTime();
        String res = format.format(d);

        webElement.findElement(By.xpath("/td[contains(@data-date,'" + res + "')]")).click();
    }
}