package org.verizon.CustomerServiceProvider;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.junit.Assert.assertEquals;

import java.util.Map;

public class EnterpriseStepDefinitions {

    private Response response;
    private String customerId;
    private String requestBody;

    @When("I send a POST request to {string} with the following details:")
    public void sendPostRequest(String endpoint, DataTable dataTable) {
        Map<String, String> details = dataTable.asMap(String.class, String.class);

        customerId = details.get("customerId");
        requestBody = "{ \"name\": \"" + details.get("name") + "\", \"email\": \"" + details.get("email") + "\", \"address\": \"" + details.get("address") + "\" }";

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

    @Then("the response should contain the newly created customer details")
    public void checkPostResponseBody() {
        // You can add code here to parse the response body and verify the newly created customer details
    }

    @Given("an existing customer with ID {string}")
    public void setExistingCustomerId(String customerId) {
        this.customerId = customerId;
    }

    @When("I send a PUT request to {string} with the following updated details:")
    public void sendPutRequest(String endpoint, DataTable dataTable) {
        Map<String, String> updatedDetails = dataTable.asMap(String.class, String.class);

        requestBody = "{ \"name\": \"" + updatedDetails.get("name") + "\", \"email\": \"" + updatedDetails.get("email") + "\", \"address\": \"" + updatedDetails.get("address") + "\" }";

        response = RestAssured.given()
            .contentType(ContentType.JSON)
            .body(requestBody)
            .put(endpoint.replace("{customerId}", customerId));
    }

    @Then("the response should contain the updated customer details")
    public void checkPutResponseBody() {
        // You can add code here to parse the response body and verify the updated customer details
    }

    @When("I send a GET request to {string}")
    public void sendGetRequest(String endpoint) {
        response = RestAssured.get(endpoint.replace("{customerId}", customerId));
    }

    @Then("the response should contain a list of all customers")
    public void checkGetAllCustomersResponseBody() {
        // You can add code here to parse the response body and verify the list of all customers
    }

    @Then("the response should contain the details of the customer")
    public void checkGetCustomerDetailsResponseBody() {
        // You can add code here to parse the response body and verify the customer details
    }
}

