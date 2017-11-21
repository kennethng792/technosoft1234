package framework;

import org.openqa.selenium.By;

public class LoginPage extends BasePage1{

	private By pageHeader = By.xpath("//*[@id='content']/div/div/div[1]/span");
	
	public String getPageHeader() {
		
		return getTextFromElement(pageHeader);
	}
}
