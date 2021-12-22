package goheavy.driver;

import goheavy.driver.pages.DriverListPage;
import goheavy.driver.pages.DriverPage;
import io.cucumber.java.en.*;
import general.*;

@SuppressWarnings("unused")
public class DriverStepDefinition {
	private GeneralSteps generalSteps;
	private DriverStep driverSteps;
	private DriverListPage driverListPage;
	private DriverPage driverPage;

	public DriverStepDefinition() {
		generalSteps = new GeneralSteps();
		driverSteps = new DriverStep();
		driverListPage = new DriverListPage();
		driverPage = new DriverPage();
	}


	@When("User clicks on \"Add Driver\" button.")
	public void user_clicks_on_Add_Driver_button() {
		try {
			driverSteps.userClicksOnAddDriverButton();

		}catch (Exception e){
			System.out.println(e.getMessage());
		}
	}
	@Given("The system opens the \"Add Driver\" view.")
	public void the_system_opens_the_add_driver_view() {
		try {
			driverSteps.userClicksOnAddDriverButton();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@When("The user inserts a valid data")
	public void the_user_inserts_a_valid_data() {
		driverSteps.insertValidData_ClicksAdd();
	}
	@When("User clicks on the Add button.")
	public void user_clicks_on_the_Add_button() {
		driverSteps.clickOnAddBtn();
	}

	@Then("The System displays message \"A new Driver was successfully created.\"")
	public void the_system_displays_message() {
		driverSteps.systemDisplaysMessage();
	}
	@Then("System returns to the \"Drivers List\" view")
	public void system_returns_to_the_Drivers_List_view() {
		driverSteps.theSystemReturnsToDriverListView();

	}

	@Then("The System Creates a new Driver in {string} status.")
	public void the_system_creates_a_new_driver_in_status(String string) {

	}
	@Then("The default rating is {int} points")
	public void the_default_rating_is_points(Integer int1) {

	}
	@Then("System registers the creation date.")
	public void system_registers_the_creation_date() {

	}
	@Then("The System sends from the Support account an email notifying the driver creation")
	public void the_system_sends_from_the_support_account_an_email_notifying_the_driver_creation() {

	}
	}