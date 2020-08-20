package com.yyc.server;

import com.yyc.utils.DriverServer;
import org.openqa.selenium.By;

public class IndexServer extends DriverServer {

    // 添加文本
    public static void sendText(By by,String str){
        driver.findElement(by).sendKeys(str);
    }


}
