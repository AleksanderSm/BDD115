@now
Feature: Logowanie do aplikacji
  Jako użytkownik chce mieć funkcjonalność
  logowania do aplikacji aby kożystać z
  zaawansowanych funkcji


  Scenario: Poprawne logowanie do aplikacji
    Given Użytkownik wpisuje adres strony internetowej
    When Użytkownik wpisuje poprawny login
    And Użytkownik wpisuje poprawne haslo
    And Użytkownik wciska przycisk zaloguj
    Then Użytkownik zostaje poprawnie zalogowany do aplikacji


  Scenario: Poprawne logowanie do aplikacji wersja 2
    Given Użytkownik przechodzi na strone "https://the-internet.herokuapp.com/login"
    When Użytkownik wprowadza login "tomsmith"
    And Użytkownik wprowadza haslo "SuperSecretPassword!"
    And Użytkownik wciska przycisk zaloguj
    Then Użytkownik zostaje poprawnie zalogowany do aplikacji


  Scenario: Niepoprawne logowanie do aplikacji wersja 2
    Given Użytkownik przechodzi na strone "https://the-internet.herokuapp.com/login"
    When Użytkownik wprowadza login "tomsmith"
    And Użytkownik wprowadza haslo "lipnehaslo"
    And Użytkownik wciska przycisk zaloguj
    Then Użytkownik nie zostaje poprawnie zalogowany do aplikacji

  Scenario: Niepoprawne logowanie do aplikacji wersja 3
    Given Użytkownik przechodzi na strone "https://the-internet.herokuapp.com/login"
    When Użytkownik wprowadza login "blednylogin"
    And Użytkownik wprowadza haslo "SuperSecretPassword!"
    And Użytkownik wciska przycisk zaloguj
    Then Użytkownik nie zostaje poprawnie zalogowany do aplikacji

  Scenario: Niepoprawne logowanie do aplikacji
    Given Użytkownik wpisuje adres strony internetowej
    When Użytkownik wpisuje poprawny login
    And Użytkownik wpisuje niepoprawne haslo
    And Użytkownik wciska przycisk zaloguj
    Then Użytkownik nie zostaje poprawnie zalogowany do aplikacji


  Scenario Outline: Niepoprawne logowanie - wersja 4
    Given Użytkownik przechodzi na strone "https://the-internet.herokuapp.com/login"
    When Użytkownik wprowadza loginek <loginek>
    And Użytkownik wprowadza haselko <haselko>
    And Użytkownik wciska przycisk zaloguj
    Then Użytkownik nie zostaje poprawnie zalogowany do aplikacji

    Examples:
    | loginek | haselko |
    | tomsmith | zlehaslo |
    | zlylogin | SuperSecretPassword! |
    | sfbsdfgh | Sgjkghjkgjdj! |
