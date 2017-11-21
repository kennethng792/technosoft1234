package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.HomePage;
import framework.LoginPage;
import framework.TestRunner;
import org.openqa.selenium.By;
import org.testng.Assert;
import static org.junit.Assert.assertThat;

import static org.hamcrest.CoreMatchers.containsString;
import static org.testng.Assert.assertTrue;

/**
 * Created by mohammadmuntakim on 6/9/17.
 */
public class LoginSD {

    private HomePage homePage = new HomePage();
    private LoginPage loginPage = new LoginPage();

    private String valueToBeSelected = "Charlotte, NC, United States (CLT-Charlotte-Douglas Intl.)";
    private String expectedSummaryArrivingText = "New York ";
    private String expectedSummaryTravelingText = "1 room";
    private String expectedSummaryChildText = "1 child";
    private String expectedSummaryAdultText = "1 adult";
    private String expectedSummaryBusinessText = "Business";


    @Given("^I am on home page$")
    public void iAmOnHomePage() {
        Assert.assertEquals(SharedSD.getDriver().getTitle(), "Facebook - Log In or Sign Up", "Invalid Home Page");
    }

    @Given("^I am on search vacation package$")
    public void iAmOnVacationPage() {
        Assert.assertEquals(SharedSD.getDriver().getTitle(), "Vacation Packages: Find Cheap Trips, Deals & Vacations | Hotels.com", "Invalid Home Page");
    }

    @When("^I enter (.+) into (username|password|firstname|lastname|mobile number|new password|origin destination|final destination) text fields on home screen$")
    public void enterDataIntoTextFields(String anyText, String textFields) {

        switch (textFields) {
            case "username":
                homePage.enterEmail(anyText);
                break;
            case "password":
                homePage.enterPassword(anyText);
                break;
            case "firstname":
                homePage.enterFirstName(anyText);
                break;
            case "lastname":
                homePage.enterLastName(anyText);
                break;
            case "mobile number":
                homePage.enterMobileNumber(anyText);
                break;
            case "new password":
                homePage.enterNewPassword(anyText);
                break;
            case "origin destination":
                homePage.enterOriginDestination(anyText);
                break;
            case "final destination":
                homePage.enterFinalDestination(anyText);
                break;
        }
    }


    @When("^I click on (login|create account|flight/hotel|Search) button$")
    public void clickOnLoginButton(String button) throws InterruptedException {

        switch (button) {
            case "flight/hotel":
                homePage.clickOn(By.id("tab-flightHotel-tab"));
                break;
            case "login":
                homePage.clickOnLoginButton();
                break;
            case "create account":
                //Implement Create account object
                break;
            case "Search":
                homePage.clickOn(By.id("search-button"));
                break;

        }
        Thread.sleep(10000);

    }

    @When("^I select dates from calendar on home screen")
    public void selectDates() throws InterruptedException {
        homePage.selectDates();

    }

    @When("^I enter dates to calendar")
    public void enterDates() throws InterruptedException {
        homePage.enterDates();
    }

    @When("^I select (.+) from (|rooms|adult|children|child1age) dropdown button$")
    public void selectFromDropdown(String anyText, String dropdowns) throws InterruptedException {

        switch (dropdowns) {
            case "rooms":
                homePage.selectRooms(anyText);
                break;
            case "adult":
                homePage.selectAdults(anyText);
                break;
            case "children":
                homePage.selectChildren(anyText);
                homePage.clickOn(By.id("wizard-theme-wrapper"));
                Thread.sleep(3000);
                break;
            case "child1age":
                homePage.clickOn(By.id("package-1-age-select-1"));
                homePage.selectChild1Age(anyText);
                break;
//            case "kid2Age":
//                hotels_homePage.selectKid2Age(anyText);
//                break;

        }
    }

    @When("^I click on Advanced dropdown button select (Business)$")
    public void selectBusinessFromDropdown(String anyText){
        homePage.selectBusinessFromAdvanceOption(anyText);
    }

    @Then("^I verify that (departing|dates|arriving|occupancy|traveling|1room|1child|1adult|business) text displayed what's expected$")
    public void verifyText(String summaries) {

        switch (summaries) {
            case "departing":

                homePage.clickOn(By.id("inpSearchFrom"));
                Assert.assertEquals(homePage.getSummaryText(),valueToBeSelected);
                break;

            case "dates":
                Assert.assertEquals(homePage.getSummaryDatesTextLeaving(), homePage.checkinDate3);
                Assert.assertEquals(homePage.getSummaryDatesTextReturning(), homePage.checkoutDate7);

                break;
            case "arriving":
                assertTrue(homePage.getSummaryArrivingText().contains(expectedSummaryArrivingText));
                break;
            case "1room":
                assertTrue(homePage.getSummaryTravelingText().contains(expectedSummaryTravelingText));
                break;
            case "1child":
                assertTrue(homePage.getSummaryChildText().contains(expectedSummaryChildText));
                break;
            case "1adult":
                assertTrue(homePage.getSummaryAdultText().contains(expectedSummaryAdultText));
                break;
            case "business":
                assertTrue(homePage.getSummaryBusinessText().contains(expectedSummaryBusinessText));
                break;


        }
    }



    @Then("^I verify that i am an invalid login page$")
    public void verifyInvalidLoginPage() {
        Assert.assertEquals(loginPage.getPageHeader(), "Log into Facebook");
    }

    @Then("^I see number [0-9] in text field$")
    public void textField(int num) {

    }

    @Then("^I verify invalid signup error message$")
    public void verifySignUpErrorMessage() {
        Assert.assertEquals(homePage.getErrorMessage(), "Invalid signup");
    }
}
