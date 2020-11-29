package com.zoho.show.tests;

import com.zoho.show.base.BaseTest;
import com.zoho.show.pages.PresentationPage;
import com.zoho.show.pages.ShowDashboardPage;
import com.zoho.show.pages.SignInPage;
import com.zoho.show.pages.ZohoShowHomePage;
import com.zoho.show.utils.DriverUtils;
import org.junit.Assert;
import org.testng.annotations.Test;

public class ZohoRegressionTests extends BaseTest {

    @Test
    public void testDSignInSignOut() {
        ZohoShowHomePage homePage = gotoShowHomePage();
        SignInPage signInPage = homePage.clickLoginLink();
        Assert.assertEquals("Title check", getTitle(), SignInPage.ZOHO_ACCOUNTS_TITLE);
        ShowDashboardPage dashboardPage = signInPage
                .typeEmailAddress(testConfigProperties.zohoUserName())
                .clickNextButton()
                .typePassword(testConfigProperties.zohoUserPassword())
                .clickNextButtonReturnDashboardPage();
        // For demo purposes this delay is added
        DriverUtils.delay(1000);
        dashboardPage
                .clickProfileImage()
                .clickSignOutLink();
        // For demo purposes this delay is added
        DriverUtils.delay(3000);
    }

    @Test
    public void testAListingView() {
        ZohoShowHomePage homePage = gotoShowHomePage();
        SignInPage signInPage = homePage.clickLoginLink();
        //DriverUtils.delay(3000);
        ShowDashboardPage dashboardPage =  signInPage.login(testConfigProperties.zohoUserName()
                ,testConfigProperties.zohoUserPassword());
    //    Assert.assertEquals("Title check", getTitle(), SignInPage.ZOHO_ACCOUNTS_TITLE);
        DriverUtils.delay(3000);
        dashboardPage
                .clickSortByIcon()
                .clickDateModified()
                .clickListViewButton();

        // For demo purposes this delay is added
        DriverUtils.delay(6000);
    }

    @Test
    public void testBSlideRightClickLockUnlock() {
        ZohoShowHomePage homePage = gotoShowHomePage();
        SignInPage signInPage = homePage.clickLoginLink();
        //DriverUtils.delay(3000);
        ShowDashboardPage dashboardPage =  signInPage.login(testConfigProperties.zohoUserName()
                ,testConfigProperties.zohoUserPassword());
     //   Assert.assertEquals("Title check", getTitle(), SignInPage.ZOHO_ACCOUNTS_TITLE);
        DriverUtils.delay(3000);
        PresentationPage presentationPage = dashboardPage.clickFirstSlideIconSwitchToNewTab();
        presentationPage
                .clickOnFirstGallerySlide()
                .rightClickOnFirstSlideAndClickLock()
                .mouseHoverOnLockIcon();
        DriverUtils.delay(6000);
    }

    @Test
    public void testCClickPlayOptionButton() {
        ZohoShowHomePage homePage = gotoShowHomePage();
        SignInPage signInPage = homePage.clickLoginLink();
        //DriverUtils.delay(3000);
        ShowDashboardPage dashboardPage =  signInPage.login(testConfigProperties.zohoUserName()
                ,testConfigProperties.zohoUserPassword());
      //  DriverUtils.delay(3000);
       // Assert.assertEquals("Title check", getTitle(), SignInPage.ZOHO_ACCOUNTS_TITLE);
        DriverUtils.delay(3000);
        PresentationPage presentationPage = dashboardPage.clickFirstSlideIconSwitchToNewTab();
        presentationPage
                .clickOnFirstGallerySlide()
                .clickPlayOption();
               // .PlayOptionButtonClick();
        DriverUtils.delay(6000);
    }

    @Test
    public void testDSlideRightClickAndAddComment() {
        ZohoShowHomePage homePage = gotoShowHomePage();
        SignInPage signInPage = homePage.clickLoginLink();
        //DriverUtils.delay(3000);
        ShowDashboardPage dashboardPage =  signInPage.login(testConfigProperties.zohoUserName()
                ,testConfigProperties.zohoUserPassword());
       // Assert.assertEquals("Title check", getTitle(), SignInPage.ZOHO_ACCOUNTS_TITLE);
        DriverUtils.delay(3000);
        PresentationPage presentationPage = dashboardPage.clickFirstSlideIconSwitchToNewTab();
        presentationPage
                .clickOnFirstGallerySlide()
                .rightClickOnAndAddComment();
        DriverUtils.delay(6000);
    }
}
