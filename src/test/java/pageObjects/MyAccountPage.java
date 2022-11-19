
package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//h2[text()='My Account']") 
	WebElement msgHeading;

	@FindBy(xpath = "//div[@class='list-group']//a[text()='Logout']") 
	WebElement lnkLogout;
	
	public boolean isMyAccountPageExists()   
	{
		try {
			System.out.println(msgHeading.isDisplayed() +" :: isMyAccountPageExists  ");
			return (
					msgHeading.isDisplayed()
					);
		} catch (Exception e) {
			System.out.println("FALSE:: isMyAccountPageExists Exception "+e.getMessage());
			
			return (false);
		}
	}

	public void clickLogout() {
		lnkLogout.click();
	}
}
