package goheavy.driver.pages;

import general.PageObject;
import general.Setup;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class DriverListPage extends PageObject {
	private String addDriverBtn = "//span[text()='Add Driver']/ancestor::button[@class='ant-btn ant-btn-primary']";
	private String listDriverTitle;

	public DriverListPage() {
		super();
		this.urlpath = "/driver";
		settListDriverTitle("//span[contains(text(),'Drivers List')]");
	}

	private String getaddDriverBtn() {
		return addDriverBtn;
	}
	private void setaddDriverBtn(String addDriverBtn) {
		addDriverBtn = addDriverBtn;
	}

	private String getListDriverTitle() {
		return listDriverTitle;
	}
	private void settListDriverTitle(String listDriverTitle) {
		listDriverTitle = listDriverTitle;
	}


	public boolean userClicksOnAddDriverButton() {
		try {
			waitForSpinningElementDissapear();
			WebElement element = getWebElement(By.xpath(addDriverBtn));
			clickOn(element);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean SystemReturnsToDriverListView(){
		waitForSpinningElementDissapear();

		try {
			Assert.assertEquals("Drivers List", Setup.getDriver().findElement(By.xpath("//*[contains(text(),'Drivers List')]")).getText());
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void systemDisplaysMessage() {
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
		Assert.assertEquals(alert.getText(), "A new Driver was successfully created.");
	}


}
