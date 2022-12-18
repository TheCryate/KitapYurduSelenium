package project.selenium.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import project.selenium.methods.Method;

public class LoginPage {
    Method method;
    Logger logger = LogManager.getLogger(LoginPage.class);

    public LoginPage(){
        method= new Method();
    }
    public void login(){
        method.click(By.cssSelector(".menu-top-button.login>a"));
        method.sendKeys(By.id("login-email"),"bathankota@hotmail.com");
        method.sendKeys(By.xpath("//input[@id='login-password']"),"batihankota11223344");
        method.click(By.xpath("//button[@id='js-popup-accept-button']"));
        method.click(By.cssSelector(".ky-btn.ky-btn-orange.w-100.ky-login-btn"));
        Assert.assertTrue(method.isElementVisible(By.cssSelector(".section")));
        logger.info("Login İşlemi Başarılı");
    }

}
