package com.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.base.BaseClass;

public class SamplePage extends BaseClass {

    // Page Factory - OR:
    @FindBy(xpath = "//input[@title='Search']")
    WebElement homePageSearchBox;

    // Initializing the Page Objects:
    public SamplePage() {
        PageFactory.initElements(driver, this);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public void search(String search) {
        homePageSearchBox.clear();
        homePageSearchBox.sendKeys(search, Keys.ENTER);
    }
}
