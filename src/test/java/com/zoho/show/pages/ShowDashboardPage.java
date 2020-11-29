package com.zoho.show.pages;

import com.zoho.show.utils.DriverUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ShowDashboardPage {
    public static final String ZOHO_ACCOUNTS_TITLE = "Zoho Show";

    private WebDriver driver;

    @FindBy(id="ztb-profile-image")
    private WebElement profileImage;

    @FindBy(xpath="//span[.='Sign Out']")
    private WebElement signOutLink;

    @FindBy(css="i#sortBy > .zs-sortby-icon")
    private WebElement sortByIcon;

    @FindBy(xpath="//z-popover[@id='sortby_popover']//span[.='Date Modified']")
    private WebElement dateModified;

    @FindBy(xpath="//z-popover[@id='sortby_popover']//span[.='Date Opened']")
    private WebElement dateOpened;

    @FindBy(css="button#list > .show-svg-icon")
    private WebElement listView;

    @FindBy(xpath="//*[@id='sortBy']")
    private WebElement sortByArrow;

    @FindBy(xpath="//button[@id='list']")
    private WebElement listButton;

    @FindBy(xpath="//span[@id='zs_title_span']")
    private List<WebElement> presentationsName;

    @FindBy(xpath="//div[@id='owned']//li//span[@class='zs-pre-modified-on ui-left']")
    private List<WebElement> modifiedTime;

    @FindBy(css="div#owned li:nth-of-type(1) > #zs_imgCont")
    private static WebElement slideClick;

    private String currentWindowHandle;

    public ShowDashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    public ShowDashboardPage clickProfileImage() {
        profileImage.click();
        return this;
    }

    public ShowDashboardPage clickSignOutLink() {
        signOutLink.click();
        return this;
    }

    public ShowDashboardPage clickSortByIcon() {
        sortByIcon.click();
        return this;
    }

    public ShowDashboardPage clickDateModified() {
        dateModified.click();
        return this;
    }

    public ShowDashboardPage clickDateOpened() {
        dateOpened.click();
        return this;
    }

    public ShowDashboardPage clickListViewIcon() {
        listView.click();
        return this;
    }

    public ShowDashboardPage clickListViewButton() {
        listButton.click();
        return this;
    }

    public PresentationPage clickFirstSlideIconSwitchToNewTab() {
        slideClick.click();
        currentWindowHandle = new DriverUtils(driver).switchToNewWindowReturnWinHandleBefore();
        new DriverUtils(driver).waitForPageToLoad(30);
        return PageFactory.initElements(driver, PresentationPage.class);
    }

}
