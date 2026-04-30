package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Profile {
	WebDriver driverG;
	
	public Profile(WebDriver driverL) {
		driverG=driverL;
		PageFactory.initElements(driverL, this);
	}
	
	private By Click_on_profile=By.xpath("//p[normalize-space()='Donie Yen']");
    private By Click_on_MyProfile=By.xpath("//li[text()='My Profile']")	;
    private By Click_on_saveButton=By.xpath("//button[@type='submit' and text()='Save']");
    private By Enterlastname=By.name("lastName");
    private By printMessage=By.xpath("//p[text()='Profile updated successfully. Please re-login to see changes.']");
    
	
	
	
	
	
	
	public By getPrintMessage() {
		return printMessage;
	}

	public By getEnterlastname() {
		return Enterlastname;
	}

	public By getClick_on_saveButton() {
		return Click_on_saveButton;
	}

	public By getClick_on_MyProfile() {
		return Click_on_MyProfile;
	}
	
	public By getClick_on_profile() {
		return Click_on_profile;
	}
	
}
