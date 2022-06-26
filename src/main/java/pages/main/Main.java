package pages.main;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.Search;
import pages.main.form.Authentication;

/**
 * Класс содержит основные элементы для работы с главной страницей сайта, конструктор PageFactory для lazy-инициализации
 * соответствующего элемента при попытке обращения к данному элементу и публичные методы для взаимодействия
 * с элементами.
 */

public class Main {
    public WebDriver driver;

    public Main(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    //Элемент кнопки "Войти"/"Имя аккаунта" для аутентификации на сайте
    @FindBy(xpath = "//*[@data-qa='account-link']")
    private WebElement signInElement;

    //Элемент поисковой строки
    @FindBy(id = "js-site-search-input")
    private WebElement inputSearchFieldElement;

    //Метод возвращает элемент поисковой строки
    public WebElement getInputSearchFieldElement() {
        return inputSearchFieldElement;
    }

    //Метод для поиска товара
    public Search search(String productName) {
        getInputSearchFieldElement().sendKeys(productName, Keys.ENTER);
        return new Search(driver);
    }

    //Метод возвращает элемент кнопки "Войти"/"Имя аккаунта" для аутентификации на сайте
    public WebElement getSignInElement() {
        return signInElement;
    }

    //Метод кликает по кнопке "Войти"/"Имя аккаунта" для аутентификации на сайте
    public Authentication clickOnSignIn() {
        getSignInElement().click();
        return new Authentication(driver);
    }

    //Метод аутентификации на сайте
    public void authentication(String email, String password) {
        Authentication authentication = clickOnSignIn();
        authentication.signIn(email, password);
    }

    //Метод возвращает имя аккаунта
    public String getAccountName() {
        return getSignInElement().getText();
    }
}
