package project.selenium.tests;

import org.junit.Test;
import project.selenium.driver.BaseTest;
import project.selenium.pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void loginTest(){
        LoginPage loginPage = new LoginPage();
        loginPage.login();
    }
}
