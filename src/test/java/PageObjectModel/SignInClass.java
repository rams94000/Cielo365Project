package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SignInClass {
	WebDriver driverG;
	
	public SignInClass(WebDriver driverL) {
		driverG=driverL;
		PageFactory.initElements(driverL, this);
	}
	
	private By Enter_username=By.id("userNameLightMode");
	private By Enter_password=By.id("passWordLightMode");
	private By Click_checkbox=By.xpath("//input[@type='checkbox']");
	private By Clik_Signin_button=By.xpath("//span[contains(normalize-space(),'Sign In')]//self::span[@class='MuiButton-label jss11']");
	private By Click_dropdown=By.xpath("//div[contains(@class,'MuiInputBase-root')]/div[@role='combobox']");
	private By select_dropdown=By.xpath("//ul[@role='listbox']/li[@role='option']/p[text()='Cielo Staging Testing India']");
	private By Click_Enter_button=By.xpath("//button[@type='submit']/descendant::span[text()='Enter']");
	private By Click_CardholderModule=By.xpath("(//span[text()='Cardholders'])[1]");
	private By Click_CarholderSubmodule=By.xpath("(//span[text()='Cardholders']/ancestor::div[@role='presentation'])[2]");
	private By PrintTbale=By.cssSelector("div.MuiDataGrid-virtualScroller");
	private By Click_CreateIcon_Btn=By.xpath("//button[@id='iconAdd' and @type='button']");
	private By Enter_Id=By.name("employeeCode");
	private By Enter_FirstName=By.name("firstName");
	private By Enter_LastName=By.name("lastName");
	private By Click_Department=By.name("departmentId");
	private By Select_Department=By.xpath("(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[1]");
	private By Select_Btn=By.xpath("//button[text()='Submit']");
	private By Enter_Email=By.name("email");
	private By Click_AddBtn=By.xpath("(//button[text()='Add'])[1]");
	private By Print_SuccessMsg=By.xpath("//p[text()='Cardholder created. It may take a few minutes to reflect on the device.']");
		
	

	public By getPrint_SuccessMsg() {
		return Print_SuccessMsg;
	}
	public By getClick_AddBtn() {
		return Click_AddBtn;
	}
	public By getEnter_Email() {
		return Enter_Email;
	}
	public By getSelect_Btn() {
		return Select_Btn;
	}
	public By getSelect_Department() {
		return Select_Department;
	}
	public By getClick_Department() {
		return Click_Department;
	}
	public By getEnter_LastName() {
		return Enter_LastName;
	}
	public By getEnter_FirstName() {
		return Enter_FirstName;
	}
	public By getEnter_Id() {
		return Enter_Id;
	}
	public By getClick_CreateIcon_Btn() {
		return Click_CreateIcon_Btn;
	}
	public By getPrintTbale() {
		return PrintTbale;
	}
	public By getClick_CarholderSubmodule() {
		return Click_CarholderSubmodule;
	}
	public By getClick_Enter_button() {
		return Click_Enter_button;
	}
	public By getEnter_username() {
		return Enter_username;
	}
	public By getClick_CardholderModule() {
		return Click_CardholderModule;
	}
	public By getEnter_password() {
		return Enter_password;
	}
	public By getSelect_dropdown() {
		return select_dropdown;
	}
	public By getClick_checkbox() {
		return Click_checkbox;
	}
	public By getClik_Signin_button() {
		return Clik_Signin_button;
	}
	public By getClick_dropdown() {
		return Click_dropdown;
	}	

}
