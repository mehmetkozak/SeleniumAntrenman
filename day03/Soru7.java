package day03;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Soru7 extends TestBase {
    @Test
    public void test07() {
        //http://szimek.github.io/signature_pad/ sayfasına gidiniz
        driver.get("http://szimek.github.io/signature_pad/");
        //Çıkan ekrana istediğiniz çizgi yada şekli çiziniz
        WebElement yaziTahtasi=driver.findElement(By.tagName("canvas"));
        Actions actions=new Actions(driver);
        actions.moveToElement(yaziTahtasi).clickAndHold();

        for (int i = 0; i < 10; i++) {
            actions.moveByOffset(5,5);
        }
        for (int i = 0; i < 10; i++) {
            actions.moveByOffset(5,-5);
        }
        for (int i = 0; i < 10; i++) {

            actions.moveByOffset(-5,-5);
        }
        actions.release().build().perform();
        //Çizimden sonra clear butonuna basalım
        driver.findElement(By.xpath("//*[text()='Clear']")).click();
        //Son olarak sayfayı temizleyiniz

    }



}
