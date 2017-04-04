package pageTests;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.Login_Page;

public class Login_Test {
	private static WebDriver driver = null;
	public String[] invalidChars = { "#", "!", "$", "@", "%", "^", "&" };

	@DataProvider(name = "Authentication")

	public static Object[][] credentials() {

		return new Object[][] { { "400218542", "sa" }, { "testuser_2", "Test@123" }, { "400218542", "" },
				{ "", "sa" } };

	}

	@Test
	public void IsUserNameFIeldIsPresent() {
		assertTrue(Login_Page.txtbx_UserName(driver).isDisplayed());
	}

	@Test
	public void IsPasswordFIeldIsPresent() {
		assertTrue(Login_Page.txtbx_Password(driver).isDisplayed());
	}

	@Test
	public void IsLoginButtonIsPresent() {
		assertTrue(Login_Page.btn_LogIn(driver).isDisplayed());
	}

	@Test
	public void LoginwithValidCredential() throws InterruptedException {
		Login_Page.txtbx_UserName(driver).sendKeys("400218542");
		Login_Page.txtbx_Password(driver).sendKeys("sa");
		Login_Page.btn_LogIn(driver).click();
		Thread.sleep(5000);
		assertTrue(Login_Page.txtlbl_InvalidUser(driver).isDisplayed());
	}

	@Test
	public void LoginwithInValidCredential() throws InterruptedException {
		Login_Page.txtbx_UserName(driver).sendKeys("400219041");
		Login_Page.txtbx_Password(driver).sendKeys("sa");
		Login_Page.btn_LogIn(driver).click();
		Thread.sleep(5000);
		assertTrue(Login_Page.txtlbl_InvalidUser(driver).isDisplayed());
	}

	@Test
	public void LoginwithValidUserInvalidPasword() {
		Login_Page.txtbx_UserName(driver).sendKeys("400218542");
		Login_Page.txtbx_Password(driver).sendKeys("ha");
		Login_Page.btn_LogIn(driver).click();
		assertTrue(Login_Page.txtlbl_InvalidUser(driver).isDisplayed());
	}

	@Test
	public void LoginwithEmptyUserNameAndPassword() {
		Login_Page.txtbx_UserName(driver).sendKeys("");
		Login_Page.txtbx_Password(driver).sendKeys("");
		Login_Page.btn_LogIn(driver).click();
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
		File file = new File(Login_Page.appUrl);
		System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
		driver = new InternetExplorerDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(Login_Page.appUrl);
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
