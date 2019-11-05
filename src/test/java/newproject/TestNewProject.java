package org.vistula.selenium.test.part1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.assertj.core.api.Assertions;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestNewProject {

    private WebDriver driver;

    @BeforeClass
    public static void setDriver() {
        WebDriverManager.chromedriver().setup();
    }


    @Test
    public void myFirstInteractionTest() {
        driver = new ChromeDriver();
        driver.get("http://demo.testarena.pl/zaloguj");
        WebElement email = driver.findElement(By.id("email"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement login = driver.findElement(By.id("login"));

        email.sendKeys("administrator@testarena.pl");
        password.sendKeys("sumXQQ72$L");
        login.click();

        WebElement admin = driver.findElement(By.className("header_admin"));
        admin.click();

        WebElement add = driver.findElement(By.partialLinkText("ADD"));
        add.click();

        WebElement tytul = driver.findElement(By.id("name"));
        tytul.sendKeys("Jędrzej");

        WebElement prefix = driver.findElement(By.id("prefix"));
        prefix.sendKeys("JM");

        WebElement save = driver.findElement(By.id("save"));
        save.click();

        WebElement projects = driver.findElement(By.partialLinkText("Projects"));
        projects.click();

        Assertions.assertThat(driver.findElements(By.partialLinkText("Jędrzej")));
        driver.quit();
    }

}
