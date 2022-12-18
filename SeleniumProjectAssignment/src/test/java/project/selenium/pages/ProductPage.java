package project.selenium.pages;
import org.junit.Assert;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import project.selenium.methods.Method;


import java.util.Random;

public class ProductPage {


    String productValue1, productValue2, productValue3, productValue4;
    Method method;

    Logger logger = LogManager.getLogger(LoginPage.class);

    public ProductPage(){
        method= new Method();
    }

    public void search(){
        method.sendKeys(By.xpath("//input[@id='search-input']"),"Oyuncak");
        method.click(By.cssSelector(".common-sprite.button-search"));
    }

    public void scroll(){
        method.scroolWithAction(By.xpath("(//div[@class='grid_7 omega'])[7]"));
    }

    public void addToFavorites(){

        productValue1 = method.addToFavorites(By.cssSelector(".product-list>.product-cr:nth-child(3)>.grid_2.alpha.omega.relative>.hover-menu>.add-to-favorites"),"onclick");
        productValue2 = method.addToFavorites(By.cssSelector(".product-list>.product-cr:nth-child(4)>.grid_2.alpha.omega.relative>.hover-menu>.add-to-favorites"),"onclick");
        productValue3 = method.addToFavorites(By.cssSelector(".product-list>.product-cr:nth-child(5)>.grid_2.alpha.omega.relative>.hover-menu>.add-to-favorites"),"onclick");
        productValue4 = method.addToFavorites(By.cssSelector(".product-list>.product-cr:nth-child(7)>.grid_2.alpha.omega.relative>.hover-menu>.add-to-favorites"),"onclick");

        logger.info("4 Adet Ürün Seçiliyor...");

        System.out.println("1.Products Unique Value : "  + productValue1);
        System.out.println("2.Products Unique Value : "  + productValue2);
        System.out.println("3.Products Unique Value : ["  + productValue3 + "]");
        System.out.println("4.Products Unique Value : " + productValue4);

        method.click(By.cssSelector(".product-list>.product-cr:nth-child(3)>.grid_2.alpha.omega.relative>.hover-menu>.add-to-favorites"));
        method.click(By.cssSelector(".product-list>.product-cr:nth-child(4)>.grid_2.alpha.omega.relative>.hover-menu>.add-to-favorites"));
        method.click(By.cssSelector(".product-list>.product-cr:nth-child(5)>.grid_2.alpha.omega.relative>.hover-menu>.add-to-favorites"));
        method.click(By.cssSelector(".product-list>.product-cr:nth-child(7)>.grid_2.alpha.omega.relative>.hover-menu>.add-to-favorites"));

        method.waitBySeconds(2);//Favoriler animasyonu çıkana kadar beklemek gerekiyor aksi halde tıklayamıyor.
        Assert.assertTrue(method.isElementVisible(By.cssSelector(".swal2-title.ky-swal-title-single>a")));
        method.click(By.cssSelector(".swal2-title.ky-swal-title-single>a"));
    }

    public void checkFavorites(){
        //method.selectByText(By.cssSelector(".results"), "Gösterilen:");

        //String attribute = method.getAttribute(By.cssSelector(".div>class"),"results");
        //logger.info("Favorilere Eklenen Ürün Sayısı: " + attribute);
        //System.out.println("Favorilere Eklenen Ürün Sayısı: " + attribute);
        //method.waitBySeconds(3);

        String text = method.getText(By.xpath("//div[@class='results']"));
        logger.info("Favorilere Eklenen Ürün Sayısı: " + text);
        System.out.println("Favorilere Eklenen Ürün Sayısı: " + text);
        ProductPage productPage = new ProductPage();
    }



    public void backToMain(){
        method.click(By.cssSelector(".logo-text>a>img"));
    }

    public void pointCatalog(){
        method.click(By.cssSelector(".lvl1catalog"));
        method.click(By.cssSelector("#landing-point>div:nth-child(4)>a:nth-child(2)>img"));//Değiştir
        method.selectByText(By.xpath("//select[@onchange='location = this.value;']"), "Yüksek Oylama");
    }

    public void hover(){
        method.mouseHover(By.xpath("//span[contains(@class,'mn-strong common-sprite')][contains(text(),'Tüm Kitaplar')]"));
        Assert.assertTrue(method.isElementVisible(By.xpath("//a[text()='Hobi']")));
        method.click(By.xpath("//a[text()='Hobi']"));
    }

    public void selectRandomProduct(){
        logger.info("Rastgele Ürün Seçiliyor...");
        System.out.println("Rastgele Ürün Seçiliyor...");
        Random random = new Random();
        int number = random.nextInt(25);
        method.click(By.xpath("(//ul[@class='product-grid jcarousel-skin-opencart']/li)[" + number + "]"));
        method.click(By.cssSelector(".pr_cart.product-info>#button-cart"));
        method.click(By.xpath("//div[@class='menu top my-list']"));
        method.click(By.xpath("//a[text()='Favorilerim']"));
    }

