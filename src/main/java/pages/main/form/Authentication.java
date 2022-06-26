package pages.main.form;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.main.Main;

import java.time.Duration;

/**
 * Класс содержит основные элементы для работы с формой аутентификации на главной странице сайта, конструктор PageFactory для lazy-инициализации
 * соответствующего элемента при попытке обращения к данному элементу и публичные методы для взаимодействия
 * с элементами.
 */

public class Authentication {
    public WebDriver driver;

    public Authentication(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    //Элемент поля для ввода Email
    @FindBy(xpath = "//*[@data-qa='loginEmail']")
    private WebElement inputEmailFieldElement;

    //Элемент поля для ввода пароля
    @FindBy(xpath = "//*[@data-qa='loginPassword']")
    private WebElement inputPasswordFieldElement;

    //Элемент кнопки "Войти" для аутентификации на сайте
    @FindBy(xpath = "//*[@data-qa='loginSubmit']")
    private WebElement submitButtonElement;

    //Метод возвращает элемент кнопки "Войти" для аутентификации на сайте
    public WebElement getSubmitButtonElement() {
        return submitButtonElement;
    }

    //Метод возвращает элемент поля для ввода пароля
    public WebElement getInputPasswordFieldElement() {
        return inputPasswordFieldElement;
    }

    //Метод возвращает элемент поля для ввода Email
    public WebElement getInputEmailFieldElement() {
        return inputEmailFieldElement;
    }

    //Метод вводит Email в поле с Email
    public void enterEmail(String email) {
        getInputEmailFieldElement().sendKeys(email);
    }

    //Метод вводит пароль в поле Password
    public void enterPassword(String password) {
        getInputPasswordFieldElement().sendKeys(password);
    }

    //Метод кликает по кнопке "Войти"
    public void clickOnSubmitButton() {
        getSubmitButtonElement().click();
    }

    //Метод производит аутентификацию
    public Main signIn(String email, String password) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.visibilityOf(getInputEmailFieldElement()));
        enterEmail(email);
        enterPassword(password);
        clickOnSubmitButton();
        webDriverWait.until(ExpectedConditions.invisibilityOf(getInputEmailFieldElement()));
        return new Main(driver);
    }


}
