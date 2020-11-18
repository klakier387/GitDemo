package com.sample.framework.pages;

import com.sample.framework.FindBy;
import com.sample.framework.Page;
import com.sample.framework.ui.controls.Edit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultPage extends Page {
    @FindBy(locator = "ss")
    public Edit editDestination;
    public SearchResultPage(WebDriver driver) {
        super(driver);
    }
}
