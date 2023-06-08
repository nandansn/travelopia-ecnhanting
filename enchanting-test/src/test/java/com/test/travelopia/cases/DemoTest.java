package com.test.travelopia.cases;

import org.testng.annotations.*;

import java.io.IOException;

@Test
public class DemoTest extends BaseTest {

    @BeforeMethod
    public void beforeTest() {
        System.out.println("before test");
        loadTestProperties();
        loadDriver();
       openApp();
    }

    @Test
    public void testOne()  {
        //System.out.println(testProperties.getUrl());
//        driver.get(testProperties.getUrl());
    }

//    @Test
//    public void testTwo()  {
//        //System.out.println(testProperties.getUrl());
//        //driver.get(testProperties.getUrl());
//    }
//
//    @Test
//    public void testThree()  {
//        //System.out.println(testProperties.getUrl());
//        //driver.get(testProperties.getUrl());
//    }
//


    @AfterMethod
    public void close() {
        driver.quit();
    }
}
