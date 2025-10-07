package pages;
import org.openqa.selenium.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage {
    WebDriver driver;
    By cartItemLable = By.className("cart_item_label");
    By checkoutButton = By.id("checkout");
    By firstNameField = By.id("first-name");
    By lastNameField = By.id("last-name");
    By zipPostalCodeField = By.id("postal-code");
    By continueButton = By.id("continue");
    By finishButton = By.id("finish");
    By successMessage = By.className("complete-header");


    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
    }
    public boolean isCartItemLabelDisplayed() {
    try {
        return driver.findElement(cartItemLable).isDisplayed();
    } catch (NoSuchElementException e) {
        return false;
    }
    }   
    public void clickCheckoutButton() {
        driver.findElement(checkoutButton).click();
    }
    public void inputFirstName(String first_name) {
        driver.findElement(firstNameField).sendKeys(first_name);
    }
    public void inputLastName(String last_name) {
        driver.findElement(lastNameField).sendKeys(last_name);
    }
    public void inputZipPostalCode(String zip_code) {
        driver.findElement(zipPostalCodeField).sendKeys(zip_code);
    }
    public void clickContinueButton() {
        driver.findElement(continueButton).click();
    }
    public void clickFinishButton() {
    driver.findElement(finishButton).click();
    }
    public boolean isSuccessOrderDisplayed() {
    try {
        return driver.findElement(successMessage).isDisplayed();
    } catch (NoSuchElementException e) {
        return false;
    }
    }   
    }
