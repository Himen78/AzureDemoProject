package com.automation.tests;

import com.automation.Utils.BaseTest;
import com.automation.Utils.FlipkartHomePage;
import com.automation.Utils.SearchResultsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FlipkartTests extends BaseTest {

    @Test
    public void testSearchForProduct() {
        driver.get("https://www.flipkart.com");
        FlipkartHomePage homePage = new FlipkartHomePage(driver);
        homePage.searchFor("laptop");

        SearchResultsPage resultsPage = new SearchResultsPage(driver);
        String firstProductTitle = resultsPage.getFirstProductTitle();
        Assert.assertTrue(firstProductTitle.toLowerCase().contains("laptop"), "Product title does not contain the search term.");
    }

    @Test
    public void testSearchForDifferentProduct() {
        driver.get("https://www.flipkart.com");
        FlipkartHomePage homePage = new FlipkartHomePage(driver);
        homePage.searchFor("headphones");

        SearchResultsPage resultsPage = new SearchResultsPage(driver);
        String firstProductTitle = resultsPage.getFirstProductTitle();
        Assert.assertTrue(firstProductTitle.toLowerCase().contains("headphones"), "Product title does not contain the search term.");
    }

    @Test
    public void testEmptySearch() {
        driver.get("https://www.flipkart.com");
        FlipkartHomePage homePage = new FlipkartHomePage(driver);
        homePage.searchFor("");
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("flipkart.com"), "Search resulted in an unexpected URL.");
    }
}
