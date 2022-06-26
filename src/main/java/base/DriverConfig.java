package base;

import base.data.URL;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.testng.annotations.*;

import java.io.*;
import java.time.Duration;
import java.util.logging.Level;

/**
 * Класс описывает настройку web-драйвера.
 * Содержит методы с аннотациями TestNG для реализации всех тестовых сценариев проекта и является классом-родителем
 * для тестовых классов из пакета mediasoft.uiautotest
 */

public class DriverConfig {
    public WebDriver driver;

    //Метод описывает настройку WebDriver
    @BeforeMethod(groups = {"authentication", "cart"})
    public void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--headless");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--window-size=1920x1080");
        options.addArguments("--allow-insecure-localhost");
        options.addArguments("--disable-gpu");
        LoggingPreferences loggingPreferences = new LoggingPreferences();
        loggingPreferences.enable(LogType.BROWSER, Level.ALL);
        options.setCapability("goog:loggingPrefs", loggingPreferences);
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(10));
        driver.manage().window().maximize();
        new URL(driver).openMainPage();
    }

    //Метод "убивает" driver по завершению тестового сценария
    @AfterMethod(groups = {"authentication", "cart"})
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
