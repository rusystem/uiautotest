package web;

import base.DriverConfig;
import org.testng.annotations.Test;
import pages.Cart;
import pages.Search;
import pages.checkout.Checkout;
import pages.main.Main;
import pages.productdetail.ProductDetail;

import static base.data.Products.getPopularProduct;
import static base.data.User.*;
import static org.testng.Assert.assertTrue;

public class CartTests extends DriverConfig {
    private Main main;
    private Search search;
    private ProductDetail productDetail;
    private Cart cart;
    private Checkout checkout;

    @Test(groups = {"cart"})
    public void hasAnOrderBeenCreatedTest() throws InterruptedException {
        main = new Main(driver);
        search = main.search(getPopularProduct());
        productDetail = search.clickOnFirstProduct();
        productDetail.addToCart();
        cart = productDetail.moveToCart();
        checkout = cart.clickOnCheckoutButton();
        checkout.makingAnOrder(getRandomEmail(), getRandomFirstName(), getRandomLastName(), getRandomPhoneNumber());
        assertTrue(checkout.getCheckoutButtonElement().isDisplayed());
    }
}
