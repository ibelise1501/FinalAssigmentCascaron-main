package goheavy.vehicles.page;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import com.sun.org.apache.bcel.internal.generic.SWITCH;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import general.PageObject;
import general.Setup;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

@SuppressWarnings("unused")
public class VehiclePage extends PageObject {
    private String vehiclesLiXpath;
    private String addVehicleButtonXpath;
    private String addVehicleTitleXpath;
    private String carIconXpath;
    private String stepBaseXpath;
    private String VINImageUploadItemXpath;
    private String VINInputXpath;
    private String vehicleTypeXpath;
    private String vehicleMakeXpath;
    private String vehicleYearMakepath;
    private String vehicleCapacitySubSectionXpath;
    private String vehicleInsuranceImageXpath = "//label[@class='ant-form-item-required' and "
            + "@title='Current Insurance Certificate Picture']/ancestor::div[@class='ant-row ant-form-item']/descendant::input"
            + "[@type='file']";
    By check = By.xpath("//span[@role='img' and @aria-label='check']/" +
            "ancestor::div[@class='ant-steps-item-container']/descendant::div[@class='ant-steps-item-title']");
    private String nextBtn;
    private String fileInputButton;

    public VehiclePage() {
        super();
        setVehiclesLiXpath("//span[text()='Vehicles']/ancestor::li[contains(@class, 'ant-menu-item')]");
        setAddVehicleButtonXpath("//span[text()='Add Vehicle']/ancestor::button[@type='button' and "
                + "@class='ant-btn ant-btn-primary']");
        setAddVehicleTitleXpath("//span[@role='img'and @aria-label='car' and "
                + "@class='anticon anticon-car']/ancestor::div[contains(@class, "
                + "'ant-col')]/descendant::span[text()='Add Vehicle']");
        setCarIconXpath("//span[text()='Add Vehicle']/span[@role='img' and @class='anticon anticon-car']");
        setStepBaseXpath("//div[@class='ant-steps-item-container']");

        //Xpath Click to Upload input
        setVINImageUploadItemXpath("//label[@class='ant-form-item-required' and @title='VIN Image']/"
                + "ancestor::div[@class='ant-row ant-form-item']/descendant::input[@type='file']");


        setVINInputXpath("//label[@title='Vehicle ID No. (VIN)' and text()='Vehicle ID No. (VIN)']/" +
                "ancestor::div[contains(@class,'ant-form-item')]/" +
                "descendant::input[@placeholder='XXXXXXXXXXXXXXXXX' and @maxlength='17']");
        setVehicleTypeXpath("//input[@id='vehicleTypeId' and @role='combobox']");
        setVehicleMakeXpath("//input[@placeholder='Enter Vehicle make' and @id='make']");
        setVehicleYearMakepath("//input[@placeholder='Enter Vehicle year']/ancestor::div[@class='ant-picker-input']");
        setVehicleCapacitySubSectionXpath("//span[@class='ant-divider-inner-text' and text()='Vehicle Capacity']");
        setNextBtn("//button[@type='submit']");
        this.urlpath = "/vehicleinsurance";
    }

    public String getNextBtn() {
        return nextBtn;
    }

    public String getfileInputButton() {
        return fileInputButton;
    }

    public void setNextBtn(String nextBtn) {
        this.nextBtn = nextBtn;
    }

    public WebElement getCheckText() {
        return getWebElement(check);
    }

    private String getVehicleCapacitySubSectionXpath() {
        return vehicleCapacitySubSectionXpath;
    }

    private void setVehicleCapacitySubSectionXpath(String vehicleSubSectionXpath) {
        this.vehicleCapacitySubSectionXpath = vehicleSubSectionXpath;
    }

    private String getVehicleYearMakepath() {
        return vehicleYearMakepath;
    }

    private void setVehicleYearMakepath(String vehicleYearMakepath) {
        this.vehicleYearMakepath = vehicleYearMakepath;
    }

