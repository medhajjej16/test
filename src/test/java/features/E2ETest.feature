Feature: Automated End2End Tests
  Description: The purpose of this feature is to test End 2 End integration.

  Scenario Outline: Customer place an order by purchasing an item from search
    Given user is on Home Page    user registration I entered "<firstname>", "<lastname>", "<email>", "<password>"
    When he search for "Apple MacBook Pro 13-inch"
    And choose to buy Two items
    And moves to checkout cart and enter personal details on checkout page and place the order
    Then he can view the order and download the invoice


    Examples:
      | firstname | lastname | email | password |
 	    | ahmed | mohamed |dmaf@user434.com | 12345678 |  
 	    | Moataz | ahmed | tamf@newuser233.com | 87654321 |
 	    
 