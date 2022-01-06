package goheavy.vehicles;

import io.cucumber.java.en.*;
import general.GeneralSteps;

public class VehicleStepDefinition {
    private VehicleStep vehicleStep;
    @SuppressWarnings("unused")
    private GeneralSteps generalSteps;
    private String VIN;

    public VehicleStepDefinition() {
        vehicleStep = new VehicleStep();
        generalSteps = new GeneralSteps();
    }
    @When("User clicks on the \"Done\" button.")
    public void clicks_button() {
        vehicleStep.clicks_button_done();
    }

    //Improve this to meet the other NF requirement
    @Then("The System Creates a new Vehicle in {string} status.")
    public void the_system_creates_vahicle_and_registers_date(String status) {
        try {
            vehicleStep.systemCreatesVehicleOnStatus(status);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @And("The System registers the creation date.")
    public void the_system_registers_the_creation_date() {
        try {
            vehicleStep.systemRegistersCreationDate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Then("System returns to the \"Vehicles & Insurance List\" view")
    public void returns_to_view() {
        vehicleStep.returnToMainView();
    }

    @Then("System displays message \"A new Driver was successfully created.\"")
    public void system_displays_message(String message) {
        vehicleStep.systemDisplaysMessage(message);
    }

    @Then("The system displays \"Assign Vehicle\" view.")
    public void system_dsiplays_assign_view() {
        try {
            vehicleStep.systemDisplaysAssignView();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @When("User assigns the vehicle.")
    public void user_assigns_the_vehicle() {
        try {
            vehicleStep.userAssignsTheVehicle();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @And("A new \"Vehicle\" is created.")
    public void aNewIsCreated() {
         VIN = vehicleStep.userInsertsValidDataAndClicksDone();
    }

    @And("The Vehicle's documents are Approved.")
    public void vehicleDocumentsAreApproved(){
        vehicleStep.approveVehicleDocs(VIN);
    }

    @And("The Vehicle has a Driver associated.")
    public void theVehicleHasADriverAssociated() {
        vehicleStep.associateDriver(String driver, String VIN);
    }
}
