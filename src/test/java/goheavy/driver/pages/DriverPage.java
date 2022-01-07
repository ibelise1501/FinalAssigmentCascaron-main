package goheavy.driver.pages;

import java.io.File;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import javax.swing.text.Element;

import org.junit.Assert;
import org.openqa.selenium.*;

import general.InputType;
import general.PageObject;
import general.Setup;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import sun.util.resources.cldr.CalendarData;

@SuppressWarnings("unused")
public class DriverPage extends PageObject {
	private String menuDriversLink;
	private String addDriverButton;
	private String AddDriverTitle;

	//Atributos de la vista Add Driver
	private String driver_Photo="(//input[@type='file'])[1]";
	private String driver_firstName="//input[@placeholder='Enter First Name']";
	private String driver_lastName="//input[@placeholder='Enter Last Name']";
	private String driver_bDate="//input[@id='birthAt']";
	private String driver_experience="//input[@placeholder='Enter Years of experience']";
	private String driver_mobile="//input[@placeholder='Enter Mobile Number']";
	private String driver_email="//input[@placeholder='Enter Email Address']";
	private String driver_shirtSize="//input[@id='tShirtSize']";
	private String driver_address="//textarea[@placeholder='Address']";
	private String driver_zipCode="//input[@placeholder='Enter ZIP Code']";
	private String driver_City="//input[@placeholder='Enter City']";
	private String driver_Country="//input[@id='addressCountryId']";
	private String driver_State="//input[@id='addressStateId']";
	private String driver_licensePhotoFront="(//input[@type='file'])[2]";
	private String driver_licensePhotoBack="(//input[@type='file'])[3]";

	private String driver_LicenseNumber="//input[@placeholder='Enter DL number']";
	private String driver_IssuedDate="//input[@id='dlIssuedDate']";
	private String driver_ExpDate="//input[@id='dlExpirationDate']";
	private String driver_ClassType="//input[@id='dlClassType']";


	private String driver_AddBtn="//span[text()='Add']";
	private String updateBtn = "//button[@class=\"ant-btn ant-btn-primary styles__ButtonSubmit-sc-1548o7b-1 khxaWf\"]";



	public DriverPage() {
		super();
		this.urlpath = "/driver";
		setMenuDriversLink("//span[text()='Drivers']/ancestor::span[@class='ant-menu-title-content']");
		setAddDriverButton("//span[text()='Add Driver']/ancestor::button[@class='ant-btn ant-btn-primary']");
		setAddDriverTitle("//span[text()='Add Driver']/ancestor::div[@class='ant-row ant-row-space-between ant-row-middle']");


		//setAddDriverTitle("//label[text()='Driver Photo (including shoulders)']/ancestor::div[contains(@class,'ant-form-item')]/descendant::input[@type='file']");
			}
	
	private String getAddDriverTitle() {
		return AddDriverTitle;
	}

	public String getUpdateBtn(){return updateBtn;}
	private String getdriver_LicenseNumber() {
		return driver_LicenseNumber;
	}
	private void setdriver_LicenseNumber(String driver_LicenseNumber) {
		driver_LicenseNumber = driver_LicenseNumber;
	}

	private String getdriver_IssuedDate() {
		return driver_IssuedDate;
	}
	private void setdriver_IssuedDate(String driver_IssuedDate) {
		driver_IssuedDate = driver_IssuedDate;
	}
	private String getdriver_ExpDate() {
		return driver_ExpDate;
	}
	private void setdriver_ExpDate(String driver_ExpDate) {
		driver_ExpDate = driver_ExpDate;
	}
	private String getdriver_ClassType() {
		return driver_ClassType;
	}
	private void setdriver_ClassType(String driver_ClassType) {
		driver_ClassType = driver_ClassType;
	}
	private String getdriver_Photo() {
		return AddDriverTitle;
	}
	private void setdriver_Photo(String driver_Photo) {
		driver_Photo = driver_Photo;
	}

	private String getdriver_firstName() {
		return AddDriverTitle;
	}
	private void setdriver_firstName(String driver_firstName) {
		driver_firstName = driver_firstName;
	}

	private String getdriver_lastName() {
		return AddDriverTitle;
	}
	private void setdriver_lastName(String driver_lastName) {
		driver_lastName = driver_lastName;
	}

