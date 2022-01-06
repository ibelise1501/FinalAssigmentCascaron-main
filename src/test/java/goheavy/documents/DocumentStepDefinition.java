package goheavy.documents;

import general.Setup;
import goheavy.driver.DriverStep;
import goheavy.vehicles.VehicleStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class DocumentStepDefinition {
    private DocumentStep docStep;
    private DriverStep driverStep;
    private VehicleStep vehicleStep;

    public DocumentStepDefinition(){
        this.docStep=new DocumentStep();
    }

    @And("The user is in main {string} view")
    public String theUserIsInView(String view) {
        try {
            if (view.equals("Vehicles & Insurance List")){
                return "Vehicles & Insurance List";
            } else if(view.equals("Drivers List")) {
                return "Drivers List";
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return view;
    }

    @When("User clicks on the \"Documents\" icon")
    public void user_clicks_on_the_icon() {
        //TODO - validar la vista en la que se encuentra

    }

    @And("The system displays the Documents {string} view.")
    public void theSystemDisplaysTheDocumentsView(String view) {
        docStep.checkPage(view);
    }

    @When("User clicks on \"View\" icon.")
    public void user_clicks_on_icon(String string) {
        docStep.clickOnElement();
    }

    @And("The system displays the Modal {string} view.")
    public void theSystemDisplaysTheModalView(String view) {
        docStep.checkTheModalView(view);
    }

    @When("The User clicks on the \"Approve\" button.")
    public void the_user_clicks_on_the_Approve_button(String string) {
        docStep.ApproveDriverDocs();
    }

    @Then("The system changes the Driver / Vehicle document status to \"Clear\"")
    public void theSystemChangesTheDriverSVehicleSDocumentStatusTo() {
        docStep.checkStatus();
    }





}
