package com.sample.framework;

import com.sample.framework.pages.SearchPage;
import com.sample.framework.pages.SearchResultPage;
import com.sample.framework.pages.banking.AddCustomerPage;
import com.sample.framework.pages.banking.BankManagerCommonPage;
import com.sample.framework.pages.banking.CustomersPage;
import com.sample.framework.pages.banking.HomePage;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

public class TestCommon {
//    protected SearchPage searchPage;
//    protected SearchResultPage searchResultPage;
    protected HomePage home;
    protected BankManagerCommonPage bankManagerMenu;
    protected AddCustomerPage addCustomer;
    protected CustomersPage customers;
    @Before
    public void setUp() throws Exception{
        Configuration.load();
        Configuration.print();

        System.setProperty("webdriver.gecko.driver", new File("drivers/geckodriver").getAbsolutePath());
        System.setProperty("webdriver.chrome.driver", new File("drivers/chromedriver").getAbsolutePath());

        DesiredCapabilities cap = new DesiredCapabilities();
        Driver.add(Configuration.get("browser"), cap);
        Driver.current().get("http://globalsqa.com/angularJs-protractor/BankingProject/#/login");

//        searchPage = PageFactory.init(SearchPage.class);
//        searchPage.navigate();


    }


    @After
    public void tearDown(){
        Driver.current().quit();
    }
}