	private String getdriver_bDate() {
		return driver_bDate;
	}
	private void setdriver_bDate(String driver_bDate) {
		driver_bDate = driver_bDate;
	}

	private String getdriver_experience() {
		return driver_experience;
	}
	private void setdriver_experience(String driver_experience) {
		driver_experience = driver_experience;
	}

	private String getdriver_mobile() {
		return driver_mobile;
	}
	private void setdriver_mobile(String driver_mobile) {
		driver_mobile = driver_mobile;
	}

	private String getdriver_email() {
		return driver_email;
	}
	private void setdriver_email(String driver_email) {
		driver_email = driver_email;
	}

	private String getdriver_shirtSize() {
		return driver_shirtSize;
	}
	private void setdriver_shirtSize(String driver_shirtSize) {
		driver_shirtSize = driver_shirtSize;
	}

	private String getdriver_address() {
		return driver_address;
	}
	private void setdriver_address(String driver_address) {
		driver_address = driver_address;
	}

	private String getdriver_zipCode() {
		return driver_zipCode;
	}
	private void setdriver_zipCode(String driver_zipCode) {
		driver_zipCode = driver_zipCode;
	}

	private String getdriver_City() {
		return driver_City;
	}
	private void setdriver_City(String driver_City) {
		driver_City = driver_City;
	}

	private String getdriver_Country() {
		return driver_Country;
	}
	private void setdriver_Country(String driver_Country) {
		driver_Country = driver_Country;
	}

	private String getdriver_State() {
		return driver_State;
	}
	private void setdriver_State(String driver_State) {
		driver_State = driver_State;
	}


	private void setAddDriverTitle(String addDriverTitle) {
		AddDriverTitle = addDriverTitle;
	}

	private String getdriver_licensePhotoFront() {
		return driver_licensePhotoFront;
	}
	private void setdriver_licensePhotoFront(String driver_licensePhotoFront) {
		driver_licensePhotoFront = driver_licensePhotoFront;
	}

	private String getDriver_licensePhotoBack() {
		return driver_licensePhotoBack;
	}
	private void setDriver_licensePhotoBack(String driver_licensePhotoBack) {
		driver_licensePhotoBack = driver_licensePhotoBack;
	}

	private String getAddDriverButton() {
		return addDriverButton;
	}

	private void setAddDriverButton(String addDriverButton) {
		this.addDriverButton = addDriverButton;
	}

	private String getMenuDriversLink() {
		return menuDriversLink;
	}

	private void setMenuDriversLink(String menuDriversLink) {
		this.menuDriversLink = menuDriversLink;
	}

