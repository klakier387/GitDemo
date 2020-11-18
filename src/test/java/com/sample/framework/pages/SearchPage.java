package com.sample.framework.pages;

import com.sample.framework.Configuration;
import com.sample.framework.FindBy;
import com.sample.framework.Page;
import com.sample.framework.ui.controls.Control;
import com.sample.framework.ui.controls.Edit;
import com.sample.tests.controls.LocationLookupEdit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage extends Page {

    @FindBy(locator = "ss")
    public LocationLookupEdit editDestination;
    @FindBy(locator = "css=div[class='xp__dates-inner xp__dates__checkin']")
    public Control checkoutDayExpand;
    @FindBy(locator = "css=div[class='sb-searchbox-submit-col -submit-button ']")
    public Control buttonSubmit;


    public SearchPage(WebDriver driver){
        super(driver);
    }

    @Override
    public Page navigate(){
        String baseUrl = Configuration.get("url");
        this.getDriver().get(baseUrl);
        return this;
    }
        public void checkInToday(){
        checkoutDayExpand.click();
        }


}
