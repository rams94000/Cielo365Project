package StepDefinition;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import PageObjectModel.SignInClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AllSteps extends BaseCalss2 {
	WebDriverWait wait;

	@Before
	public void setUp() throws IOException {
		FileInputStream fs = new FileInputStream(
				"C:\\Users\\rams9\\eclipse-workspace\\Cielo365Project\\Property.properties");
		pro = new Properties();
		pro.load(fs);
		String browser = pro.getProperty("browser");
		switch (browser.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			break;

		case "msedge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			break;

		default:
			driver = null;
			break;
		}
	}

	@Given("Enter the URL")
	public void enter_the_url() {

		driver.get(pro.getProperty("url"));
		sign = new SignInClass(driver);
		//department = new DepartmentClass(driver);
		//position = new PositionClass(driver);
	//	profile = new ProfileClass(driver);
		//site = new SiteClass(driver);

	}

	@When("Enter username and password")
	public void enter_username_and_password() {
		driver.findElement(sign.getEnter_username()).sendKeys(pro.getProperty("email"));
		driver.findElement(sign.getEnter_password()).sendKeys(pro.getProperty("password"));

	}

	@When("Click on privacy checkbox")
	public void click_on_privacy_checkbox() throws InterruptedException {
		driver.findElement(sign.getClick_checkbox()).click();

	}

	@When("Click on Signin button")
	public void click_on_signin_button() {
		driver.findElement(sign.getClik_Signin_button()).click();

	}

	@When("Click on drop down and select the value")
	public void click_on_drop_down_and_select_the_value() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".loader-container")));
		driver.findElement(sign.getClick_dropdown()).click();
		driver.findElement(sign.getSelect_dropdown()).click();
	}

	@When("Click on Enter button")
	public void click_on_enter_button() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement clik = wait.until(ExpectedConditions.elementToBeClickable(sign.getClick_Enter_button()));
		clik.click();
	}

	@Then("User should be able to view dashboard page")
	public void user_should_be_able_to_view_dashboard_page() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.titleIs("Cielo365"));
		String title = driver.getTitle();
		System.out.println(title);

	}

	
	@When("Enter invalid username and invalid password")
	public void enter_invalid_username_and_invalid_password() {
	    driver.findElement(sign.getEnter_username()).sendKeys(pro.getProperty("invalidemail"));
	    driver.findElement(sign.getEnter_password()).sendKeys("invalidpassword");
	 
	}

	@Then("User should be able to view error message invalid credentials for invalid password")
	public void user_should_be_able_to_view_error_message_invalid_credentials_for_invalid_password() throws InterruptedException {
		
	    wait=new WebDriverWait(driver,Duration.ofSeconds(13));
	   WebElement error_msg_of_invalidusername_and_invalidpassword= wait.until(ExpectedConditions.elementToBeClickable(sign.getPrint_error_msg_of_invalid_username()));
	    String print_error_msg=error_msg_of_invalidusername_and_invalidpassword.getText();
	    System.out.println("Error Message Of Invalid Username and Invalid Password: "+print_error_msg);
	}

	@When("Enter invalid username and valid password")
	public void enter_invalid_username_and_valid_password() {
	    driver.findElement(sign.getEnter_username()).sendKeys(pro.getProperty("invalidemail"));
	    driver.findElement(sign.getEnter_password()).sendKeys(pro.getProperty("password"));
	    
	}

	@Then("User should be able to view error message invalid credentials for valid password")
	public void user_should_be_able_to_view_error_message_invalid_credentials_for_valid_password() {
		wait=new WebDriverWait(driver,Duration.ofSeconds(13));
		WebElement error_msg_of_invalidusername_and_validpassword= wait.until(ExpectedConditions.elementToBeClickable(sign.getPrint_error_msg_of_valid_password()));
	    String print_error_msg=error_msg_of_invalidusername_and_validpassword.getText();
	    System.out.println("Error Message Of Invalid Username and valid Password: "+print_error_msg);
	    
	}

	@When("Enter valid username and invalid password")
	public void enter_valid_username_and_invalid_password() {
		driver.findElement(sign.getEnter_username()).sendKeys(pro.getProperty("email"));
	    driver.findElement(sign.getEnter_password()).sendKeys(pro.getProperty("invalidpassword"));
	    
	}

	@Then("User should be able to view error message Invalid credentials The user account will be locked after two failed attempts")
	public void user_should_be_able_to_view_error_message_invalid_credentials_the_user_account_will_be_locked_after_two_failed_attempts() {
		System.out.println("Account locked");
	}

	
	
	
	
	

	
	@After
	public void failedScenarios(Scenario sc) {
		if (sc.isFailed() == true) {
			final byte[] s = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			sc.attach(s, "img/png", sc.getName());
		}
		closeAllTabs();

	}

	// Log l=LogManager.getLogger(AllSteps.class);
}
