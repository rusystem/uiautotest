package pages.checkout.form;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Класс содержит основные элементы для работы с формой подарка, которая появляется после оформленного заказа сайта, конструктор PageFactory для lazy-инициализации
 * соответствующего элемента при попытке обращения к данному элементу и публичные методы для взаимодействия
 * с элементами.
 */

public class Gift {
    public WebDriver driver;

    public Gift(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    //Элемент кнопки "крестик" закрыть окно
    @FindBy(xpath = "//*[@class='ExchangeBanner-close js-close']")
    private WebElement closeElement;

    //Элемент кнопки "отказаться от подарков"
    @FindBy(xpath = "//*[@class='popup__button-wrapper']//*[2]")
    private WebElement refuseGiftsButtonElement;

    //Метод возвращает элемент кнопки "отказаться от подарков"
    public WebElement getRefuseGiftsButtonElement() {
        return refuseGiftsButtonElement;
    }

    //Метод кликает по кнопке "отказаться от подарков"
    public void clickOnRefuseGifts() {
        refuseGiftsButtonElement.click();
    }

    //Метод возвращает элемент кнопки "крестик" закрыть окно
    public WebElement getCloseElement() {
        return closeElement;
    }

    //Метод кликает по кнопке "крестик" закрыть окно
    public void clickOnClose() {
        closeElement.click();
    }
}
