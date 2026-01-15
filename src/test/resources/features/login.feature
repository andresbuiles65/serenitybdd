Feature: Login de sitio web
  Scenario: Correcto login al sitio web
    Given que el usuario abre la pagina del login
    When ingrese las correctas credenciales
      | user | pass |
    Then redirigir a pagina transacciones
