package com.zoho.show.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

/**
 * The type Driver utils.
 */
public class DriverUtils {

    private WebDriver driver;
    /**
     * The Browser type.
     */
    private String browserType;
    /**
     * The constant SERV_PROP_FILE.
     */
    public static final String SERV_PROP_FILE = "develop.properties";
    private Properties props;

    /**
     * Instantiates a new Driver utils.
     *
     * @param driver the driver
     */
    public DriverUtils(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Is element present boolean.
     *
     * @param by the by
     * @return the boolean
     */
    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    /**
     * Is alert present boolean.
     *
     * @return the boolean
     */
    public boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    /**
     * Close alert and get its text string.
     *
     * @param acceptNextAlert the accept next alert
     * @return the string
     */
    public String closeAlertAndGetItsText(boolean acceptNextAlert) {
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        if (acceptNextAlert) {
            alert.accept();
        } else {
            alert.dismiss();
        }
        return alertText;
    }

    /**
     * Gets base url.
     *
     * @return the base url
     */
    public String getBaseUrl() {
        props = new Properties();
        try {
            props.load(new FileInputStream(SERV_PROP_FILE));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return props.getProperty("url");
    }


    /**
     * Clear and type.
     *
     * @param field the field
     * @param text  the text
     */
    public void clearAndType(WebElement field, String text) {
        field.clear();
        field.sendKeys(text);
    }

    /**
     * Gets date time stamp.
     *
     * @return the date time stamp
     */
    public String getDateTimeStamp() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHmmss");
        Date today = new Date();
        return formatter.format(new java.sql.Timestamp(today.getTime()));
    }

    /**
     * Is element present boolean.
     *
     * @param driver the driver
     * @param by     the by
     * @return the boolean
     */
    public boolean isElementPresent(WebDriver driver, By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     * Select option.
     *
     * @param driver        the driver
     * @param selectOption  the select option
     * @param selectLocator the select locator
     */
    public void selectOption(WebDriver driver, final String selectOption,
                             final String selectLocator) {
        Select select = new Select(driver.findElement(By.name(selectLocator)));
        select.selectByVisibleText(selectOption);
    }

    /**
     * Select option.
     *  @param selectedElement the selected element
     * @param selectOption    the select option
     */
   public void selectOption(WebElement selectedElement, final int selectOption) {
       Select select = new Select(selectedElement);
      select.selectByVisibleText(String.valueOf(selectOption));
    }

    /**
     * Is text present boolean.
     *
     * @param driver the driver
     * @param Text   the text
     * @return the boolean
     */
    public boolean isTextPresent(WebDriver driver, String Text) {
        try {
            return driver.findElement(By.tagName("body")).getText()
                    .contains(Text);
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     * Wait for text.
     *
     * @param text       the text
     * @param by         the by
     * @param timeoutMsg the timeout msg
     * @throws Exception the exception
     */
    public void waitForText(String text, By by,
                            String timeoutMsg) throws Exception {
        for (int second = 0; ; second++) {
            if (second >= 60)
                fail(timeoutMsg);
            try {
                if (text.equals(driver.findElement(by).getText()))
                    break;
            } catch (Exception e) {
            }
            delay(1000);
        }
    }

    /**
     * Delay.
     *
     * @param seconds the seconds
     */
    public static void delay(int seconds) {
        try {
            Thread.sleep(seconds);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Click at.
     *
     * @param driver   the driver
     * @param byMethod the by method
     */
    public void clickAt(final WebDriver driver, final By byMethod) {
        final WebElement element = driver.findElement(byMethod);
        final Actions builder = new Actions(driver);
        final Action action = builder.moveToElement(element).click().build();
        action.perform();
    }

    /**
     * Click at.
     *
     * @param driver  the driver
     * @param by      the by
     * @param xOffset the x offset
     * @param yOffset the y offset
     */
    public void clickAt(WebDriver driver, By by, int xOffset, int yOffset) {
        WebElement element = driver.findElement(by);
        Actions builder = new Actions(driver);
        Action action = builder.moveToElement(element, 10, 10).click().build();
        action.perform();
    }

    /**
     * Click at.
     *
     * @param driver  the driver
     * @param element the element
     */
    public void clickAt(final WebDriver driver, final WebElement element) {
        final Actions builder = new Actions(driver);
        final Action action = builder.moveToElement(element).click().build();
        action.perform();
    }

    /**
     * Click at.
     *
     * @param driver  the driver
     * @param element the element
     * @param xOffset the x offset
     * @param yOffset the y offset
     */
    public void clickAt(final WebDriver driver, final WebElement element, final int xOffset,
                        final int yOffset) {
        final Actions builder = new Actions(driver);
        final Action action = builder.moveToElement(element, xOffset, yOffset).click().build();
        action.perform();
    }

    /**
     * Js click.
     *
     * @param element the variants record
     * @param driver  the driver
     * @throws InterruptedException the interrupted exception
     */
    public static void jsClick(final WebElement element, final WebDriver driver) throws InterruptedException {
        final JavascriptExecutor executor = (JavascriptExecutor) driver;
        ((RemoteWebDriver) executor).executeScript("arguments[0].click();", element);
    }

    /**
     * Js click by id.
     *
     * @param locatorId the locator id
     * @param driver    the driver
     * @throws InterruptedException the interrupted exception
     */
    public static void jsClickById(final String locatorId, final WebDriver driver) throws InterruptedException {
        final JavascriptExecutor executor = (JavascriptExecutor) driver;
        ((RemoteWebDriver) executor).executeScript("return document.getElementById('" + locatorId + "').click();");
    }

    /**
     * Reduce implicit wait.
     *
     * @param driver                the driver
     * @param timeToReduceInSeconds the time to reduce in seconds
     */
    public static void reduceImplicitWait(WebDriver driver, final int timeToReduceInSeconds) {
        driver.manage().timeouts().implicitlyWait(timeToReduceInSeconds, TimeUnit.SECONDS);
    }

    /**
     * Gets driver.
     *
     * @return the driver
     */
    public WebDriver getDriver() {
        return driver;
    }

    /**
     * Sets driver.
     *
     * @param driver the driver
     * @return the driver
     */
    public DriverUtils setDriver(WebDriver driver) {
        this.driver = driver;
        return this;
    }

    /**
     * Gets browser type.
     *
     * @return the browser type
     */
    public String getBrowserType() {
        return browserType;
    }

    /**
     * Sets browser type.
     *
     * @param browserType the browser type
     * @return the browser type
     */
    public DriverUtils setBrowserType(String browserType) {
        this.browserType = browserType;
        return this;
    }

    /**
     * Gets props.
     *
     * @return the props
     */
    public Properties getProps() {
        return props;
    }

    /**
     * Sets props.
     *
     * @param props the props
     * @return the props
     */
    public DriverUtils setProps(Properties props) {
        this.props = props;
        return this;
    }

    /**
     * Right click.
     *
     * @param element the element
     */
    public void rightClick(final WebElement element) {
        final Actions action = new Actions(driver).contextClick(element);
        action.build().perform();
    }

    /**
     * Right click and select an option. If you want to click on the first option of
     * the right click send 1 as a value to OptionToSelect If you want to click on
     * the third option of the right click send 3 as a value of the OptionToSelect
     * Note: If an item is disabled in the right click, don't count it.
     *
     * @param driver         the driver
     * @param element        the element
     * @param OptionToSelect the option to select
     */
    public void rightClickAndSelectOption(final WebDriver driver, final WebElement element, final int OptionToSelect) {
        final Actions action = new Actions(driver).contextClick(element);
        for (int i = 0; i < OptionToSelect; i++) {
            action.sendKeys(Keys.ARROW_DOWN);
        }
        action.build().perform();
    }

    /**
     * Right click and select option. If you want to click on the first option of
     * the right click send 1 as a value to OptionToSelect If you want to click on
     * the third option of the right click send 3 as a value of the OptionToSelect
     * Note: If an item is disabled in the right click, don't count it.
     *
     * @param element        the element
     * @param OptionToSelect the option to select
     */
    public void rightClickAndSelectOption(final WebElement element, final int OptionToSelect) {
        final Actions action = new Actions(driver);
        action.contextClick(element).build().perform();
        for (int i = 0; i < OptionToSelect; i++) {
            action.sendKeys(Keys.ARROW_DOWN).build().perform();
        }
        action.sendKeys(Keys.ENTER).build().perform();
    }


    /**
     * Switch to new window close old window.
     */
    public void switchToNewWindowCloseOldWindow() {
        // assume there are 2 windows open and the focus is on the "old" window
        String currentTab = driver.getWindowHandle();
        System.out.println("switchToNewWindowCloseOldWindow: currentTab = " + currentTab);
        String newTab = driver.getWindowHandles().stream().filter(tab -> !currentTab.equals(tab)).findFirst().get();
        driver.close();
        driver.switchTo().window(newTab);
    }

    /**
     * Clicks a link which opens in a new tab. Switches to the new tab.
     *
     * @param by the By for the link
     * @return window handle of original tab
     */
    public String clickLinkToNewTab(By by) {
        String oldTab = driver.getWindowHandle();
        driver.findElement(by).click();
        Set<String> handles = driver.getWindowHandles();
        handles.remove(oldTab);
        driver.switchTo().window((String) handles.toArray()[0]);
        waitForPageToLoad(30);
        return oldTab;
    }

    /**
     * Close and return to source tab.
     *
     * @param handle the handle
     */
    public void closeAndReturnToSourceTab(String handle) {
        driver.close();
        driver.switchTo().window(handle);
    }

    /**
     * Switch to new window return win handle before.
     *
     * @return the string
     */
    public String switchToNewWindowReturnWinHandleBefore() {
        // Store the current window handle
        final String winHandleBefore = driver.getWindowHandle();
        // Perform the click operation that opens new window
        // Switch to new window opened
        for (final String winHandle : driver.getWindowHandles()) {
            if (!winHandleBefore.equals(winHandle) )
                driver.switchTo().window(winHandle);
        }
        return winHandleBefore;
    }

    /**
     * Switch to window based on title.
     *
     * @param windowTitleWhereToBeSwitched the window title where to be switched
     * @return true, if successful
     */
    public boolean switchToWindowBasedOnTitle(final String windowTitleWhereToBeSwitched) {
        boolean switchedToWin = false;
        try {
            final Set<String> totalwindows = driver.getWindowHandles();
            final int count = totalwindows.size();
            System.out.println("total windows count: " + count);
            for (final String child : totalwindows) {
                driver.switchTo().window(child);
                final String curTitle = driver.getTitle();
                if (curTitle.contains(windowTitleWhereToBeSwitched)) {
                    switchedToWin = true;
                    break;
                }
            }
        } catch (final Exception e) {
            System.out.println(e.getMessage());
        }
        return switchedToWin;
    }

    /**
     * Switch to window by win handler.
     *
     * @param winHandler the win handler
     */
    public void switchToWindowByWinHandler(final String winHandler) {
        driver.switchTo().window(winHandler);
    }

    /**
     * This method could be used only browser based, not for head-less browsers
     * If the timeOut Exceeds, this method will make your test case to fail.
     *
     * @param timeOutInSecs the time out in secs
     */
    public void waitForPageToLoad(final long timeOutInSecs) {
        final ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            /***
             * (non-Javadoc)
             *
             * @see com.google.common.base.Function#apply(java.lang.Object)
             */
            @Override
            public Boolean apply(final WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        final Wait<WebDriver> wait = new WebDriverWait(driver, timeOutInSecs);
        try {
            wait.until(expectation);
        } catch (final Throwable error) {
            delay(2000);
        }
    }

    public static void enterKey()  {
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    public static void rightClick() throws AWTException {
        final Robot robot = new Robot();
        robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
        robot.delay(200);
        robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
        robot.delay(200);
    }

    public static void downKey(int times) {
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        for (int i =0; i < times; i++) {
            robot.keyPress(KeyEvent.VK_DOWN);
            robot.keyRelease(KeyEvent.VK_DOWN);
        }
    }

    /**
     * Mouse hover.
     *
     * @param element the element
     */
    public void mouseHover(final WebElement element) {
        final Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
        delay(3);
    }

}