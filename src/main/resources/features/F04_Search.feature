@smoke
  Feature: Search | User could search for any product using search box
    Scenario Outline: user could search using product name
      When user clicks on search box
      And user search with name "<productname>"
      Then search result appears relevant to the search keyword
      Examples:
        |productname|
        |book|
        |laptop|
        |nike|


    Scenario Outline: user could search using product sku
      When user clicks on search box
      And user search with sku "<sku>"
      Then search result appears with "<sku>"
      Examples:
        |sku|
        |SCI_FAITH|
        |APPLE_CAM|
        |SF_PRO_11|