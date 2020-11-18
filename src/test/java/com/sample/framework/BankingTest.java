package com.sample.framework;

import com.sample.framework.pages.banking.AddCustomerPage;
import com.sample.framework.pages.banking.BankManagerCommonPage;
import com.sample.framework.pages.banking.CustomersPage;
import com.sample.framework.pages.banking.HomePage;
import com.sample.framework.ui.controls.Control;
import org.junit.Assert;
import org.junit.Test;


public class BankingTest extends TestCommon {
@Test
    public void testAddNewCustomer() throws Exception{
    home = PageFactory.init(HomePage.class);
    bankManagerMenu = home.bankManagerLogin.clickAndWait(BankManagerCommonPage.class);
    customers = bankManagerMenu.customers.clickAndWait(CustomersPage.class);
    Assert.assertTrue(customers.tableCustomers.isNotEmpty());
    int rows = customers.tableCustomers.getItemsCount();
    addCustomer = bankManagerMenu.addCustomer.clickAndWait(AddCustomerPage.class);
    Thread.sleep(1000);
    Assert.assertTrue(addCustomer.allElementsExist(new Control[]{
            addCustomer.firstName,
            addCustomer.lastName,
            addCustomer.postCode,
            addCustomer.submitButton
    }));

    Assert.assertTrue(addCustomer.anyOfElementsExist(new Control[]{
            addCustomer.firstName,
            addCustomer.lastName,
            addCustomer.postCode,
            addCustomer.submitButton
    }));
    addCustomer.firstName.setText("Test");
    addCustomer.lastName.setText("User");
    addCustomer.postCode.setText("999");
    addCustomer.submitButton.click();
    addCustomer.getDriver().switchTo().alert().accept();
    bankManagerMenu.customers.clickAndWait(CustomersPage.class);

    Assert.assertEquals(rows +1, customers.tableCustomers.getItemsCount());
    Assert.assertEquals("Test", customers.tableCustomers.getSubItem("First Name", rows).getText());
    Assert.assertEquals("User", customers.tableCustomers.getSubItem("Last Name", rows).getText());
    Assert.assertEquals("999", customers.tableCustomers.getSubItem("Post Code", rows).getText());

    customers.tableCustomers.getSubItem("Delete Customer", rows).click();

    Assert.assertTrue(customers.tableCustomers.isNotEmpty());

    Assert.assertEquals(rows, customers.tableCustomers.getItemsCount());
}
}


