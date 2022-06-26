package base.data;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class User {
    public static final String FIRST_NAME = "мдмитрий";
    public static final String EMAIL = "ru.system@mail.ru";
    public static final String PASSWORD = "654321Qq";

    //Метод возвращает случайное имя пользователя
    public static String getRandomFirstName() {
        int random = (int) (Math.random() * firstNamesList().size());
        return firstNamesList().get(random);
    }

    //Метод возвращает случайную фамилию пользователя
    public static String getRandomLastName() {
        int random = (int) (Math.random() * lastNamesList().size());
        return lastNamesList().get(random);
    }

    //Метод возвращает случайный номер телефона(Самара). Маска 123ХХХХХХХ
    public static String getRandomPhoneNumber() {
        return "123" + RandomStringUtils.random(7, false, true);
    }

    //Метод возвращает случайную почту
    public static String getRandomEmail() {
        List<String> emailList = new ArrayList<>(Arrays.asList("@mail.ru", "@gmail.com", "@yandex.ru"));
        String email = emailList.get((int) (Math.random() * emailList.size()));
        String randomString = RandomStringUtils.random(5, true, true);
        return randomString + email;
    }

    //Приватный метод возвращает лист имен пользователей
    private static List<String> firstNamesList() {
        return new ArrayList<>(Arrays.asList(
                "Иван",
                "Павел",
                "Федор",
                "Кирилл",
                "Илья",
                "Евгений",
                "Сергей",
                "Тимофей",
                "Антон",
                "Андрей"
        ));
    }

    //Приватный метод возвращает лист фамилий пользователей
    private static List<String> lastNamesList() {
        return new ArrayList<>(Arrays.asList(
                "Иванов",
                "Петров",
                "Сидоров",
                "Андреев",
                "Смирнов",
                "Князев",
                "Соколов",
                "Богданов",
                "Ковалев",
                "Морозов"
        ));
    }

}
