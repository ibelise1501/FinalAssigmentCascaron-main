package goheavy.documents.page;

import general.PageObject;
import general.Setup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DocumentPage extends PageObject {
    private String pageName = "//span[contains(text(),\"Documents for\")]";
    List<WebElement> documentsList = Setup.getDriver().findElements(By.xpath("//span//ancestor::span[@class=\"anticon anticon-check-circle\"]"));
    private String approveBtn = "(//button[@type=\"submit\"]//child::span)[1]";
    List<WebElement> documentStatusList = Setup.getDriver().findElements(By.xpath("//span[contains(@class,'ant-tag')]"));


    public DocumentPage(){
        super();
    }

    public void CheckPage(String view){
        //Checkear el nombre de la pagina
    }

    public void ClickOnElement(){
        //Hacer click en el boton View
    }

    public void ApproveDocs(){
        //hacer click en el boton Approve
    }

    public void CheckStatus(){
        //checkear el status del documento
    }
    public void updateStatus(){
        //checkear el status del documento
    }

    public void checkTheModalView(String view){
        //checkear el nombre del modal
    }

    public void approveAllDriverDocs(){
        //Faltaria checkear el nombre de la vista (Documents for "Driver's name")
        for (WebElement element : documentsList
             ) {
            Setup.getActions().click(element);
            //Faltaria checkear el nombre de la vista del modal ("Driver's name" - Driver License)
            Setup.getActions().click(getWebElement(By.xpath("(//button[@type=\"submit\"])[1]")));
            //Faltaria checkear el status
        }
    }

    public void approveAllVehicleDocs(){
        //Faltaria checkear el nombre de la vista (Documents for "Vehicle ID No. (VIN)")
        for (WebElement element : documentsList
        ) {
            Setup.getActions().click(element);
            //Faltaria checkear el nombre de la vista del modal ("Vehicle ID No. (VIN)" - Vehicle Identification Number (VIN))
            Setup.getActions().click(getWebElement(By.xpath("(//button[@type=\"submit\"])[1]")));
            //Faltaria checkear el status
        }
    }
}
