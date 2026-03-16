package StepDefinition;

import java.util.HashSet;
import java.util.Properties;
import java.util.Set;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import PageObjectModel.Cardholder;
import PageObjectModel.SignInClass;
public class BaseCalss2 {
	public WebDriver driver;
	public SignInClass sign;
	public Cardholder card;
	public Properties pro;

	
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
	public String enterAddressline1() {
		return RandomStringUtils.randomAlphabetic(4);
	}
	
	
	
	
	
	public void closeAllTabs() {
		try {
			Set<String>window=new HashSet<>(driver.getWindowHandles());
			for(String handle:window) {
				driver.switchTo().window(handle);
				driver.close();
			}
		}
		finally {
			driver.quit();
		}
	}
	
	
	
}
