package com.test.travelopia.flows;

import com.test.travelopia.pages.HomePage;
import org.openqa.selenium.WebDriver;

public class HomeFlow {

    HomePage homePage;

    public HomeFlow(WebDriver driver, String url) {
        driver.get(url);
        this.homePage = new HomePage(driver);
    }


    public void clickBlog() {
        this.homePage.getNavBlog().click();
    }
}
