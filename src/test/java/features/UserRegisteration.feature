Feature: User Registration
  I want to check that the user can register in ecommerce file

  Scenario: User Registration
    Given The user is in the home page
    When I click on register link
    And I entered the user data
    Then The registration page is displayed successfully
