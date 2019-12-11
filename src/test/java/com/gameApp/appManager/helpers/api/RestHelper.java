package com.gameApp.appManager.helpers.api;

import com.gameApp.appManager.helpers.HelperBase;
import com.gameApp.appManager.model.BoardGame;
import com.gameApp.appManager.model.Poll;
import com.gameApp.appManager.model.Result;
import com.gameApp.appManager.model.Results;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RestHelper {
    static Logger log = LogManager.getLogger(RestHelper.class);
    private final ApiBase api = new ApiBase();
    static BoardGame boardGame;
    List<Result> resultList;

    public void requestBoardGameInfoByIde(String id) throws IOException, SAXException, ParserConfigurationException {
        String gameObject = (api.boardGameInfoById(id)).asString();
        boardGame = XmlHelper.getBoardGameObject(gameObject);
    }

    public void getResultListByPollName(String pollName) {
        switch (pollName) {
            case "Language Dependence": {
                resultList = ((boardGame.getPoll().get(1)).getResults().get(0)).getResult();
            }
            break;
            case "suggested_numplayers": {
                resultList = ((boardGame.getPoll().get(2)).getResults().get(0)).getResult();
            }
            break;
            default:
                throw new IllegalStateException("Unexpected value: " + pollName);
        }
    }

    public static void fullObjectPrint() {
        List<Poll> pollList = boardGame.getPoll();
        List<Result> resultList;
        for (Poll poll : pollList
        ) {
            log.info("Poll name: " + poll.getName());
            List<Results> resultsList = poll.getResults();
            for (Results results : resultsList
            ) {
                resultList = results.getResult();
                for (Result result : resultList
                ) {
                    log.info("result Value: " + result.getValue());
                }
            }
        }
    }

    private static void printSingleList(List<Result> resultList) {
        log.info("result Value: ");
        for (Result result : resultList) {
            log.info(result.getValue());
        }
    }

    public void compareInformation(List<String> uiList) {
        List<String> apiList = new ArrayList<>();
        for (Result result : resultList
        ) {
            apiList.add(result.value);
        }
        try {
            Assert.assertEquals(uiList, apiList);
        } catch (AssertionError ae) {
            log.error("'" + HelperBase.getThisMethodName() + "' Error: '" + ae.getMessage());
            System.exit(0);
        }
    }

    public void printApiInfo(String workId) {
        log.info(api.boardGameInfoById(workId).prettyPrint());
    }
}
