package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SiteClass {
	WebDriver driverG;
	
	public SiteClass(WebDriver driverL) {
		driverG=driverL;
		PageFactory.initElements(driverL, this);	
	}
	
	private By ClickOnSite_Btn=By.xpath("(//span[text()='Sites'])[1]");
	private By ClickOnAllsite_submodule=By.xpath("//span[text()='All Sites']");
	private By ClickOnAdd_Btn=By.xpath("//button[@id='iconAdd' and @permission='site_add']");
	private By EnterName=By.name("name");
	private By EnterAddresslin1=By.name("addressLine1");
	private By EnterState=By.id("state");
	private By EnterCity=By.id("city");
	private By ClickOnTime_zone=By.id("timeZone");
	private By selectElement=By.xpath("//ul[@role='listbox']/child::li");
	private By ClickOnAddBtn=By.xpath("//button[text()='Add']");
	private By printsuccessMsg=By.xpath("//p[text()='Site created successfully']");
	
	

	public By getPrintsuccessMsg() {
		return printsuccessMsg;
	}
	
	public By getClickOnAddBtn() {
		return ClickOnAddBtn;
	}


    public By getSelectElement() {
		return selectElement;
	}

	public By getClickOnTime_zone() {
		return ClickOnTime_zone;
	}

	public By getEnterCity() {
		return EnterCity;
	}

	public By getEnterState() {
		return EnterState;
	}

	public By getEnterAddresslin1() {
		return EnterAddresslin1;
	}

	public By getEnterName() {
		return EnterName;
	}

	public By getClickOnAdd_Btn() {
		return ClickOnAdd_Btn;
	}

	public By getClickOnAllsite_submodule() {
		return ClickOnAllsite_submodule;
	}

	public By getClickOnSite_Btn() {
		return ClickOnSite_Btn;
	}
	
	}

