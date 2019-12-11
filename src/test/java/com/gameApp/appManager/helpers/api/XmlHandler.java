package com.gameApp.appManager.helpers.api;

import com.gameApp.appManager.helpers.HelperBase;
import com.gameApp.appManager.model.BoardGame;
import com.gameApp.appManager.model.Poll;
import com.gameApp.appManager.model.Result;
import com.gameApp.appManager.model.Results;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

/**
 * simple data XML handler for extracting information from board game API request using created model
 * */
public class XmlHandler extends DefaultHandler {
    static Logger log = LogManager.getLogger(XmlHandler.class);
    private HelperBase helperBase;
    static final String BOARD_GAME_TAG = "boardgame";
    static final String POLL_TAG = "poll";
    static final String RESULTS_TAG = "results";
    static final String RESULT_TAG = "result";

    static final String BOARD_GAME_OBJECT_ID_ATTRIBUTE = "objectid";
    static final String POLL_NAME_ATTRIBUTE = "name";
    static final String POLL_TITLE_ATTRIBUTE = "title";
    static final String POLL_TOTALVOTES_ATTRIBUTE = "totalvotes";
    static final String RESULTS_NUMPLAYERS_ATTRIBUTE = "numplayers";
    static final String RESULT_VALUE_ATTRIBUTE = "value";
    static final String RESULT_NUMVOTES_ATTRIBUTE = "numvotes";
    static final String RESULT_LEVEL_ATTRIBUTE = "level";
    private BoardGame boardGame;
    private Poll poll;
    private Results results;
    private Result result;
    private String currentElement;

    public BoardGame getReport() {
        return boardGame;
    }

    public void startDocument() {
        log.info("Start XML parsing...");
    }

    @Override
    public void startElement(
            String uri, String localName, String qName, Attributes attributes)
        {
        currentElement = qName;
        switch (currentElement) {
            case BOARD_GAME_TAG: {
                boardGame = new BoardGame();
                boardGame.poll = new ArrayList<>();
                boardGame.objectId = Integer.parseInt(attributes.getValue(BOARD_GAME_OBJECT_ID_ATTRIBUTE));
            }
            break;
            case POLL_TAG: {
                poll = new Poll();
                poll.results = new ArrayList<>();
                poll.name = attributes.getValue(POLL_NAME_ATTRIBUTE);
                poll.title = attributes.getValue(POLL_TITLE_ATTRIBUTE);
                poll.totalVotes = Integer.valueOf(attributes.getValue(POLL_TOTALVOTES_ATTRIBUTE));
            }
            break;
            case RESULTS_TAG: {
                results = new Results();
                results.result = new ArrayList<>();
                if (attributes.getValue(RESULTS_NUMPLAYERS_ATTRIBUTE) != null)
                    results.numPlayers = attributes.getValue(RESULTS_NUMPLAYERS_ATTRIBUTE);
                else
                    results.numPlayers = "NaN";
            }
            break;
            case RESULT_TAG: {
                result = new Result();
                result.value = attributes.getValue(RESULT_VALUE_ATTRIBUTE);
                result.numVotes = Integer.valueOf(attributes.getValue(RESULT_NUMVOTES_ATTRIBUTE));
                if (attributes.getValue(RESULT_LEVEL_ATTRIBUTE) == null)
                    result.level = "NaN";
                else
                    result.level = attributes.getValue(RESULT_LEVEL_ATTRIBUTE);
            }
            break;
            default: {
                //some actions
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName)
    {
        switch (qName) {
            case RESULT_TAG: {
                results.result.add(result);

            }
            break;
            case POLL_TAG: {
                poll.results.add(results);
                boardGame.poll.add(poll);
            }
            break;
            default: {
                //some actions
            }
        }
        currentElement = null;
    }

    public void endDocument() {
        log.info("XML parsing is completed...");
    }

}




