package com.gameApp.appManager.helpers.api;

import com.gameApp.appManager.helpers.HelperBase;
import com.gameApp.appManager.support.Resources;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static io.restassured.RestAssured.when;

public class ApiBase {
    static Logger log = LogManager.getLogger(ApiBase.class);
    private HelperBase helperBase;
    private final String url = Resources.getParam("API_URL");
    public Response response;


    public Response boardGameInfoById(String id) {
        response = null;
        try {
            log.info("URL: " + url + id);
            response = when().get(url + id).then().assertThat().statusCode(200).extract().response();
        } catch (AssertionError ex) {
            log.error("'" + HelperBase.getThisMethodName() + "' Error: '" + ex.getMessage());
        }
        return response;
    }
}
