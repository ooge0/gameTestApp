package com.gameApp.tests;

import com.gameApp.appManager.hooks.TestBase;
import io.qameta.allure.*;
import org.junit.Test;

@Epic("Login")
@Feature("Login-Logout feature")
public class GameTests extends TestBase {

    @Test
    @Issue("ISSUE-0")
    @Story("Validation of user login and logout actions ")
    @Description("Check logIn/Out feature by valid credentials")
    public void testSimpleGame() throws Exception {
        String item1 = "The Hotness";
        String item2 = "Game";
        String pollName = "Language Dependence";
        app.useUiHelper().openHomePage();
        app.useUiHelper().openItem(item1);
        app.useUiHelper().openItem(item2);
        app.useUiHelper().storeHighestGameId();
        app.useUiHelper().openHighestGame();
        app.useUiHelper().openPollPopUp();
        app.useUiHelper().collectInfoFromWebPage();
        app.useRestHelper().requestBoardGameInfoByIde(app.useUiHelper().workId);
        app.useRestHelper().getResultListByPollName(pollName);
        app.useRestHelper().compareInformation(app.useUiHelper().resultsDescriptionList);
    }

}


