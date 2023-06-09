package com.test.travlopia.utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverUtility {

    public static WebDriver getDriver(TestProperties testProperties, String browserName) throws MalformedURLException {
        String name = System.getProperty("test.environment");
        WebDriver driver = null;
        if (name.equals("local")) {
            EnvironmentProperty environmentProperty = testProperties.getEnvironmentProperty().stream()
                    .filter(e -> e.getName().equals(name))
                    .findFirst()
                    .get();
            BrowserProperty browserProperty = environmentProperty.browsers.stream()
                    .filter(b -> b.getName().equals(browserName))
                    .findFirst()
                    .get();
            driver = getLocalDriver(browserProperty.getName());


            driver.manage().window().maximize();
        } else if (name.equals("remote")) {
            EnvironmentProperty environmentProperty = testProperties.getEnvironmentProperty()
                    .stream()
                    .filter(e -> e.name.equals(name))
                    .findFirst().get();


            BrowserProperty browserProperty = environmentProperty.browsers.stream()
                    .filter(b -> b.getName().equals(browserName))
                    .findFirst()
                    .get();

            MutableCapabilities mutableCapabilities = null;

            if (browserProperty.getName().equals("chrome")) {
                mutableCapabilities = new ChromeOptions();
            }

            driver = getRemoteDriver(environmentProperty.getHubUrl(), mutableCapabilities);
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
