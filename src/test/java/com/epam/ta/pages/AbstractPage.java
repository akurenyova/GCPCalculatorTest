package com.epam.ta.pages;

import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {

    protected WebDriver driver;
    protected static final String HOMEPAGE_URL = "https://cloud.google.com/";
    protected static final String TENMINUTEEMAIL_URL = "https://10minutemail.com/";

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }


}
