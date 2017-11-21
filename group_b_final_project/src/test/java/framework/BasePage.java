package framework;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.google.common.base.Function;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import stepdefinition.SharedSD;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by kennethng on 11/19/17.
 */
public class BasePage {private static WebElement webAction(final By locator) {
    Wait<WebDriver> wait = new FluentWait<WebDriver>(SharedSD.getDriver())
            .withTimeout(15, TimeUnit.SECONDS)
            .pollingEvery(1, TimeUnit.SECONDS)
            .ignoring(java.util.NoSuchElementException.class)
            .ignoring(StaleElementReferenceException.class)
            .ignoring(ElementNotFoundException.class)
            .withMessage(
                    "Webdriver waited for 15 seconds but still could not find the element therefore Timeout Exception has been thrown");

    WebElement element = wait.until(new Function<WebDriver, WebElement>() {
        public WebElement apply(WebDriver driver) {
            return driver.findElement(locator);
        }
    });

    return element;
}




    public void selectDateFromCalendar(String dateToSelect, By calendarField, By listOfDays) throws InterruptedException {

        Thread.sleep(3000);
        SharedSD.getDriver().findElement(calendarField).click();
        System.out.println(dateToSelect);

        //Fluent wait is not implemented here
        List<WebElement> days = SharedSD.getDriver().findElements(listOfDays);
//        System.out.println(days);

        for (WebElement day : days) {
            String expectedDay = day.getAttribute("data-day");
//			System.out.println(expectedDay);
            if (expectedDay.equals(dateToSelect)) {
                day.click();
                break;
            }
        }
    }


    public void clickOn(By locator) {
        try {
            SharedSD.getDriver().findElement(locator).click();
        } catch (NoSuchElementException e) {
            Assert.fail("Element is not found with this locator: " + locator.toString());
            e.printStackTrace();
        }
    }

    public void sendText(By locator, String text) {
        try {
            SharedSD.getDriver().findElement(locator).sendKeys(text);
        } catch (NoSuchElementException e) {
            Assert.fail("Element is not found with this locator: " + locator.toString());
            e.printStackTrace();
        }
    }

    public void clearText(By locator) {
        try {
            SharedSD.getDriver().findElement(locator).clear();
        } catch (NoSuchElementException e) {
            Assert.fail("Element is not found with this locator: " + locator.toString());
            e.printStackTrace();
        }
    }

    public void enterDate(String date, By calendarField) throws InterruptedException {
        clickOn(calendarField);
        clearText(calendarField);
        sendText(calendarField, date);

    }

    public String getTextFromElement(By locator) {
        String text = null;
        try {
            text = webAction(locator).getText();
        } catch (NoSuchElementException e) {
            Assert.fail("Element is not found with this locator: " + locator.toString());
            e.printStackTrace();
        }

        return text;
    }




    //SELECT AN OPTION FROM A DROPDOWN BY TEXT
    public void selectFromDropDown(By dropdownField, String visibleText) {
        // Select value from drop
        Select dropdown = new Select(SharedSD.getDriver().findElement(dropdownField));
        // Select element by visible text
        dropdown.selectByVisibleText(visibleText);
    }

    //SELECT AN OPTION FROM A DROPDOWN BY INDEX
    public void selectFromDropDown(By dropdownField, int index) {
        // Select value from drop
        Select dropdown = new Select(SharedSD.getDriver().findElement(dropdownField));
        // Select element by index
        dropdown.selectByIndex(index);
    }



    public void clickOnBrowserBackArrow() {
        SharedSD.getDriver().navigate().back();
    }

    public void clickOnBrowserForwardArrow() {
        SharedSD.getDriver().navigate().forward();
    }

    public void refreshBrowser() {
        SharedSD.getDriver().navigate().refresh();
    }



}

