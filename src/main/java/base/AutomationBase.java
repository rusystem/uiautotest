package base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class AutomationBase {

    private static final Properties PROPERTIES = new Properties();

    public static String getProperty(Property property) throws IOException {
        return getProperties().getProperty(property.getTitle());
    }

    private static Properties getProperties() throws IOException {
        PROPERTIES.load(new FileReader("src/main/resources/config.properties"));
        return PROPERTIES;
    }

    public enum Property {

        BASE_URL("BASE_URL");

        private final String title;

        Property(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }

    }

    // Метод производит скролл(перемещение) к элементу в браузере
    public static void scrollToElement(WebDriver driver, WebElement element) throws InterruptedException {
        String code = "window.scroll(" + (element.getLocation().x) + ","
                + (element.getLocation().y - 200) + ");";
        ((JavascriptExecutor) driver).executeScript(code, element, 0, 100);
        Thread.sleep(700);
    }
}
