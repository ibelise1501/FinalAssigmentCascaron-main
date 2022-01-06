package goheavy.driver;

import goheavy.documents.DocumentStep;
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
	private DocumentStep documentStep;
	private String cell;

	public DriverStepDefinition() {
		generalSteps = new GeneralSteps();
		driverSteps = new DriverStep();
		driverListPage = new DriverListPage();
		driverPage = new DriverPage();
		documentStep = new DocumentStep();
	}

	//Metodos relacionados con el feature Add Driver
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

	@Then("The System Creates a new Driver in \"On-boarding\" status.")
	public void the_system_creates_a_new_driver_in_status() {
		driverSteps.checkStatus();
	}

	//Metodos relacionados con el feature Edit Driver

	@When("User clicks on the \"Edit\" icon.")
	public void user_clicks_on_the_Edit_icon() {
		driverSteps.clickOnEditBtn();
	}

	@When("The System displays the \"Edit Driver\" view with the data preloaded.")
	public void the_system_displays_the_Edit_Driver_view_with_the_data_preloaded() {
		driverSteps.checkEditDriverview();
	}

	@When("The User set the Status to \"GoHeavy Ready\".")
	public void the_user_set_the_status_to_GoHeavy_Ready() {
		driverSteps.updateStatusTo_GoHeavyReady();
	}

	@And("The User clicks on the \"Update\" button.")
	public void theUserClicksOnTheUpdateButton() {
		driverSteps.theUserClicksOnTheUpdateButton();
	}

	@And("The system updates the status to \"GoHeavy Ready\".")
	public void theSystemUpdatesTheStatusToGoHeavyReady() {
		driverSteps.checkStatus();
	}

	//Metodo general para crear un driver
	@Given("A new \"Driver\" is created.")
	public void aNewDriverIsCreated() {
		 cell = driverSteps.insertValidData_ClicksAdd();
	}

	@Given("The Driver's documents are Approved.")
	public void the_driver_s_documents_are_approved() {
		driverSteps.clickOnDocs(cell);
		documentStep.ApproveDriverDocs();
	}

	@When("The User updates the Driver's status to \"GoHeavy Ready\".")
	public void theUserUpdatesTheDriverSStatusTo() {
		//TODO
	}

	@Then("The Driver is active.")
	public void theDriverIsActive() {
		//TODO
	}
}