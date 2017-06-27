package BusinessLogic;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class BusinessFunctions {
	WebDriver driver;
	WebDriverWait wait;
	WebElement objUN;
	WebElement objPWD;
	public void configDriver()
	{

		System.setProperty("webdriver.chrome.driver","C:\\seleniumPractice\\chromedriver.exe");
	driver=new ChromeDriver();
	wait=new WebDriverWait(driver,30);
	driver.manage().window().maximize();
		}
	// close browser
	public void closeBrowser()
	{
		driver.close();
	}
// open apllication
	public void startApp(String url)
	{
		driver.get(url);
		wait.until(ExpectedConditions.titleIs("OrangeHRM - New Level of HR Management"));
		// verify Login page
		assertEquals(driver.getTitle(),"OrangeHRM - New Level of HR Management");
		Reporter.log("Login Page Displayed");
		
		// Create Object for UN and PWD
		objUN=driver.findElement(By.name("txtUserName"));
		objPWD=driver.findElement(By.name("txtPassword"));
		
		//Verify existence of UN and PWD
		assertTrue(objUN.isDisplayed() && objPWD.isDisplayed());
		Reporter.log("UN and PWD are Displayed");
	}
		// Enter Login Details
		
public void LoginToQAHRM(String username,String password)
{
objUN.sendKeys(username);
objPWD.sendKeys(password);
driver.findElement(By.name("Submit")).click();
wait.until(ExpectedConditions.titleIs("OrangeHRM"));
// verify Home Page 
assertEquals(driver.getTitle(),"OrangeHRM");
Reporter.log("Home page displayed");

//Get Welcome Text
String weltext=driver.findElement(By.xpath("//*[@id='option-menu']/li[1]")).getText();
// Verify Welcome Text
assertEquals(weltext,"Welcome "+username);
Reporter.log("Welcome "+username+" displayed");
}
// Log out from application
public void LogoutFromApp()
{
	driver.findElement(By.linkText("Logout")).click();
	wait.until(ExpectedConditions.titleIs("OrangeHRM - New Level of HR Management"));
// Verify Home Page
	assertEquals(driver.getTitle(),"OrangeHRM - New Level of HR Management");
	Reporter.log("Successfully logged out and Login page Displayed");
}
		

}
