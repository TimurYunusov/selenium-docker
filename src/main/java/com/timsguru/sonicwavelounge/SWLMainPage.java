package com.timsguru.sonicwavelounge;

import com.timsguru.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SWLMainPage extends AbstractPage {

    @FindBy(tagName="title")
    private WebElement pageTitle;


    public SWLMainPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isAt() {
        this.wait.until(ExpectedConditions.visibilityOf(this.pageTitle));
        return this.pageTitle.isDisplayed();
    }

    public void goTo(String url){
        this.driver.get(url);
    }

    public String getPageTitle(){
        return this.driver.getTitle();
    }
}