    private String getVehicleMakeXpath() {
        return vehicleMakeXpath;
    }

    private void setVehicleMakeXpath(String vehicleMakeXpath) {
        this.vehicleMakeXpath = vehicleMakeXpath;
    }

    private String getVehicleTypeXpath() {
        return vehicleTypeXpath;
    }

    private void setVehicleTypeXpath(String vehicleTypeXpath) {
        this.vehicleTypeXpath = vehicleTypeXpath;
    }

    private String getVINInputXpath() {
        return VINInputXpath;
    }

    private void setVINInputXpath(String vINInputXpath) {
        VINInputXpath = vINInputXpath;
    }

    private String getVINImageUploadItemXpath() {
        return VINImageUploadItemXpath;
    }

    private void setVINImageUploadItemXpath(String vINImageUploadItemXpath) {
        VINImageUploadItemXpath = vINImageUploadItemXpath;
    }

    private String getStepBaseXpath() {
        return stepBaseXpath;
    }

    private void setStepBaseXpath(String stepBaseXpath) {
        this.stepBaseXpath = stepBaseXpath;
    }

    private String getCarIconXpath() {
        return carIconXpath;
    }

    private void setCarIconXpath(String carIconXpath) {
        this.carIconXpath = carIconXpath;
    }

    private String getAddVehicleTitleXpath() {
        return addVehicleTitleXpath;
    }

    private void setAddVehicleTitleXpath(String addVehicleTitleXpath) {
        this.addVehicleTitleXpath = addVehicleTitleXpath;
    }

    private String getAddVehicleButtonXpath() {
        return addVehicleButtonXpath;
    }

    private void setAddVehicleButtonXpath(String addVehicleButtonXpath) {
        this.addVehicleButtonXpath = addVehicleButtonXpath;
    }

    private String getVehiclesLiXpath() {
        return vehiclesLiXpath;
    }

    private void setVehiclesLiXpath(String vehiclesLiXpath) {
        this.vehiclesLiXpath = vehiclesLiXpath;
    }


