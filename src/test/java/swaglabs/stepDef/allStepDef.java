package swaglabs.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class allStepDef {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("user open https:\\/\\/www.saucedemo.com\\/ in browser")
    public void user_open_https_www_saucedemo_com_in_browser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //set timeout for webdriver on waiting element
        driver.get(baseUrl);

        // Assertion
        String loginPageAssert = driver.findElement(By.xpath("//div[contains(text(),'Swag Labs')]")).getText();
        Assert.assertEquals(loginPageAssert,"Swag Labs");
    }

    @When("user input a registered user")
    public void user_input_a_registered_user() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @And("user input registered password")
    public void user_input_registered_password() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("user tap login button")
    public void user_tap_login_button() {
        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }

    @Then("user redirect to dashboard")
    public void user_redirect_to_dashboard() {
        String SuccessLogin = driver.findElement(By.xpath("//div[@class='app_logo']")).getText();
        Assert.assertEquals(SuccessLogin,"Swag Labs");

        driver.close();
    }

    @When("user input a wrong registered user")
    public void user_input_a_wrong_registered_user() {
        driver.findElement(By.id("user-name")).sendKeys("locked_out_user");
    }

    @Then("user see error message")
    public void user_see_error_message() {
        String ErrorLogin = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
        Assert.assertEquals(ErrorLogin,"Epic sadface: Sorry, this user has been locked out.");

        driver.close();
    }

    @And("user see dashboard")
    public void user_see_dashboard() {
        String SuccessLogin = driver.findElement(By.xpath("//div[@class='app_logo']")).getText();
        Assert.assertEquals(SuccessLogin,"Swag Labs");
    }

    @And("user filter product by name Z to A")
    public void user_filter_product_by_name_z_to_a() {
        Select dropdown = new Select(driver.findElement(By.xpath("//select[@class='product_sort_container']")));
        dropdown.selectByValue("za");
    }

    @And("user filter product by price high to low")
    public void user_filter_product_by_price_high_to_low() {
        Select dropdown = new Select(driver.findElement(By.xpath("//select[@class='product_sort_container']")));
        dropdown.selectByValue("hilo");
    }

    @Then("user filter product by price low to high")
    public void user_filter_product_by_price_low_to_high() {
        Select dropdown = new Select(driver.findElement(By.xpath("//select[@class='product_sort_container']")));
        dropdown.selectByValue("lohi");

        driver.close();
    }

    @And("user click add to cart")
    public void user_click_add_to_cart() {
        driver.findElement(By.xpath("//button[@data-test='add-to-cart-test.allthethings()-t-shirt-(red)']")).click();
    }

    @And("user click cart")
    public void user_click_cart() {
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
    }

    @And("user click checkout")
    public void user_click_checkout() {
        driver.findElement(By.id("checkout")).click();
    }

    @And("user input first name")
    public void user_input_first_name() {
        driver.findElement(By.id("first-name")).sendKeys("Aeolin");
    }

    @And("user input last name")
    public void user_input_last_name() {
        driver.findElement(By.id("last-name")).sendKeys("Sayekti");
    }

    @And("user input postal code")
    public void user_input_postal_code() {
        driver.findElement(By.id("postal-code")).sendKeys("55555");
    }

    @And("user click continue")
    public void user_click_continue() {
        driver.findElement(By.id("continue")).click();
    }

    @And("user click finish")
    public void user_click_finish() {
        driver.findElement(By.id("finish")).click();
    }

    @Then("user see checkout complete page")
    public void user_see_checkout_complete_page() {
        String SuccessCheckout = driver.findElement(By.xpath("//h2[@class='complete-header']")).getText();
        Assert.assertEquals(SuccessCheckout,"Thank you for your order!");

        driver.close();
    }
}
