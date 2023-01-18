package day04;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.security.Key;

public class Soru12 extends TestBase {
    @Test
    public void test12() {
        //https://demo.guru99.com/test/upload/ adresine gidiniz
        driver.get("https://demo.guru99.com/test/upload/");
        //Bilgisayarınızdan herhangi bir dosyayı upload ediniz
        WebElement dosyaSec=driver.findElement(By.id("uploadfile_0"));
        //"C:\Users\kozak\Desktop\logo.jpeg"
        String anaYol=System.getProperty("user.home");
        String taliYol="\\Desktop\\logo.jpeg";
        String dosyaYolu=anaYol+taliYol;

        dosyaSec.sendKeys(dosyaYolu);


        // I accept terms of service bölümünü tikleyin
       WebElement checkBox= driver.findElement(By.id("terms"));
       checkBox.click();
       checkBox.sendKeys(Keys.TAB,Keys.TAB,Keys.ENTER);
        // Submit File buttonuna basınız

        // "1 file has been successfully uploaded" görünür olduğunu test edin
        waitFor(2);
        assert driver.findElement(By.id("res")).isDisplayed();
    }


}
