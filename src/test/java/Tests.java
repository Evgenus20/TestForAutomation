import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Tests extends DefaultSettings {

    @Test()
    public void Test1() {
        driver.get("https://google.com");
        //String title = driver.getTitle();
        //Assert.assertTrue(title.equals("Google"));
        driver.findElement(By.xpath("//input[contains(@type, 'text')]")).sendKeys("automation", Keys.ENTER);
        List<WebElement> links = driver.findElements(By.xpath("//h3"));
        links.get(0).click();
        String titleOfThePage = driver.getTitle();
        Assert.assertTrue(titleOfThePage.toLowerCase().contains("automation"));

    }

    @Test
    public void Test2() {
        String siteName = "testautomationday.com";
        driver.get("https://google.com");
        driver.findElement(By.xpath("//input[contains(@type, 'text')]")).sendKeys("automation", Keys.ENTER);
        outer:
        {
            boolean isContain = false;
            for (int n = 1; n < 5; n++){
                List<WebElement> cite = driver.findElements(By.tagName("cite"));
                for (int i = 0; i < cite.size(); i++) {
                    String nameOfTheSite = cite.get(i).getText();
                    isContain = nameOfTheSite.contains(siteName);
                    if (isContain) {
                        Assert.assertTrue(nameOfTheSite.equals(siteName));
                        break outer;
                    }
                }
                driver.findElement(By.xpath("//a/span[contains(@style, 'display:block;margin-left:53px')]")).click();
            }
            System.out.println("The website " + siteName + " was not found on first 5 pages");
            Assert.assertTrue(isContain);
        }
    }
}