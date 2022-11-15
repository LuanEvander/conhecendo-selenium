package br.edu.resolucaoproblemas;

import org.testng.annotations.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;

public class AppTest {
    private WebDriver driver;
    private final String DRIVER_PATH = "B:/Selenium/msedgedriver.exe";
    private final String CSV_PATH = "teste.csv";

    @BeforeClass
    public void openBrowser() throws Exception {
        System.setProperty("webdriver.edge.driver", DRIVER_PATH);
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://practice.automationtesting.in/my-account/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterClass
    public void closeBrowser() throws Exception {
        driver.quit();
    }

    @Test
    public void loginWithEmptyFields()
            throws InterruptedException, CsvValidationException, IOException {
        CSVReader reader = new CSVReader(new FileReader(CSV_PATH));
        String[] tableline = null;

        while ((tableline = reader.readNext()) != null) {
            for (int i = 0; i < 1; i++) {

                WebElement emailTextBox = driver.findElement(By.id("username"));
                emailTextBox.sendKeys("");

                WebElement passwordTextBox = driver.findElement(By.id("password"));
                passwordTextBox.sendKeys("");

                WebElement loginButton = driver.findElement(By.name("login"));
                loginButton.click();

                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

                WebElement errorMessage = driver.findElement(By
                        .xpath("//*[@id='page-36']/div/div[1]/ul"));

                String errorMessagetext = errorMessage.getText();
                String expectedMessage = tableline[1];

                assertEquals(expectedMessage, errorMessagetext);
            }
        }
    }

    @Test
    public void loginWithEmptyEmail()
            throws InterruptedException, CsvValidationException, IOException {
        CSVReader reader = new CSVReader(new FileReader(CSV_PATH));
        String[] tableline = null;

        while ((tableline = reader.readNext()) != null) {
            for (int i = 0; i < 1; i++) {
                WebElement emailTextBox = driver.findElement(By.id("username"));
                emailTextBox.sendKeys("");

                WebElement passwordTextBox = driver.findElement(By.id("password"));
                passwordTextBox.sendKeys("Selenium1122!");

                WebElement loginButton = driver.findElement(By.name("login"));
                loginButton.click();

                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

                WebElement errorMessage = driver.findElement(By
                        .xpath("//*[@id='page-36']/div/div[1]/ul"));

                String errorMessagetext = errorMessage.getText();
                String expectedMessage = tableline[1];

                assertEquals(expectedMessage, errorMessagetext);
            }
        }
    }

    @Test
    public void loginWithEmptyPassword()
            throws InterruptedException, CsvValidationException, IOException {
        CSVReader reader = new CSVReader(new FileReader(CSV_PATH));
        String[] tableline = null;

        while ((tableline = reader.readNext()) != null) {
            for (int i = 0; i < 1; i++) {
                WebElement emailTextBox = driver.findElement(By.id("username"));
                emailTextBox.sendKeys("evanderluan@gmail.com");

                WebElement passwordTextBox = driver.findElement(By.id("password"));
                passwordTextBox.sendKeys("");

                WebElement loginButton = driver.findElement(By.name("login"));
                loginButton.click();

                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

                WebElement errorMessage = driver.findElement(By
                        .xpath("//*[@id='page-36']/div/div[1]/ul"));

                String errorMessagetext = errorMessage.getText();
                String expectedMessage = tableline[2];

                assertEquals(expectedMessage, errorMessagetext);

            }
        }
    }

    @Test
    public void loginWithWrongDatas()
            throws InterruptedException, CsvValidationException, IOException {
        CSVReader reader = new CSVReader(new FileReader(CSV_PATH));
        String[] tableline = null;

        while ((tableline = reader.readNext()) != null) {
            for (int i = 0; i < 1; i++) {

                WebElement emailTextBox = driver.findElement(By.id("username"));
                emailTextBox.sendKeys("luanevander@gmail.com");

                WebElement passwordTextBox = driver.findElement(By.id("password"));
                passwordTextBox.sendKeys("Selenium1112");

                WebElement loginButton = driver.findElement(By.name("login"));
                loginButton.click();

                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

                WebElement errorMessage = driver.findElement(By
                        .xpath("//*[@id='page-36']/div/div[1]/ul"));

                String errorMessagetext = errorMessage.getText();
                String expectedMessage = tableline[0];

                assertEquals(expectedMessage, errorMessagetext);
            }
        }
    }

    @Test
    public void loginWithRightDatas()
            throws InterruptedException, CsvValidationException, IOException {
        CSVReader reader = new CSVReader(new FileReader(CSV_PATH));
        String[] tableline = null;

        while ((tableline = reader.readNext()) != null) {
            for (int i = 0; i < 1; i++) {

                WebElement emailTextBox = driver.findElement(By.id("element-0"));
                emailTextBox.sendKeys("evanderluan@gmail.com");

                WebElement passwordTextBox = driver.findElement(By.id("element-3"));
                passwordTextBox.sendKeys("Selenium1122!");

                WebElement loginButton =
                        driver.findElement(By.xpath(
                                "//*[@id='todoist_app']/div/div/div[2]/div[1]/div/div/form/button"));
                loginButton.click();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

                String expectedUrl = tableline[3];

                //assertEquals(expectedUrl, driver.getCurrentUrl());
            }
        }

    }
}
