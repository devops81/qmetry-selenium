package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login_Page {
	private static WebElement element = null;

	public static WebElement txtbx_UserName(WebDriver driver) {

		element = driver.findElement(By.id("username"));

		return element;
	}

	public static WebElement txtbx_Password(WebDriver driver) {

		element = driver.findElement(By.id("password"));

		return element;
	}

	public static WebElement btn_LogIn(WebDriver driver) {

		element = driver.findElement(By.id("submit"));

		return element;
	}
	
	public static WebElement txtlbl_InvalidUser(WebDriver driver) {

		element = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/table/tbody/tr[3]/td/span"));

		return element;
	}
	
	public static WebElement btn_Back(WebDriver driver) {

		element = driver.findElement(By.xpath("/html/body/center/a"));

		return element;
	}
	
}
