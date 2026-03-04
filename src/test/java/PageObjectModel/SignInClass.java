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
	private By print_error_msg_of_invalid_username=By.xpath("//p[normalize-space()='Invalid credentials']");
	private By print_error_msg_of_valid_password=By.xpath("//p[normalize-space()='Invalid credentials']");
	
	

	
	public By getPrint_error_msg_of_valid_password() {
		return print_error_msg_of_valid_password;
	}
	public By getPrint_error_msg_of_invalid_username() {
		return print_error_msg_of_invalid_username;
	}
	public By getClick_Enter_button() {
		return Click_Enter_button;
	}
	public By getEnter_username() {
		return Enter_username;
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
