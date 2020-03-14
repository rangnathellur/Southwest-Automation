package com.southwest.pages;

import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.southwest.base.TestBase;

public class SouthwestPage extends TestBase{
	@FindBy(xpath = "//button[contains(@class,'tab-navigation--tab_flight')]")
	WebElement flights;
	
	@FindBy(xpath = "//button[contains(@class,'tab-navigation--tab_flight')]/div[contains(@class,'actionable-tab--phase-selected')]")
	WebElement flightsDefault;
	
	@FindBy(xpath = "//button[contains(@class,'tab-navigation--tab_hotel')]")
	WebElement hotels;
	
	@FindBy(xpath = "//input[contains(@value,'oneway')]")
	WebElement oneway;
	 
	@FindBy(id="LandingAirBookingSearchForm_originationAirportCode")
	WebElement depart;

	@FindBy(id="LandingAirBookingSearchForm_destinationAirportCode")
	WebElement arrive;

	@FindBy(xpath = "//div[contains(@class,'search-form--fields-dates_input')]/div[1]/label/div/div/div/div/span[contains(@class,'swa-icon input--icon swa-icon_calendar')]")
	WebElement departDate;
	
	@FindBy(xpath = "//div[contains(@class,'search-form--fields-dates_input')]/div[2]/label/div/div/div/div/span[contains(@class,'swa-icon input--icon swa-icon_calendar')]")
	WebElement arrivalDate;
	
	@FindBy(xpath = "//div[contains(@class,'calendar-month--days')]")
	WebElement calenderDepart;

	@FindBy(id="LandingAirBookingSearchForm_submit-button")
	WebElement searchBtn;

	//Initializing the Page Objects:
	public SouthwestPage() throws Throwable{
		PageFactory.initElements(driver, this);
	}

	
	public boolean isFlightDefault() {
		if (flights.isSelected())
			return true;
		else
			return false;
	}
	
	//Basic flow to search for a flight.
	public void searchFlight(String departCity, String arriveCity){
		depart.click();
		depart.sendKeys(Keys.DELETE);
		depart.sendKeys(departCity);
		arrive.sendKeys(Keys.DELETE);
		arrive.sendKeys(arriveCity);
		departDate.click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		selectDate(getCurrentDay());
		arrivalDate.click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
		calendar.set(Calendar.DAY_OF_MONTH, 30);
		int newdate = calendar.get(Calendar.DAY_OF_MONTH);
		selectDate(newdate);
		searchBtn.click();
	}

	//method to select the date on calender
	public void selectDate(int date) {
		System.out.println("Date "+date);
		 List<WebElement> columns = calenderDepart.findElements(By.tagName("button"));
		 for (WebElement cell: columns) {
	            if (cell.getText().equals(String.valueOf(date))) {
	                cell.click();
	                break;
	            }
	        }
	}
	
    //Get The Current Day
    public int getCurrentDay (){
        //Create a Calendar Object
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
 
        //Get Current Day as a number
        int todayInt = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println("Today Int: " + todayInt +"\n");
 
        return todayInt;
    }
}
