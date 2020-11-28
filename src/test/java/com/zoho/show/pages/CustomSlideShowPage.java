package com.zoho.show.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CustomSlideShowPage {

    public static final String ZOHO_ACCOUNTS_TITLE = "Zoho Show";

    private WebDriver driver;

    @FindBy(css=".ui-left[data-title='Example2']")
    private WebElement presentationSlide;

    @FindBy(id="slideshow-setup")
    private WebElement playOption;

    public CustomSlideShowPage(WebDriver driver) {
        this.driver = driver;
    }

    public CustomSlideShowPage clickPresentationSlide() {
        presentationSlide.click();
        return this;
    }
}
