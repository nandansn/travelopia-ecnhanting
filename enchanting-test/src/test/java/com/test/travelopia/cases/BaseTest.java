package com.test.travelopia.cases;

import com.test.travlopia.utility.DriverUtility;
import com.test.travlopia.utility.PropertiesParser;
import com.test.travlopia.utility.TestContext;
import com.test.travlopia.utility.TestProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.DriverManager;


abstract public class BaseTest {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    TestProperties testProperties;


    String testPropertyPath = "src/test/resources/properties/test.properties.yml";



    public WebDriver driver(String browserName) {
        loadProperties();
        WebDriver driver = null;
        try {
            driver = DriverUtility.getDriver(testProperties, browserName);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            Assert.fail("Driver Creation failed");
        }

        return driver;
    }

    private void loadProperties() {
        TestContext testContext = new TestContext(testPropertyPath);
        testContext.setProperties();
        this.testProperties = testContext.getProperties();
    }

    abstract public void createdriver(String browser);
   abstract public void closeDriver();
}
