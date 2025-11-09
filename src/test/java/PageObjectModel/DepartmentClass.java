package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import StepDefinition.AllSteps;
import io.cucumber.java.en.*;

public class DepartmentClass {
	
	
 WebDriver driverG;
	
	public DepartmentClass(WebDriver driverL) {
		driverG=driverL;
		PageFactory.initElements(driverL, this);
	}
	
	private By Click_Departmentsubmodule=By.xpath("//div[@permission='department_list']/child::div[@class='sidenav---navtext---1AE_f']/child::span[text()='Departments']");
    private By Click_CreateIcon_btnOf_Dep=By.xpath("//button[@type='button']/child::span[@class='MuiIconButton-label']/*[@height='40']");
    private By EnterName=By.id("deptName");
    private By EnterCode=By.id("deptCode");
    private By ClickOn_AddBtnOfDep=By.xpath("//button[text()='Add']");
    private By PrintSuccessMessageOf_Dep=By.xpath("//p[text()='Department created successfully']");
	private By ClickOnImport_Btn=By.xpath("(//*[local-name()='svg' and @ height='20']/parent::span[@class='MuiIconButton-label'])[2]");
	private By ClickTo_SelectFile=By.xpath("//div[@class='MuiBox-root css-b1m6vs']//span[1]");
    private By ClickOn_ImportBtn=By.xpath("//button[text()='Import']");
    private By printFialedLine=By.xpath("(//p[text()='Failed on Line'])[1]");
    private By printSuccessmsg=By.xpath("(//p[text()='Success Count'])[1]");
    private By printErrormsg=By.xpath("(//p[text()='Error Count'])[1]");
    private By ClickOn_closeBtn=By.xpath("//button[text()='Close']");
    private By ClickOn_CloseBtnOfImportDep=By.xpath("(//*[local-name()='svg' and @data-testid='CloseIcon'])[2]");
    private By ClickOn_EditBtn=By.xpath("(//button[@type='button']/child::*[@width='20'])[1]");
    private By ClickOnSaveBtnOfDep=By.xpath("//button[text()='Save']");
    private By printUpdatemsg=By.xpath("//p[text()='Department updated successfully']");
    private By ClickOn_deleteBtn=By.xpath("(//button[@type='button']/child::*[@width='20'])[2]");
    private By ClickOn_YesBtn=By.xpath("//button[text()='Delete']");
    private By printDeleteSuccessMsg=By.xpath("//p[text()='Department has been successfully deleted.']");
    
	public By getPrintDeleteSuccessMsg() {
		return printDeleteSuccessMsg;
	}
	public By getClickOn_YesBtn() {
		return ClickOn_YesBtn;
	}
	public By getClickOn_deleteBtn() {
		return ClickOn_deleteBtn;
	}
	public By getPrintUpdatemsg() {
		return printUpdatemsg;
	}
	public By getClickOnSaveBtnOfDep() {
		return ClickOnSaveBtnOfDep;
	}
	public By getClickOn_EditBtn() {
		return ClickOn_EditBtn;
	}
	public By getClickOn_CloseBtnOfImportDep() {
		return ClickOn_CloseBtnOfImportDep;
	}
	public By getClickOn_closeBtn() {
		return ClickOn_closeBtn;
	}
	public By getPrintErrormsg() {
		return printErrormsg;
	}
	public By getPrintSuccessmsg() {
		return printSuccessmsg;
	}
	public By getPrintFialedLine() {
		return printFialedLine;
	}
	public By getClickOn_ImportBtn() {
		return ClickOn_ImportBtn;
	}
	public By getClickTo_SelectFile() {
		return ClickTo_SelectFile;
	}
	public By getClickOnImport_Btn() {
		return ClickOnImport_Btn;
	}
	public By getPrintSuccessMessageOf_Dep() {
		return PrintSuccessMessageOf_Dep;
	}
	public By getClickOn_AddBtnOfDep() {
		return ClickOn_AddBtnOfDep;
	}
	public By getEnterCode() {
		return EnterCode;
	}
	public By getEnterName() {
		return EnterName;
	}
	public By getClick_CreateIcon_btnOf_Dep() {
		return Click_CreateIcon_btnOf_Dep;
	}
	public By getClick_Departmentsubmodule() {
		return Click_Departmentsubmodule;
	}
	
}
