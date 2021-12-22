package goheavy.driver;

import goheavy.driver.pages.DriverListPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import general.PageObject;
import general.Setup;
import general.Steps;
import goheavy.driver.pages.DriverPage;

import java.util.Set;

@SuppressWarnings("unused")
public class DriverStep extends Steps{
	private DriverPage driverPage;
	private DriverListPage driverListPage;


	public DriverStep() {

		driverPage = new DriverPage();
		driverListPage = new DriverListPage();
	}

	public void checkPage() {
		String path = "//span[text()='Add Driver']";
		Assert.assertEquals(Setup.getDriver().findElement(By.xpath(path)).getText(), "Add Driver");
	}

	public void goToView() {
		Assert.assertTrue(driverPage.goToView());
	}

	public void userClicksOnAddDriverButton() {
		try {
			driverListPage.userClicksOnAddDriverButton();
			Setup.getWait().thread(5000);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void theSystemReturnsToDriverListView() {
		try {
			Assert.assertTrue(driverListPage.SystemReturnsToDriverListView());
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void insertValidData_ClicksAdd(){
		Setup.getWait().thread(5000);
		driverPage.insertValidData();
	}

	public void clickOnAddBtn(){

		driverPage.clicks_button_done();
	}

	public void systemDisplaysMessage(){
		driverListPage.systemDisplaysMessage();
	}

}
