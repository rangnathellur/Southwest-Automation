package com.southwest.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.southwest.base.TestBase;

public class TripandPriceDetailsPage extends TestBase{
	
	@FindBy(xpath = "//span[contains(@class,'header-booking--text')]")
	WebElement bookingText;
	
	@FindBy(xpath = "//span[contains(@class,'--date-range')]/span")
	WebElement dateRange;
	
	@FindBy(xpath = "//div[contains(@class,'checkout-price-flight-product')]/div[2]/div[5]/span/span")
	WebElement flightPrice;
	
	//Initializing the Page Objects:
	public TripandPriceDetailsPage(){
		PageFactory.initElements(driver, this);
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
	
	//Total price of the flight.
	public double getFlightPrice() {
		double price = Double.parseDouble(flightPrice.getText());
		return price;
	}

}
