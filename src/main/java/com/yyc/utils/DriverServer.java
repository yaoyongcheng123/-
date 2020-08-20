package com.yyc.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverServer {
    public static WebDriver driver;

    public static WebDriver getDriver(String type) {
        String path = System.getProperty("user.dir");
        if ("chrome".equals(type)) {
            System.setProperty("webdriver.chrome.driver", path + "\\drivers\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if ("ie".equals(type)) {

        } else if ("fireFox".equals(type)) {
            System.setProperty("webdriver.firefox.bin", path + "\\drivers\\geckodriver.exe");
            driver = new FirefoxDriver();
        }

        return driver;
    }
}
