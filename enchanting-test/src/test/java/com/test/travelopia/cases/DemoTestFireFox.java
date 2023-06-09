package com.test.travelopia.cases;

import com.test.travelopia.flows.HomeFlow;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@Test
public class DemoTestFireFox extends BaseTest {

    WebDriver driver;


    @BeforeTest
    @Parameters("browser")
    @Override
    public void createdriver(String browser) {
        this.driver = driver(browser);
    }


    @Test
    public void testOne() {
        HomeFlow homeFlow = new HomeFlow(driver, testProperties.getUrl());
        homeFlow.clickBlog();
    }

    @Test
    public void testTwo() {
        HomeFlow homeFlow = new HomeFlow(driver, testProperties.getUrl());
        homeFlow.clickBlog();
    }

    @Test
    public void testThree() {
        HomeFlow homeFlow = new HomeFlow(driver, testProperties.getUrl());
        homeFlow.clickBlog();
    }


    @AfterTest
    @Override
    public void closeDriver() {
        this.driver.quit();
    }
}
