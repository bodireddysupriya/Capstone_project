package pages;

import org.openqa.selenium.support.ui.ExpectedConditions;

import com.aventstack.extentreports.Status;

import base.BaseClass;
import objects.RegistrationPageObjects;
import screenshot.Capture;

public class RegistrationPage extends BaseClass {

	static RegistrationPageObjects obj;
 
	// Enter first name in the firstName field
	public static void enterFirstName(String firstName) throws Exception {
		logger1.addScreenCaptureFromPath(Capture.screenShot("Register"));
		logger1.log(Status.INFO, "Details are entered");
		try {
			obj = new RegistrationPageObjects();
			wait.until(ExpectedConditions.visibilityOf(obj.firstNameElement));
			obj.firstNameElement.sendKeys(firstName);
			System.out.println("Entered First Name: " + firstName);
			logger1.log(Status.PASS, "First name is entered");
		} catch (Exception e) {
			System.out.println("Exception in enterFirstName method: " + e);
			logger1.log(Status.FAIL, "Couldnot enter first name");
		}
	}

	// Enter Last name in the LastName field
	public static void enterLastName(String lastName) {
		try {
			obj = new RegistrationPageObjects();
			wait.until(ExpectedConditions.visibilityOf(obj.lastNameElement));
			obj.lastNameElement.sendKeys(lastName);
			System.out.println("Entered Last Name: " + lastName);
			logger1.log(Status.PASS, "Lastname is given");
		} catch (Exception e) {
			System.out.println("Exception in enterLastName method: " + e);
			logger1.log(Status.FAIL, "Couldnot give last name");
		}
	}

	// Enter the mail in the Email field
	public static void enterEmail(String str) {
		try {
			obj = new RegistrationPageObjects();
			wait.until(ExpectedConditions.visibilityOf(obj.emailElement));
			obj.emailElement.clear();
			obj.emailElement.sendKeys(str);
			System.out.println("Entered Email: " + str);
			logger1.log(Status.PASS, "Email is given");
		} catch (Exception e) {
			System.out.println("Exception in enterEmail method: " + e);
			logger1.log(Status.FAIL, "Email is not given");
		}
	}

	//Enter the password in the password field
	public static void enterPassword(String password) {
		try {
			obj = new RegistrationPageObjects();
			wait.until(ExpectedConditions.visibilityOf(obj.passwordElement));
			obj.passwordElement.sendKeys(password);
			System.out.println("Entered Password");
			logger1.log(Status.PASS, "Password is entered");
		} catch (Exception e) {
			System.out.println("Exception in enterPassword method: " + e);
			logger1.log(Status.PASS, "Password is not entered");
		}
	}

	//Enter the Confirm pass in the confirm password field
	public static void enterConfirmPassword(String confirmPassword) {
		try {
			obj = new RegistrationPageObjects();
			wait.until(ExpectedConditions.visibilityOf(obj.confirmPasswordElement));
			obj.confirmPasswordElement.sendKeys(confirmPassword);
			System.out.println("Entered Confirm Password");
			logger1.log(Status.PASS, "ConfirmPassword entered");
		} catch (Exception e) {
			System.out.println("Exception in enterConfirmPassword method: " + e);
			logger1.log(Status.FAIL, "Couldnot enter confirm password");
		}
	}

	// Clicks the Create an Account button
	public static void clickCreateAnAccount() throws Exception{
		try {
			obj = new RegistrationPageObjects();
			wait.until(ExpectedConditions.elementToBeClickable(obj.createAnAccountElement));
			obj.createAnAccountElement.click();
			System.out.println("Clicked Create an Account");
			logger1.log(Status.PASS, "Create account button clicked");
		} catch (Exception e) {
			System.out.println("Exception in clickCreateAnAccount method: " + e);
			logger1.log(Status.FAIL, "Couldnot click create account button");
		}
	}

	// displays error message in email field
	public static String emailErrorMessage() {
		try {
			obj = new RegistrationPageObjects();
			wait.until(ExpectedConditions.visibilityOf(obj.emailErrorElement));
			String message = obj.emailErrorElement.getText();
			System.out.println("Email Error Message: " + message);
			logger1.log(Status.PASS, "Error message displayed");
			return message;
		} catch (Exception e) {
			System.out.println("Exception in getEmailErrorMessage method: " + e);
			logger1.log(Status.FAIL, "Couldnot see my account page");
			logger1.log(Status.PASS, "Error message not displayed");
			return null;
		}
	}
}
