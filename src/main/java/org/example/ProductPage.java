package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {
    @FindBy(className = "summary")
    private WebElement productSummary;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public boolean isProductSummaryDisplayed() {
        return productSummary.isDisplayed();
    }
}
