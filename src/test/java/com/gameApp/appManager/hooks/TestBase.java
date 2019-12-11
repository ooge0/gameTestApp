package com.gameApp.appManager.hooks;

import com.gameApp.appManager.ApplicationManager;
import com.gameApp.appManager.support.Resources;
import org.junit.After;
import org.junit.Before;

public class TestBase {
    protected final ApplicationManager app = new ApplicationManager(Resources.getParam("BROWSER"));
    @Before
    public void setUp() {
        app.init();
    }

    @After
    public void tearDown()  {
        app.stop();
    }
}
