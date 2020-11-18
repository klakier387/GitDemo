package com.sample.framework.pages.banking;

import com.sample.framework.Alias;
import com.sample.framework.FindBy;
import com.sample.framework.Page;
import com.sample.framework.ui.controls.Control;
import org.openqa.selenium.WebDriver;
@Alias("Banking Manager Home")
public class BankManagerCommonPage extends Page {
    public BankManagerCommonPage(WebDriver driver){
        super(driver);
    }
    @Alias("Add Customer")
    @FindBy(locator = "css=button[ng-class='btnClass1']")
    public Control addCustomer;
    @Alias("Open Account")
    @FindBy(locator = "css=button[ng-class='btnClas2']")
    public Control openAccount;
    @Alias("Customers")
    @FindBy(locator = "css=button[ng-class='btnClass3']")
    public Control customers;


}
