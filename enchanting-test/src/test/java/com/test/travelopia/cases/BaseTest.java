package com.test.travelopia.cases;

import com.test.travlopia.utility.PropertiesParser;
import com.test.travlopia.utility.TestProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.DriverManager;


public class BaseTest {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    TestProperties testProperties;

    WebDriver driver;


    public void loadTestProperties() {
        try {
            logger.info("loading properties");
            testProperties = new PropertiesParser<TestProperties>("src/test/resources/properties/test.properties.yml", TestProperties.class).getProperty();
        } catch (IOException e) {
            logAndFail(e);
        }
    }

    public void logAndFail(Exception e) {
        logger.error(e.getMessage());
        e.printStackTrace();
        Assert.fail(e.getMessage());
    }

    public void loadDriver() throws MalformedURLException {
        System.out.println("load driver");
        System.out.println(testProperties.getUrl());
        //driver = WebDriverManager.getInstance(testProperties.getBrowserProperty().getName()).create();

        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), new ChromeOptions());
        System.out.println(driver == null);
        System.out.println(driver);
        driver.get(testProperties.getUrl());
        logger.info("driver loaded");
    }

    protected void openApp() {

        if (driver == null) {
            logAndFail(new Exception("Driver not loaded"));
        }
        driver.get(testProperties.getUrl());
    }
}
