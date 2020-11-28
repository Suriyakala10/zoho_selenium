package com.zoho.show.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignInPage {
    public static final String ZOHO_ACCOUNTS_TITLE = "Zoho Accounts";
    private WebDriver driver;

    @FindBy(id = "login_id")
    private WebElement emailAddress;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "nextbtn")
    private WebElement nextButton;

    public SignInPage(WebDriver driver) {
        this.driver = driver;
    }

    public SignInPage typeEmailAddress(final String emailId) {
        emailAddress.sendKeys(emailId);
        return this;
    }

    public SignInPage typePassword(final String password) {
        boolean staleElement = true;
        while (staleElement) {
            try {
                driver.findElement(By.id("password")).sendKeys(password);
                staleElement = false;
            } catch (StaleElementReferenceException exception) {
                staleElement = true;
            }
        }
        return this;
    }

    public SignInPage clickNextButton() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(nextButton));
        nextButton.click();
        return this;
    }

    public ShowDashboardPage clickNextButtonReturnDashboardPage() {
        clickNextButton();
        return PageFactory.initElements(driver, ShowDashboardPage.class);
    }

    public ShowDashboardPage login(final String emailId, final String password) {
        return this
                .typeEmailAddress(emailId)
                .clickNextButton()
                .typePassword(password)
                .clickNextButtonReturnDashboardPage();
    }

}
