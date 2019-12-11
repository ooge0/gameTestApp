package com.gameApp.appManager.helpers.ui;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import com.gameApp.appManager.helpers.HelperBase;
import com.gameApp.appManager.support.Resources;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class UiHelper {
    static Logger log = LogManager.getLogger(UiHelper.class);
    private HelperBase helperBase;
    public String workId;
    public List<String> resultsDescriptionList;
    private String url = Resources.getParam("WEB_URL");

    /**
     * Page navigation locators
     */
    SelenideElement hotnessMenu = $(Selectors.byXpath("//*[@id=\"mainbody\"]/div/geekoutput-sidebar/div/div/div/hotness-module/div/span/button"));
    SelenideElement gameItem = $(Selectors.byXpath("//*[@id=\"mainbody\"]/div/geekoutput-sidebar/div/div/div/hotness-module/div/span/button"));
    ElementsCollection hotnessGameList = $$(Selectors.byXpath("//*[@id=\"mainbody\"]//ul[@class=\"global-secondary-nav-links hotness\"]/li"));
    SelenideElement idNumber = $(Selectors.byXpath("//*[@id=\"mainbody\"]/div/geekoutput-sidebar/div/div/div/hotness-module/ul/li[1]/a"));
    SelenideElement highestGame = $(Selectors.byXpath("//*[@id=\"mainbody\"]/div/geekoutput-sidebar/div/div/div/hotness-module/ul/li[1]/a/div[2]"));
    SelenideElement somePlace = $(Selectors.byXpath("//*/official-links-module/div/div[1]/h3"));
    SelenideElement viewPollInfoButton = $(Selectors.byXpath("//span[@item-poll-button=\"languagedependence\"]/button/span[1]"));
    /**
     * Poll screen locators
     */
    ElementsCollection pollResultsLines = $$(Selectors.byXpath("//tbody[@ng-repeat=\"row in question.results.question.choicesr\"]/tr/th/span"));
    SelenideElement poolInfoTable = $(Selectors.byXpath("//table"));

    public void openHomePage() {
        open(url);
    }


    /**
     * poolLines Web element collection contains information ONLY from 'tbody' !!!
     * */
    public void collectInfoFromWebPage() {
        resultsDescriptionList = new ArrayList<>();
        List<SelenideElement> pollLines = pollResultsLines;
        for (SelenideElement element : pollLines) {
            String text = element.getText();
            resultsDescriptionList.add(text);
        }
        try {
            Assert.assertNotNull(resultsDescriptionList);
        } catch (AssertionError ae) {
            log.error("'" + HelperBase.getThisMethodName() + "' Error: '" + ae.getMessage());
            System.exit(0);
        }
    }

    public void openItem(String item) {
        try {
            switch (item) {
                case "The Hotness": {
                    if (!hotnessMenu.isDisplayed())
                        hotnessMenu.click();
                }
                break;
                case "Game": {
                    gameItem.doubleClick();
                }
                break;
            }
            log.info("'" + HelperBase.getThisMethodName() + "' is completed");
        } catch (Exception ex) {
            log.error("'" + HelperBase.getThisMethodName() + "'Error " + ex.getMessage());
        }
    }
    public void openHighestGame() {
        try {
            SelenideElement element = hotnessGameList.get(0);
            // hotnessGameList contains the list of web elements (board games) that contains game by order from higher to lower rank
            element.getWrappedElement().click();
            log.info("'" + HelperBase.getThisMethodName() + "' is completed");
        } catch (Exception ex) {
            log.error("'" + HelperBase.getThisMethodName() + "'Error " + ex.getMessage());
        }
    }

    public void openPollPopUp() {
        try {

            somePlace.scrollTo();
            viewPollInfoButton.click();
            // wait until information on the Result popup will be visible

            poolInfoTable.shouldBe(Condition.appear);
            log.info("'" + HelperBase.getThisMethodName() + "' is completed");
        } catch (Exception ex) {
            log.error("'" + HelperBase.getThisMethodName() + "'Error " + ex.getMessage());
        }
    }
    /***
     *  Extracting game ID for API call contains in the link. It should be extracted by simple manipulation
     * */
    public void storeHighestGameId() {
        workId = ((idNumber.getAttribute("href")).split("/"))[4];
    }
}
