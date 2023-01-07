package day01;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Soru01 extends TestBase {

    @Test
    public void test01(){
        //1. "http://webdriveruniversity.com/Actions" sayfasina
        driver.get("http://webdriveruniversity.com/Actions");

        //2. "Hover over Me First" kutusunun ustune gelin
        WebElement hoverOver =findXPath("//*[.='Hover Over Me First!']");
        Actions surucu=new Actions(driver);
        surucu.moveToElement(hoverOver).perform();

        //3. "Link 1" e tiklayin
        findCss("div[class='dropdown hover'] a[class='list-alert']").click();

        //4. Popup mesajini yazdirin
        System.out.println("Alert yazısı = " + driver.switchTo().alert().getText());
        waitFor(3);
        //5. Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();

        //6. "Click and hold" kutusuna basili tutun
        WebElement clickAndHoldBox=findId("click-box");
        surucu.clickAndHold(clickAndHoldBox).perform();

        //7. "Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(clickAndHoldBox.getText());

        //8. "Double click me" butonunu cift tiklayin
        WebElement renkDegistirenBox=findId("double-click");
        String ilkRenk=renkDegistirenBox.getAttribute("class");
        System.out.println(ilkRenk);
        waitFor(3);
        surucu.doubleClick(renkDegistirenBox).perform();
        waitFor(3);
        String ikinciRenk=renkDegistirenBox.getAttribute("class");
        System.out.println(ikinciRenk);

        //9. "Double click me" butonunun renk değiştridiğini doğrulayın
      Assert.assertNotEquals(ilkRenk,ikinciRenk);
    }

}
