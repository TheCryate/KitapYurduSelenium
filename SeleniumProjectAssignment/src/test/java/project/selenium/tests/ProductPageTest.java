package project.selenium.tests;

import org.junit.Test;
import project.selenium.driver.BaseTest;
import project.selenium.pages.LoginPage;
import project.selenium.pages.ProductPage;


public class ProductPageTest extends BaseTest {

    public void login(){
        LoginPage loginPage = new LoginPage();
        loginPage.login();
    }

    @Test
    public void product(){
        login();
        ProductPage productPage = new ProductPage();
        productPage.search();
        productPage.scroll();
        productPage.addToFavorites();
        productPage.checkFavorites();
        productPage.backToMain();
        productPage.pointCatalog();
        productPage.hover();
        productPage.selectRandomProduct();
        productPage.removeFromFavorites();
        productPage.myBasket();
        productPage.addNewAddress();
        productPage.addNewCard();
        productPage.logOut();
    }

    //ProductPageTest içindeki voidleri sayfalara dağıtmaya çalışırken kafam karıştı :D
    //Normal şartlarda AllPageTest, MainPage ve MainPageTest, CheckOutPage ve CheckOutPageTest oluşturacaktım.
    //Elimde olanı bozmamak için tasarımla uğraşmadım.








}
