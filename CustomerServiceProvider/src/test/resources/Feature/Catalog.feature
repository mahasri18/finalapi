Feature: Catalog API - Manage products/plans/features in the catalog

Scenario: Retrieve the catalog
    When I send a GET request to "/api/catalog"
    Then the response status code should be 200
    And the response should contain a list of products/plans/features
    And the response should have a content type of "application/json"

Scenario: Add a new product/plan/feature to the catalog
    Given the request body contains product/plan/feature details
    When I send a POST request to "/api/catalog"
    Then the response status code should be 201
    And the response should contain the newly added product/plan/feature details
    And the response should have a content type of "application/json"

Scenario: Update an existing product/plan/feature in the catalog
    Given the request body contains updated product/plan/feature details
    When I send a PUT request to "/api/catalog/{id}"
    Then the response status code should be 200
    And the response should contain the updated product/plan/feature details
    And the response should have a content type of "application/json"

Scenario: Delete a product/plan/feature from the catalog
    When I send a DELETE request to "/api/catalog/{id}"
    Then the response status code should be 204
