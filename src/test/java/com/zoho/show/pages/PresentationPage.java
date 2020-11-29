package com.zoho.show.pages;

import com.zoho.show.utils.DriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PresentationPage {

    private WebDriver driver;

    @FindBy(xpath="//div[contains(@class,'ui-zthumbnail-selected')]/div[@class='thumbnail_scrollable']")
    private WebElement firstGallerySlide;

    @FindBy(css = ".ui-lock-thumbnail")
    private WebElement unlockIcon;

    @FindBy(css="button.ui-slideshow-button > .show-svg-icon")
    private WebElement playOption;

    //#textEditingDiv
    @FindBy(css="#textEditingDiv")
    private WebElement addComment;

    public PresentationPage(WebDriver driver) {
        this.driver = driver;
    }

    public PresentationPage clickOnFirstGallerySlide() {
        this.firstGallerySlide.click();
        return this;
    }

    public PresentationPage rightClickOnFirstSlideAndClickLock() {
        new DriverUtils(driver).rightClickAndSelectOption(this.firstGallerySlide,8);
        return this;
    }

    public PresentationPage rightClickOnAndAddComment() {
        new DriverUtils(driver).rightClickAndSelectOption(this.firstGallerySlide,11);
        return this;
    }

    public PresentationPage mouseHoverOnLockIcon() {
        new DriverUtils(driver).mouseHover(this.unlockIcon);
        this.unlockIcon.click();
        return this;
    }

    public PresentationPage clickPlayOption() {
        this.playOption.click();
        return this;
    }

    public PresentationPage typeComment(final String comment) {
        boolean staleElement = true;
        while (staleElement) {
            try {
                driver.findElement(By.cssSelector("#textEditingDiv")).sendKeys(comment);
                staleElement = false;
            } catch (StaleElementReferenceException exception) {
                staleElement = true;
            }
        }
        return this;
    }




    // public PresentationPage PlayOptionButtonClick() {
    //  new DriverUtils(driver).selectOption(this.playOption,1);
   //   return this;
 //  }

}
