package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;
    By username_field = By.id("user-name");
    By password_field = By.id("password");
    By loginBtn = By.id("login-button");
    By errorMsg = By.cssSelector("h3[data-test='error']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String user, String pass) {
        input_user_name(user);
        input_password(pass);
        click_login_btn();
    }

    public void input_user_name(String user_name){
        driver.findElement(username_field).sendKeys(user_name);
    }

    public void input_password(String password){
        driver.findElement(password_field).sendKeys(password);
    }
    public void click_login_btn(){
        driver.findElement(loginBtn).click();

    }

    public String getErrorMessage() {
        return driver.findElement(errorMsg).getText();
    }
}
