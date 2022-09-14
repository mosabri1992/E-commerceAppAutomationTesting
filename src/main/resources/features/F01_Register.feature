@smoke
  Feature: Register | register new account

    Scenario: user register with valid data
      Given user go to register page
      When user select gender
      And user enter first name "automation" and last name "tester"
      And user enter date of birth
      And user enter email "mohamed@example.com" field
      And user fills Password fields "P@ssw0rd" "P@ssw0rd"
      And user clicks on register button
      Then success message is displayed
