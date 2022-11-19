package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDataDrivenTest extends BaseClass {

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
	public void test_LoginDDT(String email, String pwd, String exp) {
		logger.info(" Starting TC_003_LoginDataDrivenTest :: "+email+","+pwd+","+exp);
		System.out.println(" Starting TC_003_LoginDataDrivenTest :: "+email+","+pwd+","+exp);
		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();

			LoginPage lp = new LoginPage(driver);
			lp.setEmail(email);
			lp.setPassword(pwd);
			lp.clickLogin();

			MyAccountPage macc=new MyAccountPage(driver);
			boolean targetpage = macc.isMyAccountPageExists();// this method is created MyAccountPage

			if (exp.equals("valid")) {
				
				if (targetpage == true) {
					
					logger.info("Valid/True");
					macc.clickLogout();
					Assert.assertTrue(true);
				} else {
					
					logger.info("Valid/False");
					Assert.fail();
				}
			}

			if (exp.equals("invalid")) {
				if (targetpage == true) {
					logger.info("InValid/True");
					MyAccountPage myaccpage = new MyAccountPage(driver);
					myaccpage.clickLogout();
					Assert.assertTrue(false);
				} else {
					logger.info("InValid/False");
					Assert.assertTrue(true);
				}
			}

		} catch (Exception e) {
			logger.info("Exception");
			Assert.fail();
		}

		logger.info(" Finished TC_003_LoginDataDrivenTest");

	}

}