package QAAutomationImpl.unittest;

import pageObjects.Login_Page;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;

public class Login_Test {
	private static WebDriver driver = null;
	public String[] invalidChars = { "#", "!", "$", "@", "%", "^", "&" };

	@DataProvider(name = "Authentication")

	public static Object[][] credentials() {

		return new Object[][] { { "400218542", "sa" }, { "testuser_2", "Test@123" }, { "400218542", "" },
				{ "", "sa" } };

	}

	 @Test
	public void Validate_PageIsLoadedOrNOt() {
		assertEquals(driver.getTitle(), "IntelliGen Framework Genpact");

	}

	//@Test
	public void Validate_SuccessfulLogin() throws InterruptedException {
		Login_Page.txtbx_UserName(driver).sendKeys("400219041");
		Login_Page.txtbx_Password(driver).sendKeys("sa");
		Login_Page.btn_LogIn(driver).click();
		Alert a = driver.switchTo().alert();
		a.accept();
		Thread.sleep(5000);
		assertEquals(driver.getTitle(), "Welcome Page");
		Login_Page.btn_Back(driver).click();
	}

	//@Test
	public void IsUserNameFIeldIsPresent() {
		assertTrue(Login_Page.txtbx_UserName(driver).isDisplayed());
	}

	// @Test
	public void IsPasswordFIeldIsPresent() {
		assertTrue(Login_Page.txtbx_Password(driver).isDisplayed());
	}

	//@Test
	public void IsLoginButtonIsPresent() {
		assertTrue(Login_Page.btn_LogIn(driver).isDisplayed());
	}

	//@Test
	public void Validate_LoginwithValidCredential() throws InterruptedException {
		Login_Page.txtbx_UserName(driver).sendKeys("400219041");
		Login_Page.txtbx_Password(driver).sendKeys("sa");
		Login_Page.btn_LogIn(driver).click();
		Thread.sleep(5000);
		assertTrue(Login_Page.txtlbl_InvalidUser(driver).isDisplayed());
	}

	//@Test
	public void Validate_LoginwithInValidCredential() throws InterruptedException {
		Login_Page.txtbx_UserName(driver).sendKeys("maneeshs");
		Login_Page.txtbx_Password(driver).sendKeys("sa");
		Login_Page.btn_LogIn(driver).click();
		Thread.sleep(5000);
		Alert alert = driver.switchTo().alert();
		String alertMsg = alert.getText();
		String expectedMsg="Invalid User or Password and You have left";
		alert.accept();
		assertTrue(alertMsg.contains(expectedMsg));
	}

	// @Test
	public void Validate_LoginwithValidUserInvalidPasword() {
		Login_Page.txtbx_UserName(driver).sendKeys("400219041");
		Login_Page.txtbx_Password(driver).sendKeys("ha");
		Login_Page.btn_LogIn(driver).click();
		assertTrue(Login_Page.txtlbl_InvalidUser(driver).isDisplayed());
	}

	// @Test
	public void Validate_LoginwithEmptyUserNameAndPassword() throws InterruptedException {
		Login_Page.txtbx_UserName(driver).sendKeys("");
		Login_Page.txtbx_Password(driver).sendKeys("sa");
		Login_Page.btn_LogIn(driver).click();
		Thread.sleep(5000);
		assertTrue(Login_Page.txtlbl_InvalidUser(driver).isDisplayed());
	}

	// @Test(dataProvider = "Authentication")
	public void FirstTest(String sUsername, String sPassword) {
		Login_Page.txtbx_UserName(driver).sendKeys(sUsername);
		Login_Page.txtbx_Password(driver).sendKeys(sPassword);
		Login_Page.btn_LogIn(driver).click();
		assertTrue(Login_Page.txtlbl_InvalidUser(driver).isDisplayed());
	}

	@BeforeMethod
	public void beforeMethod() {
		File file = new File("C:/Driver/IEDriverServer.exe");
		System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
		driver = new InternetExplorerDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("file:///C:/CustomWork/examples/feed-combiner-java8-webapp/src/main/webapp/index.html");
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
