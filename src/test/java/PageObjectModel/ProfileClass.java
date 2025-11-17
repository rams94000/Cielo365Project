package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ProfileClass {
	WebDriver driverG;
	
	public ProfileClass(WebDriver driverL) {
		driverG=driverL;
		PageFactory.initElements(driverL, this);
	}
	
	private By ClickonprofileBtn=By.xpath("//p[text()='Donie Yen']");
	private By ClickonMyprofile=By.xpath("//li[@id='myProfile']");
	private By ClickOnchooseFile=By.xpath("//span[text()='Choose File']");
	private By printsuccessmsg=By.xpath("//p[text()='Profile updated successfully. Please re-login to see changes.']");
	
	public By getPrintsuccessmsg() {
		return printsuccessmsg;
	}
	public By getClickOnchooseFile() {
		return ClickOnchooseFile;
	}
	public By getClickonMyprofile() {
		return ClickonMyprofile;
	}
	public By getClickonprofileBtn() {
		return ClickonprofileBtn;
	}
	
}