    public boolean goToVehiclesAndInsuranceListView() {
        try {
            waitForSpinningElementDissapear();
            Setup.getWait().thread(1500);
            WebElement element = getWebElement(By.xpath(getVehiclesLiXpath()));
            clickOn(element);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean clickOnAddVehicleButton() {
        try {
            waitForSpinningElementDissapear();
            Setup.getWait().thread(3000);
            WebElement element = getWebElement(By.xpath(getAddVehicleButtonXpath()));
            clickOn(element);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean systemOpensAddVehicleView() {
        Setup.getWait().thread(5000);
        waitForSpinningElementDissapear();

        try {
            Assert.assertNotNull("Page Title not found", getPageElementBy(By.xpath(getAddVehicleTitleXpath())));
            Assert.assertNotNull("Page Icon not Found", getPageElementBy(By.xpath(getCarIconXpath())));
            Assert.assertTrue("Step 1 not found", checkStep(getWebElement(By.xpath(getStepBaseXpath())), "1", "Vehicle Info"));
            Assert.assertNotNull("VIN Image Upload not found", getPageElementBy(By.xpath(getVINImageUploadItemXpath())));
            Assert.assertNotNull("VIN Input not found or do not match Expected Criteria",
                    getPageElementBy(By.xpath(getVINInputXpath())));
            Assert.assertNotNull("Vehicle Type Input not found or do not match Expected Criteria",
                    getPageElementBy(By.xpath(getVehicleTypeXpath())));
            checkVehicleTypeComponentBehaviour();
            Assert.assertNotNull("Vehicle Make Input not found or do not match Expected Criteria",
                    getPageElementBy(By.xpath(getVehicleMakeXpath())));
            Assert.assertNotNull("Vehicle Year Make Input not found or do not match Expected Criteria",
                    getPageElementBy(By.xpath(getVehicleYearMakepath())));
            Assert.assertNotNull("Vehicle Sub Section not found",
                    getPageElementBy(By.xpath(getVehicleCapacitySubSectionXpath())));
            //TODO: Work in progress check for every element on the goheavy.documents.page to be Expected
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    private void checkVehicleTypeComponentBehaviour() {
        waitForSpinningElementDissapear();
        try {
            Setup.getWait().thread(150);
            clickOn(getWebElement(By.xpath(getVehicleTypeXpath())));
            Setup.getWait().thread(150);
            Assert.assertNotNull("Vehicle types not found or none to show", getPageElementBy(By.xpath(
                    "//div[@class='rc-virtual-list-holder-inner']")));
            WebElement vehicle_type_list = getPageElementBy(By.xpath("//div[@class='rc-virtual-list-holder-inner']"));
            List<WebElement> element_list = vehicle_type_list.findElements(By.xpath(
                    "//div[@class='ant-select-item ant-select-item-option']"));
            int val = element_list.size();
            if (element_list.size() > 3)
                val = 0;

            int number = (int) (Math.random() * val + 1);
            hoverElement(null, element_list.get(number));
            clickOn(element_list.get(number));
            Setup.getWait().thread(150);
        } catch (Exception e) {
        }
    }

    public boolean checkStep(WebElement element, String step, String stepName) {
        waitForSpinningElementDissapear();
        String numberXpath = "//span[@class='ant-steps-icon' and text()='" + step + "']";
        String titleXpath = "//div[@class='ant-steps-item-title' and text()='" + stepName + "']";

        try {
            Assert.assertNotNull("Error on Step Number Retrieve", element.findElement(
                    By.xpath(numberXpath)));
            Assert.assertNotNull("Error on Step Title Retrieve", element.findElement(
                    By.xpath(titleXpath)));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public WebElement getPageElementBy(By by) {
        try {
            return getWebElement(By.xpath(getAddVehicleTitleXpath()));
        } catch (Exception e) {
            Assert.fail("Expected Title Page element not found");
            return null;
        }
    }


    public boolean hoverElement(By by, WebElement element) {
        try {
            Setup.getWait().thread(500);
            if (element != null)
                Setup.getActions().moveToElement(element).build().perform();
            else
                Setup.getActions().moveToElement(getWebElement(by)).build().perform();
            Setup.getWait().thread(500);
            return true;
        } catch (Exception e) {
            Assert.fail(e.getMessage());
            return false;
        }
    }

    public void sendDataToInput(WebElement element, String data, Keys key, String form) {
        try {
            if (element.getAttribute("value").length() > 0)
                clear_element_text(element);
        } catch (Exception e) {
        }
        scrollToWebElement(element, form);
        if (data != null)
            Setup.getActions().sendKeys(element, data).build().perform();
        else
            Setup.getActions().sendKeys(element, key).build().perform();
    }

    public WebElement systemCreatesVehicleOnStatus(String status) {
        try {
            waitForSpinningElementDissapear();
            Setup.getActions().sendKeys(getWebElement(By.xpath(""
                            + "//input[@placeholder='Search...' and @type='text' and @class='ant-input']")),
                    (String) Setup.getValueStore("vehicleMake")).build().perform();

            Setup.getWait().thread(250);

            Setup.getActions().click(getWebElement(By.xpath(""
                    + "//button[@class='ant-btn ant-btn-icon-only ant-input-search-button']"))).build().perform();

            Setup.getWait().thread(250);

            String status_xpath = "//span[@class='ant-tag ant-tag-blue' and text()='" + status + "']";
            return getWebElement(By.xpath(status_xpath));
        } catch (Exception e) {
            Assert.fail(e.getMessage());
            return null;
        }
    }

    public WebElement systemsRegistersCreationDate() {
        waitForSpinningElementDissapear();
        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
            String date_compare = dtf.format(LocalDateTime.now());
            String date_xpath = "//td[@class='ant-table-cell' and contains(text(), '" + date_compare + "')]";
            return getWebElement(By.xpath(date_xpath));
        } catch (Exception e) {
            Assert.fail(e.getMessage());
            return null;
        }
    }


    public boolean systemDisplaysAssignView() {
        Setup.getWait().thread(3000);
        waitForSpinningElementDissapear();
        try {
            String xpath = "//div[text()='Assign Vehicle' and @class='ant-modal-title']";
            WebElement alert = getWebElement(By.xpath(xpath));
            return true;
        } catch (Exception e) {
            Assert.fail(e.getMessage());
            return false;
        }
    }

    public boolean userAssignsTheVehicle() {
        Setup.getWait().thread(3000);
        waitForSpinningElementDissapear();
        try {
            Setup.getActions().moveToElement(getWebElement(By.xpath("//input[@placeholder='Please, select a option']"))).
                    build().perform();
            Setup.getWait().thread(500);
            Setup.getActions().click(getWebElement(By.xpath("//input[@placeholder='Please, select a option']"))).
                    build().perform();
            Setup.getWait().thread(1000);
            Setup.getActions().moveToElement(getWebElement(By.xpath("//div[@class='ant-select-item-option-content']"))).
                    build().perform();
            Setup.getWait().thread(500);
            Setup.getActions().click(getWebElement(By.xpath("//div[@class='ant-select-item-option-content']"))).
                    build().perform();
            Setup.getWait().thread(500);
            Setup.getActions().click(getWebElement(By.xpath("//button[@class='ant-btn ant-btn-primary' and @type='button']/"
                    + "descendant::span[text()='Assign']"))).build().perform();
            Setup.getWait().thread(1000);
            System.exit(0);
            return true;
        } catch (Exception e) {
            Assert.fail(e.getMessage());
            return false;
        }
    }

    public void clicks_button_done() {
        clickOn(getWebElement(By.xpath("//button[@type='submit']")));

        waitForSpinningElementDissapear();

    }

    /*public boolean systemDisplaysMessage(String message) {
        Setup.getWait().thread(3000);
        waitForSpinningElementDissapear();
        try {
            String xpath = "//div[text()='Assign Vehicle' and @class='ant-modal-title']";
            WebElement alert = getWebElement(By.xpath(xpath));
            return true;
        } catch (Exception e) {
            Assert.fail(e.getMessage());
            return false;
        }
    }*/

    public void systemDisplaysMessage(String message) {

        waitForSpinningElementDissapear();
        String xpath = "//div[@class='ant-notification ant-notification-topRight']";

        WebElement alert = getWebElement(By.xpath(xpath));

        //Espera de tipo Fluent Wait, para chequear la pagina cada 2seg por un intervalo de 10seg en busca del mensaje de fallo del upload file
        Wait<WebDriver> mywait = new FluentWait<WebDriver>(Setup.getDriver())
                .withTimeout(10, TimeUnit.SECONDS)
                .pollingEvery(2, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);

        WebDriver driver = Setup.getDriver();
        WebElement msg = mywait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                Assert.assertNotNull(alert.getText());
                return alert;
            }
        });
        //Assert.assertEquals(msg.getText(), message);
        Assert.assertEquals(alert.getText(), message);
    }


    //Metodo utilizado para la captura y tratamiento del pop-up que se muestra cuando el fichero a subir con cumple las condiciones de tipo de extension y formato
    public String systemDisplaysMessage_FailedUploadFiles(File file) {

        waitForSpinningElementDissapear();
        String xpath = "//div[@class='ant-notification ant-notification-topRight']";

        WebElement alert = getWebElement(By.xpath(xpath));

        //Espera de tipo Fluent Wait, para chequear la pagina cada 2seg por un intervalo de 10seg en busca del mensaje de fallo del upload file
        Wait<WebDriver> mywait = new FluentWait<WebDriver>(Setup.getDriver())
                .withTimeout(10, TimeUnit.SECONDS)
                .pollingEvery(2, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);

        WebDriver driver = Setup.getDriver();
        WebElement msg = mywait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                //Assert.assertEquals(alert.getText(), message);
                Assert.assertNotNull(alert.getText());
                return alert;
            }
        });
        //Assert.assertEquals(msg.getText(), message);
        return msg.getText();
    }

    public boolean hoverOverImageComponent() {
        waitForSpinningElementDissapear();
        try {
            setImage(getWebElement(By.xpath(getVINImageUploadItemXpath())), null);
            Setup.getWait().thread(500);
            Setup.getActions().moveToElement(getWebElement(By.xpath("//div[contains(@class, 'kxeirt')]/descendant::img")))
                    .build().perform();
            Setup.getWait().thread(500);

            Assert.assertTrue(hoverElement(By.xpath("//span[@role='img' and @class='anticon anticon-eye' and @cursor='pointer']")
                    , null));
            clickOn(getWebElement(By.xpath("//span[@role='img' and @class='anticon anticon-eye' and @cursor='pointer']")));
            clickOn(getWebElement(By.xpath("//span[@class='anticon anticon-close ant-modal-close-icon' and @role='img']")));
            Assert.assertTrue(hoverElement(By.xpath("//span[@role='img' and @class='anticon anticon-check' and @cursor='pointer']")
                    , null));
            clickOn(getWebElement(By.xpath("//span[@role='img' and @class='anticon anticon-check' and @cursor='pointer']")));
            Assert.assertTrue(hoverElement(By.xpath("//span[@role='img' and @class='anticon anticon-close' and @cursor='pointer']")
                    , null));

            return true;
        } catch (Exception e) {
            Assert.fail("Expected Image Over element not found");
            return false;
        }
    }

    //Metodo implementado para la validacion de las imagenes antes de cargarlas al DOM, aplicable a todos los input con Type=file (mismo comportamiento en todas las clases hijas)
    public void CheckUploadImageComponent(String fileInputButton, String nextBtn) {
        waitForSpinningElementDissapear();
        //Defini 3 ficheros principales para hacer la prueba, donde los dos primeros fallaran y el 3ro se podra subir satisfactoriamente,
        // aunque para agilizar la prueba se puede solo usar el 3er file
        File invalid_file = new File("src/test/resources/pl.xlsx");
        File exceeds_max = new File("src/test/resources/huge.png");
        File valid_file_PNG = new File("src/test/resources/file2.jpg");
        List<File> paths = new ArrayList<File>();
        paths.add(invalid_file);
        paths.add(exceeds_max);
        paths.add(valid_file_PNG);
        for (File file : paths) {
            //Pasando el path absoluto del fichero al input no valida, solo captura el fichero a subir, por lo que es necesario simular
            // el click en el botton Next para realizar la validacion
            Setup.getDriver().findElement(By.xpath(fileInputButton)).sendKeys(file.getAbsolutePath());
            Setup.getDriver().findElement(By.xpath(nextBtn)).click();

            try {
                if (file.getName().contains("JPG") && file.getName().contains("JPEG") && file.getName().contains("PNG")) {
                    Assert.assertEquals(systemDisplaysMessage_FailedUploadFiles(file), "You can only upload JPG/JPEG/PNG files");
                    if (file.length() >= 5242880) {
                        Assert.assertEquals(systemDisplaysMessage_FailedUploadFiles(file), "The image must be smaller than 5 MB");
                    } else {
                        Assert.assertTrue(Setup.getDriver().findElement(By.xpath("//div[@class='styles__ImagePreviewActionsStyled-sc-1qjgkf9-12 kxeirt']")).isDisplayed());
                        Assert.assertEquals(Setup.getDriver().findElement(By.xpath("//span[@class='styles__ItemStatusStyled-sc-1qjgkf9-14 gDWxff item-status']")).getText(),"Assessing");
                    }

                }
            } catch (Exception e) {
                Assert.fail(e.getMessage());
            }


        }

            }
            public void clickOnDocumentsIcon(){
        //TODO
    }
}

