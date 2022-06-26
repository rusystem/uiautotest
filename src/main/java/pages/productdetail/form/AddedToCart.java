package pages.productdetail.form;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Класс содержит основные элементы popup окна, которое появляется после добавления товара в корзину, конструктор PageFactory для lazy-инициализации
 * соответствующего элемента при попытке обращения к данному элементу и публичные методы для взаимодействия
 * с элементами.
 */

public class AddedToCart {
    public WebDriver driver;

    public AddedToCart(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    //Элемент кнопки "крестик" закрыть popup окно
    @FindBy(xpath = "//*[@class='icon icon--close js-close']")
    private WebElement closeElement;

    //Метод возвращает элемент кнопки "крестик" закрыть popup окно
    public WebElement getCloseElement() {
        return closeElement;
    }

    //Метод закрывает popUp окно
    public void close() {
        closeElement.click();
    }
}
