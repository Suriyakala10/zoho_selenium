package com.zoho.show.base;

import com.zoho.show.pages.ZohoShowHomePage;
import org.aeonbits.owner.ConfigCache;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    private static final String BASE_URL  = "https://www.zoho.com/show/";
    protected static WebDriver driver;
    public static final TestConfig testConfigProperties = ConfigCache.getOrCreate(TestConfig.class);
    public static final String ZOHO_SHOW_HOME_PAGE_TITLE = "Online Presentation Software | Create & Edit Slides Online - Zoho Show";

    @BeforeMethod
    public static void setUpDriver() {
        // System.setProperty("webdriver.chrome.driver",
        // "C:/SeleniumRC/tools/chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public static void tearDownDriver() {
        driver.close();  // close the default window
        driver.quit();  // close the session
    }

    public ZohoShowHomePage gotoShowHomePage() {
        driver.get(testConfigProperties.baseUrl());
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.titleIs(ZOHO_SHOW_HOME_PAGE_TITLE));
        Assert.assertEquals("Title check", driver.getTitle(), ZOHO_SHOW_HOME_PAGE_TITLE);
        return PageFactory.initElements(driver, ZohoShowHomePage.class);
    }

    public String getTitle() {
        return driver.getTitle();
    }
}
