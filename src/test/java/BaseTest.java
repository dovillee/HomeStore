import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    static WebDriver driver;
    @BeforeEach
    public void seUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://themes.woocommerce.com/homestore/shop/");
    }
//    @AfterEach
//    public void tearDown() {
//        driver.quit();
//    }
}
