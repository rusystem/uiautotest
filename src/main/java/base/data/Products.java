package base.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Класс содержит основную инфомрмацию для работы с товарами сайта.
 */

public class Products {

    //Метод возвращает лист наименований популярных товаров.
    public static List<String> getPopularProducts() {
        return new ArrayList<>(Arrays.asList(
                "Нижнее белье"
        ));
    }

    //Метод возвращает случайный популярный товар
    public static String getPopularProduct() {
        return getPopularProducts().get((int) (Math.random() * getPopularProducts().size()));
    }
}
