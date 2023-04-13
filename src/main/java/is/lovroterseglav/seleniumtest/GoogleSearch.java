package is.lovroterseglav.seleniumtest;

import is.lovroterseglav.seleniumtest.util.SeleniumUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GoogleSearch {
    WebDriver driver;

    GoogleSearch(WebDriver driver) {
        this.driver = driver;
    }

    private void acceptTerms() {
        if (!driver.getPageSource().contains("Preden nadaljujete v Google")) {
            return;
        }
        WebElement consentElement = driver.findElement(By.xpath("//div[text()='Sprejmi vse']"));
        consentElement.click();
    }

    public GoogleSearch search(String searchTerm) {
        driver.get("https://www.google.com");
        acceptTerms();
        WebElement searchForm = driver.findElement(By.name("q"));
        searchForm.sendKeys(searchTerm);
        searchForm.submit();
        return this;
    }

    public GoogleSearch openImagesTab() {
        WebElement imageTab = driver.findElement(By.xpath("//a[text()='Slike']"));
        imageTab.click();
        return this;
    }

    public boolean searchHasImages() {
        return this.openImagesTab().isDisplayingImages();
    }

    private boolean isDisplayingImages() {
        WebElement imageResults = SeleniumUtil.getParentElement(driver.findElement(By.xpath("//h2[text()='Image Results']")));
        List<WebElement> images = imageResults.findElements(By.xpath(".//img"));
        this.quit();
        return !images.isEmpty();
    }

    public void quit() {
        driver.quit();
    }

}
