package com.automation.Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultsPage {

    private WebDriver driver;

    private By firstProduct = By.cssSelector("span[class*=BUOuZu]");

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getFirstProductTitle() {
        return driver.findElement(firstProduct).getText();
    }

}
