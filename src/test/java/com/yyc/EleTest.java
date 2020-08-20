package com.yyc;

import com.yyc.element.EleIndex;
import com.yyc.log.Log;
import com.yyc.server.IndexServer;
import com.yyc.utils.Asserts;
import com.yyc.utils.DriverServer;
import com.yyc.utils.MathRandom;
import com.yyc.utils.Snapshot;
import org.apache.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class EleTest {

    private static Logger logger = Log.logger(EleTest.class);
    @Test
    public void indexCase01(){
        WebDriver driver = DriverServer.getDriver("chrome");
        driver.get("file:///C:/Users/Administrator/Desktop/selenium_html/index.html");
        IndexServer.sendText(EleIndex.INPUT,"哈哈哈！！");
        Snapshot.snapshot(MathRandom.getRandName());

        Asserts.assertEquals("122","122");
    }

    @Test
    public void indexCase02(){
        Asserts.assertEquals("124","124");
    }

    public static void main(String[] args) {
//        PropertyConfigurator.configure( "D:\\project\\ahnx\\jnyd\\jnyd\\webDriverFrame\\src\\log4j.properties");
//        DOMConfigurator.configure("D:\\project\\ahnx\\jnyd\\jnyd\\webDriverFrame\\src\\config\\log4j.properties");
//        BasicConfigurator.configure();
        logger.info("aaaa");

        logger.debug("bbbb");

        logger.error("cccc");
    }


    @DataProvider(name = "add")
    public Object[][] add(){
        Object[][] Z = new Object[][]{};
        return new Object[][]{
                {"username","user"},
                {"username","user2"}
        };
    }
}
