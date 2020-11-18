package com.sample.framework;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class Driver {
    private  static ConcurrentHashMap<String, WebDriver> driverThreadMap =
            new ConcurrentHashMap<String, WebDriver>();
    private  static final Map<String, Class<?>> driverMap = new HashMap<String, Class<?>>(){
        {
            put("chrome", ChromeDriver.class);
            put("firefox", FirefoxDriver.class);
            put("ie", InternetExplorerDriver.class);
            put("opera", OperaDriver.class);
            put("safari", SafariDriver.class);
        }
    };

    public static String getThreadName(){
        return  Thread.currentThread().getName() + "-" + Thread.currentThread().getId();
    }
    public static void add(String browser, Capabilities capabilities) throws Exception{
        Class<?> driverClass = driverMap.get(browser);
        WebDriver driver = (WebDriver) driverClass.getConstructor(Capabilities.class)
                .newInstance(capabilities);
        String threadName = getThreadName();
        driverThreadMap.put(threadName, driver);
    }

    public static WebDriver current(){
        String threadName = getThreadName();
        return driverThreadMap.get(threadName);
    }


}
