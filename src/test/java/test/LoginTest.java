package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;


public class LoginTest {
	
	WebDriver driver;
	

	@Test
	@Parameters({"userName", "password", "FullName", "CompanyName", "Email", "PhoneNum", "Address", "City", "State", "Zip", "CountryName"})
     public void userShouldBeAbleToLogIn(String userName, String password, String fullname, String company, String email, String phone, String address, String city, String state, String zip, String country) {
    	 
    	 driver = BrowserFactory.init();
    	 
    	 LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
    	 loginPage.insertUserName(userName);
		 loginPage.insertPassword(password);
		 loginPage.clickOnSigninButton();
		 DashboardPage dashboard = PageFactory.initElements(driver, DashboardPage.class);
		 dashboard.validateDashboardPage();
		 
		 BrowserFactory.tearDown();
     }

}
