package com.automation.Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FlipkartHomePage {

    private WebDriver driver;

    private By searchBox = By.name("q");
    private By searchButton = By.cssSelector("button[type='submit']");

    public FlipkartHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchFor(String query) {
        WebElement searchInput = driver.findElement(searchBox);
        searchInput.clear();
        searchInput.sendKeys(query);
        driver.findElement(searchButton).click();
    }

}
