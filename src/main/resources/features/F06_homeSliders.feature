@smoke
  Feature: Slider | user could select product from slider
    Scenario: First slider is clickable on home page
      When user clicks on first slider
      And user clicks on first slider product
      Then user redirected to first product page

    Scenario: Second slider is clickable on home page
      When user clicks on second slider
      And user clicks on second slider product
      Then user redirected to second product page