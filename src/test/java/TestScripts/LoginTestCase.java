package TestScripts;

import org.testng.annotations.Test;

import BusinessLogic.BusinessFunctions;

public class LoginTestCase {
	@Test
	public void VerifyLogin()
	{
	BusinessFunctions bf=new BusinessFunctions();
	bf.configDriver();
	bf.startApp("http://apps.qaplanet.in/qahrm/login.php");
	bf.LoginToQAHRM("qaplanet1","user1");
	bf.LogoutFromApp();
	bf.closeBrowser();

}
}
