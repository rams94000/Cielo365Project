package StepDefinition;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObjectModel.Cardholder;
import PageObjectModel.Departments;
import PageObjectModel.Profile;
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
		card=new Cardholder(driver);
		dep=new Departments(driver);
		porfile=new Profile(driver);

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
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement error_msg_of_invalidPassword=wait.until(ExpectedConditions.visibilityOfElementLocated(sign.getPrint_error_msg_of_Invalid_password()));
		String print_error_msg_of_invalidPassword=error_msg_of_invalidPassword.getText();
		System.out.println("Error Message of invalid password"+print_error_msg_of_invalidPassword);
	}

	@When("Click on cardholder module")
	public void click_on_cardholder_module() {
	    wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	    WebElement click_on_cardholdermodule=wait.until(ExpectedConditions.elementToBeClickable(card.getClick_on_cardholder_module()));
	    click_on_cardholdermodule.click();
	}
	@When("Click on cardholder submodule")
	public void click_on_cardholder_submodule() {
		 wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		 WebElement click_on_cardholdersubmodule=wait.until(ExpectedConditions.elementToBeClickable(card.getClick_on_cardholder_submodule()));
		 click_on_cardholdersubmodule.click();
		
		
	}
	@When("Click on cardholder add icon button")
	public void click_on_cardholder_add_icon_button() {
	    wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.elementToBeClickable(card.getClick_on_add_icon_button())).click();
		
		
	}
	@When("Enter all data in mandatory fields for cardholder")
	public void enter_all_data_in_mandatory_fields_for_cardholder() throws InterruptedException {
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement Enteremployeecode=wait.until(ExpectedConditions.visibilityOfElementLocated(card.getEnter_employee_code()));
	    Enteremployeecode.sendKeys(enterFirstName());
		
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement Enterefirstname=wait.until(ExpectedConditions.visibilityOfElementLocated(card.getEnter_first_name()));
		Enterefirstname.sendKeys(enterFirstName());
		
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement Clickondepartmentofcardholder=wait.until(ExpectedConditions.elementToBeClickable(card.getClick_on_department_of_cardholder()));
		Clickondepartmentofcardholder.click();
		
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement Selectdepartmentofcardholder=wait.until(ExpectedConditions.elementToBeClickable(card.getSelectdepartmentofcardholder()));
		if(Selectdepartmentofcardholder.getText().equals("dev")) {
			Selectdepartmentofcardholder.click();
		}
		
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement Clickonsubmitbuttonofcardholder=wait.until(ExpectedConditions.elementToBeClickable(card.getClick_on_submit_button_of_cardholder()));
		Clickonsubmitbuttonofcardholder.click();
	}
	@When("Click on cardholder add button")
	public void click_on_cardholder_add_button() {
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement Clickonaddbuttonofcardholder=wait.until(ExpectedConditions.elementToBeClickable(card.getClic_on_addbutton_of_cardholder()));
		Clickonaddbuttonofcardholder.click();
		
		
	}
	@Then("Cardholder should be created successfully")
	public void cardholder_should_be_created_successfully() {
	    
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement printsuccessmessageofcradholder=wait.until(ExpectedConditions.visibilityOfElementLocated(card.getPrint_Success_msg_of_createcardholder()));
		String message=printsuccessmessageofcradholder.getText();
		System.out.println(message);
	}
	
	@When("Enter all data in non mandatory fields for cardholder")
	public void enter_all_data_in_non_mandatory_fields_for_cardholder() throws AWTException, InterruptedException {
	  wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	  WebElement enterlastname=  wait.until(ExpectedConditions.visibilityOfElementLocated(card.getEnter_last_name_of_carholder()));
	  enterlastname.sendKeys(enetrLastName());
	  
	  wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	  WebElement clickonchoosefile=  wait.until(ExpectedConditions.elementToBeClickable(card.getClick_on_choosefile_cardholder()));
	  clickonchoosefile.click();
	  
	  Robot rb=new Robot();
	  rb.delay(4000);
	  StringSelection ss=new StringSelection("Downloads\\Shan.Image.jpg");
	  Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
	  rb.keyPress(KeyEvent.VK_CONTROL);
	  rb.keyPress(KeyEvent.VK_V);
	  
	  rb.keyRelease(KeyEvent.VK_CONTROL);
	  rb.keyRelease(KeyEvent.VK_V);
	  
	  rb.keyPress(KeyEvent.VK_ENTER);
	  rb.keyRelease(KeyEvent.VK_ENTER);
	  wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	  wait.until(ExpectedConditions.visibilityOfElementLocated(card.getClick_on_choosefile_cardholder()));
	  	
	}

	@Then("the user should see a mandatory field error message for cardholder")
	public void the_user_should_see_a_mandatory_field_error_message_for_cardholder() {
	    wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	    WebElement errormessageofmandatoryfieldscardholdr=   wait.until(ExpectedConditions.visibilityOfElementLocated(card.getPrint_errormsg_of_mandatoryfields_cardholder()));
		String errormessage=errormessageofmandatoryfieldscardholdr.getText();
		System.out.println(errormessage);
		
	}
	
	@When("Click On Delete button of cardholder page")
	public void click_on_delete_button_of_cardholder_page() {
	  wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	  WebElement Clickondeletebuttonofcardholder=  wait.until(ExpectedConditions.elementToBeClickable(card.getClick_on_Delete_button_of_cardholder()));
	  Clickondeletebuttonofcardholder.click();
	  
	  wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	  WebElement ClickonYesButton=  wait.until(ExpectedConditions.elementToBeClickable(card.getClick_on_Deletebutton_of_cardholder()));
	  ClickonYesButton.click();
	  
	}
	@Then("the user should be able to see cardholder delete success message")
	public void the_user_should_be_able_to_see_cardholder_delete_success_message() {
	    System.out.println("Cardholder Deleted successfully");
		
	}
	@When("Click on edit button of cardholder")
	public void click_on_edit_button_of_cardholder() {
	    wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	    WebElement Clickoneditbuttonofcardholder= wait.until(ExpectedConditions.elementToBeClickable(card.getClick_on_edit_button_of_cardholder()));
	    Clickoneditbuttonofcardholder.click();
	}
	@When("Edit the data")
	public void edit_the_data() {
	    
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement Enterefirstname=wait.until(ExpectedConditions.visibilityOfElementLocated(card.getEnter_first_name()));
		Enterefirstname.sendKeys(enterFirstName());
		
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(card.getClick_on_save_button_of_cardholder())).click();
		
		
	}
	@Then("the user should be able to view success message of edit cardholder")
	public void the_user_should_be_able_to_view_success_message_of_edit_cardholder() {
	    wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	    WebElement successmessage= wait.until(ExpectedConditions.visibilityOfElementLocated(card.getPrint_success_message_of_editcardholder()));
		String message=successmessage.getText();
		System.out.println(message);
	}
	
	@When("Scroll the cardholder page")
	public void scroll_the_cardholder_page() throws InterruptedException {
		
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	        JavascriptExecutor js = (JavascriptExecutor) driver;

	        wait.until(ExpectedConditions.presenceOfElementLocated(
	                By.xpath("//div[@role='row' and contains(@class,'MuiDataGrid-row')]")));

	        Set<String> allRecords = new HashSet<>();

	        System.out.println("Name\tCardholderID\tDepartment\tPosition");

	        int previousSize = -1;

	        while (true) {

	            
	            List<WebElement> rows = driver.findElements(
	                    By.xpath("//div[@role='row' and contains(@class,'MuiDataGrid-row')]"));

	            for (WebElement row : rows) {

	                try {

	                    String name = row.findElement(By.xpath(".//div[@data-field='firstName']")).getText();
	                    String cardId = row.findElement(By.xpath(".//div[@data-field='code']")).getText();
	                    String department = row.findElement(By.xpath(".//div[@data-field='departmentName']")).getText();
	                    String position = row.findElement(By.xpath(".//div[@data-field='designationName']")).getText();

	                    String record = name + "\t" + cardId + "\t" + department + "\t" + position;

	                    if (allRecords.add(record)) {
	                        System.out.println(record);
	                    }

	                } catch (Exception e) {
	                   System.out.println(e);
	                }
	            }
	            if (allRecords.size() == previousSize) {
	                break;
	            }
	            previousSize = allRecords.size();

	            WebElement grid = driver.findElement(
	                    By.xpath("//div[contains(@class,'MuiDataGrid-virtualScroller')]"));

	            js.executeScript("arguments[0].scrollTop = arguments[0].scrollHeight", grid);

	            Thread.sleep(1500);
	        }

	        System.out.println("\nTotal Records Captured: " + allRecords.size());
	
	}
	
	
	// Test cases for Department module
	
	@When("Click on Departments submodule")
	public void click_on_departments_submodule() {
	   wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	   WebElement Click_on_department_submodule=wait.until(ExpectedConditions.elementToBeClickable(dep.getClick_on_Departments_submodule()));
	   Click_on_department_submodule.click();
		
	}
	@When("Click on Add icon buttton of department list page")
	public void click_on_add_icon_buttton_of_department_list_page() {
	    
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement Click_on_Department_add_icon_button=wait.until(ExpectedConditions.elementToBeClickable(dep.getClick_on_Departments_Addicon_button()));
		Click_on_Department_add_icon_button.click();
	}
	@When("Enter all mandatory fields in department create page")
	public void enter_all_mandatory_fields_in_department_create_page() {
	 wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	 WebElement Enter_departmentname_on_nameTextfields=	wait.until(ExpectedConditions.visibilityOfElementLocated(dep.getEnter_Departmentname_on_departmentTextfields()));
	 Enter_departmentname_on_nameTextfields.sendKeys(enterFirstName());
	 
	 wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	 WebElement Enter_departmentcode_on_codeTextfields=	wait.until(ExpectedConditions.visibilityOfElementLocated(dep.getEnter_Departmentcode_on_codeTextfields()));
	 Enter_departmentcode_on_codeTextfields.sendKeys(enterFirstName());
		
		
	}
	@When("Click on Add button in department create page")
	public void click_on_add_button_in_department_create_page() {
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement Click_on_addiconButtonOfDepartment=	wait.until(ExpectedConditions.elementToBeClickable(dep.getClick_on_Addicon_button_Department()));
		Click_on_addiconButtonOfDepartment.click();
		
		
		
	}
	@Then("the user should be able to view department created successfully message")
	public void the_user_should_be_able_to_view_department_created_successfully_message() {
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement Print_Success_message_of_Department=wait.until(ExpectedConditions.visibilityOfElementLocated(dep.getPrint_success_message_of_Department()));
		String Success_Message=Print_Success_message_of_Department.getText();
		System.out.println(Success_Message);
		
		
	}
	
	@When("Click On Departments edit button")
	public void click_on_departments_edit_button() {
	    wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	    WebElement Click_on_edit_button_ofDepartment= wait.until(ExpectedConditions.elementToBeClickable(dep.getClick_on_Department_edit_button()));
	    Click_on_edit_button_ofDepartment.click();
		
	}
	@When("Edit the data of Departments")
	public void edit_the_data_of_departments() {
		 wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		 WebElement Enter_departmentname_on_nameTextfields=	wait.until(ExpectedConditions.visibilityOfElementLocated(dep.getEnter_Departmentname_on_departmentTextfields()));
		 Enter_departmentname_on_nameTextfields.sendKeys(enterFirstName());
		
	}
	@When("Click on edit button of departments")
	public void click_on_edit_button_of_departments() {
		 wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		 WebElement Click_edit_button_ofDepartmengt=wait.until(ExpectedConditions.elementToBeClickable(dep.getClick_on_Department_save_button()));
		 Click_edit_button_ofDepartmengt.click();
		
	}
	@Then("the user should be able to view Department edited successfully")
	public void the_user_should_be_able_to_view_department_edited_successfully() {
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		 WebElement Click_edit_button_ofDepartmengt=wait.until(ExpectedConditions.elementToBeClickable(dep.getPrintSuccessedit_message()));
		 String successEdit=Click_edit_button_ofDepartmengt.getText();
		 System.out.println(successEdit);
		
	}
	
	@When("Click on profile icon button")
	public void click_on_profile_icon_button() {
	    wait=new WebDriverWait(driver,Duration.ofSeconds(15));
	    WebElement click_on_profile=wait.until(ExpectedConditions.elementToBeClickable(porfile.getClick_on_profile()));
	    click_on_profile.click();
		
	}
	@When("Click on my profile")
	public void click_on_my_profile() throws InterruptedException {
	    wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	    WebElement click_on_MyProfile=wait.until(ExpectedConditions.elementToBeClickable(porfile.getClick_on_MyProfile()));
	    click_on_MyProfile.click();
		
	}
	@When("Edit the data of profile")
	public void edit_the_data_of_profile() {
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement enetername=wait.until(ExpectedConditions.elementToBeClickable(porfile.getEnterlastname()));
		enetername.sendKeys(enetrLastName());
		
	}
	@When("Click on Save button of profile")
	public void click_on_save_button_of_profile() {
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	    WebElement click_on_SaveButton=wait.until(ExpectedConditions.elementToBeClickable(porfile.getClick_on_saveButton()));
	    click_on_SaveButton.click();
		
	}
	@Then("User should be able to view profile updated successfully")
	public void user_should_be_able_to_view_profile_updated_successfully() {
	    wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	    WebElement message=wait.until(ExpectedConditions.elementToBeClickable(porfile.getPrintMessage()));
	    String SuccessMessage=message.getText();
	    System.out.println(SuccessMessage);
		
	}

	
	
	
	

	@After
	public void failedScenarios(Scenario sc) {
		if (sc.isFailed() == true) {
			final byte[] s = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			sc.attach(s, "img/png", sc.getName());
		}
		closeAllTabs();

	}

	
	
}
