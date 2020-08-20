package com.wff.element;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Driver {
    public static WebDriver driver;


    public static WebDriver getDriver(String type) throws Exception{
        String path = System.getProperty("user.dir");
        if("chrome".equals(type)){
            System.setProperty("webdriver.chrome.driver",path+"\\drivers\\chromedriver.exe");
            driver = new ChromeDriver();
        }else if("ie".equals(type)){
            System.setProperty("webdriver.ie.driver",path+"\\drivers\\chromedriver.exe");
            driver = new InternetExplorerDriver();
        }else  if ("firefox".equals(type)){
            System.setProperty("webdriver.firefox.driver",path+"\\drivers\\chromedriver.exe");
            driver = new FirefoxDriver();
        }else{
           throw new Exception();
        }

        return driver;
    }
}
