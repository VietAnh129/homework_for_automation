package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void test_valid_login() {
        LoginPage login = new LoginPage(driver);
        login.login("standard_user", "secret_sauce");
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"), "Login failed!");
    }

    @Test
    public void test_invalid_login_with_wrong_password() {
        LoginPage login = new LoginPage(driver);
        login.login("invalid_user", "wrong_pass");
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
}
