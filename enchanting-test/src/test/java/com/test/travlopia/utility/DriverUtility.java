package com.test.travlopia.utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverUtility {

    public static WebDriver getDriver(TestProperties testProperties) {
        String name = System.getProperty("test.environment");
        WebDriver driver = null;
        if (name.equals("local")) {
            driver = getLocalDriver(testProperties.browserProperty.getName());
        } else {
            return null;
        }

        return driver;

    }

    private static WebDriver getLocalDriver(String browserName) {
        return WebDriverManager.getInstance(browserName).create();
    }

    private static WebDriver getRemoteDriver(String hubUrl, MutableCapabilities mutableCapabilities)
            throws MalformedURLException {
        return new RemoteWebDriver(new URL(hubUrl), mutableCapabilities);
    }


}
