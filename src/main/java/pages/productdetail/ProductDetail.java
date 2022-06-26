package pages.productdetail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Cart;
import pages.productdetail.form.AddedToCart;

import java.time.Duration;
import java.util.List;

/**
 * Класс содержит основные элементы детальной страницы товара, конструктор PageFactory для lazy-инициализации
 * соответствующего элемента при попытке обращения к данному элементу и публичные методы для взаимодействия
 * с элементами.
 */

public class ProductDetail {
    public WebDriver driver;

    public ProductDetail(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    //Элемент кнопки "Добавить в корзину"
    @FindBy(xpath = "//*[contains(text(),\"Добавить в корзину\")]")
    private WebElement addToCartElement;

    //Лист элементов размеров товара
    @FindBy(xpath = "//*[@class='product-details__sizes-wrapper custom-scroll js-add-to-basket-sizes']//*")
    private List<WebElement> productSizeList;

    //Элемент кнопки "корзина"
    @FindBy(xpath = "//*[@data-qa='icon-cart']")
    private WebElement cartButtonElement;

    //Метод возвращает элемент кнопки "корзина"
    public WebElement getCartButtonElement() {
        return cartButtonElement;
    }

    //Метод возвращает лист элементов размеров товара
    public List<WebElement> getProductSizeList() {
        return productSizeList;
    }

    //Метод возвращает элемент кнопки "Добавить в корзину"
    public WebElement getAddToCartElement() {
        return addToCartElement;
    }

    //Метод кликает по кнопке добавить в корзину
    public void clickOnAddToCart() {
        getAddToCartElement().click();
    }

    //Метод добавляет товар в корзину
    public void addToCart() {
        clickOnAddToCart();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(getProductSizeList().get(0)));
        getProductSizeList().get(0).click();
        AddedToCart addedToCartForm = new AddedToCart(driver);
        wait.until(ExpectedConditions.visibilityOf(addedToCartForm.getCloseElement()));
        addedToCartForm.close();
    }

    public Cart moveToCart() {
        getCartButtonElement().click();
        return new Cart(driver);
    }
}
