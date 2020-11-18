package com.sample.framework.pages.banking;

import com.sample.framework.Alias;
import com.sample.framework.FindBy;
import com.sample.framework.Page;
import com.sample.framework.SubItem;
import com.sample.framework.ui.controls.TableView;
import org.openqa.selenium.WebDriver;
@Alias("Customers")
public class CustomersPage extends Page {
    public CustomersPage(WebDriver driver)
    {super(driver);
    }
    @Alias("Customer List")
    @FindBy(locator = "//table", itemLocator = "/tbody/tr")
    @SubItem(name = "First Name", locator="/td[1]")
    @SubItem(name = "Last Name", locator="/td[2]")
    @SubItem(name = "Post Code", locator="/td[3]")
    @SubItem(name = "Account Number", locator="/td[4]")
    @SubItem(name = "Delete Customer", locator="/td[5]/button")

    public TableView tableCustomers;
}
