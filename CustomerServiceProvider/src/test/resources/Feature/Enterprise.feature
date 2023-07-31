Feature: Enterprise API - Manage customers

  Scenario: Create a new customer
    When I send a POST request to "/api/enterprise/customers" with the following details:
      | customerId | name       | email             | address     |
      | 12345      | John Doe   | john.doe@example.com | New York    |
    Then the response status code should be 201
    And the response should contain the newly created customer details
    And the response should have a content type of "application/json"

  Scenario: Update an existing customer
    Given an existing customer with ID {customerId}
    When I send a PUT request to "/api/enterprise/customers/{customerId}" with the following updated details:
      | name       | email             | address     |
      | Jane Doe   | jane.doe@example.com | California  |
    Then the response status code should be 200
    And the response should contain the updated customer details
    And the response should have a content type of "application/json"

  Scenario: Get all customers
    When I send a GET request to "/api/enterprise/customers"
    Then the response status code should be 200
    And the response should contain a list of all customers
    And the response should have a content type of "application/json"

  Scenario: Get details of a specific customer
    When I send a GET request to "/api/enterprise/customers/{customerId}"
    Then the response status code should be 200
    And the response should contain the details of the customer
    And the response should have a content type of "application/json"
