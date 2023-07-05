package org.example;

import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ShopPage extends BasePage {
    @FindBy(className = "orderby")
    public WebElement dropdown;
    @FindBy(css = ".product")
    public List<WebElement> productLayout;
    @FindBy(className = "current")
    public WebElement currentPage;
    @FindBy(className = "page-numbers")
    public WebElement pageNumber;
    @FindBy(className = "next")
    public WebElement nextPageButtonArrow;
    @FindBy(className = "prev")
    public WebElement previousArrowButton;
    @FindBy(id = "woocommerce-product-search-field-0")
    public WebElement headerSearchBar;
    @FindBy(className = "page-title")
    public WebElement pageTitle;
    @FindBy(xpath = "//*[@id=\"search-2\"]/form/label/input")
    public WebElement sideMenuSearchBar;
    @FindBy(className = "product_title")
    public WebElement productTitle;
    @FindBy(className = "summary")
    public WebElement productInfo;
    @FindBy(className = "single_add_to_cart_button")
    private WebElement addToCartFromProductPage;
    @FindBy(className = "qty")
    private WebElement inputQty;
    @FindBy(className = "woocommerce")
    private WebElement alert;
    @FindBy(className = "posted_in")
    private WebElement productCategory;

    public ShopPage(WebDriver driver) {
        super(driver);
    }
    public void clickDropdown() {
        dropdown.click();
    }
    public void selectSortingOptionsInDropdown(String value) {
        Select drop = new Select(dropdown);
        drop.selectByValue(value);
    }
    public String productName(int productNumber) {
        return productLayout.get(productNumber - 1)
                .findElement(By.cssSelector(".woocommerce-loop-product__title"))
                .getText();
    }
    public void clickProduct(int productNumber) {
        productLayout.get(productNumber - 1)
                .findElement(By.cssSelector(".woocommerce-loop-product__title"))
                .click();
    }
    public String getProductNameInProductPage() {
        return productTitle.getText();
    }
    public String getCurrentPageNumberText() {
            return currentPage.getText();
    }
    public void clickNumberButtonOfTheOtherPage() {
        pageNumber.click();
    }
    public void clickArrowButtonToTheNextPage() {
        nextPageButtonArrow.click();
    }
    public void clickPreviousPageArrowButton() {
        previousArrowButton.click();
    }
    public void writeProductInHeaderSearchBar(String item) {
        headerSearchBar.sendKeys(item + Keys.ENTER);
    }
    public boolean isPageTitleDisplayed() {
        return pageTitle.isDisplayed();
    }
    public String getPageTitle() {
        return pageTitle.getText();
    }
    public void clickSideMenuSearchBar() {
        sideMenuSearchBar.click();
    }
    public void writeProductInSideMenuSearchBar(String item) {
        sideMenuSearchBar.sendKeys(item + Keys.ENTER);
    }
    public boolean isProductInfoDisplayed() {
        return productInfo.isDisplayed();
    }
    public void clickAddToCartFromProductPage() {
        addToCartFromProductPage.click();
    }
    public void clearInputQty() {
        inputQty.clear();
    }
    public void writeQty(String numberQty) {
        inputQty.sendKeys(numberQty);
    }
    public boolean isAlertDisplayed() {
        return alert.isDisplayed();
    }
    public String getAlertText() {
        return alert.getText();
    }
    public String getProductCategoryText() {
        return alert.getText();
    }
}
