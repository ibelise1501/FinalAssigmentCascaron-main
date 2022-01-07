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





}
