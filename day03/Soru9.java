package day03;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Soru9 extends TestBase {
    @Test
    public void Test09() throws InterruptedException {
        //"https://demoqa.com/automation-practice-form"  Adresine gidin
        // Formu doldurunuz
        // Sayfayi kapatin

            //"https://demoqa.com/automation-practice-form"  Adresine gidin
            driver.get("https://demoqa.com/automation-practice-form");
            // Formu doldurunuz
            Faker faker = new Faker();
            WebElement firstName = driver.findElement(By.id("firstName"));
            firstName.sendKeys(faker.name().firstName(), Keys.TAB,faker.name().lastName(),Keys.TAB,
                    faker.internet().emailAddress(),Keys.TAB,Keys.SPACE,Keys.TAB,faker.phoneNumber().cellPhone(),Keys.TAB
                    ,"20 Jul 1980",Keys.ENTER,Keys.TAB,faker.shakespeare().romeoAndJulietQuote(),Keys.TAB,Keys.SPACE);
        WebElement gıcıkButon= driver.findElement(By.id("subjectsInput"));
        gıcıkButon.sendKeys("Maths");
        gıcıkButon.sendKeys(Keys.ENTER);

            WebElement dosyaSec = driver.findElement(By.xpath("//*[@id='uploadPicture']"));
            //String dosyaYolu = "C:\\Users\\Lenovo\\OneDrive\\Masaüstü\\sen.txt";
            String anaYol = System.getProperty("user.home"); //C:\\Users\\Lenovo\\
            String ortakYol = "\\Masaüstü\\logo.txt";
            String dosyaYolu = anaYol+ortakYol;
            dosyaSec.sendKeys(dosyaYolu);
            WebElement adress = driver.findElement(By.xpath("//*[@id='currentAddress']"));
            adress.sendKeys(faker.address().fullAddress(),Keys.TAB,"NCR");
            Thread.sleep(2000);
    }
}
