package com.sample.tests.junit.kdt.steps;

import com.sample.framework.Configuration;
import com.sample.framework.Driver;
import com.sample.framework.Page;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.junit.Assert;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

public class Hooks {
    @Before
    public void beforeScenario(Scenario scenario) throws Exception{
        Configuration.load();
        Configuration.print();

        System.setProperty("webdriver.gecko.driver", new File("drivers/geckodriver").getAbsolutePath());
        System.setProperty("webdriver.chrome.driver", new File("drivers/chromedriver").getAbsolutePath());
//
        ChromeOptions options = new ChromeOptions();
        options.addArguments("window-size=1000,1000");

        DesiredCapabilities cap = new DesiredCapabilities();

        cap.setCapability(ChromeOptions.CAPABILITY, options);

        Driver.add(Configuration.get("browser"), cap);
    }

    @After
    public void afterScenario(Scenario scenario){

        Driver.current().quit();
    }
}
