Feature: Adding Multiple Products to Cart & Validating Cart Summary  

Scenario Outline: Adding Multiple Products to Cart & Validating Cart Summary 
	Given User opens the browser  	
	And User navigates to the application URL "https://magento.softwaretestingboard.com/"  
	When User clicks the "Sign In" link on the homepage  
  And User enters the valid Login Credentials 
	|LoginDetails.xlsx| 
  And User clicks the "Sign In" button  
  And User clear the cart elements
  And User enters the data jacket "Jacket" in the search textbox   
  And User selects jacket for men from the auto-suggestion list  '<option1>'
  And User clicks on the '<item1>'  from the search results
	And User selects size, color, and quantity from 
	|LoginDetails.xlsx|  
	And User clicks the Add to Cart button 
	Then Verify whether the product is added to cart with message '<Message1>'
	And User enters the data jackets "tshirts" in the search textbox  
	And User selects tshirts for man from the auto-suggestion list  '<option2>'
	And User clicks on the '<item2>'  from the search results
	And User selects size, color, and quantity from 
	|LoginDetails.xlsx|  
	And User clicks the Add to Cart button 
	Then Verify whether the product is added to cart with message '<Message2>'
	And User click on cart icon
	Then Verify whether the products are added to cart with message and total price "$89.00"

Examples:  
|option1                |option2           |item1                                    |item2    															   |Message1																															 |Message2																																 |						     
|Jacket for men         |tshirts for man   |Typhon Performance Fleece-lined Jacket   |Atomic Endurance Running Tee (Crew-Neck) |You added Typhon Performance Fleece-lined Jacket to your shopping cart.|You added Atomic Endurance Running Tee (Crew-Neck) to your shopping cart.|

