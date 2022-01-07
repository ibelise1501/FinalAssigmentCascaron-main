package goheavy.driver;

import goheavy.documents.DocumentStep;
import goheavy.driver.pages.DriverListPage;
import goheavy.driver.pages.DriverPage;
import goheavy.vehicles.VehicleStep;
import goheavy.vehicles.VehicleStepDefinition;
import io.cucumber.java.en.*;
import general.*;

@SuppressWarnings("unused")
public class DriverStepDefinition {
	private GeneralSteps generalSteps;
	private DriverStep driverSteps;
	private DriverListPage driverListPage;
	private DriverPage driverPage;
	private DocumentStep documentStep;
	private VehicleStep vehicleStep;
	private VehicleStepDefinition vehicleStepDefinition;
	private String cell;

	public DriverStepDefinition() {
		generalSteps = new GeneralSteps();
		driverSteps = new DriverStep();
		driverListPage = new DriverListPage();
		driverPage = new DriverPage();
		documentStep = new DocumentStep();
		vehicleStepDefinition = new VehicleStepDefinition();
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

	@When("The user inserts a valid data")
	public void the_user_inserts_a_valid_data() {
		cell = driverSteps.insertValidData_ClicksAdd();
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

	//Metodos relacionados con la activacion del driver
	@Given("A new \"Driver\" is created.")
	public void aNewDriverIsCreated() {
		user_clicks_on_Add_Driver_button();
		the_user_inserts_a_valid_data();
		user_clicks_on_the_Add_button();
		the_system_displays_message();
		//system_returns_to_the_Drivers_List_view();
	}

	@And("A new Vehicle is associated to the Driver.")
	public void aNewVehicleIsAssociatedToTheDriver() {
		driverSteps.searchDriver(cell);
		driverSteps.clickOnVehiclesIcon(cell);
		vehicleStepDefinition.the_user_clicks_on_add_vehicle_button();
		vehicleStepDefinition.the_user_inserts_valid_data_and_clicks_done_button();
		//Faltaria validar que el nombre del driver aparezca listado como asociado a nuevo vehiculo

	}

	@And("The Documents are approved.")
	public void theDocumentsAreApproved() {
		driverSteps.goToDriverList();
		driverSteps.clickOnDocs(cell);
		documentStep.ApproveDocs();
	}

	@And("The User updates the Driver's status to {string}.")
	public void theUserUpdatesTheDriverSStatusTo() {
		driverSteps.goToDriverList();
		driverSteps.searchDriver(cell);
		driverSteps.updateStatusTo_GoHeavyReady();

	}

	@Then("The Driver is active.")
	public void theDriverIsActive() {
		driverSteps.checkDriverStatus(cell);
	}
}