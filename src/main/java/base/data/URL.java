package base.data;

import base.AutomationBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

import static base.AutomationBase.getProperty;

/**
 * Класс содержит основные элементы для работы с URL сайта, конструктор PageFactory для lazy-инициализации
 * соответствующего элемента при попытке обращения к данному элементу и публичные методы для взаимодействия
 * с элементами.
 */

public class URL {
    public WebDriver driver;

    public URL(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    //Элемент кнопки "Да, верно" из аларма выбора региона
    @FindBy(xpath = "//*[@data-qa='saveAutodetectRegion']")
    private WebElement confirmElement;

    //Метод возвращает элемент кнопки "Да, верно" из аларма выбора региона
    public WebElement getConfirmElement() {
        return confirmElement;
    }

    //Метод кликает по кнопке "Да, верно" из аларма выбора региона
    public void clickOnConfirm() {
        getConfirmElement().click();
    }

    //Метод возвращает строку с url главной страницы
    public static String getMaster() throws IOException {
        return getProperty(AutomationBase.Property.BASE_URL);
    }

    //Метод открывает главную страницу
    public void openMainPage() throws IOException {
        driver.get(getMaster());
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(getConfirmElement()));
        clickOnConfirm();
    }
}
