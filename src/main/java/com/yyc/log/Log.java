package com.yyc.log;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log {

    private static Logger logger ;

    public static Logger logger(Class<?> T){
        String path = System.getProperty("user.dir"); //get current work folder
        PropertyConfigurator.configure( path+"\\src\\log4j.properties");
        logger = Logger.getLogger(T);
        return logger;
    }
}
