package com.zoho.show.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ZohoShowHomePage {

    private WebDriver driver;

    @FindBy(xpath="//div[@class='zgh-utilities']//a[.='LOGIN']")
    private WebElement loginLink;


    public ZohoShowHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public SignInPage clickLoginLink() {
        loginLink.click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.titleIs(SignInPage.ZOHO_ACCOUNTS_TITLE));
        return PageFactory.initElements(driver, SignInPage.class);
    }

}
