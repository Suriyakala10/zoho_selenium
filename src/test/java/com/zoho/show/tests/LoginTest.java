package com.zoho.show.tests;

import com.zoho.show.base.BaseTest;
import com.zoho.show.pages.ShowDashboardPage;
import com.zoho.show.pages.SignInPage;
import com.zoho.show.pages.ZohoShowHomePage;
import com.zoho.show.utils.DriverUtils;
import org.junit.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void testSignInSignOut() {
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
    public void testListingView() {
        ZohoShowHomePage homePage = gotoShowHomePage();
        SignInPage signInPage = homePage.clickLoginLink();
        //DriverUtils.delay(3000);
        ShowDashboardPage dashboardPage =  signInPage.login(testConfigProperties.zohoUserName()
                ,testConfigProperties.zohoUserPassword());
        Assert.assertEquals("Title check", getTitle(), SignInPage.ZOHO_ACCOUNTS_TITLE);
        DriverUtils.delay(3000);
        dashboardPage
                .clickSortByIcon()
                .clickDateModified()
                .clickListViewButton();

        // For demo purposes this delay is added
        DriverUtils.delay(6000);
    }
}
