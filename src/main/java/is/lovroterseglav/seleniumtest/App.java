package is.lovroterseglav.seleniumtest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class App {
    public static final String ANIMAL = "pes";
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();


        boolean hasImages = new GoogleSearch(driver).search(ANIMAL).searchHasImages();
        String res = hasImages ? "Images found" : "Images not found";
        System.out.println(res);
    }


}

