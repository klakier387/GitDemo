package com.sample.framework.pages.banking;

import com.sample.framework.Alias;
import com.sample.framework.FindBy;
import com.sample.framework.Page;
import com.sample.framework.ui.controls.Control;
import cucumber.api.java.hr.Ali;
import org.openqa.selenium.WebDriver;
@Alias("Banking Home")
public class HomePage extends Page {
    public HomePage(WebDriver driver){
        super(driver);
    }
    @FindBy(locator = "css=button[class='btn home']")
    public Control homeButton;
    @FindBy(locator = "css=button[ng-click='customer()']")
    public Control customerLogin;
    @Alias("Banking Manager Login")
    @FindBy(locator = "css=button[ng-click='manager()']")
    public Control bankManagerLogin;
}
