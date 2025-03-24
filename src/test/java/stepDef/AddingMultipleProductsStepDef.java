package stepDef;

import org.testng.Assert;
import com.aventstack.extentreports.Status;

import base.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.AddToCartPage;
import pages.HomePage;
import pages.MyAccount;

public class AddingMultipleProductsStepDef extends BaseClass {


    
    @And("User clear the cart elements")
    public void user_clear_the_cart_elements() {
    	   logger1.log(Status.INFO, "Attempting to clear cart elements");
           try {
               HomePage.deleteingCartData();
               logger1.log(Status.PASS, "Cart cleared successfully");
           } catch (Exception e) {
               System.err.println("Error clearing cart: " + e.getMessage());
               logger1.log(Status.FAIL, "Failed to clear cart: " + e.getMessage());
           }
    }

    @And("User enters the data jacket {string} in the search textbox")
    public void user_enters_the_data_jacket_in_the_search_textbox(String query) {
        logger1.log(Status.INFO, "Entering search query: " + query);
        try {
            MyAccount.enterSearchQuery(query);
            logger1.log(Status.PASS, "Search query entered successfully");
        } catch (Exception e) {
            logger1.log(Status.FAIL, "Failed to enter search query: " + e.getMessage());
        }
    }
    @And("User selects jacket for men from the auto-suggestion list  {string}")
    public void user_selects_jacket_for_men_from_the_auto_suggestion_list(String selection) {
    	logger1.log(Status.INFO, "Selecting item from auto-suggestion: " + selection);
        try {
            MyAccount.selectSuggestion(selection);
            logger1.log(Status.PASS, "Jacket selected successfully");
        } catch (Exception e) {
            logger1.log(Status.FAIL, "Failed to select jacket: " + e.getMessage());
        }
    }
    @And("User enters the data jackets {string} in the search textbox")
    public void user_enters_the_data_jackets_in_the_search_textbox(String query) {
        logger1.log(Status.INFO, "Entering search query: " + query);
        try {
            MyAccount.enterSearchQuery(query);
            logger1.log(Status.PASS, "Search query entered successfully");
        } catch (Exception e) {
            logger1.log(Status.FAIL, "Failed to enter search query: " + e.getMessage());
        }
    }
    @Then("User selects tshirts for man from the auto-suggestion list  {string}")
    public void user_selects_tshirts_for_man_from_the_auto_suggestion_list(String selection) {
    	 logger1.log(Status.INFO, "Selecting t-shirt from auto-suggestion: " + selection);
         try {
             MyAccount.selectSuggestion(selection);
             logger1.log(Status.PASS, "T-shirt selected successfully");
         } catch (Exception e) {
             logger1.log(Status.FAIL, "Failed to select t-shirt: " + e.getMessage());
         }
    }
    
    @And("User click on cart icon")
    public void user_click_on_cart_icon() {
    	logger1.log(Status.INFO, "Clicking on cart icon");
        try {
            AddToCartPage.clickCartSymbol();
            Thread.sleep(9000); // Consider replacing this with an explicit wait
            logger1.log(Status.PASS, "Cart icon clicked successfully");
        } catch (Exception e) {
            logger1.log(Status.FAIL, "Failed to click cart icon: " + e.getMessage());
        }
    }
    @Then("Verify whether the products are added to cart with message and total price {string}")
    public void verify_whether_the_products_are_added_to_cart_with_message_and_total_price(String expectedAmount) {
        logger1.log(Status.INFO, "Verifying cart total price");
        try {
            String actualAmount = AddToCartPage.getCartAmount();
            Assert.assertEquals(actualAmount, expectedAmount, "Cart amount mismatch");
            System.out.println("Cart Total: " + actualAmount);
            logger1.log(Status.PASS, "Cart total price verified successfully");
        } catch (Exception e) {
            System.err.println("Error comparing amount: " + e.getMessage());
            logger1.log(Status.FAIL, "Failed to verify cart total price: " + e.getMessage());
        }
    }
}
