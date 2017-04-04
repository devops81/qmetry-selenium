package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login_Page {
	private static WebElement element = null;
	public static String appUrl = "C:\JenkinSlave\workspace\Banking Scorecard Build\examples\feed-combiner-java8-webapp\src\test\resources\chromedriver.exe";
	public static String driverUrl = "C:\JenkinSlave\workspace\Banking Scorecard Build\examples\feed-combiner-java8-webapp\src\test\resources\IEDriverServer.exe";

	public static WebElement txtbx_UserName(WebDriver driver) {

		element = driver.findElement(By.id("userid"));

		return element;
	}

	public static WebElement txtbx_Password(WebDriver driver) {

		element = driver.findElement(By.id("pswrd"));

		return element;
	}

	public static WebElement btn_LogIn(WebDriver driver) {

		element = driver.findElement(By.xpath("/html/body/form/input[3]"));

		return element;
	}
	
	public static WebElement txtlbl_InvalidUser(WebDriver driver) {

		element = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/table/tbody/tr[3]/td/span"));

		return element;
	}

}
