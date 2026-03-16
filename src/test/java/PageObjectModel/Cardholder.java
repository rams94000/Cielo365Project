package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Cardholder {
	WebDriver driverG;
	
	
  public Cardholder(WebDriver driverL) {
		driverG=driverL;
		PageFactory.initElements(driverL,this);
	}
  
 private By Click_on_cardholder_module=By.xpath("(//span[contains(text(),'Cardholders')])[1]");
 private By Click_on_cardholder_submodule=By.xpath("(//span[contains(text(),'Cardholders')])[3]");
 private By Click_on_add_icon_button=By.id("iconAdd");
 private By Enter_employee_code=By.name("employeeCode");
 private By Enter_first_name=By.name("firstName");
 private By Click_on_department_of_cardholder=By.name("departmentId");
 private By Selectdepartmentofcardholder=By.xpath("//div[text()='dev']");
 private By Click_on_submit_button_of_cardholder=By.xpath("//button[text()='Submit']");
 private By Clic_on_addbutton_of_cardholder=By.xpath("(//button[@type='submit'])[2]"); 
 private By print_Success_msg_of_createcardholder=By.xpath("//p[text()='Cardholder created. It may take a few minutes to reflect on the device.']");
 private By Enter_last_name_of_carholder=By.name("lastName");
 private By Click_on_choosefile_cardholder=By.xpath("//span[text()='Choose File']")	;
 private By print_errormsg_of_mandatoryfields_cardholder=By.xpath("//p[text()='Please enter the Cardholder ID.']");
 private By Click_on_Delete_button_of_cardholder=By.xpath("(//button[@title='Delete'])[1]");
 private By Click_on_Deletebutton_of_cardholder=By.id("deleteText");
 private By Click_on_edit_button_of_cardholder=By.xpath("(//button[@title='Edit'])[1]");
 private By Click_on_save_button_of_cardholder=By.xpath("(//button[@type='submit'])[2]");
 private By print_success_message_of_editcardholder=By.xpath("//p[text()='Cardholder updated. It may take a few minutes to update the device.']");
		
 
 
 
 
 
 public By getPrint_success_message_of_editcardholder() {
	return print_success_message_of_editcardholder;
}
public By getClick_on_save_button_of_cardholder() {
	return Click_on_save_button_of_cardholder;
}
public By getClick_on_edit_button_of_cardholder() {
	return Click_on_edit_button_of_cardholder;
}
public By getClick_on_Deletebutton_of_cardholder() {
	return Click_on_Deletebutton_of_cardholder;
}
public By getClick_on_Delete_button_of_cardholder() {
	return Click_on_Delete_button_of_cardholder;
}
public By getPrint_errormsg_of_mandatoryfields_cardholder() {
	return print_errormsg_of_mandatoryfields_cardholder;
}
public By getClick_on_choosefile_cardholder() {
	return Click_on_choosefile_cardholder;
}
public By getEnter_last_name_of_carholder() {
	return Enter_last_name_of_carholder;
}
public By getPrint_Success_msg_of_createcardholder() {
	return print_Success_msg_of_createcardholder;
}
public By getClic_on_addbutton_of_cardholder() {
	return Clic_on_addbutton_of_cardholder;
}
public By getClick_on_submit_button_of_cardholder() {
	return Click_on_submit_button_of_cardholder;
}
public By getSelectdepartmentofcardholder() {
	return Selectdepartmentofcardholder;
}
public By getClick_on_department_of_cardholder() {
	return Click_on_department_of_cardholder;
}
public By getEnter_first_name() {
	return Enter_first_name;
}
public By getEnter_employee_code() {
	return Enter_employee_code;
}
public By getClick_on_add_icon_button() {
	return Click_on_add_icon_button;
}
public By getClick_on_cardholder_submodule() {
	return Click_on_cardholder_submodule;
}
public By getClick_on_cardholder_module() {
	return Click_on_cardholder_module;
}

}
