import org.example.ShopPage;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

public class ShopPageTest extends BaseTest {
    ShopPage shopPage;

    @Test
    @DisplayName("User can sort products by Popularity sorting")
    public void sortingByPopularity() {
        shopPage = new ShopPage(driver);

        shopPage.clickDropdown();
        shopPage.selectSortingOptionsInDropdown("popularity");
        assertAll("By Popularity sorting products are 'Ceramic Flower Pot' and 'Minimalist ceramic lamp'",
                () -> assertEquals("Ceramic Flower Pot", shopPage.productName(1), "First product name is not the same"),
                () -> assertEquals("Minimalist ceramic lamp", shopPage.productName(2), "Second product name is not the same")
        );
    }
    @Test
    @DisplayName("User can sort products by Default sorting")
    public void sortingByDefault() {
        shopPage = new ShopPage(driver);

        shopPage.clickDropdown();
        shopPage.selectSortingOptionsInDropdown("menu_order");
        assertAll("Default sorting products are 'Ceramic Flower Pot' and 'Classic TV stand'",
                () -> assertEquals("Ceramic Flower Pot", shopPage.productName(1), "First product name is not the same"),
                () -> assertEquals("Classic TV stand", shopPage.productName(2), "Second product name is not the same")
        );
    }
    @Disabled
    public void sortingByRating() {
        shopPage = new ShopPage(driver);

        shopPage.clickDropdown();
        shopPage.selectSortingOptionsInDropdown("rating");
    }
    @Disabled
    public void sortingByLatest() {
        shopPage = new ShopPage(driver);

        shopPage.clickDropdown();
        shopPage.selectSortingOptionsInDropdown("date");
    }
    @Disabled
    public void sortingByPriceLowToHigh() {
        shopPage = new ShopPage(driver);

        shopPage.clickDropdown();
        shopPage.selectSortingOptionsInDropdown("price");
    }
    @Disabled
    public void sortingByPriceHighToLow() {
        shopPage = new ShopPage(driver);

        shopPage.clickDropdown();
        shopPage.selectSortingOptionsInDropdown("price-desc");
    }
    @Test
    @DisplayName("User can navigate to the next and previous page with numbered buttons")
    public void goingToTheNextPageWithNumberedButton(){
    shopPage = new ShopPage(driver);

    shopPage.getCurrentPageNumberText();
    assertEquals("1", shopPage.getCurrentPageNumberText(), "User is not in the first page!");
    shopPage.clickNumberButtonOfTheOtherPage();
    assertEquals("2", shopPage.getCurrentPageNumberText(), "User is not in the second page!");
    shopPage.clickNumberButtonOfTheOtherPage();
    assertEquals("1", shopPage.getCurrentPageNumberText(), "User is not in the first page!");

    }
    @Test
    @DisplayName("User can navigate to the next and previous page with arrow buttons")
    public void goingToTheNextPageWithArrows() {
        shopPage = new ShopPage(driver);

        shopPage.getCurrentPageNumberText();
        assertEquals("1", shopPage.getCurrentPageNumberText(), "User is not in the first page!");
        shopPage.clickArrowButtonToTheNextPage();
        assertEquals("2", shopPage.getCurrentPageNumberText(), "User is not in the second page!");
        shopPage.clickPreviousPageArrowButton();
        assertEquals("1", shopPage.getCurrentPageNumberText(), "User is not in the first page!");
    }

    @Test
    @DisplayName("User can search product with header search bar")
    public void searchProductsInHeaderBar() {
        shopPage = new ShopPage(driver);
        shopPage.writeProductInHeaderSearchBar("bed");
        assertAll("User is in search results page",
                () -> assertTrue(shopPage.isPageTitleDisplayed(), "Search results title is not displayed!"),
                () -> assertEquals("Search results: “bed”", shopPage.getPageTitle(), "Page title is not the same!")
        );
    }
    @Test
    @DisplayName("User can search product with side menu search bar")
    public void searchProductsInSideMenuSearchBar() {
        shopPage = new ShopPage(driver);

        shopPage.clickSideMenuSearchBar();
        shopPage.writeProductInSideMenuSearchBar("curtains");
        assertAll("User is in search results page",
                () -> assertTrue(shopPage.isPageTitleDisplayed(), "Search results title is not displayed!"),
                () -> assertEquals("Search Results for: curtains", shopPage.getPageTitle(), "Page title is not the same!")
        );
    }
    @Test
    @DisplayName("User can search add more keywords to current search")
    public void addMoreKeywordsToCurrentSearch() {
        shopPage = new ShopPage(driver);

        shopPage.clickSideMenuSearchBar();
        shopPage.writeProductInSideMenuSearchBar("curtains");
        assertAll("User is in search results page",
                () -> assertTrue(shopPage.isPageTitleDisplayed(), "Search results title is not displayed!"),
                () -> assertEquals("Search Results for: curtains", shopPage.getPageTitle(), "Page title is not the same!")
        );
        shopPage.writeProductInSideMenuSearchBar(" brown");
        assertEquals("Search Results for: curtains brown", shopPage.getPageTitle(), "Page title is not the same!");
    }

    @Test
    @DisplayName("User can see chosen product information and add written quantity it to cart")
    public void addToCartWithChangedWrittenQty() {
        shopPage = new ShopPage(driver);

        shopPage.clickProduct(2);
        assertAll("Information about the product",
            () -> assertEquals("Classic TV stand", shopPage.getProductNameInProductPage(), "Page title is not the same!"),
            () -> assertTrue(shopPage.isProductInfoDisplayed(), "Product detailed information is not displayed!"),
            () -> assertTrue(shopPage.getProductCategoryText().contains("Living Room"), "Product category is not the same")
        );
        shopPage.clearInputQty();
        shopPage.writeQty("2");
        shopPage.clickAddToCartFromProductPage();
        assertAll("User added product to the cart",
                () -> assertTrue(shopPage.isAlertDisplayed(), "Alert is not displayed"),
                () -> assertTrue(shopPage.getAlertText().contains("have been added to your cart"), "Alert does not contains \"have been added to your cart\"")
        );
    }
}