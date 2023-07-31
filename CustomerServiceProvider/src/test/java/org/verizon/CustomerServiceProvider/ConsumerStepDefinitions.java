package org.verizon.CustomerServiceProvider;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

public class ConsumerStepDefinitions {

    private Response response;
    private String customerId;
    private String orderId;
    private String requestBody;

    @When("I send a POST request to {string} with the following details:")
    public void sendPostRequest(String endpoint, DataTable dataTable) {
        List<Map<String, String>> orderDetails = dataTable.asMaps(String.class, String.class);
        Map<String, String> details = orderDetails.get(0);
        customerId = details.get("customerId");

        requestBody = "{ \"product\": \"" + details.get("product") + "\", \"quantity\": " + details.get("quantity") + " }";

        response = RestAssured.given()
            .contentType(ContentType.JSON)
            .body(requestBody)
            .post(endpoint.replace("{customerId}", customerId));
    }

    @Then("the response status code should be {int}")
    public void checkResponseStatusCode(int expectedStatusCode) {
        int actualStatusCode = response.getStatusCode();
        assertEquals(expectedStatusCode, actualStatusCode);
    }

    @Then("the response should contain the newly created order details")
    public void checkPostResponseBody() {
        // You can add code here to parse the response body and verify the newly created order details
    }

    @Given("an existing order with ID {string}")
    public void setExistingOrderId(String orderId) {
        this.orderId = orderId;
    }

    @When("I send a PUT request to {string} with the following updated details:")
    public void sendPutRequest(String endpoint, DataTable dataTable) {
        Map<String, String> updatedDetails = dataTable.asMaps(String.class, String.class).get(0);

        requestBody = "{ \"product\": \"" + updatedDetails.get("product") + "\", \"quantity\": " + updatedDetails.get("quantity") + " }";

        response = RestAssured.given()
            .contentType(ContentType.JSON)
            .body(requestBody)
            .put(endpoint.replace("{customerId}", customerId).replace("{orderId}", orderId));
    }

    @Then("the response should contain the updated order details")
    public void checkPutResponseBody() {
        // You can add code here to parse the response body and verify the updated order details
    }

    @When("I send a GET request to {string}")
    public void sendGetRequest(String endpoint) {
        response = RestAssured.get(endpoint.replace("{customerId}", customerId).replace("{orderId}", orderId));
    }

    @Then("the response should contain a list of orders for the customer")
    public void checkGetAllOrdersResponseBody() {
        // You can add code here to parse the response body and verify the list of orders for the customer
    }

    @Then("the response should contain the order details")
    public void checkGetOrderDetailsResponseBody() {
        // You can add code here to parse the response body and verify the order details
    }

    @Then("the response should contain the status of the order")
    public void checkGetOrderStatusResponseBody() {
        // You can add code here to parse the response body and verify the order status
    }
}
