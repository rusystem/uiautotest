package web;

import base.DriverConfig;
import base.data.User;
import org.testng.annotations.Test;
import pages.main.Main;

import static org.testng.Assert.assertEquals;

public class AuthenticationTests extends DriverConfig {
    private Main main;

    @Test(groups = {"authentication"})
    public void authenticationTest() {
        main = new Main(driver);
        main.authentication(User.EMAIL, User.PASSWORD);
        assertEquals(main.getAccountName(), User.FIRST_NAME);
    }
}
