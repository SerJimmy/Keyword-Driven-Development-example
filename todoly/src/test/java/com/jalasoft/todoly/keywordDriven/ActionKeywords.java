package com.jalasoft.todoly.keywordDriven;


import api.APIManager;
import framework.Environment;
import io.restassured.response.Response;
import org.testng.Assert;
import utils.LoggerManager;
import java.util.HashMap;
import java.util.Map;

public class ActionKeywords {
    private static final APIManager apiManager = APIManager.getInstance();
    private static final Environment environment = Environment.getInstance();
    private static final LoggerManager logger = LoggerManager.getInstance();
    private Response getAllProjectsResponse;

    private void setCredentials() {
        apiManager.setCredentials(environment.getUserName(), environment.getPassword());
    }
    private void requestGetAllProjects() {
        Response response = apiManager.get(environment.getProjectsEndpoint());
        getAllProjectsResponse = response;
        System.out.println(getAllProjectsResponse.prettyPrint());
    }
    private void verifyStatusCode200() {
        Assert.assertEquals(getAllProjectsResponse.getStatusCode(), 200, "Correct status code is not returned");
    }
    private void verifyNullErrorMessage() {
        Assert.assertFalse(getAllProjectsResponse.getBody().asString().contains("ErrorMessage"), "Correct response body is not returned");
    }
    private void verifyNullErrorCode() {
        Assert.assertFalse(getAllProjectsResponse.getBody().asString().contains("ErrorCode"), "Correct response body is not returned");
    }
    public Map<String, Runnable> createFunctionMap() {
        Map<String, Runnable> functionMap = new HashMap<String, Runnable>();
        functionMap.put("setCredentials", ()->setCredentials());
        functionMap.put("requestGetAllProjects", ()->requestGetAllProjects());
        functionMap.put("verifyStatusCode200", ()->verifyStatusCode200());
        functionMap.put("verifyNullErrorMessage", ()->verifyNullErrorMessage());
        functionMap.put("verifyNullErrorCode", ()->verifyNullErrorCode());
        return functionMap;
    }
}
