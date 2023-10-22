package sauceDemo.cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class login {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";


    @Given("user open website")
    public void user_open_website() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseUrl);

        driver.findElement(By.id("user-name")).sendKeys("visual_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        //close browser
        //driver.close();
    }

    @When("user input username")
    public void user_input_username() {
        driver.findElement(By.id("user-name")).sendKeys("visual_user");
    }

    @And("user input password")
    public void user_input_password() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("user click login")
    public void user_click_login() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("user entering system")
    public void user_entering_system() {
            Assert.assertEquals("Products",driver.findElement(By.className("title")).getText());
            System.out.println("Success Login");
            driver.close();
    }

    @And("user input invalid password")
    public void user_input_invalid_password() {
        driver.findElement(By.id("password")).sendKeys("secret_receipe");
    }

    @Then("error system alert")
    public void error_system_alert() {
        String ErrorLogin = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3/button/svg")).getText();
        Assert.assertEquals(ErrorLogin, "Epic sadface: Username and password do not match any user in this service");
        driver.close();
    }
}
