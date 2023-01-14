package hw;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class Hw01 extends TestBase {

    @Test
    public void hwTest01(){
        //Test01 :  1- amazon gidin
        driver.get("https://www.amazon.com");
        //Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
        WebElement dropdownBox = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select select = new Select(dropdownBox);
        List<WebElement>dropdownBoxList =select.getOptions();
        dropdownBoxList.forEach(t-> System.out.println(t.getText()));
        //dropdown menude 40 eleman olduğunu doğrulayın
        Assert.assertFalse( "Dropdown Menüde 40 adet eleman bulunuyor",dropdownBoxList.size()==40);
        //Test02
        //dropdown menuden elektronik bölümü seçin
        //select.selectByVisibleText("Electronics");
        dropdownBox.sendKeys("Electronics");
        //arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
        WebElement searchBox = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        searchBox.sendKeys("iphone", Keys.ENTER);
        String sonucText =driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]")).getText();
        System.out.println("Sonuc Yazısı = " + sonucText);
        //sonuc sayisi bildiren yazinin iphone icerdigini test edin
        Assert.assertTrue(sonucText.contains("iphone"));
        //ikinci ürüne relative locater kullanarak tıklayin
        driver.findElement(By.xpath("//img[@src='https://m.media-amazon.com/images/I/51atS65QJHL._AC_UL320_.jpg']")).click();
        //ürünün title'ni ve fiyatını variable’a  assign edip ürünü sepete ekleyelim
        String urunBasligi = driver.findElement(By.id("productTitle")).getText();
        String urunFiyati =driver.findElement(By.xpath("//*[@class='a-section a-spacing-none aok-align-center']")).getText();
        System.out.println(urunBasligi+"//\n"+urunFiyati);
        //Test03
        //yeni bir sekme açarak amazon anasayfaya gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.amazon.com");
        //dropdown’dan bebek bölümüne secin
        WebElement dropdownBox2 = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select select2 = new Select(dropdownBox2);
        select2.selectByVisibleText("Baby");
        //bebek stroller aratıp bulundan sonuç sayısını yazdırın
        WebElement searchBox2 = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        searchBox2.sendKeys("stroller",Keys.ENTER);
        //sonuç yazsının puset içerdiğini test edin
        String sonucYazisi =driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]")).getText();
        Assert.assertTrue(sonucYazisi.contains("stroller"));
        //5-üçüncü ürüne relative locater kullanarak tıklayin
        driver.findElement(By.xpath("//img[@class='s-image' and @src='https://m.media-amazon.com/images/I/814Eys-70BL._AC_UY218_.jpg']")).click();
        //6-title ve fiyat bilgilerini assign edelim
        String title2 = driver.findElement(By.id("productTitle")).getText();
        String fiyat2 = driver.findElement(By.xpath("//*[@class='a-price a-text-price a-size-medium apexPriceToPay']")).getText();
        System.out.println(title2+"//\n"+fiyat2);
        //7-Browser'ı kapatalım

    }

}
