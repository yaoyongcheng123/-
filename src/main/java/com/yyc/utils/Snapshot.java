package com.yyc.utils;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Snapshot extends DriverServer {

    public static void snapshot(String fileName) {
        TakesScreenshot drivername = (TakesScreenshot) driver;
        String path = System.getProperty("user.dir"); //get current work folder
        File scrFile = drivername.getScreenshotAs(OutputType.FILE);
        try {
            String folderName = DateUtils.strToDate(new Date(), DateUtils.format10);
            File file=new File(path + "\\imgs\\"+folderName);
            if(!file.exists()){//如果文件夹不存在
                file.mkdir();//创建文件夹
            }
            FileUtils.copyFile(scrFile, new File(path + "\\imgs\\" +folderName+"\\"+ fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
