package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PositionClass {
	WebDriver driverG;
	
	public PositionClass(WebDriver driverl) {
		driverG=driverl;
		PageFactory.initElements(driverl, this);
	}
	
	private By ClickOnPostionsubmodule=By.xpath("//span[text()='Positions']");
	private By ClickOnCreateIconButton=By.xpath("//button[@id='iconAdd']");
	private By EnterPostionData=By.id("deptName");
	private By EnterCode=By.id("deptCode");
	private By ClickOnAddBtn=By.xpath("//button[text()='Add']");
	private By PrintSuccessMsgOfPosition=By.xpath("//p[text()='Position created successfully.']");
	private By ClickonDeletebutton=By.xpath("(//button[@aria-label='Delete']/child::*[@height='20'])[1]");
	private By ClickOnDeleteBtn=By.id("deleteText");
	private By PrintSeccessMesgOfDelete=By.xpath("//p[text()='Position has been successfully deleted']");
	

	public By getPrintSeccessMesgOfDelete() {
		return PrintSeccessMesgOfDelete;
	}
	public By getClickOnDeleteBtn() {
		return ClickOnDeleteBtn;
	}
	public By getClickonDeletebutton() {
		return ClickonDeletebutton;
	}
	public By getPrintSuccessMsgOfPosition() {
		return PrintSuccessMsgOfPosition;
	}
	public By getClickOnAddBtn() {
		return ClickOnAddBtn;
	}
	public By getEnterCode() {
		return EnterCode;
	}
	public By getEnterPostionData() {
		return EnterPostionData;
	}
	public By getClickOnCreateIconButton() {
		return ClickOnCreateIconButton;
	}
	public By getClickOnPostionsubmodule() {
		return ClickOnPostionsubmodule;
	}
	
	
	
}
