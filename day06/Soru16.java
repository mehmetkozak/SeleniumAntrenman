package day06;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

public class Soru16 extends TestBase {
    @Test
    public void test16() {
        //https://www.fenerbahce.org/ sitesine gidiniz
        driver.get("https://www.fenerbahce.org/");
        //TARAFTAR butonu üzerine gelerek altta açılan 28 Şampiyonluğumuz üzerine tıklayın
        WebElement taraftar=driver.findElement(By.xpath("//*[.='TARAFTAR']"));
        Actions actions=new Actions(driver);
        actions.moveToElement(taraftar).perform();
        waitFor(3);
        driver.findElement(By.xpath("//*[text()='28 Şampiyonluğumuz']")).click();
        //Açılan sayfada "NEDEN 28?" Butonunun görünür olduğunu doğrulayınız
        WebElement neden28=driver.findElement(By.xpath("//*[@class='btn btn-yellow first-step-btn pull-right']"));
        Assert.assertTrue(neden28.isDisplayed());

        //Daha sonra sayfa içerisindeki metin arasında başlıklar halinde yer alan ve şampiyonluk yıllarını gösteren
        // sezon yıllarının 28 adet olduğunu doğrulayınız
        List<WebElement> sampiyonlukSayisi=driver.findElements(By.xpath("//*[@class='date']"));
        System.out.println(sampiyonlukSayisi.size());
        Assert.assertEquals(28,sampiyonlukSayisi.size());


        //https://www.fenerbahce.org/ sitesine gidiniz
        //TARAFTAR butonu üzerine gelerek altta açılan 28 Şampiyonluğumuz üzerine tıklayın
        //Açılan sayfada "NEDEN 28?" Butonunun görünür olduğunu doğrulayınız
        //Daha sonra sayfa içerisindeki metin arasında başlıklar halinde yer alan ve şampiyonluk yıllarını gösteren
        // sezon yıllarının 28 adet olduğunu doğrulayınız
    }
}
