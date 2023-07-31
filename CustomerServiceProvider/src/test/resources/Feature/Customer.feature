Feature: Consumer API - Manage customer orders

  Scenario: Create an order for a customer
    When I send a POST request to "/api/consumer/customers/{customerId}/orders" with the following details:
      | customerId | product     | quantity |
      | 12345      | ProductA    | 2        |
    Then the response status code should be 201
    And the response should contain the newly created order details
    And the response should have a content type of "application/json"

  Scenario: Update an existing order for a customer
    Given an existing order with ID {orderId}
    When I send a PUT request to "/api/consumer/customers/{customerId}/orders/{orderId}" with the following updated details:
      | product  | quantity |
      | ProductB | 3        |
    Then the response status code should be 200
    And the response should contain the updated order details
    And the response should have a content type of "application/json"

  Scenario: Get all orders for a customer
    When I send a GET request to "/api/consumer/customers/{customerId}/orders"
    Then the response status code should be 200
    And the response should contain a list of orders for the customer
    And the response should have a content type of "application/json"

  Scenario: Get details of a specific order
    When I send a GET request to "/api/consumer/orders/{orderId}"
    Then the response status code should be 200
    And the response should contain the order details
    And the response should have a content type of "application/json"

  Scenario: Get the status of a specific order
    When I send a GET request to "/api/consumer/orders/status/{orderId}"
    Then the response status code should be 200
    And the response should contain the status of the order
    And the response should have a content type of "application/json"
