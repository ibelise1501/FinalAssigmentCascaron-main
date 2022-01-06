package goheavy.vehicles;

import goheavy.documents.DocumentStep;
import javafx.scene.control.TabPane;
import org.junit.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import general.Setup;
import general.Steps;
import goheavy.driver.pages.DriverPage;
import goheavy.vehicles.page.*;

import java.io.File;

@SuppressWarnings("unused")
public class VehicleStep extends Steps {
    public VehiclePage vehiclePage;
    public VehiculeInfoPage vehicleInfo;
    public VehiculeFeaturesPage vehicleFeture;
    public DrivingRequirementsPage drivingRequirements;
    private TabsPage tp;
    String VINID;
    private DocumentStep documentStep;

    public VehicleStep() {
        vehiclePage = new VehiclePage();
        vehicleInfo = new VehiculeInfoPage();
        vehicleFeture = new VehiculeFeaturesPage();
        drivingRequirements = new DrivingRequirementsPage();
        documentStep = new DocumentStep();

    }

    public void checkPage() {
        String path = vehiclePage.getPagePath().toLowerCase();
        Assert.assertTrue(" The path provided is not correct in the url. path: " + path,
                vehiclePage.getCurrentUrl().toLowerCase().contains(path));
    }

    public void goToAccountSettingsView() {
        try {
            Setup.getWait().thread(2500);
            Assert.assertTrue(vehiclePage.goToVehiclesAndInsuranceListView());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    public void userClicksOnAddVehicleButton() {
        try {
            Assert.assertTrue(vehiclePage.clickOnAddVehicleButton());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    public void theSystemOpensTheAddVehicleView() {
        try {
            Assert.assertTrue(vehiclePage.systemOpensAddVehicleView());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    public void hoverOverImageComponent() {
        try {
            Assert.assertTrue(vehiclePage.hoverOverImageComponent());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    public String userInsertsValidDataAndClicksDone() {

        try {
            TabsPage tp = new VehiculeInfoPage();
            tp.insertValidData();
            VINID = vehicleInfo.getVINInputID();
            tp = new VehiculeFeaturesPage();
            tp.insertValidData();
            tp = new DrivingRequirementsPage();
            tp.insertValidData();
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }

        return VINID;
    }

    public void systemCreatesVehicleOnStatus(String status) {
        try {
            Assert.assertNotNull(vehiclePage.systemCreatesVehicleOnStatus(status));
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    public void systemRegistersCreationDate() {
        try {
            Assert.assertNotNull(vehiclePage.systemsRegistersCreationDate());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    public void returnToMainView() {
        checkPage();
    }

    public void systemDisplaysAssignView() {
        try {
            Assert.assertTrue(vehiclePage.systemDisplaysAssignView());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    public void userAssignsTheVehicle() {
        try {
            Assert.assertTrue(vehiclePage.userAssignsTheVehicle());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    public void clicks_button_done() {

        vehiclePage.clicks_button_done();
    }

    public void systemDisplaysMessage( String message) {
        vehiclePage.systemDisplaysMessage(message);
    }

    public void systemDisplaysMessage2( File file, String message, String fileInputButton, String nextBtn) {
        vehiclePage.systemDisplaysMessage_FailedUploadFiles(file);
    }
    public void uploadFile(){
       vehicleInfo.CheckUploadImageComponent(vehicleInfo.getUploadInputButton(), vehicleInfo.getNextBtn());
    }

    public void approveVehicleDocs(String VINID){
        vehiclePage.searchVehicle(VINID);
        vehiclePage.clickOnDocuments();
        documentStep.ApproveVehicleDocs();

    }

    public void associateDriver(String VINID, String driver){
        vehiclePage.assignVehicle(VINID, driver);
    }


}
