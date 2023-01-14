package day02;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Set;

public class Soru05 extends TestBase {
    @Test
    public void test05() {
        //   url'ye git: http://demo.guru99.com/popup.php
        driver.get("http://demo.guru99.com/popup.php");
        //   ilk pencereyi al
       String ilkPencere= driver.getWindowHandle();
        //   "Click Here" butonuna tıklayın
        driver.findElement(By.xpath("//*[text()='Click Here']")).click();
        //   setteki tüm pencereyi al
        Set<String>allWindow=driver.getWindowHandles();
        //   diğer pencereye geç
        for (String w:allWindow) {
            if (!w.equals(ilkPencere)){
                driver.switchTo().window(w);
                break;
            }
        }
        //   e-posta kimliğini (somepne@gmail.com) girin ve bu girişe bir şey yazın
        //   Gönder düğmesine tıklayarak
        driver.findElement(By.name("emailid")).sendKeys("somepne@gmail.com", Keys.ENTER);

        //   "This access is valid only for 20 days." ifadesinin beklendiği gibi olduğunu doğrula
        String metin=driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals("This access is valid only for 20 days.",metin);
        //   Tekrar ilk pencereye geç
        driver.switchTo().window(ilkPencere);
        //   İlk pencerede olduğunu doğrula
       WebElement logo= driver.findElement(By.xpath("//*[@src='/logo.png']"));
       Assert.assertTrue(logo.isDisplayed());

    }



}
