package com.gameApp.appManager.support;

import com.gameApp.appManager.helpers.HelperBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Resources {
    static Logger log = LogManager.getLogger(Resources.class);
    public static String envPath = "/home/roman/GIT/git_JAVA/gameTestApp/env.properties";

    public static String getParam(String key) {
        String value = null;
        try {
            value = testProps(key);
            log.info("'" + key + "': " + value );
       } catch (Exception ex) {
            log.error(HelperBase.getThisMethodName() + ": " + ex);
        }
        return value;
    }

    public static String testProps(String key) throws IOException {
        Properties prop = new Properties();
        try (FileInputStream fis = new FileInputStream(envPath)) {
            prop.load(fis);
            return (String) prop.get(key);
        }
    }
}
