package sauceDemo.cucumber.stepDef;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class logout {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";


    @Given("user success login")
    public void user_success_login() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseUrl);

        driver.findElement(By.id("user-name")).sendKeys("visual_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        driver.findElement(By.xpath("//span[@class='title']"));
        String productlist = driver.findElement(By.xpath("//span[@class='title']")).getText();
        Assert.assertEquals(productlist,"Products");

    }
    @When("user click menu")
    public void user_click_menu() {
        driver.findElement(By.id("react-burger-menu-btn")).click();
    }

    @When("user click logout password")
    public void user_click_logout_password() {
        driver.findElement(By.id("menu_button_container")).isDisplayed();
        driver.findElement(By.id("logout_sidebar_link")).click();

    }
    @Then("user exit system")
    public void user_exit_system() {
        String exitPage = driver.findElement(By.xpath("//*[@id='login_credentials']/h4")).getText();
        Assert.assertEquals(exitPage,"Accepted usernames are:");
        driver.close();
    }
}
