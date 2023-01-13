package hw;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class Hw04 extends TestBase {
    @Test
    public void hw04Test() {
        //"https://facebook.com"  Adresine gidin
        driver.get("https://facebook.com");
        //“create new account”  butonuna basin
        driver.findElement(By.xpath("//*[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        //“firstName” giris kutusuna bir isim yazin
        //“surname” giris kutusuna bir soyisim yazin
        //“email” giris kutusuna bir email yazin
        //“email” onay kutusuna emaili tekrar yazin
        //Bir sifre girin
        driver.findElement(By.xpath("//*[@name='firstname']")).sendKeys("Mehmet", Keys.TAB,
                "Kozak",Keys.TAB,
                "mehmetkozak46@gmail.com",Keys.TAB,"mehmetkozak46@gmail.com",Keys.TAB,"12345");


        //Tarih icin gun secin
        //Tarih icin ay secin
        //Tarih icin yil secin
        WebElement day=driver.findElement(By.id("day"));
        WebElement month=driver.findElement(By.id("month"));
        WebElement year=driver.findElement(By.id("year"));
        Select selectDay=new Select(day);
        Select selectMonth=new Select(month);
        Select selectYear=new Select(year);
        selectDay.selectByVisibleText("30");
        selectMonth.selectByIndex(5);
        selectYear.selectByVisibleText("1991");
        waitFor(1);


        //Cinsiyeti secin
        driver.findElement(By.xpath("//input[@value='2']")).click();
        waitFor(3);
        //Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
        WebElement female=driver.findElement(By.xpath("//input[@value='1']"));
        Assert.assertFalse(female.isSelected());
    //Sayfayi kapatin

    }

}
