package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest {
    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValid() {
        WebElement emailField = driver.findElement(By.id("user-name"));
        emailField.sendKeys("standard_user");

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        String expectedMessage = "PRODUCTS";

        String actualMessage = driver.findElement(By.xpath("//span[contains(text(),'Products')]")).getText();

        //Validate actual and expected message
        Assert.assertEquals("PRODUCTS text not displayed correctly", expectedMessage, actualMessage);
    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        //sending  email to email field element
        WebElement emailField = driver.findElement(By.id("user-name"));
        emailField.sendKeys("standard_user");
        //sending password to password field element
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("secret_sauce");
        // find log in link and click on log in link
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
        //Find Element of products
        List<WebElement> products = driver.findElements(By.className("inventory_item"));
        //Print number of Items
        System.out.println("Items displayed : " + products.size());
        //to Count how many items
        for (WebElement element : products)
            Assert.assertEquals(true, element.isDisplayed());
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}



