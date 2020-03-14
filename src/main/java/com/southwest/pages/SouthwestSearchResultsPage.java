package com.southwest.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.southwest.base.TestBase;

public class SouthwestSearchResultsPage extends TestBase{

	
	@FindBy(xpath = "//span[contains(@class,'header-booking--text')]")
	WebElement bookingText;
	
	@FindBy(xpath = "//span[contains(@class,'--date-range')]/span")
	WebElement dateRange;
	
	@FindBy(xpath = "//div[contains(@class,'checkbox--content-button-container')]")
	WebElement nonStop;
	
	@FindBy(xpath = "//div[contains(@class,'flight-stops--duration')]")
	List<WebElement> flightStops;

	@FindBy(xpath = "//div[@id='air-booking-fares-0-1']/div")
	WebElement selectFirstPrice;
	
	@FindBy(id="air-booking-product-2")
	WebElement btnContinue;	
	
	Actions action;
	//Initializing the Page Objects:
	public SouthwestSearchResultsPage(){
		PageFactory.initElements(driver, this);
	}
		
	public WebElement getNonstopbtn() {
		return nonStop;
	}

	public int verifyDepartDate() {
		String date = dateRange.getText();
		return Integer.valueOf(date.substring(4,6));
	}
	
	public int verifyArrivalDate() {
		String date = dateRange.getText();
		return Integer.valueOf(date.substring(9,11));
	}
	
	public String verifyDepartCity() {
		String deptCity = bookingText.getText();
		return deptCity.substring(0,3);
	}
	
	public String verifyArrivalCity() {
		String arrivalCity = bookingText.getText();
		return arrivalCity.substring(arrivalCity.length()-3,arrivalCity.length());
	}
	
	public void clickNonStop() {
		action = new Actions(driver);
		action.moveToElement(nonStop).click().perform();
		
	}
	
	//validate if filtered results showing nonstop flights only
	public boolean validateNonstop() {		
		for(WebElement stopFlight : flightStops) {			
			if(stopFlight.getText().contains("stop"))
				return false;
		}	
		
		return true;
	}
	
	public void clickSelectPrice() {
		selectFirstPrice.click();
	}
	
	public void clickContinue() {
		btnContinue.click();
	}
}
