@smoke
  Feature: Currency | users could change currency to euro
    Scenario: user could switch currency to euro
      When user select euro currency
      Then user can find euro symbol shown on the products in Home page
