package stepDef;
import com.aventstack.extentreports.Status;

import base.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LogoutPage;
import pages.MyAccount;
import pages.SignInPage;

public class LogoutStepDef extends BaseClass {

    @And("User enters valid email {string} and password {string}")
    public void user_enters_valid_email_and_password(String email, String password) {
        logger1.log(Status.INFO, "Attempting to enter valid login credentials");
        try {
            SignInPage.enterValidCredentials(email, password);
            System.out.println("User logged in with valid credentials");
            logger1.log(Status.PASS, "Valid credentials entered successfully");
        } catch (Exception e) {
            System.out.println("Exception in user_enters_valid_email_and_password: " + e.getMessage());
            logger1.log(Status.FAIL, "Failed to enter valid credentials: " + e.getMessage());
        }
    }


    @When("User clicks {string} from {string}  page")
    public void user_clicks_from_page(String action, String page) {
    	 logger1.log(Status.INFO, "Attempting to perform action: " + action + " on " + page + " page");
         try {
             if (action.equalsIgnoreCase("Logout") && page.equalsIgnoreCase("My Account")) {
                 LogoutPage.logout();
                 System.out.println("User clicked on Logout from My Account page");
                 logger1.log(Status.PASS, "Logout clicked successfully");
             } else {
                 logger1.log(Status.FAIL, "Invalid action or page provided");
             }
         } catch (Exception e) {
             System.out.println("Exception in user_clicks_from_page: " + e.getMessage());
             logger1.log(Status.FAIL, "Failed to click Logout: " + e.getMessage());
         }
    }

    @Then("User verifies that the session ends and the user is redirected to the homepage")
    public void user_verifies_that_the_session_ends_and_the_user_is_redirected_to_the_homepage() {
        logger1.log(Status.INFO, "Verifying session end and redirection to homepage");
        try {
            
            String homepageText = MyAccount.getMyAccountText();
            System.out.println(homepageText);
                System.out.println("Session ended and user redirected to homepage");
                logger1.log(Status.PASS, "User successfully redirected to homepage");
                Thread.sleep(7000);
        } catch (Exception e) {
            System.out.println("Exception in user_verifies_that_the_session_ends: " + e.getMessage());
            logger1.log(Status.FAIL, "Failed to verify session end: " + e.getMessage());
        }
    }

    @And("User verifies the {string} is displayed")
    public void user_verifies_the_is_displayed(String expectedText) {
        logger1.log(Status.INFO, "Verifying displayed text: " + expectedText);
        try {
            String actualText = MyAccount.getMyAccountText();
            if (actualText.equalsIgnoreCase(expectedText)) {
                System.out.println(expectedText + " is displayed successfully");
                logger1.log(Status.PASS, expectedText + " is displayed correctly");
            } else {
                System.out.println("Expected: " + expectedText + ", but found: " + actualText);
                logger1.log(Status.FAIL, "Text mismatch: Expected '" + expectedText + "', but found '" + actualText + "'");
            }
        } catch (Exception e) {
            System.out.println("Exception in user_verifies_the_is_displayed: " + e.getMessage());
            logger1.log(Status.FAIL, "Failed to verify displayed text: " + e.getMessage());
        }
    }
}
