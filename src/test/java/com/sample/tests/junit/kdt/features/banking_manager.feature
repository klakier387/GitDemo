Feature: Bank Manager
  Scenario: Add new customer
    Given the banking application has been started
    And I am on the "Banking Home" page
    When I click on the "Banking Manager Login" button
    Then I should see the "Banking Manager Home" page
    When I am on the "Banking Manager Home" page
    And I click on the "Customers" button
    When I am on the "Customers" page
    Then I should see the "Customers" page
    When I am on the "Banking Manager Home" page
    And I click on the "Add Customer" button
    When I am on the "Add Customer" page
    Then I should see the "Add Customer" page
    And the following fields are shown:
    | First Name |
    | Last Name  |
    | Post Code  |
    | Submit     |
    When I populate current page with the following data:
      | Field      | Value |
      | First Name | Test  |
      | Last Name  | User  |
      | Post Code  | WW99  |
    Then I should see the page contains the following data:
      | Field      | Value |
      | First Name | Test  |
      | Last Name  | User  |
      | Post Code  | WW99  |

    When I click on the "Submit" button
    When I accept the alert message
    Then I should see the "Add Customer" page
    When I am on the "Banking Manager Home" page
    And I click on the "Customers" button
    Then I should see the "Customers" page
    Then I should see the "Customer List" list is not empty
    When I scroll to the bottom of the page
    Then I should see the "Customers" page
    And the following labels are shown:
      | Test  |
      | User  |
      | WW99  |