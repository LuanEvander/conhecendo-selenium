package br.edu.resolucaoproblemas;

import org.openqa.selenium.edge.EdgeDriver;
import java.util.List;
import org.openqa.selenium.*;

public class App {
    public static void main(String[] args) throws Exception {
        System.setProperty("webdriver.edge.driver", "B:/Selenium/msedgedriver.exe");
        EdgeDriver driver = new EdgeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.kabum.com.br");

        // Faz busca por produtos
        WebElement caixaDeBusca = driver.findElement(By.id("input-busca"));
        caixaDeBusca.click();
        caixaDeBusca.sendKeys("notebook");
        caixaDeBusca.sendKeys(Keys.ENTER);
        Thread.sleep(2000);

        List<WebElement> pagination =
                driver.findElements(By.xpath("//*[@id='listingPagination']/ul"));
        int pgSize = pagination.size();
        for (int j = 1; j < pgSize; j++) {
            Thread.sleep(1000);
            WebElement pageIndex =
                    driver.findElement(By.xpath("(//*[@id='listingPagination']/ul)[" + j + "]"));
            pageIndex.click();
            //*[@id="listingPagination"]/ul/li[3]/a
        }
    }
}
