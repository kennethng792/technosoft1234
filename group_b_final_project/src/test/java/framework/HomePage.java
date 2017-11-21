package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import ru.yandex.qatools.allure.annotations.Step;
import stepdefinition.SharedSD;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class HomePage extends BasePage1{

	private By emailTextField = By.id("email");
	private By passwordTextField = By.id("pass");
	private By loginButton = By.id("loginbutton");
	private By firstNameTextField = By.id("firstName");
	private By lastNameTextField = By.id("lastName");
	private By mobileNumberTextField = By.id("mobileNumber");
	private By newPasswordTextField = By.id("newPwd");
	private By errorMessage = By.id("errorMessage");
	private By originDestinationTextField = By.id("package-origin");
	private By finalDestinationTextField = By.id("package-destination");
	private By calenderBoxLink = By.xpath(".//*[@id='package-departing']/descendant::data-day");
	private By checkinCalendar = By.id("package-departing");
	private By checkoutCalendar = By.id("package-returning");
	private By listOfDays = By.xpath(".//*[@class='datepicker-cal-dates']/descendant::data-day");
	private By roomDropDownLocation = By.id("package-rooms-label");
	private By roomsDropdown = By.id("package-rooms");
	private By adultDropdown = By.id("package-1-adults");
	private By childrenDropdown = By.id("package-1-children");
	private By children1AgeDropdown = By.id("package-1-age-select-1");
	private By advanceDropDown = By.id("package-advanced-preferred-class");
	private By background = By.id("wizard-theme-wrapper");
	private By originDestination = By.id("inpSearchFrom");
	private By verifyDepartingTime = By.id("inpStartDate");
	private By verifyReturningTime = By.id("inpEndDate");
	private By finalDestination = By.id("inpSearchNear");
	private By travellersTextBox = By.id("wizardTravellerSummaryRoom");
	private By childTextBox = By.id("wizardTravellerSummaryChild");
	private By adultTextBox = By.id("wizardTravellerSummaryAdults");
	private By businessTextBox = By.id("wizardTravellerSummaryCabinClass");


	private String getFutureDay(int i){
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, i);
		DateFormat yearLast = new SimpleDateFormat("MM/dd/yyyy");
		return yearLast.format(calendar.getTime());
	}

	private String checkinDate = getFutureDay(0);
	public String checkinDate3 = getFutureDay(3);
	public String checkoutDate7 = getFutureDay(7);



	
	public void clickOnLoginButton() {
		clickOn(loginButton);
	}

	public void enterEmail(String enterEmail) {
		sendText(emailTextField, enterEmail);
	}
	
	public void enterPassword(String enterPassword) {
		sendText(passwordTextField, enterPassword);
	}

	public void enterFirstName(String firstName) {
		sendText(firstNameTextField, firstName);
	}

	public void enterLastName(String lastName) {
		sendText(lastNameTextField, lastName);
	}

	public void enterMobileNumber(String mobileNum) {
		sendText(mobileNumberTextField, mobileNum);
	}

	public void enterNewPassword(String password) {
		sendText(newPasswordTextField, password);
	}
	public void enterOriginDestination(String originDestination){
		sendText(originDestinationTextField, originDestination);
	}
	public void enterFinalDestination(String finalDestination){
		sendText(finalDestinationTextField, finalDestination);
	}


	public void selectDates() throws InterruptedException {

		selectDateFromCalendar(checkinDate3, checkinCalendar, listOfDays);
		selectDateFromCalendar(checkoutDate7, checkoutCalendar, listOfDays);
	}

	public String getErrorMessage() {
		return getTextFromElement(errorMessage);
	}

	public void enterDates() throws InterruptedException{

		enterDate(checkinDate3, checkinCalendar);
		enterDate(checkoutDate7, checkoutCalendar);
	}

	public void selectRooms(String visibleText){
		clickOn(roomsDropdown);
		selectFromDropDown(roomsDropdown, visibleText);
	}
	public void selectAdults(String visibleText){
		clickOn(adultDropdown);
		selectFromDropDown(adultDropdown, visibleText);
	}
	public void selectChildren(String visibleText) {
		clickOn(childrenDropdown);
		selectFromDropDown(childrenDropdown, visibleText);
	}
	public void selectChild1Age(String visibleText){
		clickOn(children1AgeDropdown);

		selectFromDropDown(children1AgeDropdown, visibleText);
	}
	public void selectBusinessFromAdvanceOption(String visibleText){
		clickOn(advanceDropDown);
		selectFromDropDown(advanceDropDown, visibleText);
	}

	public String getSummaryText() {

		return getTextFromElement(originDestination);
	}

	public String getSummaryDatesTextLeaving(){
		return getTextFromElement(verifyDepartingTime);
	}
	public String getSummaryDatesTextReturning(){
		return getTextFromElement(verifyReturningTime);
	}
	public String getSummaryArrivingText(){
		return getTextFromElement(finalDestination);
	}

	public String getSummaryTravelingText(){
		return getTextFromElement1(travellersTextBox);
	}

	public String getSummaryChildText(){
		return getTextFromElement1(childTextBox);
	}

	public String getSummaryAdultText(){
		return getTextFromElement1(adultTextBox);
	}

	public String getSummaryBusinessText(){
		return getTextFromElement1(businessTextBox);
	}
}

//	public String getSummaryDatesText(){
//		return getTextFromElement(summaryDates);
//	}
//
//	public String getSummaryNightsText(){
//		return getTextFromElement(summaryNights);
//	}
//
//	public String getSummaryRoomsText(){
//		return getTextFromElement(summaryRooms);
//	}







