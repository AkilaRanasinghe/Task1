package com.sysco.qe.cura.util;

import com.sysco.qe.cura.exceptions.CustomException;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

import static com.sysco.qe.cura.common.Constants.HOMEPAGEURL;

public class BasePage {

    public static final int TIMEOUT_DEFAULT = 15;

    static String chromeDriverPath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "chromedriver.exe";

    protected static WebDriver driver;

    public static void loadHomePage() {
        webDriverSetup(HOMEPAGEURL);
    }

    public WebElement findElement(By by) {
        return driver.findElement(by);
    }

    public void scrollToElement(By locator) {
        try {
            WebElement element1 = (new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_DEFAULT))).until(ExpectedConditions.visibilityOfElementLocated(locator));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false); window.scrollBy(0, 0);", element1);
        } catch (Exception e) {
            throw new CustomException("Element Not Found. " + e.getMessage());
        }
    }

    public void selectFromDropDown(By locator, String visibleText) {
        if (visibleText != null) {
            waitTillElementLoaded(locator, TIMEOUT_DEFAULT);
            scrollToElement(locator);
            click(locator);
            click(By.xpath(String.format("//select[@id='combo_facility']//option[text()='%s']", visibleText)));
        }
    }

    public boolean isSelected(By by) {
        return this.findElement(by).isSelected();
    }

    public String getText(By by) {
        return this.findElement(by).getText();
    }

    public void performCheckbox(By locator, Boolean check) {
        if (check != null) {
            Boolean actualState = isSelected(locator);
            if (!actualState.equals(check)) {
                click(locator);
            }
            Boolean finalStatus = isSelected(locator);
            if (!finalStatus.equals(check)) {
                throw new CustomException(String.format("Checkbox status(%s) NOT changed as expected(%s)", finalStatus, check));
            }
        }
    }

    public boolean isDisplayed(By by) {
        waitTillElementLoaded(by, 5);
        return this.findElement(by).isDisplayed();
    }

    public WebElement waitTillElementLoaded(By by, long timeout) {
        return (WebElement)(new WebDriverWait(driver, Duration.ofSeconds(timeout))).until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void click(By by) {
        this.findElement(by).click();
    }

    public void clearTextField(By locator) {
        new Actions(driver)
                .click(driver.findElement(locator))
                .pause(200).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
                .pause(200).sendKeys(Keys.BACK_SPACE).perform();
    }

    public void sendKeys(By by, String text) {
        this.clearTextField(by);
        this.findElement(by).sendKeys(new CharSequence[]{text});
    }

    public void enterText(By by, String text) {
        if (text != null) {
            this.findElement(by);
            clearTextField(by);
            sendKeys(by, text);
        }
    }

    private static void webDriverSetup(String url) {
        try {
            closeWindow();
            System.setProperty("webdriver.chrome.driver", chromeDriverPath);
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get(url);
            System.out.println("Web driver successfully setup");
        } catch (CustomException customException) {
            System.out.println("Exception found : " + customException);
        }
    }

    public static void closeWindow() {
        if (driver != null) {
            driver.quit();
        }
    }
}
