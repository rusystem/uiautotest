package pages.checkout;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

/**
 * Класс содержит основные элементы страницы оформления заказа на сайте, конструктор PageFactory для lazy-инициализации
 * соответствующего элемента при попытке обращения к данному элементу и публичные методы для взаимодействия
 * с элементами.
 */

public class Checkout {
    public WebDriver driver;
    public static final String THANKS_FOR_THE_ORDER = "Спасибо за заказ!";

    public Checkout(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    //Элемент кнопки "Оформить заказ"
    @FindBy(xpath = "(//*[contains(text(),\"Оформить заказ\")])[1]")
    private WebElement checkoutButtonElement;

    //Элемент поля Email
    @FindBy(xpath = "//*[@class='checkout js-checkout-main']//*[@name='email']")
    private WebElement inputEmailFieldElement;

    //Лист элементов магазинов
    @FindBy(xpath = "//*[@class='checkout-point-item js-checkout-point']")
    private List<WebElement> checkoutPointList;

    //Элемент поля Имя
    @FindBy(xpath = "//*[@class='checkout js-checkout-main']//*[@name='firstName']")
    private WebElement inputFirstNameFieldElement;

    //Элемент поля Фамилия
    @FindBy(xpath = "//*[@class='checkout js-checkout-main']//*[@name='lastName']")
    private WebElement inputLastNameFieldElement;

    //Элемент поля телефон
    @FindBy(xpath = "//*[@class='checkout js-checkout-main']//*[@name='cellphone']")
    private WebElement inputPhoneFieldElement;

    //Элемент кнопки "Выбрать пункт"
    @FindBy(xpath = "(//*[contains(text(),\"Выбрать пункт\")])[1]")
    private WebElement selectCheckoutPointElement;

    //Элемент поля "Спасибо за заказ!"
    @FindBy(xpath = "//*[@class='main-caption']")
    private WebElement thanksForTheOrderElement;

    //Метод возвращает элемент поля "Спасибо за заказ!"
    public WebElement getThanksForTheOrderElement() {
        return thanksForTheOrderElement;
    }

    //Метод возвращает текст элемента поля "Спасибо за заказ!"
    public String getThanksForTheOrder() {
        return thanksForTheOrderElement.getText();
    }

    //Метод возвращает элемент кнопки "Выбрать пункт"
    public WebElement getSelectCheckoutPointElement() {
        return selectCheckoutPointElement;
    }

    //Метод возвращает элемент поля телефон
    public WebElement getInputPhoneFieldElement() {
        return inputPhoneFieldElement;
    }

    //Метод возвращает элемент поля Фамилия
    public WebElement getInputLastNameFieldElement() {
        return inputLastNameFieldElement;
    }

    //Метод возвращает элемент поля Имя
    public WebElement getInputFirstNameFieldElement() {
        return inputFirstNameFieldElement;
    }

    //Метод возвращает лист элементов магазинов
    public List<WebElement> getCheckoutPointList() {
        return checkoutPointList;
    }

    //Метод возвращает элемент поля ввода Email
    public WebElement getInputEmailFieldElement() {
        return inputEmailFieldElement;
    }

    //Метод возвращает элемент кнопки "Оформить заказ"
    public WebElement getCheckoutButtonElement() {
        return checkoutButtonElement;
    }

    //Метод выбора случайного магазина
    public void setFirstCheckoutPoint() throws InterruptedException {
        WebElement element = getCheckoutPointList().get(0);
        Thread.sleep(4000);
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        getSelectCheckoutPointElement().click();
    }

    //Метод вводит Email в поле с Email
    public void enterEmail(String email) {
        getInputEmailFieldElement().sendKeys(email);
    }

    //Метод вводит firstName в поле с firstName
    public void enterFirstName(String firstName) {
        getInputFirstNameFieldElement().sendKeys(firstName);
    }

    //Метод вводит lastName в поле с lastName
    public void enterLastName(String lastName) {
        getInputLastNameFieldElement().sendKeys(lastName);
    }

    //Метод вводит phone в поле с phone
    public void enterPhone(String phone) {
        getInputPhoneFieldElement().sendKeys(phone);
    }

    //Метод ввода данных получателя
    public void enterUserData(String firstName, String lastName, String phone) {
        enterFirstName(firstName);
        enterLastName(lastName);
        enterPhone(phone);
    }

    //Метод заполнения дополнительных сведений для заказа
    public void enterAdditionalInformation(String email, String firstName, String lastName, String phone) throws InterruptedException {
        enterEmail(email);
        setFirstCheckoutPoint();
        enterUserData(firstName, lastName, phone);
    }

    //Метод кликает по кнопке "Оформить заказ"
    public void clickOnCheckoutButton() {
        getCheckoutButtonElement().click();
    }

    //Метод оформления заказа
    public void makingAnOrder(String email, String firstName, String lastName, String phone) throws InterruptedException {
        enterAdditionalInformation(email, firstName, lastName, phone);


        //if you want to place an order in full, then comment out the code below

/*        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Thread.sleep(1000);
        clickOnCheckoutButton();
        driver.switchTo().frame(driver.findElement(By.id("iframe_flock_data_provider")));
        Gift gift = new Gift(driver);
        wait.until(ExpectedConditions.visibilityOf(gift.getCloseElement()));
        gift.clickOnClose();
        wait.until(ExpectedConditions.visibilityOf(gift.getRefuseGiftsButtonElement()));
        gift.clickOnRefuseGifts();
        driver.switchTo().defaultContent();*/
    }
}