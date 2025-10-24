package StepDefinition;

import static org.junit.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import PageObjectModel.DepartmentClass;
import PageObjectModel.SignInClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;

public class AllSteps extends BaseCalss2 {
	WebDriverWait wait;
	
	@Before
	public void setUp() throws IOException {
	FileInputStream fs=new FileInputStream("C:\\Users\\rams9\\eclipse-workspace\\Cielo365Project\\Property.properties");
	pro=new Properties();
	pro.load(fs);
	String browser=pro.getProperty("browser");
	switch(browser.toLowerCase()) {
	case "chrome":
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		break;
		
	case "firefox":
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		break;
		
	case "msedge":
		driver=new EdgeDriver();
		driver.manage().window().maximize();
		break;
		
		default:
			driver=null;
			break;
	}
	}
	@Given("Enter the URL")
	public void enter_the_url() {
		
		driver.get(pro.getProperty("url"));
		sign=new SignInClass(driver);
		department=new DepartmentClass(driver);
	    
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
		wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".loader-container")));		
	    driver.findElement(sign.getClick_dropdown()).click();
	    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".loader-container")));
	    driver.findElement(sign.getSelect_dropdown()).click();	
	}
	@When("Click on Enter button")
	public void click_on_enter_button() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
	    driver.findElement(sign.getClick_Enter_button()).click();
	}
	@Then("User should be able to view dashboard page")
	public void user_should_be_able_to_view_dashboard_page() throws InterruptedException {
		Thread.sleep(4000);
	    String title=driver.getTitle();
	    System.out.println(title);
	}
	@Given("Click on cardholder module")
	public void click_on_cardholder_module() throws InterruptedException {
		wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".loader-container")));	;
	    WebElement click=wait.until(ExpectedConditions.elementToBeClickable(sign.getClick_CardholderModule()));
	    click.click();   
	}
	@Given("Click on cardholder submodule")
	public void click_on_cardholder_submodule() throws InterruptedException {
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".loader-container")));
		driver.findElement(sign.getClick_CarholderSubmodule()).click();	
	}
	@Then("User should be able to view all records of cardholders on console")
	public void user_should_be_able_to_view_all_records_of_cardholders_on_console() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement grid = driver.findElement(By.cssSelector("div.MuiDataGrid-virtualScroller"));
		Set<String> uniqueRows = new LinkedHashSet<>();
		while (true) { 
		    long lastScrollTop = -1;
		    int sameScrollCount = 0;
		    while (true) {
		        List<WebElement> rows = driver.findElements(By.cssSelector("div[role='row'][data-rowindex]"));
		        for (WebElement row : rows) {
		            uniqueRows.add(row.getText().trim());
		        }
		        js.executeScript("arguments[0].scrollTop = arguments[0].scrollTop + 600;", grid);
		        Thread.sleep(1200);
		        long currentScrollTop = ((Number) js.executeScript("return arguments[0].scrollTop;", grid)).longValue();
		        long scrollHeight = ((Number) js.executeScript("return arguments[0].scrollHeight;", grid)).longValue();
		        long clientHeight = ((Number) js.executeScript("return arguments[0].clientHeight;", grid)).longValue();
		        if (currentScrollTop == lastScrollTop) {
		            sameScrollCount++;
		        } else {
		            sameScrollCount = 0;
		        }
		        if (currentScrollTop + clientHeight >= scrollHeight || sameScrollCount >= 3) {
		            break;
		        }
		        lastScrollTop = currentScrollTop;
		    }
		    List<WebElement> finalRows = driver.findElements(By.cssSelector("div[role='row'][data-rowindex]"));
		    for (WebElement row : finalRows) {
		        uniqueRows.add(row.getText().trim());
		    }
		    try {
		        WebElement nextButton = driver.findElement(By.cssSelector("button[aria-label='Go to next page']"));
		        if (nextButton.isEnabled()) {
		            nextButton.click();
		            Thread.sleep(2000);
		            grid = driver.findElement(By.cssSelector("div.MuiDataGrid-virtualScroller"));
		        } else {
		            break;
		        }
		    } catch (NoSuchElementException e) {
		        System.out.println("No next page button found — reached last page.");
		        break;
		    }
		}
		System.out.println("Total unique rows captured: " + uniqueRows.size());
		for (String rowText : uniqueRows) {
		    System.out.println(rowText);
		}	
	}
	@Given("Click on create icon button")
	public void click_on_create_icon_button() throws InterruptedException {
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".loader-container")));
		WebElement click_CreateBtn=wait.until(ExpectedConditions.visibilityOfElementLocated(sign.getClick_CreateIcon_Btn()));
		click_CreateBtn.click();	
	}
	@Given("Enter all the information of cardholders")
	public void enter_all_the_information_of_cardholders() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(sign.getEnter_Id()).sendKeys(enterId());
		driver.findElement(sign.getEnter_FirstName()).sendKeys(enterFirstName());
		driver.findElement(sign.getEnter_LastName()).sendKeys(enetrLastName());
		driver.findElement(sign.getClick_Department()).click();
		driver.findElement(sign.getSelect_Department()).click();
		driver.findElement(sign.getSelect_Btn()).click();
		driver.findElement(sign.getEnter_Email()).sendKeys(enterEmail());	
	}
	@Given("Click on Add button")
	public void click_on_add_button() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement addButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[text()='Add'])[1]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addButton);
		Thread.sleep(500);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", addButton);	
	}

	@Then("User should be able to view success message")
	public void user_should_be_able_to_view_success_message() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    WebElement print=driver.findElement(sign.getPrint_SuccessMsg());
	    String successMsg=print.getText();
	    System.out.println(successMsg);	
	}
	
	//Department submodule
	
	@Then("Click on Department submodule")
	public void click_on_department_submodule() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4000));
	    driver.findElement(department.getClick_Departmentsubmodule()).click();	
	}
	@Then("Click on Create icon button of Department")
	public void click_on_create_icon_button_of_department() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(department.getClick_CreateIcon_btnOf_Dep()).click();
	}
	@Then("Enter All the data")
	public void enter_all_the_data() {
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
	    driver.findElement(department.getEnterName()).sendKeys(enterFirstName());
	    driver.findElement(department.getEnterCode()).sendKeys(enterId());	
	}
	@Then("Click on Add button of Department")
	public void click_on_add_button_of_department() {
	    driver.findElement(department.getClickOn_AddBtnOfDep()).click();
	}
	@Then("User should be able to view success message of created department")
	public void user_should_be_able_to_view_success_message_of_created_department() {
	    WebElement sucess =driver.findElement(department.getPrintSuccessMessageOf_Dep());
	    String print_success_message=sucess.getText();
	    System.out.println(print_success_message);	
	}
	@Then("Click on Import Icon button")
	public void click_on_import_icon_button() throws InterruptedException {
	    Thread.sleep(3000);
		driver.findElement(department.getClickOnImport_Btn()).click();
	}
	@Then("Select the file from the System")
	public void select_the_file_from_the_system() throws InterruptedException, AWTException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(department.getClickTo_SelectFile()));
		element.click(); 
		
		Robot rb=new Robot();
		rb.delay(2000);
		StringSelection s=new StringSelection("C:\\Users\\rams9\\Downloads\\Department.2025-09-13 14_46_46.xlsx");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);
		
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
	}
	@Then("Click on Import button")
	public void click_on_import_button() {
	    wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.elementToBeClickable(department.getClickOn_ImportBtn())).click();
	}

	@Then("User should be able to view Succes and Error count message")
	public void user_should_be_able_to_view_succes_and_error_count_message() {
	    
	WebElement success=driver.findElement(department.getPrintFialedLine());
	String succes_msg=success.getText();
	System.out.println(succes_msg);
	
	WebElement sucessmsg=driver.findElement(department.getPrintSuccessmsg());
	String successmsg=sucessmsg.getText();
	System.out.println(successmsg);
	
	WebElement Errormsg=driver.findElement(department.getPrintErrormsg());
	String error_Msg=Errormsg.getText();
	System.out.println(error_Msg);
	
	driver.findElement(department.getClickOn_closeBtn()).click();
	driver.findElement(department.getClickOn_CloseBtnOfImportDep()).click();
		
	}
	
	@Then("Click on Edit icon button")
	public void click_on_edit_icon_button() {
	    
		driver.findElement(department.getClickOn_EditBtn()).click();
	}
	@Then("Edit the data")
	public void edit_the_data() {
	    
		driver.findElement(department.getEnterName()).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		driver.findElement(department.getEnterName()).sendKeys(enterFirstName());
		
	}
	@Then("Click on Save button")
	public void click_on_save_button() {
	    
		driver.findElement(department.getClickOnSaveBtnOfDep()).click();
		
	}
	@Then("User should be able to view success message of edit department")
	public void user_should_be_able_to_view_success_message_of_edit_department() throws InterruptedException {
	    
	wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	WebElement msg=	wait.until(ExpectedConditions.visibilityOfElementLocated(department.getPrintUpdatemsg()));
	String update=msg.getText();
	System.out.println(update);
	}

	@Then("Click on delete icon button")
	public void click_on_delete_icon_button() {
	    
		driver.findElement(department.getClickOn_deleteBtn()).click();
	}
	@Then("Click on Yes button")
	public void click_on_yes_button() {
	    driver.findElement(department.getClickOn_YesBtn()).click();
		
		
	}
	@Then("User should be able to view success message of deleted records")
	public void user_should_be_able_to_view_success_message_of_deleted_records() {
	    wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	    WebElement msg=wait.until(ExpectedConditions.visibilityOfElementLocated(department.getPrintDeleteSuccessMsg()));
	    String successDeletemsg=msg.getText();
	    System.out.println(successDeletemsg);
		
	}
	@Then("User should be able to Scroll the page and print all the records")
	public void user_should_be_able_to_scroll_the_page_and_print_all_the_records() throws InterruptedException {
	    
		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement grid = driver.findElement(By.cssSelector("div.MuiDataGrid-virtualScroller"));
		
		Set<String> uniqueRows = new LinkedHashSet<>();

		while (true) { 
		    long lastScrollTop = -1;
		    int sameScrollCount = 0;

		    while (true) {
		        List<WebElement> rows = driver.findElements(By.cssSelector("div[role='row'][data-rowindex]"));
		        for (WebElement row : rows) {
		            uniqueRows.add(row.getText().trim());
		        }

		        js.executeScript("arguments[0].scrollTop = arguments[0].scrollTop + 600;", grid);
		        Thread.sleep(1200);
		        long currentScrollTop = ((Number) js.executeScript("return arguments[0].scrollTop;", grid)).longValue();
		        long scrollHeight = ((Number) js.executeScript("return arguments[0].scrollHeight;", grid)).longValue();
		        long clientHeight = ((Number) js.executeScript("return arguments[0].clientHeight;", grid)).longValue();

		        if (currentScrollTop == lastScrollTop) {
		            sameScrollCount++;
		        } else {
		            sameScrollCount = 0;
		        }

		        if (currentScrollTop + clientHeight >= scrollHeight || sameScrollCount >= 3) {
		            break; 
		        }

		        lastScrollTop = currentScrollTop;
		    }

		    List<WebElement> finalRows = driver.findElements(By.cssSelector("div[role='row'][data-rowindex]"));
		    for (WebElement row : finalRows) {
		        uniqueRows.add(row.getText().trim());
		    }
		    
		    try {
		        WebElement nextButton = driver.findElement(By.cssSelector("button[aria-label='Go to next page']"));
		        if (nextButton.isEnabled()) {
		            nextButton.click();
		            Thread.sleep(2000);
		            grid = driver.findElement(By.cssSelector("div.MuiDataGrid-virtualScroller"));
		        } else {
		            break;
		        }
		    } catch (NoSuchElementException e) {
		        System.out.println("No next page button found — reached last page.");
		        break;
		    }
		}

		System.out.println("Total unique rows captured: " + uniqueRows.size());
		for (String rowText : uniqueRows) {
		    System.out.println(rowText);
		}
	}

	
	@After
	public void failedScenarios(Scenario sc) {
		if(sc.isFailed()==true) {
		final byte[] s=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		sc.attach(s, "img/png", sc.getName());
	}
		driver.quit();
}
}
	
	

