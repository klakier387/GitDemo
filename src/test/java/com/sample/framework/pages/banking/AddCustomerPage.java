package com.sample.framework.pages.banking;

import com.sample.framework.Alias;
import com.sample.framework.FindBy;
import com.sample.framework.Page;
import com.sample.framework.ui.controls.Control;
import com.sample.framework.ui.controls.Edit;
import org.openqa.selenium.WebDriver;
@Alias("Add Customer")
public class AddCustomerPage extends Page {

    public AddCustomerPage(WebDriver driver){
        super(driver);
    }
    @Alias("First Name")
    @FindBy(locator = "css=input[ng-model='fName']")
    public Edit firstName;
    @Alias("Last Name")
    @FindBy(locator = "css=input[ng-model='lName']")
    public Edit lastName;
    @Alias("Post Code")
    @FindBy(locator = "css=input[ng-model='postCd']")
    public Edit postCode;
    @Alias("Submit")
    @FindBy(locator = "css=button[type='submit']")
    public Control submitButton;



}
