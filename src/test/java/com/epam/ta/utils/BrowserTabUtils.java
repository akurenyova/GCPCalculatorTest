package com.epam.ta.utils;

import com.epam.ta.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.Iterator;
import java.util.Set;

public class BrowserTabUtils extends AbstractPage {

    public BrowserTabUtils(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void switchToNextTab() {
        String subWindowHandler = null;
        Set<String> handles = driver.getWindowHandles();
        Iterator<String> iterator = handles.iterator();
        while (iterator.hasNext()){
            subWindowHandler = iterator.next();
        }
        driver.switchTo().window(subWindowHandler);
    }
}
