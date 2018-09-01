import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class GoogleSearchTest {

    private WebDriver driver;
    String SearchWord;




    @Before
    public void beforeMethod() {
        driver = new ChromeDriver();
        SearchWord = "e46 buy";

    }

    @Test
    public void testMethod() {
        driver.get("https://www.google.com.ua");
        WebElement searchField = driver.findElement(By.cssSelector("#lst-ib"));
        searchField.sendKeys(SearchWord);
        searchField.sendKeys(Keys.ENTER);
        List<WebElement> searchResult = driver.findElements(By.cssSelector("div.rc"));
        for (WebElement el : searchResult) {
            assertTrue (el.getText().toLowerCase().contains(SearchWord.toLowerCase()));

        }

    }
    @After
    public void afterMethod () {
        driver.quit();


    }

}
