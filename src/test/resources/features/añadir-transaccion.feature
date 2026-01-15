Feature: Añadir transacción

  Background:
    Given que el usuario está logueado y en la pagina de transacciones
      | user | pass |

  Scenario: Correcta creacion y guardado de transaccion
    When da clic en el boton Añadir transacción
    And llena la información correctamente
      | "12-07-2026" | 25000 | example |
    Then se debe almacenar correctamente la transaccion