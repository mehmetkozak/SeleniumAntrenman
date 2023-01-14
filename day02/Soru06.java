package day02;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Soru06 extends TestBase {
    @Test
    public void test06(){
        //go to web site : https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
        //maximize the website
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");
        // ikinci emojiye tıklayın
        driver.switchTo().frame(1);
        driver.findElement(By.xpath("(//span[@data-upgraded=',MaterialRipple'])[2]")).click();

        // ikinci emoji altındaki tüm öğelere tıklayın
        List<WebElement> tumEmoji=driver.findElements(By.xpath("//div[@id='nature']/div"));
        tumEmoji.forEach(WebElement::click);
        // ana iframe'e geri dön
        driver.switchTo().parentFrame();
        //formu doldurun,(Formu istediğiniz metinlerle doldurun)
        List<WebElement> allInputTags = driver.findElements(By.xpath("//input"));
        List<String> allWords = new ArrayList<>(Arrays.asList("Fırtınadayım",
                "bir","fırtınadayım","Gözümün","gördüğü","göğsümün","bildiği","ile","bir","değil","Mabel"));

        for(int i = 0; i<allInputTags.size(); i++){
            allInputTags.get(i).sendKeys(allWords.get(i));
        }
        // uygula butonuna tıklayın
        driver.findElement(By.id("send")).click();
        WebElement son = driver.findElement(By.id("code"));
        Assert.assertTrue(son.isDisplayed());
    }
}
