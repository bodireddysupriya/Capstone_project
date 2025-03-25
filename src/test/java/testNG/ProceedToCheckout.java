package testNG;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProceedToCheckout extends BaseClass1 {
    LoginPage loginPage;
    ProductPage2 productPage;

    @BeforeMethod
    public void setUpTest() {
        loginPage = new LoginPage(driver);  // Initialize Page Objects
        productPage = new ProductPage2(driver);
    }

    @Test
    public void testAddToCartAndProceedToCheckout() {
        // Login
        loginPage.enterEmail("bodireddysupriya@gmail.com");
        loginPage.enterPassword("Supriya@1234");
        
        // Search and select Hoodie
        productPage.searchProduct("Hoodies and sweatshirts for women");
        productPage.selectHoodie();
        productPage.selectColour();
        productPage.selectSize("M");
        
        // Add to Cart and Open Cart
        productPage.addToCart();
        productPage.openCart();
        String productName = productPage.getCartProductName();
        Assert.assertTrue(productName.contains("Hoodie"), "Hoodie not found in cart!");
        
     // Click "View and Edit Cart" before Checkout
        productPage.viewAndEditCart();

        // Proceed to Checkout
        productPage.checkoutButton();
        System.out.println("Successfully proceeded to checkout.");
    }
}