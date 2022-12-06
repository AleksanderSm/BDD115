Feature: Logowanie do aplikacji
  Jako użytkownik chce mieć funkcjonalność
  logowania do aplikacji aby kożystać z
  zaawansowanych funkcji

  Scenario: Poprawne logowanie do aplikacji
    Given Użytkownik otwiera przeglądarkę
    And Użytkownik wpisuje adres strony internetowej
    When Użytkownik wpisuje poprawny login
    And Użytkownik wpisuje poprawne haslo
    And Użytkownik wciska przycisk zaloguj
    Then Użytkownik zostaje poprawnie zalogowany do aplikacji
