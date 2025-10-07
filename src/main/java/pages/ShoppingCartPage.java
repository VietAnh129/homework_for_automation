package pages;
import org.openqa.selenium.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage {
    WebDriver driver;
    By cartItemLable = By.className("cart_item_label");
    By checkoutButton = By.id("checkout");

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
    }
