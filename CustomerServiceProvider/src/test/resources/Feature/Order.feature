Feature: Enterprise API - Manage customer orders

  Scenario: Create a new order for a customer
    When I send a POST request to "/api/enterprise/customers/{customerId}/orders" with the following details:
      | orderId | product     | quantity |
      | order1  | ProductA    | 2        |
    Then the response status code should be 201
    And the response should contain the newly created order details
    And the response should have a content type of "application/json"

  Scenario: Update an existing order for a customer
    Given an existing order with ID {orderId}
    When I send a PUT request to "/api/enterprise/customers/{customerId}/orders/{orderId}" with the following updated details:
      | product  | quantity |
      | ProductB | 3        |
    Then the response status code should be 200
    And the response should contain the updated order details
    And the response should have a content type of "application/json"

  Scenario: Get all orders for a customer
    When I send a GET request to "/api/enterprise/customers/{customerId}/orders"
    Then the response status code should be 200
    And the response should contain a list of orders for the customer
    And the response should have a content type of "application/json"

  Scenario: Get details of a specific order
    When I send a GET request to "/api/enterprise/orders/{orderId}"
    Then the response status code should be 200
    And the response should contain the order details
    And the response should have a content type of "application/json"
