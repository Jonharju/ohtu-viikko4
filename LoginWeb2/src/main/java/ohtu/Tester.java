package ohtu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Tester {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();

        driver.get("http://localhost:8090");
        System.out.println( driver.getPageSource() );
        WebElement element = driver.findElement(By.linkText("login"));       
        element.click();
        
        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep");
        element = driver.findElement(By.name("login"));
        element.submit();
        
        //epäonnistunut kirjautuminen väärällä salasanlla
        element = driver.findElement(By.linkText("logout"));       
        element.click();
        element = driver.findElement(By.linkText("login"));       
        element.click();
        
        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("vaara");
        element = driver.findElement(By.name("login"));
        element.submit();
        
        //epäonnistunut kirjautuminen ei-olemassaolevalla tunnuksella
    
        element = driver.findElement(By.name("username"));
        element.sendKeys("vaara");
        element = driver.findElement(By.name("password"));
        element.sendKeys("vaara");
        element = driver.findElement(By.name("login"));
        element.submit();        
       
        //uuden käyttäjän luonti
        element = driver.findElement(By.linkText("back to home"));
        element.click();
        element = driver.findElement(By.linkText("register new user"));
        element.click();
        
        element = driver.findElement(By.name("username"));
        element.sendKeys("uusik");
        element = driver.findElement(By.name("password"));
        element.sendKeys("uusiuus1");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("uusiuus1");
        element = driver.findElement(By.name("add"));
        element.submit();
        
        //uloskirjautuminen luomisen jälkeen
        element = driver.findElement(By.linkText("continue to application mainpage"));
        element.click();
        element = driver.findElement(By.linkText("logout"));
        element.click();
        
        element = driver.findElement(By.name("username"));
        element.sendKeys("uusik");
        element = driver.findElement(By.name("password"));
        element.sendKeys("uusiuus1");
        element = driver.findElement(By.name("login"));
        element.submit();
    }
}
