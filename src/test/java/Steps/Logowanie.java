package Steps;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.net.URL;

public class Logowanie {
   private static WebDriver driver;

    @BeforeAll
    public static void setDriver() {
        driver = new ChromeDriver();

    }


    @Given("Użytkownik otwiera przeglądarkę")
    public void uzytkownik_otwiera_przegladarke() {
        System.out.println("Krok 1 - uzytkownik otwiera przegladarke");
        // driver = new ChromeDriver(); // konstruktor wywołujący przeglądarkę
      //  driver.manage().window().maximize();

    }

    @Given("Użytkownik wpisuje adres strony internetowej")
    public void użytkownik_wpisuje_adres_strony_internetowej() {
        System.out.println("Krok 2 - użytkownik_wpisuje_adres_strony_internetowej");
        driver.navigate().to("https://the-internet.herokuapp.com/login");
    }

    @When("Użytkownik wpisuje poprawny login")
    public void użytkownik_wpisuje_poprawny_login() {
        System.out.println("Krok 3 - użytkownik_wpisuje_poprawny_login");
      WebElement userInput = driver.findElement(By.id("username"));
      userInput.clear();
      userInput.sendKeys("tomsmith");
       // driver.findElement(By.id("username")).sendKeys("tomsmith");
    }

    @When("Użytkownik wpisuje poprawne haslo")
    public void użytkownik_wpisuje_poprawne_haslo() {
        System.out.println("Krok 4 - użytkownik_wpisuje_poprawne_haslo");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
    }

    @When("Użytkownik wciska przycisk zaloguj")
    public void uzytkownik_wciska_przycisk_zaloguj() {
        System.out.println("Krok 5 - uzytkownik_wciska_przycisk_zaloguj");
      WebElement loginButton = driver.findElement(By.tagName("button"));
      String textButton = loginButton.getText();
        System.out.println("Przycisk login zawiera tekst = " + textButton);
      loginButton.click();


        // driver.findElement(By.tagName("button")).click();
    }

    @Then("Użytkownik zostaje poprawnie zalogowany do aplikacji")
    public void uzytkownik_zostaje_poprawnie_zalogowany_do_aplikacji() {
        System.out.println("Krok 6 - uzytkownik_wciska_przycisk_zaloguj");
        Assert.assertEquals("https://the-internet.herokuapp.com/secure", driver.getCurrentUrl());
        //  driver.close();
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
        //  driver.close();

    }


    @Given("Użytkownik przechodzi na strone {string}")
    public void użytkownik_przechodzi_na_strone(String adresStrony) {
        //adresStrony to zmienna ktora zapamieta adres strony internetowej
        System.out.println("Krok 2 - użytkownik_wpisuje_adres_strony_internetowej");
        driver.navigate().to(adresStrony);

    }

    @When("Użytkownik wprowadza login {string}")
    public void użytkownik_wprowadza_login(String userName) {
        System.out.println("Krok 3 - użytkownik_wpisuje_poprawny_login");
        driver.findElement(By.id("username")).sendKeys(userName);

    }

    @When("Użytkownik wprowadza haslo {string}")
    public void użytkownik_wprowadza_haslo(String userPassword) {
        System.out.println("Krok 4 - użytkownik_wpisuje_poprawne_haslo");
        driver.findElement(By.name("password")).sendKeys(userPassword);

    }

    //When Użytkownik wprowadza login <loginek>
    @When("^Użytkownik wprowadza loginek (.+)$")
    public void uytkownik_wprowadza_login2(String loginek) {
        driver.findElement(By.id("username")).sendKeys(loginek);
    }
    //When Użytkownik wprowadza haslo <haselko>
    @And("^Użytkownik wprowadza haselko (.+)$")
    public void uytkownik_wprowadza_haslo2(String haselko) {
        driver.findElement(By.name("password")).sendKeys(haselko);
    }

    @AfterAll
    public static void tearDriver() {
        driver.close();
    }
}
