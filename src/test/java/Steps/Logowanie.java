package Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.net.URL;

public class Logowanie {
    WebDriver driver;

    @Given("Użytkownik otwiera przeglądarkę")
    public void uzytkownik_otwiera_przegladarke() {
        System.out.println("Krok 1 - uzytkownik otwiera przegladarke");
        driver = new ChromeDriver(); // konstruktor wywołujący przeglądarkę
        driver.manage().window().maximize();

    }

    @Given("Użytkownik wpisuje adres strony internetowej")
    public void użytkownik_wpisuje_adres_strony_internetowej() {
        System.out.println("Krok 2 - użytkownik_wpisuje_adres_strony_internetowej");
        driver.navigate().to("https://the-internet.herokuapp.com/login");
    }

    @When("Użytkownik wpisuje poprawny login")
    public void użytkownik_wpisuje_poprawny_login() {
        System.out.println("Krok 3 - użytkownik_wpisuje_poprawny_login");
        driver.findElement(By.id("username")).sendKeys("tomsmith");
    }

    @When("Użytkownik wpisuje poprawne haslo")
    public void użytkownik_wpisuje_poprawne_haslo() {
        System.out.println("Krok 4 - użytkownik_wpisuje_poprawne_haslo");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
    }

    @When("Użytkownik wciska przycisk zaloguj")
    public void uzytkownik_wciska_przycisk_zaloguj() {
        System.out.println("Krok 5 - uzytkownik_wciska_przycisk_zaloguj");
        driver.findElement(By.tagName("button")).click();
    }

    @Then("Użytkownik zostaje poprawnie zalogowany do aplikacji")
    public void uzytkownik_zostaje_poprawnie_zalogowany_do_aplikacji() {
        System.out.println("Krok 6 - uzytkownik_wciska_przycisk_zaloguj");
        Assert.assertEquals("https://the-internet.herokuapp.com/secure", driver.getCurrentUrl());
        driver.close();
    }

    @When("Użytkownik wpisuje niepoprawne haslo")
    public void uzytkownik_wpisuje_niepoprawne_haslo() {
        System.out.println("Krok 4 - użytkownik_wpisuje_poprawne_haslo");
        driver.findElement(By.name("password")).sendKeys("FailedPassword!");
    }

    @Then("Użytkownik nie zostaje poprawnie zalogowany do aplikacji")
    public void uzytkownik_nie_zostaje_poprawnie_zalogowany_do_aplikacji() {
        System.out.println("Krok 6 - uzytkownik_wciska_przycisk_zaloguj");
        Assert.assertEquals("https://the-internet.herokuapp.com/login", driver.getCurrentUrl());
        driver.close();

    }
}
