package stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
public class NavigationSetps {

	WebDriver driver;
	
	@Given("I am on DEMO webpage")
	public void i_am_on_demo_webpage() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","src/test/java/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoblaze.com/index.html");
	}

	@When("I click navigate through {string} category")
	public void i_click_navigate_through_or_or(String productCategory) throws InterruptedException {
		try {
		WebElement dropElement = driver.findElement(By.xpath("/html/body/div[5]/div/div[1]/div/a[6]"));
		
			dropElement.click();
		} catch (NoSuchElementException nEE) {
			Assert.fail("There is no " + productCategory + "present in navigation menu");
		}
	}

	@Then("Check for an specific product {string} in selected category")
	public void check_for_an_specific_product_in_selected_category(String product) {
		Assert.assertTrue(driver.getPageSource().contains("MacBook air"));
	}
	
	@When("I click navigate through Monitors category")
	public void i_click_navigate_through_monitors_category() {
		WebElement dropElement = driver.findElement(By.xpath("/html/body/div[5]/div/div[1]/div/a[4]"));
		dropElement.click();
	}

	@Then("Check for monitor {string} is selected category")
	public void check_for_monitor_is_selected_category(String string) {
		Assert.assertTrue(driver.getPageSource().contains("Samsung"));
	}
	
}
