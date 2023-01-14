package hw;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class Hw05 extends TestBase {
    @Test
    public void hw05Test() {
        // sahibinden.com a gidin
        driver.get("https://sahibinden.com");
        driver.manage().deleteAllCookies();
        // anasayfada oldugunuzu dogrulayin
        Assert.assertTrue(driver.findElement(By.xpath("//a[text()='Acil Acil']")).isDisplayed());
        // detayli arama tiklayin
        driver.findElement(By.xpath("//*[@title='Detaylı Arama']")).click();
        // detayli arama sayfasina geldiginizi dogrulatin
        Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='Detaylı Arama']")).isDisplayed());
        // emlak-konut-satilik seceneklerini secip altta cikan butun filtre seceneklerine en az bir filtre degeri girip en sonundaki arama yap tusuna tiklayin
        // filtreler için sağıdakilere benzer methodlar oluşturun
        // detayli_Arama_Adres("izmir", "bayrakli", "adalet mah.");
        // detayli_Arama_Fiyat("4.000","4.000.000","USD");
        // detayli_Arama_Brut("180","400");
        // detayli_Arama_Oda_Sayisi("10 Üzeri");//0-43 arasi

        driver.findElement(By.xpath("//*[text()='Emlak']")).click();
        driver.findElement(By.xpath("//*[text()='Konut']")).click();
        driver.findElement(By.xpath("//*[text()='Satılık']")).click();
        driver.findElement(By.xpath("//*[text()='Daire']")).click();

        WebElement element=driver.findElement(By.xpath("//li[@data-address='city']//a[@class='faceted-select']"));
        element.click();
        driver.findElement(By.xpath("//input[@class='js-address-filter' and @placeholder='İl']")).sendKeys("Ankara");
        driver.findElement(By.xpath("//li[@data-id='6']")).click();
        waitFor(5);

       //Select select= new Select(element);
       //select.selectByVisibleText("Ankara");

        // cikan sonuc sayisini veya sonuc yoksa bunu bildiren yaziyi konsolda yazdirin
        driver.findElement(By.id("onetrust-reject-all-handler")).click();
        WebElement aramaYap= driver.findElement(By.xpath("//button[@value='Arama Yap']"));
        aramaYap.click();
        System.out.print(driver.findElement(By.className("result-text-sub-group")).getText());

    }
}
