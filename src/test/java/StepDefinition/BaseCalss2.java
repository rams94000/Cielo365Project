package StepDefinition;

import java.util.Properties;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import PageObjectModel.DepartmentClass;
import PageObjectModel.PositionClass;
import PageObjectModel.SignInClass;

public class BaseCalss2 {
	public WebDriver driver;
	public SignInClass sign;
	public Properties pro;
	public DepartmentClass department;
	public PositionClass position;
	
	public String enterId() {
		return RandomStringUtils.randomNumeric(3);
	}
	public String enterFirstName() {
		return RandomStringUtils.randomAlphabetic(4);
	}
	public String enetrLastName() {
		return RandomStringUtils.randomAlphabetic(3);
	}
	public String enterEmail() {
		return RandomStringUtils.randomAlphanumeric(3)+"@gmail.com";
	}
}
