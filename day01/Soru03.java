package day01;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class Soru03 extends TestBase {

    @Test
    public void test03() {
        //go to https://www.amazon.com.tr/
        driver.get("https://www.amazon.com.tr/");
        driver.findElement(By.id("sp-cc-accept")).click();
        //search iphone13 512
        WebElement searchBox=driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("iphone13 512", Keys.ENTER);
        //check that the results are listed
        List<WebElement> sonuclar = driver.findElements(By.xpath("//*[@class='a-size-base-plus a-color-base a-text-normal']"));

        //click iphone13 at the top of the list
        sonuclar.get(0).click();

        //Log the following values for each size .Size information .Price .Color .Stock status
        String telefonIsmi = driver.findElement(By.id("productTitle")).getText();
        System.out.print(telefonIsmi+"   ");
        String size = driver.findElement(By.id("inline-twister-expanded-dimension-text-size_name")).getText();
        System.out.println("Size :" + size);
        String color = driver.findElement(By.id("inline-twister-expanded-dimension-text-color_name")).getText();
        System.out.print("Color:"+color+"   ");
        String price = driver.findElement(By.xpath("(//*[@class='a-section slots-padding'])[2]")).getText();
        System.out.println("Price:"+price);
        String stock = driver.findElement(By.xpath("//*[@class='a-size-medium a-color-success']")).getText();
        System.out.println("Stock:"+stock);


    }
}
