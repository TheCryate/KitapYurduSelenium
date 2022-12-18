package project.selenium.methods;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import project.selenium.driver.BaseTest;

import java.time.Duration;

public class Method {
    WebDriver driver;
    FluentWait<WebDriver> wait;
    JavascriptExecutor jsdriver;
    Logger logger = LogManager.getLogger(Method.class);


    public Method(){
        driver = BaseTest.driver;
        wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(NoSuchElementException.class);
        jsdriver = (JavascriptExecutor) driver;
    }


    public WebElement findElement(By by){
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }


    public void click(By by){
        findElement(by).click();
    }


    public String addToFavorites(By by, String favorites){
        String favorites1 = findElement(by).getAttribute(favorites);
        logger.info("Text : " + favorites);
        return (favorites1.substring(15,21));
    }


    public void waitBySeconds(long seconds){
        try {
            Thread.sleep(seconds * 1000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public void sendKeys(By by, String text){
        findElement(by).sendKeys(text);
    }



    public boolean isElementVisible(By by){
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            logger.info("true");
            return true;
        }catch (Exception e){
            logger.info("false" + e.getMessage());
            return false;
        }
    }


    public void mouseHover(By by){
        WebElement hover = driver.findElement(by);
        Actions action = new Actions(driver);
        action.moveToElement(hover).perform();
    }


    public void scroolWithAction(By by){
        Actions actions = new Actions(driver);
        actions.moveToElement(findElement(by)).build().perform();
    }





    public void doubleClick(By by){
        WebElement doubleCl = driver.findElement(by);
        Actions action = new Actions(driver);
        action.doubleClick(doubleCl).perform();
    }

    public Select getSelect(By by){
        return new Select(findElement(by));
    }

    public void selectByText(By by, String text){
        getSelect(by).selectByVisibleText(text);
    }



    public String getText(By by){
        return findElement(by).getText();
    }

    public String getValue(By by){
        return jsdriver.executeScript("return arguments[0].value;",findElement(by)).toString();
    }
}
