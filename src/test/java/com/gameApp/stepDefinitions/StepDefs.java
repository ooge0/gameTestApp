package com.gameApp.stepDefinitions;

import com.gameApp.appManager.hooks.TestBase;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class StepDefs extends TestBase {
    @Given("^I open homepage of the web site$")
    public void iOpenHomepageOfTheWebSite() {
        app.init();
        app.useUiHelper().openHomePage();
    }

    @When("^Navigate to the page of the game with highest rank in \"([^\"]*)\" left side menu$")
    public void navigateToTheLeftSideMenu(String item) {
        app.useUiHelper().openItem(item);
    }

    @Then("^I select \"(Game)\" option$")
    public void iSelectGameOption(String item) {
        app.useUiHelper().openItem(item);
        app.useUiHelper().storeHighestGameId();
    }

    @And("^I open highest rank game$")
    public void iOpenHighestRankGame() {
        app.useUiHelper().openHighestGame();
    }

    @Then("^I collect information about game with highest rank from web page$")
    public void iCollectInformationAboutGameWithHighestRankFromWebPage() {
        app.useUiHelper().openPollPopUp();
        app.useUiHelper().collectInfoFromWebPage();
    }

    @And("^I retrieve information about a particular game from site api$")
    public void iRetrieveInformationAboutAParticularGameFromSiteApi() throws ParserConfigurationException, SAXException, IOException {
        app.useRestHelper().requestBoardGameInfoByIde(app.useUiHelper().workId);
    }

    @When("^I parse response to get most voted option in \"(Language Dependence)\" poll$")
    public void iParseResponseToGetMostVotedOptionInLanguageDependencePoll(String key) {
        app.useRestHelper().getResultListByPollName(key);
    }

    @Then("^I assert Language Dependence text on the page and retrieved information from API side$")
    public void iAssertLanguageDependenceTextOnThePageAndRetrievedInformationFromAPISide() {
        app.useRestHelper().compareInformation(app.useUiHelper().resultsDescriptionList);
    }
}
