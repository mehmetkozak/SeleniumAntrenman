package hw;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Hw03 extends TestBase {
    @Test
    public void hw03Test() {
        //1- "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");

        // 2- Hover over Me First" kutusunun ustune gelin
        Actions actions=new Actions(driver);
        WebElement hoverText=driver.findElement(By.xpath("(//button[@class='dropbtn'])[1]"));
        actions.moveToElement(hoverText).perform();
        waitFor(3);

        //Link 1" e tiklayin
        driver.findElement(By.xpath("(//a[.='Link 1'])[1]")).click();
        //Popup mesajini yazdirin

        System.out.println(driver.switchTo().alert().getText());
        //Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();
        //“Click and hold" kutusuna basili tutun
        WebElement clickAndHold=driver.findElement(By.id("click-box"));
        actions.clickAndHold(clickAndHold).perform();
        //7-“Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(clickAndHold.getText());
        //8- “Double click me" butonunu cift tiklayin
        WebElement doubleClick=driver.findElement(By.id("double-click"));
        actions.doubleClick(doubleClick).perform();

    }



}
