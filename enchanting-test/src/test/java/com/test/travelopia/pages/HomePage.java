package com.test.travelopia.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

public class HomePage {

    @FindBy(css = "nav li a[href*='travel-blog']")
    WebElement navBlog;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public WebElement getNavBlog() {
        return navBlog;
    }
}
