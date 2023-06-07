package com.test.travelopia.cases;

import org.testng.annotations.*;

import java.io.IOException;

@Test
public class DemoTest extends BaseTest {

    @BeforeMethod
    public void beforeTest() {
       openApp();
    }

    @Test
    public void testOne()  {
        //System.out.println(testProperties.getUrl());
//        driver.get(testProperties.getUrl());
    }

    @Test
    public void testTwo()  {
        //System.out.println(testProperties.getUrl());
        //driver.get(testProperties.getUrl());
    }

    @Test
    public void testThree()  {
        //System.out.println(testProperties.getUrl());
        //driver.get(testProperties.getUrl());
    }



    @AfterTest
    public void close() {
        driver.quit();
    }
}
