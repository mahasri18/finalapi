package org.verizon.CustomerServiceProvider;

import cucumber.api.java.en.When;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.junit.Assert.assertEquals;

import java.util.Map;

public class ServiceStepDefinitions {

    private Response response;
    private String requestBody;

    @When("I send a POST request to {string} with the following details:")
    public void sendPostRequest(String endpoint, DataTable dataTable) {
        Map<String, String> details = dataTable.asMap(String.class, String.class);

        requestBody = "{ \"serviceType\": \"" + details.get("serviceType") + "\", \"customerId\": " + details.get("customerId") + ", \"connectionId\": \"" + details.get("connectionId") + "\" }";

        response = RestAssured.given()
            .contentType(ContentType.JSON)
            .body(requestBody)
            .post(endpoint);
    }

    @Then("the response status code should be {int}")
    public void checkResponseStatusCode(int expectedStatusCode) {
        int actualStatusCode = response.getStatusCode();
        assertEquals(expectedStatusCode, actualStatusCode);
    }

    @Then("the response should contain the newly provisioned connection details")
    public void checkPostResponseBody() {
        // You can add code here to parse the response body and verify the newly provisioned connection details
    }

    @When("I send a POST request to {string} with the following details:")
    public void sendTestQosRequest(String endpoint, DataTable dataTable) {
        Map<String, String> details = dataTable.asMap(String.class, String.class);

        requestBody = "{ \"connectionId\": \"" + details.get("connectionId") + "\", \"parameter1\": \"" + details.get("parameter1") + "\", \"parameter2\": \"" + details.get("parameter2") + "\" }";

        response = RestAssured.given()
            .contentType(ContentType.JSON)
            .body(requestBody)
            .post(endpoint);
    }

    @Then("the response should contain the quality of service test results")
    public void checkTestQosResponseBody() {
        // You can add code here to parse the response body and verify the quality of service test results
    }

    @When("I send a PUT request to {string} with the connection ID {string}")
    public void sendPutRequest(String endpoint, String connectionId) {
        response = RestAssured.given()
            .contentType(ContentType.JSON)
            .put(endpoint.replace("{connectionId}", connectionId));
    }
}

