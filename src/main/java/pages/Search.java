package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.productdetail.ProductDetail;

import java.util.List;

import static base.AutomationBase.scrollToElement;

/**
 * Класс содержит основные элементы поисковой страницы сайта, конструктор PageFactory для lazy-инициализации
 * соответствующего элемента при попытке обращения к данному элементу и публичные методы для взаимодействия
 * с элементами.
 */

public class Search {
    public WebDriver driver;

    public Search(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    //Лист элементов карточек товаров
    @FindBy(xpath = "//*[@data-qa='product-block']")
    private List<WebElement> productCardList;

    //Метод возвращает лист элементов карточек товаров
    public List<WebElement> getProductCardList() {
        return productCardList;
    }

    //Метод кликает по карточке первого товара
    public ProductDetail clickOnFirstProduct() throws InterruptedException {
        WebElement element = getProductCardList().get(0);
        scrollToElement(driver, element);
        element.click();
        return new ProductDetail(driver);
    }

}
