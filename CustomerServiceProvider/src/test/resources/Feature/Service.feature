Feature: Service API - Manage service connections

  Scenario: Provision a new service connection
    When I send a POST request to "/api/service/provision" with the following details:
      | serviceType | customerId | connectionId |
      | typeA       | 12345      | conn123      |
    Then the response status code should be 201
    And the response should contain the newly provisioned connection details
    And the response should have a content type of "application/json"

  Scenario: Test quality of service for a service connection
    When I send a POST request to "/api/service/test-qos" with the following details:
      | connectionId | parameter1 | parameter2 |
      | conn123      | value1     | value2     |
    Then the response status code should be 200
    And the response should contain the quality of service test results
    And the response should have a content type of "application/json"

  Scenario: Disable a service connection
    When I send a PUT request to "/api/service/disable/{connectionId}" with the connection ID "conn123"
    Then the response status code should be 200

  Scenario: Hold a service connection
    When I send a PUT request to "/api/service/hold/{connectionId}" with the connection ID "conn123"
    Then the response status code should be 200

  Scenario: Resume a service connection
    When I send a PUT request to "/api/service/resume/{connectionId}" with the connection ID "conn123"
    Then the response status code should be 200
