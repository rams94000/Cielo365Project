package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Departments {
	WebDriver driverG;
	
	public Departments(WebDriver driverL) {
		driverG=driverL;
		PageFactory.initElements(driverL, this);
		
	}
	
	private By Click_on_Departments_submodule=By.xpath("//span[text()='Departments']");
	private By click_on_Departments_Addicon_button=By .id("iconAdd");
	private By Enter_Departmentname_on_departmentTextfields=By.id("deptName");
	private By Enter_Departmentcode_on_codeTextfields=By.id("deptCode");
	private By Click_on_Addicon_button_Department=By.xpath("//button[text()='Add']");
	private By Print_success_message_of_Department=By.xpath("//p[text()='Department created successfully']");
	private By Click_on_Department_edit_button=By.xpath("(//button[@aria-label='Edit' and @type='button']/child::*[@width='20'])[1]");
	private By Click_on_Department_save_button=By.xpath("//button[text()='Save']");
	private By PrintSuccessedit_message=By.xpath("//p[text()='Department updated successfully']");
	
	

	public By getPrintSuccessedit_message() {
		return PrintSuccessedit_message;
	}




	public By getClick_on_Department_save_button() {
		return Click_on_Department_save_button;
	}




	public By getClick_on_Department_edit_button() {
		return Click_on_Department_edit_button;
	}




	public By getPrint_success_message_of_Department() {
		return Print_success_message_of_Department;
	}




	public By getClick_on_Addicon_button_Department() {
		return Click_on_Addicon_button_Department;
	}




	public By getEnter_Departmentcode_on_codeTextfields() {
		return Enter_Departmentcode_on_codeTextfields;
	}




	public By getEnter_Departmentname_on_departmentTextfields() {
		return Enter_Departmentname_on_departmentTextfields;
	}




	public By getClick_on_Departments_Addicon_button() {
		return click_on_Departments_Addicon_button;
	}




	public By getClick_on_Departments_submodule() {
		return Click_on_Departments_submodule;
	}
	
	
	

}
