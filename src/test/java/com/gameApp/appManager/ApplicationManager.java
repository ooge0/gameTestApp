package com.gameApp.appManager;

import com.codeborne.selenide.Configuration;
import com.gameApp.appManager.helpers.HelperBase;
import com.gameApp.appManager.helpers.api.RestHelper;
import com.gameApp.appManager.helpers.ui.HomePageHelper;
import com.gameApp.appManager.helpers.ui.UiHelper;
import com.gameApp.appManager.support.Resources;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.close;
import static org.junit.Assert.fail;


public class ApplicationManager {
    static Logger log = LogManager.getLogger(ApplicationManager.class);
    private StringBuffer verificationErrors = new StringBuffer();
    private UiHelper uiHelper;
    private RestHelper restHelper;
    private HomePageHelper homePageHelper;
    private HelperBase helperBase;
    private String browser;


    public UiHelper useUiHelper() {
        return uiHelper;
    }

    public RestHelper useRestHelper() {
        return restHelper;
    }

    public HelperBase useHelperBase() {
        return helperBase;
    }


    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public void init()  {
        boolean browserWindow = Boolean.parseBoolean(Resources.getParam("BrowserMaxWindowSize"));
        boolean headlessMode = Boolean.parseBoolean(Resources.getParam("HeadlessMode"));
        int timeout = Integer.parseInt(Resources.getParam("Timeout"));
        try {
            if (browser.equals("FIREFOX")) {
                Configuration.browser = "firefox";
            } else if (browser.equals("CHROME")) {
                Configuration.browser = "chrome";
            }
            Configuration.headless = headlessMode;
            Configuration.timeout = timeout;
            Configuration.startMaximized = browserWindow;
            log.info("'" + HelperBase.getThisMethodName() + "' is completed");
            helperBase = new HelperBase();
            uiHelper = new UiHelper();
            homePageHelper = new HomePageHelper();
            restHelper = new RestHelper();
        } catch (Exception ex) {
            log.error("Check the browser parameter !!!  '" + HelperBase.getThisMethodName() + "()':  " + ex.getMessage());
        }
    }

    public void stop() {
        try {
            close();
            String verificationErrorString = verificationErrors.toString();
            if (!"".equals(verificationErrorString)) {
                fail(verificationErrorString);
            }
            log.info("'" + HelperBase.getThisMethodName() + "' is completed");
        } catch (Exception ex) {
            log.error("Error " + ex.getMessage());
        }
    }


}