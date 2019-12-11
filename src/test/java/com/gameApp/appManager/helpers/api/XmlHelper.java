package com.gameApp.appManager.helpers.api;

import com.gameApp.appManager.helpers.HelperBase;
import com.gameApp.appManager.model.BoardGame;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.StringReader;
/**
 * XML helper that using SAX for reading XML
 *  */
public class XmlHelper {
    static Logger log = LogManager.getLogger(XmlHelper.class);
    private static HelperBase helperBase;

    public static BoardGame getBoardGameObject(String response) throws ParserConfigurationException, SAXException, IOException {
        BoardGame boardGame = new BoardGame();
        SAXParserFactory spf = SAXParserFactory.newInstance();
        SAXParser saxParser = spf.newSAXParser();
        XMLReader xmlReader = saxParser.getXMLReader();
        XmlHandler handler = new XmlHandler();
        xmlReader.setContentHandler(handler);
        InputSource is = new InputSource(new StringReader(response));
        xmlReader.parse(is);
        try {
            boardGame = handler.getReport();
        } catch (Throwable t) {
            log.error("'" + HelperBase.getThisMethodName() + "' Error: '" + t.getMessage());
        }
        return boardGame;
    }
}
