@reg
Feature: Message sent validation

Scenario: Verify your message has been sent displayed
  Given I am on the seller ad page
  When  I click sign in to message
#  When  I sign in to gumtree
  Then  I verify buyer signed in
  When  I enter message in the message section
  Then  I verify your message has been sent displayed

