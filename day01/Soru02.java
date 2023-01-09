package day01;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Soru02 extends TestBase {

    @Test
    public void test02(){
        //#url'ye gidin: http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html
        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
        //#Ülkeye göre başkentleri doldurun

        for (int i = 1; i <8 ; i++) {
            WebElement kaynak=driver.findElement(By.id("box"+i));
            WebElement hedef=driver.findElement(By.id("box"+(100+i)));
            Actions actions=new Actions(driver);
            actions.dragAndDrop(kaynak,hedef).perform();
        }



    }




}
