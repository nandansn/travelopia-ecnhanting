package com.test.travelopia.cases;

import com.test.travlopia.utility.PropertiesParser;
import com.test.travlopia.utility.TestProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.io.IOException;
import java.sql.DriverManager;


public class BaseTest {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    TestProperties testProperties;

    WebDriver driver;

    {
        loadTestProperties();
        loadDriver();
    }


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

    public void loadDriver() {
        System.out.println("load driver");
        logger.info("loading driver...");
        driver = WebDriverManager.getInstance(testProperties.getBrowserProperty().getName()).create();
        logger.info("driver loaded");
    }

    protected void openApp() {
        //loadDriver();
        if (driver == null) {
            logAndFail(new Exception("Driver not loaded"));
        }
        driver.get(testProperties.getUrl());
    }
}
