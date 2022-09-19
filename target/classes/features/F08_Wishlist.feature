@smoke
  Feature:  WishList Feature | user can click on ❤ button to add product to wish list
    Scenario: after adding items to wishlist you get a success message
      When user add product to wishlist
      Then adding item to wishlist success message is displayed


      Scenario: the item you added appears in wishlist page
        When user add another product to wishlist
        And adding item to wishlist success message is displayed
        And user go to wishlist page
        Then user find added items in the wishlist page and Qty value is bigger than 0

