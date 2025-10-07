package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.InventoryPage;
import pages.LoginPage;
import pages.ShoppingCartPage;

public class InventoryTest extends BaseTest {
    InventoryPage inventoryPage;
    ShoppingCartPage shoppingCartPage;

    @Test
    public void test_valid_login() {
        LoginPage login = new LoginPage(driver);
        login.login("standard_user", "secret_sauce");
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"), "Login failed!");
    }

    @Test
    public void test_invalid_login_with_wrong_password() {
        LoginPage login = new LoginPage(driver);
        login.login("standard_user", "wrong_pass");
        Assert.assertTrue(login.getErrorMessage().contains("Username and password do not match"), "Wrong Message!");
    }
    @Test
    public void test_invalid_login_with_wrong_user() {
        LoginPage login = new LoginPage(driver);
        login.login("invalid_user", "secret_sauce");
        Assert.assertTrue(login.getErrorMessage().contains("Username and password do not match"), "Wrong Message!");
    }
    @Test
    public void test_invalid_login_with_empty_user_field(){
        LoginPage login = new LoginPage(driver);
        login.login("", "secret_sauce");
        Assert.assertTrue(login.getErrorMessage().contains("Username is required"), "Wrong Message!");
    }
    @Test
    public void test_invalid_login_with_empty_password_field(){
        LoginPage login = new LoginPage(driver);
        login.login("standard_user", "");
        Assert.assertTrue(login.getErrorMessage().contains("Password is required"), "Wrong Message!");
    }
    @Test
    public void test_invalid_login_with_locked_out_user(){
        LoginPage login = new LoginPage(driver);
        login.login("locked_out_user", "secret_sauce");
        Assert.assertTrue(login.getErrorMessage().contains("Sorry, this user has been locked out."), "Wrong Message!");
    }
    @Test
    public void test_add_item_n_checkout(){
        LoginPage login = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        shoppingCartPage = new ShoppingCartPage(driver);
        login.login("standard_user", "secret_sauce");
        inventoryPage.addItemToCart();
        inventoryPage.openCart();
        Assert.assertTrue(shoppingCartPage.isCartItemLabelDisplayed());
        shoppingCartPage.clickCheckoutButton();
        shoppingCartPage.inputFirstName("Viet Anh");
        shoppingCartPage.inputLastName("Le");
        shoppingCartPage.inputZipPostalCode("10000");
        shoppingCartPage.clickContinueButton();
        shoppingCartPage.clickFinishButton();
        Assert.assertTrue(shoppingCartPage.isSuccessOrderDisplayed());
    }
}
