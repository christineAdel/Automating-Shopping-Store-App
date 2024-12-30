

Feature: Shopping in the General Store App


Scenario Outline: Add products to the cart and verify total
    Given the app is launched
    When I select <country> as the country
    And I enter <name> as the name
    And I select <gender> as the gender
    And I click on Lets Shop
    Then I add two products to the cart
    And I navigate to the cart screen
    And I verify the products are displayed
    And I verify the total equals the sum of the product prices

    Examples:
      | country | name  | gender |
      | Egypt   | Test  | Female |

