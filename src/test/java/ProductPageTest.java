import org.example.ProductPage;
import org.example.ShopPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductPageTest extends  BaseTest {
    ShopPage shopPage;
    ProductPage productPage;
    @BeforeEach
    public void setUp() {
        shopPage = new ShopPage(driver);
        productPage = new ProductPage(driver);
    }
    @Test
    public void productInfoAndAddToCartTest() {
        productPage.isProductSummaryDisplayed();
    }
}
