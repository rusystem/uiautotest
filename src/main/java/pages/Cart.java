package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.checkout.Checkout;

/**
 * Класс содержит основные элементы страницы корзины сайта, конструктор PageFactory для lazy-инициализации
 * соответствующего элемента при попытке обращения к данному элементу и публичные методы для взаимодействия
 * с элементами.
 */

public class Cart {
    public WebDriver driver;

    public Cart(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    //Элемент кнопки "Оформить заказ"
    @FindBy(xpath = "(//*[contains(text(),\"Оформить заказ\")])[2]")
    private WebElement checkoutButtonElement;

    //Метод возвращает элемент кнопки "Оформить заказ"
    public WebElement getCheckoutButtonElement() {
        return checkoutButtonElement;
    }

    //Метод кликает по кнопке "Оформить заказ"
    public Checkout clickOnCheckoutButton() {
        checkoutButtonElement.click();
        return new Checkout(driver);
    }


}