    public void removeFromFavorites(){
        //method.click(By.cssSelector(".hover-menu>a[onclick='removeFromFavorites(" + productValue3.substring(8)+");']"));
        method.click(By.cssSelector("#product-494781>div.grid_2.alpha.omega.relative>div.hover-menu>a:nth-child(3)"));
        logger.info("Favorilere Eklenen 3. Ürün Siliniyor...");
        System.out.println("Favorilere Eklenen 3. Ürün Siliniyor...");
        method.waitBySeconds(1);//Favoriler kaldırılırken sayfa kendini refreshliyor o yüzden beklemek gerekiyor.
    }

    public void myBasket(){
        logger.info("Sepet İşlemleri Yapılıyor...");
        //method.waitBySeconds(3);
        //method.click(By.cssSelector("#sprite-cart-icon"));
        Assert.assertTrue(method.isElementVisible(By.xpath("//span[@id='cart-items']")));
        method.click(By.xpath("//span[@id='cart-items']"));
        //Assert.assertTrue(method.isElementVisible(By.cssSelector("#js-cart.button")));
        //method.waitBySeconds(3);
        method.click(By.cssSelector("#js-cart.button"));
        //method.click(By.xpath("//*[@id=cart_module]/div[1]/table/tbody/tr/td[4]/form/input[1]"));
        //method.click(By.xpath("//input[@name='quantity']"));
        //method.click(By.xpath("//input[@name='quantity']"));
        method.doubleClick(By.xpath("//input[@name='quantity']"));
        method.sendKeys(By.xpath("//input[@name='quantity']"),"3");//Normalde 2 ürün ekliyordu fakat 7 tl lik ürün olunca 30 tl yi geçemiyor.
        method.click(By.xpath("//i[@title='Güncelle']"));

        //method.click(By.xpath("//a[@class='button red']"));
        //Assert.assertTrue(method.isElementVisible(By.cssSelector(".to-wishlist>a")));
        method.waitBySeconds(2);
        //method.click(By.cssSelector(".to-wishlist>a"));
        //method.mouseHover(By.cssSelector(".right>.button.red"));
        method.click(By.cssSelector(".right>.button.red"));
    }

    public void addNewAddress(){
        logger.info("Yeni Adres Ekleniyor...");
        method.click(By.xpath("//a[@onclick][2]")); //Adres eklendiği için yeni eklemek durumundayım. Eskisini silemiyorum.

        method.sendKeys(By.xpath("//input[@id='address-firstname-companyname']"),"Batıhan"); //Ad
        method.sendKeys(By.xpath("//input[@id='address-lastname-title']"),"Kota");           //Soyad

        method.selectByText(By.xpath("//select[@id='address-zone-id']"), "İstanbul");        //Şehir
        Assert.assertTrue(method.isElementVisible(By.xpath("//select[@id='address-county-id']")));
        method.waitBySeconds(1);//olmazsa 2 yap
        method.selectByText(By.xpath("//select[@id='address-county-id']"), "ADALAR");        //İlçe

        method.sendKeys(By.xpath("//input[@id='district']"),"Ev");                          //Mahalle
        method.sendKeys(By.xpath("//textarea[@id='address-address-text']"),"Ev1");           //Adres
        method.sendKeys(By.xpath("//input[@id='address-mobile-telephone']"),"5551112223");  //Telefon

        method.click(By.xpath("//button[@id='button-checkout-continue']"));                      //Devam
        method.waitBySeconds(1);//olmazsa 2 yap
        method.click(By.xpath("//button[@id='button-checkout-continue']"));                      //Devam
    }

    public void addNewCard(){
        logger.info("Yeni Kart Ekleniyor...");
        method.waitBySeconds(3);//olmazsa 3 yap
        method.sendKeys(By.xpath("//input[@id='credit-card-owner']"),"Batıhan Kota");   //Kart Sahibinin Adı

        method.sendKeys(By.xpath("//input[@id='credit_card_number_1']"),"1234");           //Kart Numarası1
        method.sendKeys(By.xpath("//input[@id='credit_card_number_2']"),"5678");           //Kart Numarası2
        method.sendKeys(By.xpath("//input[@id='credit_card_number_3']"),"9123");           //Kart Numarası3
        method.sendKeys(By.xpath("//input[@id='credit_card_number_4']"),"4567");           //Kart Numarası4

        method.selectByText(By.xpath("//select[@id='credit-card-expire-date-month']"), "02");        //S.K.T Ay
        method.selectByText(By.xpath("//select[@id='credit-card-expire-date-year']"), "2030");      //S.K.T Yıl
        method.sendKeys(By.xpath("//input[@id='credit-card-security-code']"),"123");            //CVV2

        method.waitBySeconds(1);
        method.click(By.xpath("//button[@id='button-checkout-continue']"));  //Devam


        String error = method.getText(By.xpath("//span[@class='error']"));
        logger.info("Hata:" + error);
        System.out.println("Hata:" + error);
        //System.out.println("Geçersiz Kart Numarası!");

        method.click(By.xpath("//div[@id='cart-header']"));
        method.mouseHover(By.xpath("//a[@class='common-sprite'][1]"));
    }

    public void logOut(){
        method.click(By.xpath("//a[text()='Çıkış']"));
        logger.info("Çıkış Yapılıyor...");
    }
}
