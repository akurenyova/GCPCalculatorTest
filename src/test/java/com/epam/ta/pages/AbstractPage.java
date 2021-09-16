package com.epam.ta.pages;

import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {

    protected WebDriver driver;
    protected static final String HOMEPAGE_URL = "testdata.goodlecloud.url";
    protected static final String TENMINUTEEMAIL_URL = "testdata.tenminemail.url";

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }


}
