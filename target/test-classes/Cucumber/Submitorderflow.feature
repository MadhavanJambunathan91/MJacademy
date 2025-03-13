

@tag
Feature: Purchase order flow
  I want to use this template for my feature file
  
  
  Background: 
  
  Given I landed on ecommerce page


  @tag2
  Scenario Outline: Positive test of submitting order
    Given i login with "<name>" and "<password>"
    When I add the "<productname>" in cart
    And checkout "<productname>" and submit order
    Then  I verify the "THANKYOU FOR THE ORDER"
    
    Examples: 
      | name                  | password      | | productname  |
      | madhavan915@gmail.com |   Test@54321 |  | ADIDAS ORIGINAL |
      