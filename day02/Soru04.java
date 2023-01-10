package day02;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Set;

public class Soru04 extends TestBase {

    @Test
    public void test04(){
        //https://demoqa.com/ url'ine gidin.
        driver.get("https://demoqa.com/");
        //Alerts, Frame & Windows Butonuna click yap
        driver.findElement(By.xpath("(//div[@class='card mt-4 top-card'])[3]")).click();
        //""Please select an item from left to start practice."" yazısının görünür olduğunu doğrula
        WebElement text=driver.findElement(By.xpath("//div[@class='col-12 mt-4 col-md-6']"));
        Assert.assertTrue(text.isDisplayed());
        //Sol'da açılan Menu den ""Browser Windows"" butonuna click yap
        driver.findElement(By.xpath("//span[text()='Browser Windows']")).click();
        //New Tab butonunun görünür olduğunu doğrula
        Assert.assertTrue(driver.findElement(By.id("tabButton")).isDisplayed());
        //New Tab butonuna click yap
        String ilkSayfaHandle=driver.getWindowHandle();
        driver.findElement(By.id("tabButton")).click();
        //Açılan yeni Tab da ""This is a sample page"" yazısının görünür olduğunu doğrula
        Set<String> handleListeleri= driver.getWindowHandles();

        for (String w: handleListeleri){
            if (!w.equals(ilkSayfaHandle)){
                driver.switchTo().window(w);
                break;
            }
        }
       Assert.assertTrue(driver.findElement(By.id("sampleHeading")).isDisplayed());
        //İlk Tab'a geri dön

        driver.switchTo().window(ilkSayfaHandle);
        //New Tab butonunun görünür olduğunu doğrula
        Assert.assertTrue(driver.findElement(By.id("tabButton")).isDisplayed());
    }
}