	public boolean goToView() {
		try {
			waitForSpinningElementDissapear();
			waitAddittionalTime();
			clickOnElement(getWebElement(By.xpath(getMenuDriversLink())), true);
			return true;
		} catch(Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}


	public void waitAddittionalTime() {
		Setup.getWait().thread(5000);
	}
	
	public void waitAddittionalShortTime() {
		Setup.getWait().thread(1000);
	}
	
	public void clickOnElement(WebElement element, boolean waitForSpinner) {
		if (waitForSpinner)
			waitForSpinningElementDissapear();
		Setup.getActions().moveToElement(element).build().perform();
		Setup.getActions().click(element).build().perform();
		if (waitForSpinner)
			waitForSpinningElementDissapear();
	}

	public boolean clickOnAddDriverButton() {
		try {
			waitForSpinningElementDissapear();
			Setup.getWait().thread(3000);
			WebElement element = getWebElement(By.xpath(getAddDriverButton()));
			clickOn(element);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean systemOpensView(String view) {
		Setup.getWait().thread(5000);
		waitForSpinningElementDissapear();
		try {
			Assert.assertEquals(Setup.getDriver().findElement(By.xpath(getAddDriverTitle())).getText(),view);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	//El caso ideal seria definir estos metodos en una clase de uso comun para no repetirlos en todas las clases
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
		try {
			Assert.assertEquals(alert.getText(), message);
			System.out.println("Capturado el mensaje");
		}	catch (Exception e)	{
			System.out.println(e);

		}
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

	public void CheckUploadImageComponent(String fileInputButton, String nextBtn) {
		waitForSpinningElementDissapear();
		//Defini 3 ficheros principales para hacer la prueba, donde los dos primeros fallaran y el 3ro se podra subir satisfactoriamente,
		// aunque para agilizar la prueba se puede solo usar el 3er file
		//File invalid_file = new File("src/test/resources/pl.xlsx");
		//File exceeds_max = new File("src/test/resources/huge.png");
		File valid_file_PNG = new File("src/test/resources/file2.jpg");
		List<File> paths = new ArrayList<File>();
		//paths.add(invalid_file);
		//paths.add(exceeds_max);
		paths.add(valid_file_PNG);
		for (File file : paths) {
			//Pasando el path absoluto del fichero al input no valida, solo captura el fichero a subir, por lo que es necesario simular
			// el click en el botton Next para realizar la validacion
			Setup.getDriver().findElement(By.xpath(fileInputButton)).sendKeys(file.getAbsolutePath());
			//Comentarie esta linea ya que tomo como echo que el fichero va a ser valido
			//Setup.getDriver().findElement(By.xpath(nextBtn)).click();

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

	public void clicks_button_done() {
		clickOn(getWebElement(By.xpath(driver_AddBtn)));
		waitForSpinningElementDissapear();

	}

	public void sendDataToInput(WebElement element, String data, Keys key) {
		scrollByVisibleElement(element);

		try {
			if (element.getAttribute("value").length() > 0)
				clear_element_text(element);
		} catch (Exception e) {
		}

		if (data != null)
			Setup.getActions().sendKeys(element, data).build().perform();
		else
			Setup.getActions().sendKeys(element, key).build().perform();
	}

	public void scrollByVisibleElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) Setup.getDriver();

		//Para hacer un scroll en la pagina hasta encontrar el elemento de la variable Element
		js.executeScript("arguments[0].scrollIntoView();", element);
	}

	public String insertValidData() {
		//waitForSpinningElementDissapear();
		CheckUploadImageComponent(driver_Photo,driver_AddBtn);

		Setup.getActions().click(getWebElement(By.xpath(driver_firstName))).build().perform();
		sendDataToInput(getWebElement(By.xpath(driver_firstName)), getFaker().name().firstName(),null);
		sendDataToInput(getWebElement(By.xpath(driver_lastName)), getFaker().name().lastName(),null);

		//Creado en la clase Page Object para forzar el relleno todos los campos que me dieron trabajo :D
		fillComplicatedFields(driver_bDate, "12/01/2000");

		sendDataToInput(getWebElement(By.xpath(driver_experience)), "4", null);
		sendDataToInput(getWebElement(By.xpath(driver_mobile)), getFaker().number().digits(10), null);
		String mobile = Setup.getDriver().findElement(By.xpath(driver_mobile)).getAttribute("value");
				sendDataToInput(getWebElement(By.xpath(driver_email)), getFaker().internet().emailAddress(), null);

		fillComplicatedFields(driver_shirtSize,"M");

		sendDataToInput(getWebElement(By.xpath(driver_address)), getFaker().address().streetName(), null);
		sendDataToInput(getWebElement(By.xpath(driver_zipCode)), getFaker().address().zipCode(), null);

		sendDataToInput(getWebElement(By.xpath(driver_City)), getFaker().address().city(), null);

		fillComplicatedFields(driver_State, "Alabama");

		CheckUploadImageComponent(driver_licensePhotoFront,driver_AddBtn);
		CheckUploadImageComponent(driver_licensePhotoBack,driver_AddBtn);

		sendDataToInput(getWebElement(By.xpath(driver_LicenseNumber)), getFaker().number().digits(7), null);

		fillComplicatedFields(driver_IssuedDate, "12/01/2016");
		fillComplicatedFields(driver_ExpDate, "12/31/2022");
		fillComplicatedFields(driver_ClassType, "M");


		//clickOn(Setup.getDriver().findElement(By.xpath(driver_AddBtn)));
		//clicks_button_done();

		waitForSpinningElementDissapear();
		Setup.getWait().thread(1500);

		return mobile;

	}

	public void updateStatus(){
		String status = "//input[@id='status']";
		try {
			Assert.assertTrue(Setup.getDriver().findElement(By.xpath(status)).isEnabled());
			sendDataToInput(getWebElement(By.xpath(status)),"GoHeavy Ready", Keys.ENTER);
			clicks_button_done();
		}catch (Exception e){
			 System.out.println(e);
		}

	}


}
