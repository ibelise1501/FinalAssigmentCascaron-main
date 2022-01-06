package goheavy.documents;

import general.Steps;
import goheavy.account.page.AccountPage;
import goheavy.documents.page.DocumentPage;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.fail;

public class DocumentStep extends Steps {
    private DocumentPage documentPage;

    public DocumentStep() {
        documentPage = new DocumentPage();
    }


    public void checkPage(String view) {
       documentPage.CheckPage(view);
    }

    public void clickOnElement(){
        documentPage.ClickOnElement();
    }

    public void checkStatus(){
        documentPage.CheckStatus();
    }

    public void updateStatus(){
        documentPage.updateStatus();
    }

    public void ApproveDriverDocs(){
        documentPage.approveAllDriverDocs();
    }

        public void ApproveVehicleDocs(){

        documentPage.approveAllVehicleDocs();
    }

    public void checkTheModalView(String view){
        documentPage.checkTheModalView(view);
    }

    @Override
    public void checkPage() {

    }
}
