package goheavy.driver;

import goheavy.driver.pages.DriverListPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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

	public String insertValidData_ClicksAdd(){
		Setup.getWait().thread(5000);
		String cell = driverPage.insertValidData();

		return cell;
	}

	public void goToDriverList(){
		driverListPage.clickOnDriverLink();
	}

	public void clickOnAddBtn(){

		driverPage.clicks_button_done();
	}

	public void systemDisplaysMessage(){
		driverListPage.systemDisplaysMessage();
	}

	public void updateStatusTo_GoHeavyReady() {
		driverListPage.clickOnEditBtn();
		driverPage.updateStatus();
	}

	public void checkDriverStatus(String cell){
		driverListPage.checkStatus(cell);
	}

	public void clickOnDocs(String cell){
		try {
			driverListPage.searchDriver(cell);
			Setup.getWait().thread(5000);
			driverListPage.clickOnDocuments();
		}catch (Exception e){
			System.out.println(e);
		}
	}

	public void searchDriver(String email){
		try {

			driverListPage.searchDriver(email);
		}catch (Exception e){
			System.out.println(e);
		}

	}

	public void clickOnVehiclesIcon(){
		try {
			//driverListPage.searchDriver(email);
			//Setup.getWait().thread(5000);
			driverListPage.clickOnVehiclesIcon();
		}catch (Exception e){
			System.out.println(e);
		}

	}

}
