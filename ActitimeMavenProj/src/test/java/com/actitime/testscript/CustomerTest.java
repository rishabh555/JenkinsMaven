package com.actitime.testscript;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;
import com.actitime.generics.BaseClass;
import com.actitime.repository.HomePage;
import com.actitime.repository.TaskListPage;

public class CustomerTest extends BaseClass{
	/**
	 * @throws IOException
	 * @throws InvalidFormatException 
	 * @throws EncryptedDocumentException 
	 *
	 */
	@Test
	public void testCreateCustomer() throws IOException, EncryptedDocumentException, InvalidFormatException {
		String CustomerName = f.getExcelValue("Create Customer", 1, 0);
		String CustomerDes = f.getExcelValue("Create Customer", 1, 1);
		HomePage h=new HomePage(driver);
		//click on Task menu
		h.getTaskMenu().click();
		//click on Add new button
		TaskListPage tl=new TaskListPage(driver);
		//click on add new button
		tl.getAddNewBtn().click();
		//click on new customer menu
		tl.getNewCustomerMenu().click();
		//Enter the customername
		tl.getEnterCustomerNameTBX().sendKeys(CustomerName);
		//enter the customer description
		tl.getEnterCustomerDescriptionTBX().sendKeys(CustomerDes);
		//click on select customer drop down
		tl.getSelectCustomerDropDown().click();
		//select our company in the menu
		tl.getOurCompanyText().click();
		//click on create customer
		tl.getCreateCustomerPopUpBtn().click();

	}
}